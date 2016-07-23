package view;

import com.googlecode.lanterna.gui2.ComboBox;
import com.googlecode.lanterna.gui2.Direction;
import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.Panel;

public class PainelTopo {
	
	public Panel getPainel(){
		
		ComboBox<String> vendas = new ComboBox<String>();
		vendas.addItem("Vendas");
		vendas.addItem("Emitir Nota");
		vendas.addItem("Consultar venda");
		
		ComboBox<String> estoque = new ComboBox<String>();
		estoque.addItem("Estoque");
		estoque.addItem("Atualizar");
		estoque.addItem("Dar baixa");
		
		ComboBox<String> faturamento = new ComboBox<String>();
		faturamento.addItem("Faturamento");
		faturamento.addItem("Cadastrar");
		faturamento.addItem("Dar Baixa");
		
		
		String vazio = new String("                                         ");
		
		Panel pan = new Panel();
		pan.setLayoutManager(new com.googlecode.lanterna.gui2.LinearLayout(Direction.HORIZONTAL));
		pan.addComponent(new Label(vazio));
		
		pan.addComponent(vendas);
		pan.addComponent(new EmptySpace());
		pan.addComponent(estoque);
		pan.addComponent(new EmptySpace());
		pan.addComponent(faturamento);
		
		pan.addComponent(new Label(vazio));
		
		return pan;
	}
	

}
