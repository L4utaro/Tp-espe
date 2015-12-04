package com.grupo.dgeg;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class ListaGrupoBusquedaView extends VerticalLayout implements View {

	public static final String NAME = "Lista de Grupos de Busqueda";
	
	public ListaGrupoBusquedaView() {
		BeanItemContainer<GrupoBusqueda> lista = new BeanItemContainer<GrupoBusqueda>(GrupoBusqueda.class);
		Grid grid = new Grid("Grilla", lista);
		grid.setColumnOrder("nombre", "descripcion");
		this.addComponent(grid);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}
