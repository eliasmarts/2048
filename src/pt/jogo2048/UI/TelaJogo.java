package pt.jogo2048.UI;

import javax.swing.JFrame;
import javax.swing.JLabel;

import pt.jogo2048.jogo.ControleJogo;
import pt.jogo2048.jogo.EstadoJogo;

public class TelaJogo extends JFrame {
	private ControleJogo controle;
	private TelaTabuleiro tela;

	public TelaJogo(int tamX, int tamY) {
		controle = new ControleJogo(tamX, tamY);
		
		setSize(800, 800);
		
		tela = new TelaTabuleiro(controle, this);
		
		add(tela);
		
		
	}
	
	
	public void iniciaJogo() {
		controle.iniciaJogo();
		atualiza();
		
		
		setVisible(true);
	}
	
	public void atualiza() {
		tela.atualiza();
	}


	public void atualiza(EstadoJogo estado) {
		if (estado == EstadoJogo.GANHOU) {
			remove(tela);
			add(new JLabel("Voce ganhou"));
		}
		else if (estado == EstadoJogo.PERDEU) {
			remove(tela);
			add(new JLabel("Voce perdeu"));
		}
		
		revalidate();
		repaint();
	}
}
