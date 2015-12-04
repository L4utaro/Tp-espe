package com.grupo.dgeg;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.OID;

public class GrupoBusquedaDAO {
	public void guardar(GrupoBusqueda g) {
		ODB odb = null;
		try {
			// Abre/Crea la bd
			odb = ODBFactory.open("TPdb");
			// Guardamos el objeto
			odb.store(g);
		} finally {
			if (odb != null) {
				// Cerramos la bd
				odb.close();
			}
		}
	}
	
	public void borrar(GrupoBusqueda g) {
		ODB odb = null;
		try {
			// Abre/Crea la bd
			odb = ODBFactory.open("TPdb");
			OID idObjeto = odb.store(g);
			// borramos el objeto
			odb.deleteObjectWithId(idObjeto);
		} finally {
			if (odb != null) {
				// Cerramos la bd
				odb.close();
			}
		}
	}
}