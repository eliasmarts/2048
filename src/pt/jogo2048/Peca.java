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
	
	
	/**
	 * Recebe a posicao atual da peca (x, y) e a direcao do movimento
	 * e move a peca
	 */
	public void mover(int x, int y, char direcao) {
		
	}
	
	
	public void dobrar() {
		valor *= 2;
	}
	
	
	public Peca clone() {
		return new Peca(vazio, valor);
	}
}
