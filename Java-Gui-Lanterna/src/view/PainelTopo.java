package view;

import com.googlecode.lanterna.gui2.Direction;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.Panel;

public class PainelTopo {
	
	public Panel getPainel(){
		
		Panel pan = new Panel();
		pan.setLayoutManager(new com.googlecode.lanterna.gui2.LinearLayout(Direction.HORIZONTAL));
		pan.addComponent(new Label("MENU 1 | MENU 2 | MENU 3 | MENU 4 | MENU 5"));
		pan.addComponent(new Label("agora vai"));
		return pan;
	}
	

}
