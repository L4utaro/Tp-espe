package com.grupo.dgeg;



public class DAO<T> {
	
	public void guardar (T t){
		Conexion.getInstance().store(t);
		Conexion.getInstance().commit();
	}
	
	public void borrar(T t){
		Conexion.getInstance().delete(t);
	}
	
}

