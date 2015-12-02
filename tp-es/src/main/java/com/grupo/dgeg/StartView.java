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
		
		Button b = new Button("ASDF", new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(MainView.NAME);
			}
		});
		
		
		this.addComponent(b);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
