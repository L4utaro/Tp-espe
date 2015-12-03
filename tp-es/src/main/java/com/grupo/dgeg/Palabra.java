package com.grupo.dgeg;

import javax.validation.constraints.NotNull;

public class Palabra {
	String palabra;

	public Palabra(String palabra) {
		this.palabra = palabra;
	}

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}
	
	
}
