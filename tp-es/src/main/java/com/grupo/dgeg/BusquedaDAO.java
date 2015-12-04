package com.grupo.dgeg;

import java.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.OID;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class BusquedaDAO {
	public void guardar(Busqueda b) {
		ODB odb = null;
		try {
			// Abre/Crea la bd
			odb = ODBFactory.open("TPdb");
			// Guardamos el objeto
			odb.store(b);
		} finally {
			if (odb != null) {
				// Cerramos la bd
				odb.close();
			}
		}
	}

	public void borrar(Busqueda b) {
		ODB odb = null;
		try {
			// Abre/Crea la bd
			odb = ODBFactory.open("TPdb");
			OID idObjeto = odb.store(b);
			// borramos el objeto
			odb.deleteObjectWithId(idObjeto);
		} finally {
			if (odb != null) {
				// Cerramos la bd
				odb.close();
			}
		}
	}

	// muestra la busqueda
	public void mostrarBusqueda(String nombreUsuario) {
		ODB odb = null;
		try {
			odb = ODBFactory.open("TPdb");
			IQuery query = new CriteriaQuery(GrupoBusqueda.class, Where.equal(
					"nombre", nombreUsuario));
		} finally {
			if (odb != null) {
				// Cerramos la bd
				odb.close();
			}
		}
	}

	public List<Busqueda> recorrerBusquedas() {

		//List<Busqueda> listaDeBusqueda = new ArrayList<Busqueda>();
		LinkedList<Busqueda> lista = new LinkedList();
		Busqueda b = null;

		ODB odb = ODBFactory.open("TPdb");
		// Recuperamos todos las busquedas
		Objects<Busqueda> busqueda = odb.getObjects(Busqueda.class);
		// y los mostramos
		for (Busqueda act : busqueda) {
			// nombre
			System.out.println(act.getNombre());
			b.nombre = act.getNombre();

			// lista de palabra
			for (int i = 0; i < act.getListaPalabras().size(); i++) {
				System.out.println(act.getListaPalabras().get(i));
				b.listaPalabrasArrayList.set(i, act.getListaPalabras().get(i));//add=set
			}

			// grupo
			System.out.println(act.getGrupo().getNombre());
			b.grupo.nombre = act.getGrupo().getNombre();
			System.out.println(act.getGrupo().getDescripcion());
			b.grupo.nombre = act.getGrupo().getDescripcion();

			// latitud
			System.out.println(act.getLatitud());
			b.latitud = act.getLatitud();

			// longitud
			System.out.println(act.getLongitud());
			b.longitud = act.getLongitud();


			lista.add(b);
		}
		// cerramos la bd
		odb.close();
		return lista;
	}
}
