package controller;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.Theme;
import com.googlecode.lanterna.graphics.ThemeDefinition;
import com.googlecode.lanterna.graphics.ThemeStyle;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import view.Painel1;
import view.PainelTopo;

public class Main {
	
	//Playing a little bit with Lanterna GUI

	public static void main(String[] args) throws IOException {

		//------------------------------ Setup terminal and screens layers ----------------------------------------
		Terminal terminal = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(140, 35)).createTerminal();
		Screen screen = new TerminalScreen(terminal);		
		screen.startScreen();
		
		
		//----------------------------------------ADICIONAR PAINEIS -----------------------------------------------
		
		Panel painel1 = new Painel1().getPainel();
		Panel painelTopo = new PainelTopo().getPainel();
		
		
		//----------------------------------------FIM DA ÁREA DE COMPONENTES ------------------------------------------
		
		
        //------------------------------------------------ JANELAS ----------------------------------------------------
		BasicWindow topo = new BasicWindow(); //janela do topo servindo de menu horizontal
        topo.setHints(Arrays.asList(Window.Hint.FIXED_POSITION));
        topo.setPosition(new TerminalPosition(0, 0));
        topo.setComponent(painelTopo);
		
		BasicWindow centro = new BasicWindow("JANELA"); //janela do centro, corpo do programa
        centro.setHints(Arrays.asList(Window.Hint.CENTERED));
        centro.setComponent(painel1);
        

        //----------------------------------------- Create GUI and start GUI ------------------------------------------------
        MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE));
        gui.addWindow(topo);
        gui.addWindowAndWait(centro);
        
        
		
	}

}
