package com.grupo.dgeg;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class NuevoGrupoBusquedaView extends VerticalLayout implements View {
	
	public static final String NAME = "Nuevo Grupo de Búsqueda";

	public NuevoGrupoBusquedaView() {
		final TextField nombre = new TextField("Nombre");
		final TextField descripcion = new TextField("Descripcion");
		Button aceptar = new Button("Aceptar", new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				if (tfValido(nombre.getValue())
						&& tfValido(descripcion.getValue())){
					GrupoBusqueda gb = new GrupoBusqueda(nombre.getValue(), descripcion.getValue());
					nombre.setValue("");
					descripcion.setValue("");
				}
			}

			private boolean tfValido(String palabra) {
				return (palabra != null 
				&& (palabra.trim().length() > 0));
			}
		});
		Button cancelar = new Button("Cancelar");
		
		this.addComponents(nombre, descripcion, aceptar, cancelar);
		
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}
