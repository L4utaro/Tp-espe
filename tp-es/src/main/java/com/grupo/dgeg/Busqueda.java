package com.grupo.dgeg;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Busqueda {
	
	String nombre;
	String[] listaPalabras;
	
	@Min(-90)
	@Max(90)
	double latitud;
	@Min(-90)
	@Max(90)
	double longitud;
	
	public Busqueda(String nombre, String[] listaPalabras, double latitud, double longitud) {
		this.nombre = nombre;
		this.listaPalabras = listaPalabras;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String[] getListaPalabras() {
		return listaPalabras;
	}

	public void setListaPalabras(String[] listaPalabras) {
		this.listaPalabras = listaPalabras;
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
	
	
}
