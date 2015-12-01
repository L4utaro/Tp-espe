package src.main.java.evs;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;

public class MainMenuView extends VerticalLayout implements View{

	public static final String NAME = "MainView";
	
	MainMenuView(){
		setSizeFull();
		
		Button button = new Button("Click Me");
		button.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
			}
		});
		this.addComponent(button);
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		
	}

}
