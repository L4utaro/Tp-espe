package com.grupo.dgeg;

public class Busqueda {
	
	String nombre;
	String palabra;
	int latitud;
	int longitud;
	
	public Busqueda(String nombre, String palabra, int latitud, int longitud) {
		this.nombre = nombre;
		this.palabra = palabra;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	public int getLatitud() {
		return latitud;
	}

	public void setLatitud(int latitud) {
		this.latitud = latitud;
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}
	
	
}
