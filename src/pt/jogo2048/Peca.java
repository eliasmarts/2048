package pt.jogo2048;

public class Peca {
	private boolean vazio;
	private int valor;
	

	public Peca() {
		this.vazio = true;
		this.valor = 0;
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
	
	
	public void mover(char direcao) {
		
	}
	
	
	public void dobrar() {
		valor *= 2;
	}
	
	
	public Peca clone() {
		Peca c = new Peca();
		c.setVazio(isVazio());
		c.setValor(getValor());
		return c;
	}
}
