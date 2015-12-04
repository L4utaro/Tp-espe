package com.grupo.dgeg;

import java.sql.Savepoint;

import com.vaadin.ui.Button.ClickListener;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.FieldEvents.FocusEvent;
import com.vaadin.event.FieldEvents.FocusListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
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
		
		final Table table = new Table("Palabras a buscar", palabrasBean);
		table.setColumnExpandRatio(null, 1.0f);
		table.setPageLength(0);
		table.setHeight("100%"); 
		
		final Container container = new IndexedContainer();
		container.addContainerProperty("Palabra", String.class, "");
		
		Button agregarPalabra = new Button("Agregar palabra", new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				agregarPalabra(palabraTF.getValue(), container, table);
				palabraTF.setValue("");
			}
		});
		
		ComboBox grupos = new ComboBox("Grupos de Busqueda");
		grupos.setNullSelectionAllowed(false);
		grupos.setImmediate(true);
		TextField latitud = new TextField("Latitud");
		TextField longitud = new TextField("Longitud");
		Button aceptar = new Button("Aceptar");
		Button cancelar = new Button("Cancelar");
		
		FormLayout mitadSuperior = new FormLayout();
		HorizontalLayout coordenadas = new HorizontalLayout();
		coordenadas.addComponents(latitud, longitud);
		HorizontalLayout botones = new HorizontalLayout();
		botones.addComponents(aceptar, cancelar);
		FormLayout mitadInferior = new FormLayout();
		mitadSuperior.addComponents(nombreTF, palabraTF);
		mitadInferior.addComponents(agregarPalabra, grupos, coordenadas, botones);
		
		addComponents(mitadSuperior, table, mitadInferior);
		
	}
	
	private void agregarPalabra(String palabra, Container c, Table t){
		if (palabraValida(palabra, c)){
			Item item = c.addItem(palabra);
			item.getItemProperty("Palabra").setValue(palabra);
			t.setContainerDataSource(c);
			actualizarTabla(t);
		}
	}

	private void actualizarTabla(Table t) {
		t.setColumnWidth("Palabra", -1);
	}

	private boolean palabraValida(String palabra, Container c) {
		return (palabra != null 
				&& !(c.containsId(palabra))
				&& (palabra.trim().length() > 0));
	}

	@Override
	public void enter(ViewChangeEvent event) {
	}

}
