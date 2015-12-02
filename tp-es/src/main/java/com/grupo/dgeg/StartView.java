package com.grupo.dgeg;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class StartView extends VerticalLayout implements View {

	public static final String NAME = "";
	
	public StartView(){
		this.setSizeFull();
	}

	@Override
	public void enter(ViewChangeEvent event) {
	}

}
