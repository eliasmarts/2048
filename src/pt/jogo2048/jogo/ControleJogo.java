package pt.jogo2048.jogo;

import java.io.Serializable;

public class ControleJogo implements IControleJogo, Serializable {
	private static final long serialVersionUID = 6529701263675348160L;
	private Tabuleiro tabuleiroJogo;
	private EstadoJogo estado;
	private int tamX, tamY;
	
	
	
	public Tabuleiro getTabuleiroJogo() {
		return tabuleiroJogo;
	}


	public EstadoJogo getEstado() {
		return estado;
	}
	
	
	public ControleJogo() {
		
	}
	
	
	public void movimento(char direcao) {
		if (tabuleiroJogo == null)
			throw new IllegalStateException("O jogo ainda nao foi iniciado");
		
			
		tabuleiroJogo.moverTodasPecas(direcao);
		
		if (!tabuleiroJogo.colocarPecaAleatoria()) {
			estado = EstadoJogo.PERDEU;
		}
		
		else if ( tabuleiroJogo.maiorPeca() == 2048) {
			estado = EstadoJogo.GANHOU;
		}
	}


	public void iniciaJogo() {
		if (tamX <= 0 || tamY <= 0)
			throw new IllegalStateException("Tamanhos devem ser positivos");
		
		tabuleiroJogo = new Tabuleiro(tamX, tamY);
		
		tabuleiroJogo.colocarPecaAleatoria();
		
		estado = EstadoJogo.JOGANDO;
	}


	@Override
	public int getPontuacao() {
		// TODO Auto-generated method stub
		return 0;
	}


	public int getTamX() {
		return tamX;
	}


	public void setTamX(int tamX) {
		this.tamX = tamX;
	}


	public int getTamY() {
		return tamY;
	}


	public void setTamY(int tamY) {
		this.tamY = tamY;
	}


}
