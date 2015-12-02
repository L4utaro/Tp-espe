package com.grupo.dgeg;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

public class BusquedaView extends VerticalLayout implements View {
	
	
	
	public static final String NAME = "Nueva busqueda";

	public BusquedaView(){
		Button button = new Button(this.NAME);
		this.addComponent(button);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
