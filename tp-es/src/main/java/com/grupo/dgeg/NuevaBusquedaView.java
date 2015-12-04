package com.grupo.dgeg;

import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.Collection;

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
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
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
		
		final TextField latitudTF = new TextField("Latitud");
		final TextField longitudTF = new TextField("Longitud");
		
		DateField fechaInicio = new DateField("Fecha de inicio");
		final DateField fechafin = new DateField("Fecha de Fin");
		
		
		

		
		
		
		
		Button aceptar = new Button("Aceptar", new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				final ArrayList<String> listaPalabrasArrayList =  new ArrayList<String>();
				for (Object component : container.getItemIds()) {
					listaPalabrasArrayList.add((String)component);
				}
				if (todosLosCamposValidos(nombreTF, longitudTF, latitudTF, listaPalabrasArrayList)){
					String nombreBusqueda = nombreTF.getValue();
					double latitud = Double.parseDouble(latitudTF.getValue());
					double longitud = Double.parseDouble(longitudTF.getValue());
					//TODO pedir grupo de DB
					GrupoBusqueda grupo = new GrupoBusqueda("Nombre", "Descripcion");
					Busqueda busqueda = new Busqueda(nombreBusqueda, listaPalabrasArrayList, latitud, longitud, grupo);
					BusquedaDAO dao = new BusquedaDAO();
					dao.guardar(busqueda);
				}
				else{
					Notification.show("Error: no se pudo crear la Busqueda");
				}
			}
		});
		Button cancelar = new Button("Cancelar");
		
		FormLayout mitadSuperior = new FormLayout();
		HorizontalLayout coordenadas = new HorizontalLayout();
		coordenadas.addComponents(latitudTF, longitudTF);
		HorizontalLayout botones = new HorizontalLayout();
		botones.addComponents(aceptar, cancelar);
		VerticalLayout grupoBusquedaLayout = new VerticalLayout();
		grupoBusquedaLayout.addComponent(grupos);
		FormLayout mitadInferior = new FormLayout();
		mitadSuperior.addComponents(nombreTF, palabraTF);
		mitadInferior.addComponents(agregarPalabra, fechaInicio, fechafin, grupoBusquedaLayout, coordenadas, botones);
		
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
	
	private boolean todosLosCamposValidos(TextField nombreTF, TextField latitudTF, TextField longitudTF, ArrayList<String> listaPalabrasArrayList) {
		return (tfValido(nombreTF.getValue())
				&& zonaGeograficaValida(latitudTF, longitudTF))
				&& arrayValido(listaPalabrasArrayList)
				&& grupoValido(new GrupoBusqueda());
	}
	
	private boolean grupoValido(GrupoBusqueda grupoBusqueda) {
		return true;
	}
	
	private boolean arrayValido(ArrayList<String> listaPalabrasArrayList) {
		return !(listaPalabrasArrayList.isEmpty());
	}
	
	private boolean zonaGeograficaValida(TextField latitudTF,
			TextField longitudTF) {
		double latitud = Double.parseDouble(latitudTF.getValue()); 
		double longitud = Double.parseDouble(longitudTF.getValue());
		
		return (latitud <= 90.0
				&& latitud>= -90.0
				&& longitud <= 90.0
				&& longitud >= -90.0);
	}
	
	private boolean tfValido(String palabra) {
	    if (palabra != null){
	     String palabraTrimmed = palabra.trim();
	     return (palabraTrimmed.length() > 0);
	    }
	    return false;
	    }

	@Override
	public void enter(ViewChangeEvent event) {
	}

}
