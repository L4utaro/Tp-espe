package com.grupo.dgeg;

import javax.servlet.annotation.WebServlet;


import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 *
 */
@Theme("mytheme")
@Widgetset("com.grupo.dgeg.MyAppWidgetset")
public class MyUI extends UI {
	
	 @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	    public static class MyUIServlet extends VaadinServlet {
	    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        
    	final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		
		Navigator navigator = new Navigator(this, layout);
		
		navigator.addView(StartView.NAME, new StartView());
		navigator.addView(MainView.NAME, new MainView());
		

    }
}
