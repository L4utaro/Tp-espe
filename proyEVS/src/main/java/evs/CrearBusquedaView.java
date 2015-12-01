package src.main.java.evs;

import javax.swing.GroupLayout.Alignment;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class CrearBusquedaView extends VerticalLayout implements View{
	
	public static final String NAME = "";

	public CrearBusquedaView(){
		setSizeFull();
		
		TextField palabra = new TextField("Palabra");
		TextField coordenada1 = new TextField("Coordenada 1");
		TextField coordenada2 = new TextField("Coordenada 2");
		Button cargarLista = new Button("Cargar Lista");
		Button aceptar = new Button("Aceptar");
		Button cancelar = new Button("Cancelar");
		
		addComponents(palabra, coordenada1, coordenada2, cargarLista, aceptar, cancelar);
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
