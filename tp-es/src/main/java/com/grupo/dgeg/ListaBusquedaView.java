package com.grupo.dgeg;

import java.util.ArrayList;

import com.vaadin.data.Container;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class ListaBusquedaView extends VerticalLayout implements View {

	public static final String NAME = "Lista de Busquedas";
	
	public ListaBusquedaView(){
		
		//BusquedaDAO listaBusquedasDAO = new BusquedaDAO();
		//ArrayList lista = (ArrayList)listaBusquedasDAO.recorrerBusquedas();
		
		BeanItemContainer<Busqueda> listaBusquedas = new BeanItemContainer<Busqueda>(Busqueda.class);

		
		Grid grid = new Grid("Grilla", listaBusquedas);
		grid.setColumnOrder("nombre", "listaPalabras", "grupo", "latitud", "longitud");
		
		
		addComponent(grid);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
	}

}
