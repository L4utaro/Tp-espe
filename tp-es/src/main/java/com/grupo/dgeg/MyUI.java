package com.grupo.dgeg;

import javax.servlet.annotation.WebServlet;









import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Tree;
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
        
    	final Panel panel = new Panel();
		panel.setSizeFull();
		
		
		final Navigator navigator = new Navigator(this, panel);
		
		navigator.addView(StartView.NAME, new StartView());
		navigator.addView(BusquedaView.NAME, new BusquedaView());
		navigator.addView(NuevaBusquedaView.NAME, new NuevaBusquedaView());
		
		
		final Tree tree = new Tree("Menu Principal");
		tree.setImmediate(true);
		tree.addItem("Busqueda");
		tree.addItem("Nueva busqueda");
		
		tree.setParent("Nueva busqueda", "Busqueda");
		
		tree.setChildrenAllowed("Nueva busqueda", false);
		
		tree.addValueChangeListener(new ValueChangeListener() {
			
			@Override
			public void valueChange(ValueChangeEvent event) {
				if (tree.getValue() != null){
					navigator.navigateTo(tree.getValue().toString());
				}
			}
		});
		

		
		HorizontalSplitPanel hsplit = new HorizontalSplitPanel();
		hsplit.setFirstComponent(tree);
		hsplit.setSecondComponent(panel);
		
		hsplit.setSplitPosition(30, Unit.PERCENTAGE);
		setContent(hsplit);
		

    }
}
