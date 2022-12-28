package pt.jogo2048.UI;

import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JLabel;

import pt.jogo2048.jogo.EstadoJogo;
import pt.jogo2048.jogo.IControleJogo;

public class TelaJogo extends JFrame implements ITelaJogo, Serializable {
	private static final long serialVersionUID = 2237390651565424182L;
	private TelaTabuleiro tela;
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
		
		setSize(800, 800);
		setVisible(true);
	}
	
	public void atualiza() {
		tela.atualiza();
	}


	protected void atualiza(EstadoJogo estado) {
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

	@Override
	public void connect(IControleJogo controle) {
		this.controle = controle;
	}
}