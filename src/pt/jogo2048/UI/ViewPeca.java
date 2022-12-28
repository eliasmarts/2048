package pt.jogo2048.UI;

import java.awt.Color;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pt.jogo2048.jogo.Tabuleiro;

public class ViewPeca extends JPanel {
	private static Map<Integer, Color> colors = Map.of(
			2, Color.GRAY,
			4, Color.CYAN,
			8, Color.GREEN,
			16, Color.YELLOW,
			32, Color.ORANGE,
			64, Color.RED,
			128, Color.PINK,
			256, Color.BLUE
		);
	
	private JLabel textoPeca;

	public ViewPeca() {
		textoPeca = new JLabel("-");
		
		add(textoPeca);
		
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	
	public void atualiza(Tabuleiro tab, int x, int y) {
		if (tab.getValorPeca(x, y) == -1) {
			textoPeca.setText("-");
		}
		else
			textoPeca.setText(Integer.toString(tab.getValorPeca(x, y)));
		
		atualizaBackground(tab.getValorPeca(x, y));
	}
	
	
	private void atualizaBackground(int valor) {
		if (valor == -1) {
			setBackground(null);
		}
		while (valor > 256) {
			valor = valor / 256;
		}
		
		setBackground(colors.get(valor));
		
		revalidate();
		repaint();
	}
}
