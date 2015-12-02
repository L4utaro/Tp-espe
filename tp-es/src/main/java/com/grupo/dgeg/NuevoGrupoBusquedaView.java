package com.grupo.dgeg;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class NuevoGrupoBusquedaView extends VerticalLayout implements View {
	
	public static final String NAME = "Nuevo Grupo de Búsqueda";

	public NuevoGrupoBusquedaView() {
		TextField nombre = new TextField("Nombre");
		TextField descripcion = new TextField("Descripcion");
		Button aceptar = new Button("Aceptar");
		Button cancelar = new Button("Cancelar");
		
		this.addComponents(nombre, descripcion, aceptar, cancelar);
		
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}
