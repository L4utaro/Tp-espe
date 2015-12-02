package com.grupo.dgeg;

import java.util.List;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

public abstract class DAO<T> {

	public Objects<T> getAll(Class<T> cls){
		ODB odb = ODBFactory.open("TPdb");
		
		Objects<T> elements = odb.getObjects(cls);
		
		odb.close();
		
		return elements;
	}
		
		
}
