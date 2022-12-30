package pt.jogo2048.UI;


import java.awt.FlowLayout;
import java.io.Serializable;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import pt.jogo2048.jogo.EstadoJogo;
import pt.jogo2048.jogo.IControleJogo;


public class TelaJogo extends JFrame implements ITelaJogo, Serializable {
	private static final long serialVersionUID = 2237390651565424182L;
	private TelaTabuleiro tela;
	private TelaFim telaFim;
	private IControleJogo controle;
	
	public TelaJogo() {
		super();
		
	}
	
	
	public void iniciaJogo() {
		if (controle == null)
			throw new IllegalStateException("Esse componente precisa ser conectado com um IControleJogo");
		
		controle.iniciaJogo();
		tela = new TelaTabuleiro(controle, this);
		add(tela);
		
		telaFim = new TelaFim(this, controle);
		
		setSize(800, 800);
		
		tela.requestFocusInWindow();
		setVisible(true);
	}
	
	public void atualiza() {
		atualiza(controle.getEstado());
		tela.atualiza();
	}


	protected void atualiza(EstadoJogo estado) {
		if (estado != EstadoJogo.JOGANDO) {
			remove(tela);
			telaFim.atualiza();
			add(telaFim);
			
		}
		
		revalidate();
		repaint();
	}

	@Override
	public void connect(IControleJogo controle) {
		this.controle = controle;
	}


	protected void renicia() {
		controle.iniciaJogo();
		remove(telaFim);
		add(tela);
		tela.requestFocusInWindow();
		atualiza();
	}


	protected void continua() {
		remove(telaFim);
		add(tela);
		tela.requestFocusInWindow();
		atualiza();
	}
}
