package pt.jogo2048.UI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import pt.jogo2048.jogo.EstadoJogo;
import pt.jogo2048.jogo.IControleJogo;
import pt.jogo2048.jogo.Tabuleiro;

public class TelaTabuleiro extends Tela {
	private static final long serialVersionUID = -8950615515098707709L;
	private ViewPeca[][] pecas;
	private int x, y;
	private Tela telaFim;
	private Tabuleiro tabuleiro;
	
	

	

	public TelaTabuleiro(Jogo2048UI jogo) {
		super(jogo);
		
		jogo.getControleJogo().iniciaJogo();
		
		this.tabuleiro = jogo.getControleJogo().getTabuleiroJogo();
		
		addLabels();
		addMoves();
	}

	private void addLabels() {
		x = tabuleiro.getTamX();
		y = tabuleiro.getTamY();
		pecas = new ViewPeca[x][y];
		
		setLayout(new GridLayout(x, y));
		
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				pecas[i][j] = new ViewPeca();
				
				add(pecas[i][j]);
			}
		}
	}

	protected void atualiza() {
		tabuleiro = jogo.getControleJogo().getTabuleiroJogo();
		
		
		
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				pecas[i][j].atualiza(tabuleiro, i, j);
			}
		}
		super.revalidate();
		super.repaint();
		
		atualizaEstado();
	}
	
	
	private void atualizaEstado() {
		if (jogo.getControleJogo().getEstado() != EstadoJogo.JOGANDO)
			jogo.mudaTela(telaFim);
	}


	private class Move extends AbstractAction {
		private static final long serialVersionUID = 6665069484280622954L;
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



	protected void jogar(char direction) {
		jogo.getControleJogo().movimento(direction);
		atualiza();
	}

	public void setTelaFim(Tela telaFim) {
		this.telaFim = telaFim;
	}
	
}
