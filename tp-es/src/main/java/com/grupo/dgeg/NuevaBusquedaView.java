package com.grupo.dgeg;

import java.util.ArrayList;

import com.vaadin.ui.Button.ClickListener;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

@PreserveOnRefresh
public class NuevaBusquedaView extends VerticalLayout implements View {
	public static final String NAME = "Nueva busqueda";

	public NuevaBusquedaView(){
		
		
		
		final ArrayList<String> listaPalabras = new ArrayList<String>();
		
		final TextField palabra = new TextField("Palabra");
		
		Button agregarPalabra = new Button("Agregar palabra", new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				if (!(palabra.getValue().equals(""))){
					listaPalabras.add(palabra.getValue());
					palabra.setValue("");
				}
			}
		});
		Button verListaPalabras = new Button ("Ver la lista de palabras");
		TextField latitud = new TextField("Latitud");
		TextField longitud = new TextField("Longitud");
		Button aceptar = new Button("Aceptar");
		Button cancelar = new Button("Cancelar");
		
		addComponents(palabra, agregarPalabra, verListaPalabras, latitud, longitud, aceptar, cancelar);
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
	}

}
