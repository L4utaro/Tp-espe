package src.main.java.evs;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Tree;

public class MenuTree extends CustomComponent{
	String NAME = "";
	
	public void init(String context){
		Tree tree = new Tree("Menu Principal");
		tree.addItem("Busquedas");
		tree.addItem("Lista de Busquedas");
		
		tree.setParent("Lista De Busquedas", "Busquedas");
		
		tree.setChildrenAllowed("Lista de Busquedas", false);
		
		tree.addItemClickListener(new ItemClickListener() {
			
			@Override
			public void itemClick(ItemClickEvent event) {
			}
		});
	}

}
