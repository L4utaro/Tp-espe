package com.grupo.dgeg;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

public class GrupoBusquedaView extends VerticalLayout implements View {
	
	
	
	public static final String NAME = "Grupo de Busquedas";

	public GrupoBusquedaView() {
		
		Button button = new Button(NAME);
		addComponent(button);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}
