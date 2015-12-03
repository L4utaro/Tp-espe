package com.grupo.dgeg;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class ListaBusquedaView extends VerticalLayout implements View {

	public static final String NAME = "Lista de Busquedas";
	
	public ListaBusquedaView(){
		BeanItemContainer<Busqueda> listaBusquedas = new BeanItemContainer<Busqueda>(Busqueda.class);
		
		Table table = new Table(NAME, listaBusquedas);
		table.setPageLength(0);
		table.setHeight("100%"); 
		
		addComponent(table);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
