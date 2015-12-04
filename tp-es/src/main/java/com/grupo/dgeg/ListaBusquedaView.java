package com.grupo.dgeg;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class ListaBusquedaView extends VerticalLayout implements View {

	public static final String NAME = "Lista de Busquedas";
	
	public ListaBusquedaView(){
		BeanItemContainer<Busqueda> listaBusquedas = new BeanItemContainer<Busqueda>(Busqueda.class);
		
		Grid grid = new Grid("Grilla", listaBusquedas);
		grid.setColumnOrder("nombre", "listaPalabras", "grupo", "latitud", "longitud");
		this.addComponent(grid); 
		
		addComponent(grid);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
