package pt.jogo2048.UI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import pt.jogo2048.jogo.ControleJogo;
import pt.jogo2048.jogo.Tabuleiro;

public class TelaTabuleiro extends JPanel {
	private Tabuleiro tabuleiro;
	private ViewPeca[][] pecas;
	private ControleJogo controle;
	private TelaJogo telaJogo;
	private int x, y;

	public TelaTabuleiro(ControleJogo controle, TelaJogo telaJogo) {
		this.tabuleiro = controle.getTabuleiroJogo();
		this.controle = controle;
		this.telaJogo = telaJogo;
		
		addLabels();
		
		addMoves();
		atualiza();
	}

	

	private void addLabels() {
		this.x = tabuleiro.getTamX();
		this.y = tabuleiro.getTamY();
		pecas = new ViewPeca[x][y];
		
		setLayout(new GridLayout(x, y));
		
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				pecas[i][j] = new ViewPeca();
				
				add(pecas[i][j]);
			}
		}
	}

	public void atualiza() {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				pecas[i][j].atualiza(tabuleiro, i, j);
			}
		}
		super.revalidate();
		super.repaint();
	}
	
	
	private class Move extends AbstractAction {
		private char direction;
		private TelaTabuleiro tela;
		
		
		public Move(char direction, TelaTabuleiro tela) {
			this.direction = direction;
			this.tela = tela;
		}


		@Override
		public void actionPerformed(ActionEvent arg0) {
			tela.jogar(direction);
		}
		
	}
	
	
	private void addMoves() {
		InputMap input = getInputMap();
		ActionMap action = getActionMap();
		
		input.put(KeyStroke.getKeyStroke('w'), "w");
		input.put(KeyStroke.getKeyStroke('a'), "a");
		input.put(KeyStroke.getKeyStroke('s'), "s");
		input.put(KeyStroke.getKeyStroke('d'), "d");
		
		
		action.put("w", new Move('w', this));
		action.put("a", new Move('a', this));
		action.put("s", new Move('s', this));
		action.put("d", new Move('d', this));
		
	}



	public void jogar(char direction) {
		controle.movimento(direction);
		telaJogo.atualiza(controle.getEstado());
		atualiza();
	}
	
}
