package com.grupo.dgeg;

import org.neodatis.odb.ODB;

import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.OID;

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
}
