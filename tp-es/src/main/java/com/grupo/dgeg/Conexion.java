package com.grupo.dgeg;

import org.neodatis.odb.ODB;


import org.neodatis.odb.ODBFactory;

public class Conexion {
	private static ODB instance;
	private static String connStr;

	public static void iniciar(String connStr) {
		Conexion.connStr = connStr;
	}

	public static ODB getInstance() {
		if (Conexion.instance == null)
			Conexion.instance = ODBFactory.open(connStr);
		return Conexion.instance;
	}

	public static void finalizar() {
		instance.close();
	}
}
