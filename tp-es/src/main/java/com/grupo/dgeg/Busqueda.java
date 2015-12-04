package com.grupo.dgeg;

import java.util.ArrayList;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Busqueda {
	
	String nombre;
	ArrayList<String> listaPalabrasArrayList;
	
	@Min(-90)
	@Max(90)
	double latitud;
	@Min(-90)
	@Max(90)
	double longitud;
	GrupoBusqueda grupo;
	
	public Busqueda(String nombre, ArrayList<String> listaPalabrasArrayList, double latitud, double longitud, GrupoBusqueda grupo) {
		this.nombre = nombre;
		this.listaPalabrasArrayList = listaPalabrasArrayList;
		this.latitud = latitud;
		this.longitud = longitud;
		this.grupo = grupo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<String> getListaPalabras() {
		return listaPalabrasArrayList;
	}

	public void setListaPalabras(ArrayList<String> listaPalabras) {
		this.listaPalabrasArrayList = listaPalabras;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public GrupoBusqueda getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoBusqueda grupo) {
		this.grupo = grupo;
	}
	
	
}
