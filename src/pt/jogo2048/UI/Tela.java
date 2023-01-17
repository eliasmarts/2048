package pt.jogo2048.UI;

import javax.swing.JLabel;

public abstract class Tela extends JLabel{
	protected Jogo2048UI jogo;
	
	
	
	

	public Tela(Jogo2048UI jogo) {
		super();
		this.jogo = jogo;
	}


	public void mostra() {
		atualiza();
		revalidate();
		repaint();
		
		requestFocusInWindow();
	}


	public void oculta() {
		
	}

	
	protected abstract void atualiza();
}
