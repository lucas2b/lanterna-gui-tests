import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class Main {
	
	//Playing a little bit with Lanterna GUI

	public static void main(String[] args) throws IOException {

		//------------------------------ Setup terminal and screens layers ----------------------------------------
		Terminal terminal = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(160, 45)).createTerminal();
		Screen screen = new TerminalScreen(terminal);		
		screen.startScreen();
		
		
		//-------------------------------------- Panel (circundado preto)-----------------------------------------
		Panel panel = new Panel();
        panel.setLayoutManager(new com.googlecode.lanterna.gui2.GridLayout(2));
        //teste
        //teste commit
        
        //---------------------------------- Components inside the panel -----------------------------------------
        panel.addComponent(new Label("Simple form "));
        panel.addComponent(new EmptySpace());
        
        panel.addComponent(new Label("Name: "));
        final TextBox name = new TextBox();
        panel.addComponent(name);
        
        
        final TextBox surename = new TextBox();
        panel.addComponent(new Label("Surename: "));
        panel.addComponent(surename);
           
        Button okay = new Button("Show", new Runnable() {
			
			@Override
			public void run() {
				JOptionPane.showMessageDialog(null, "Hello "+name.getText()+" "+surename.getText());
				
			}
		});
        panel.addComponent(new Label(""));
        panel.addComponent(okay);
        
        //------------------------------------ Form submission (calculator)--------------------------------------------------
        panel.addComponent(new EmptySpace());
        panel.addComponent(new EmptySpace());
        panel.addComponent(new Label("Calculator "));
        panel.addComponent(new EmptySpace());
        
        final Label lblOutput = new Label("");

        panel.addComponent(new Label("Num 1:"));
        final TextBox txtNum1 = new TextBox().setValidationPattern(Pattern.compile("[0-9]*")).addTo(panel);

        panel.addComponent(new Label("Num 2:"));
        final TextBox txtNum2 = new TextBox().setValidationPattern(Pattern.compile("[0-9]*")).addTo(panel);

        panel.addComponent(new EmptySpace(new TerminalSize(0, 0)));
        new Button("Add!", new Runnable() {
            @Override
            public void run() {
                int num1 = Integer.parseInt(txtNum1.getText());
                int num2 = Integer.parseInt(txtNum2.getText());
                lblOutput.setText(Integer.toString(num1 + num2));
            }
        }).addTo(panel);

        panel.addComponent(new EmptySpace(new TerminalSize(0,0)));
        panel.addComponent(lblOutput);
        
      //------------------------------------------------ COMBO BOX ---------------------------------------------------------
        panel.addComponent(new Label("Combo box:"));
        panel.addComponent(new Label(""));
        
        ComboBox<String> comboBox = new ComboBox<String>();
        comboBox.addItem("Pelotas");
        comboBox.addItem("Porto Alegre");
        comboBox.addItem("Alegrete");
        comboBox.addItem("Lajeado");
        
        comboBox.setPreferredSize(new TerminalSize(15, 1));
        panel.addComponent(comboBox);
        panel.addComponent(new EmptySpace());
        Button bt2 = new Button("Show Selection", new Runnable() {
			
			@Override
			public void run() {
				JOptionPane.showMessageDialog(null, comboBox.getSelectedItem());
				
			}
		});
        bt2.addTo(panel);
        panel.addComponent(new Label(""));
        panel.addComponent(new Label(""));
      //------------------------------------------------- CHECK BOX --------------------------------------------------------
        
        panel.addComponent(new Label("Check Box:"));
        panel.addComponent(new Label(""));
        CheckBoxList<String> checkBox = new CheckBoxList<String>();
        checkBox.addItem("Maiara");
        checkBox.addItem("Lucas");
        checkBox.addItem("Joao");
        checkBox.addItem("Pedro");
        Button bt3 = new Button("Show Selection", new Runnable() {
			
			@Override
			public void run() {
				JOptionPane.showMessageDialog(null, "Selected: "+checkBox.getSelectedItem());
				
			}
		}).addTo(panel);
        panel.addComponent(checkBox);
        
        
        //--------------------------------- Create window to hold the panel (gray color) ------------------------------------
        BasicWindow window = new BasicWindow("JANELA");
        window.setHints(Arrays.asList(Window.Hint.CENTERED));
       
        window.setComponent(panel);

        //----------------------------------------- Create GUI and start GUI ------------------------------------------------
        MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE));
        gui.addWindowAndWait(window);
			
		
	}

}
