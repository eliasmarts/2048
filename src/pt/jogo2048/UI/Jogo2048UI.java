package pt.jogo2048.UI;


import java.awt.BorderLayout;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JLabel;

import pt.jogo2048.jogo.IControleJogo;


public class Jogo2048UI extends JFrame implements IJogo2048UI, Serializable {
	private static final long serialVersionUID = 2237390651565424182L;
	private IControleJogo controle;
	private Tela telaAtual;
	
	public Jogo2048UI() {
		super("2048");
		setSize(800, 800);
		
		setLayout(new BorderLayout());
		
		setVisible(true);
	}
	
	
	public void iniciaJogo() {
		if (controle == null)
			throw new IllegalStateException("Esse componente precisa ser conectado com um IControleJogo");
		
		criaTelas();
		
		
	}
	
	
	protected void mudaTela(Tela tela) {
		if (telaAtual != null) {
			telaAtual.oculta();
		
			remove(telaAtual);
		}
		
		super.add(tela, BorderLayout.CENTER);
		
		System.out.println(getComponentCount());
		tela.mostra();
		
		this.telaAtual = tela;
		
		revalidate();
		repaint();
	}
	
	
	private void criaTelas() {
		TelaTabuleiro tab = new TelaTabuleiro(this);
		TelaInicio inicio = new TelaInicio(this);
		TelaFim fim = new TelaFim(this, inicio, tab);
		
		inicio.setTelaJogo(tab);
		tab.setTelaFim(fim);
		
		mudaTela(inicio);
	}
	
	
	protected IControleJogo getControleJogo() {
		return controle;
	}

	@Override
	public void connect(IControleJogo controle) {
		this.controle = controle;
	}
}
