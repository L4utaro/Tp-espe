package com.grupo.dgeg;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.VerticalLayout;

public class MainView extends VerticalLayout implements View {

	public static final String NAME = "MainView";
	
	public MainView(){
		this.setSizeFull();
		
		Button button = new Button("Ir a StartView", new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(StartView.NAME);
			}
		});
		this.addComponent(button);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
