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
		navigator.addView(ListaBusquedaView.NAME, new ListaBusquedaView());
		navigator.addView(GrupoBusquedaView.NAME, new GrupoBusquedaView());
		navigator.addView(NuevoGrupoBusquedaView.NAME, new NuevoGrupoBusquedaView());
		navigator.addView(ListaGrupoBusquedaView.NAME, new ListaGrupoBusquedaView());
		
		
		// TODO Sacar el arbol de la UI y meterlo en su propia clase
		final Tree tree = new Tree("Menu Principal");
		tree.setImmediate(true);
		tree.addItem(BusquedaView.NAME);
		tree.addItem(NuevaBusquedaView.NAME);
		tree.addItem(ListaBusquedaView.NAME);
		tree.addItem(GrupoBusquedaView.NAME);
		tree.addItem(NuevoGrupoBusquedaView.NAME);
		tree.addItem(ListaGrupoBusquedaView.NAME);
		
		tree.setParent(NuevaBusquedaView.NAME, BusquedaView.NAME);
		tree.setParent(ListaBusquedaView.NAME, BusquedaView.NAME);
		tree.setParent(NuevoGrupoBusquedaView.NAME, GrupoBusquedaView.NAME);
		tree.setParent(ListaGrupoBusquedaView.NAME, GrupoBusquedaView.NAME);
				
		tree.setChildrenAllowed(NuevaBusquedaView.NAME, false);
		tree.setChildrenAllowed(ListaBusquedaView.NAME, false);
		tree.setChildrenAllowed(NuevoGrupoBusquedaView.NAME, false);
		tree.setChildrenAllowed(ListaGrupoBusquedaView.NAME, false);
		
				
		tree.addValueChangeListener(new ValueChangeListener() {
			
			@Override
			public void valueChange(ValueChangeEvent event) {
				if (tree.getValue() != null){
					getUI().getNavigator().navigateTo(tree.getValue().toString());
				}
			}
		});
		

		
		HorizontalSplitPanel hsplit = new HorizontalSplitPanel();
		hsplit.setFirstComponent(tree);
		hsplit.setSecondComponent(panel);
		
		hsplit.setSplitPosition(20, Unit.PERCENTAGE);
		setContent(hsplit);
		

    }
}
