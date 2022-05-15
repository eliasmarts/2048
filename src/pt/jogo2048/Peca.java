package pt.jogo2048;

public class Peca {
	private int valor;
	private Tabuleiro tabuleiro;

	
	public Peca(int valor) {
		this.valor = valor;
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
			
			// se bateu em uma peca igual
			if (outroValor == valor) {
				tabuleiro.dobrarPeca(i, y);
				removeu = true;
				break;
			}
			
			// se bateu em uma peca diferente
			if (outroValor > 0) {
				if (i + 1 != x) {
					tabuleiro.colocarPeca(this, i + 1, y);
					removeu = true;
				}
				break;
			}
			
			// se chegou na borda do tabuleiro
			if (i == 0) {
				tabuleiro.colocarPeca(this, i, y);
				removeu = true;
			}
		}
		
		if (removeu)
			tabuleiro.removerPeca(x, y);
	}
	
	
	private void moverBaixo(int x, int y) {
		int outroValor;
		boolean removeu = false;
		for (int i = x + 1; i < tabuleiro.getTamX(); i++) {
			outroValor = tabuleiro.getValorPeca(i, y);
			
			// se bateu em uma peca igual
			if (outroValor == valor) {
				tabuleiro.dobrarPeca(i, y);
				removeu = true;
				break;
			}
			
			// se bateu em uma peca diferente
			if (outroValor > 0) {
				if (i - 1 != x) {
					tabuleiro.colocarPeca(this, i - 1, y);
					removeu = true;
				}
				break;
			}
			
			// se chegou na borda do tabuleiro
			if (i == tabuleiro.getTamX() - 1) {
				tabuleiro.colocarPeca(this, i, y);
				removeu = true;
			}
		}
		
		if (removeu)
			tabuleiro.removerPeca(x, y);
	}
	
	
	private void moverEsquerda(int x, int y) {
		int outroValor;
		boolean removeu = false;
		for (int j = y - 1; j >= 0; j--) {
			outroValor = tabuleiro.getValorPeca(x, j);
			
			// se bateu em uma peca igual
			if (outroValor == valor) {
				tabuleiro.dobrarPeca(x, j);
				removeu = true;
				break;
			}
			
			// se bateu em uma peca diferente
			if (outroValor > 0) {
				if (j + 1 != y) {
					tabuleiro.colocarPeca(this, x, j + 1);
					removeu = true;
				}
				break;
			}
			
			// se chegou na borda do tabuleiro
			if (j == 0) {
				tabuleiro.colocarPeca(this, x, j);
				removeu = true;
			}
		}
		
		if (removeu)
			tabuleiro.removerPeca(x, y);
	}
	
	
	private void moverDireita(int x, int y) {
		int outroValor;
		boolean removeu = false;
		for (int j = y + 1; j < tabuleiro.getTamY(); j++) {
			outroValor = tabuleiro.getValorPeca(x, j);
			
			// se bateu em uma peca igual
			if (outroValor == valor) {
				tabuleiro.dobrarPeca(x, j);
				removeu = true;
				break;
			}
			
			// se bateu em uma peca diferente
			if (outroValor > 0) {
				if (j - 1 != y) {
					tabuleiro.colocarPeca(this, x, j - 1);
					removeu = true;
				}
				break;
			}
			
			// se chegou na borda do tabuleiro
			if (j == tabuleiro.getTamY() - 1) {
				tabuleiro.colocarPeca(this, x, j);
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
		else if (direcao == 's')
			moverBaixo(x, y);
		else if (direcao == 'a')
			moverEsquerda(x, y);
		else
			moverDireita(x, y);
	}
	
	
	public void dobrar() {
		valor *= 2;
	}
}
