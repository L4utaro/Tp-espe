package com.grupo.dgeg;

import java.sql.Savepoint;

import com.vaadin.ui.Button.ClickListener;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.FieldEvents.FocusEvent;
import com.vaadin.event.FieldEvents.FocusListener;
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
		final TextField nombreTF = new TextField("Nombre");
		final BeanItemContainer<Palabra> palabrasBean = new BeanItemContainer<Palabra>(Palabra.class);
		
		final TextField palabraTF = new TextField("Palabra");
		
		Table table = new Table("Palabras a buscar", palabrasBean);
		table.setColumnExpandRatio(null, 1.0f);
		
		
		
		table.setPageLength(0);
		table.setHeight("100%"); 
		
		Button agregarPalabra = new Button("Agregar palabra", new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				if (palabraTF != null && (palabraTF.getValue().trim().length() > 0)){
					Palabra p = new Palabra(palabraTF.getValue());
					if (!(palabrasBean.containsId(p))){
						palabrasBean.addBean(p);
						palabraTF.setValue("");
					}
				}
			}
		});
		TextField latitud = new TextField("Latitud");
		TextField longitud = new TextField("Longitud");
		Button aceptar = new Button("Aceptar");
		Button cancelar = new Button("Cancelar");
		
		addComponents(nombreTF, palabraTF, table, agregarPalabra, latitud, longitud, aceptar, cancelar);
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
	}

}
