package pt.jogo2048;

public class Peca {
	private boolean vazio;
	private int valor;
	private Tabuleiro tabuleiro;

	
	public Peca(boolean vazio, int valor) {
		this.vazio = vazio;
		this.valor = valor;
	}
	
	
	public boolean isVazio() {
		return vazio;
	}


	public void setVazio(boolean vazio) {
		this.vazio = vazio;
	}


	public int getValor() {
		return valor;
	}
	
	
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	
	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	
	
	private void moverCima(int x, int y) {
		int outroValor;
		boolean removeu = false;
		for (int i = x - 1; i >= 0; i--) {
			outroValor = tabuleiro.getValorPeca(i, y);
			
			if (outroValor == valor) {
				tabuleiro.dobrarPeca(i, y);
				removeu = true;
				break;
			}
			
			if (outroValor > 0) {
				if (i + 1 != x) {
					tabuleiro.colocarPeca(clone(), i + 1, y);
					removeu = true;
				}
				break;
			}
			
			
			/**
			 * se ta nas bordas do tabuleiro
			 */
			if (i == 0) {
				tabuleiro.colocarPeca(clone(), i, y);
				removeu = true;
			}
		}
		
		if (removeu)
			tabuleiro.removerPeca(x, y);
	}
	
	
	/**
	 * Recebe a posicao atual da peca (x, y) e a direcao do movimento
	 * e move a peca
	 */
	public void mover(int x, int y, char direcao) {
		if (direcao == 'w')
			moverCima(x, y);
	}
	
	
	public void dobrar() {
		valor *= 2;
	}
	
	
	public Peca clone() {
		return new Peca(vazio, valor);
	}
}
