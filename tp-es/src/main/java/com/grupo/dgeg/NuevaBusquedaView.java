package com.grupo.dgeg;

import com.vaadin.ui.Button.ClickListener;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class NuevaBusquedaView extends VerticalLayout implements View {
	public static final String NAME = "Nueva busqueda";

	public NuevaBusquedaView(){
		
		final BeanItemContainer<Palabra> palabrasBean = new BeanItemContainer<Palabra>(Palabra.class);
		
		final TextField palabra = new TextField("Palabra");
		
		Table table = new Table("Palabras a buscar", palabrasBean);
		table.setColumnExpandRatio(null, 1.0f);
		
		
		table.setPageLength(0);
		table.setHeight("100%"); 
		table.setColumnExpandRatio(table.getPropertyDataSource(), 1.0f);
		Button agregarPalabra = new Button("Agregar palabra", new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				if (palabra != null && (palabra.getValue().trim().length() > 0)){
					Palabra p = new Palabra(palabra.getValue());
					palabrasBean.addBean(p);
					palabra.setValue("");
				}
			}
		});
		TextField latitud = new TextField("Latitud");
		TextField longitud = new TextField("Longitud");
		Button aceptar = new Button("Aceptar");
		Button cancelar = new Button("Cancelar");
		
		addComponents(palabra, table, agregarPalabra, latitud, longitud, aceptar, cancelar);
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
	}

}
