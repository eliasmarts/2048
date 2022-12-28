package pt.jogo2048.jogo;

import java.util.HashSet;
import java.util.Scanner;

public class ControleJogo {
	private Tabuleiro tabuleiroJogo;
	private EstadoJogo estado;
	
	
	
	public Tabuleiro getTabuleiroJogo() {
		return tabuleiroJogo;
	}


	public EstadoJogo getEstado() {
		return estado;
	}


	public ControleJogo(int tamX, int tamY) {
		tabuleiroJogo = new Tabuleiro(tamX, tamY);
		
	}
	
	
	public void movimento(char direcao) {
			
		tabuleiroJogo.moverTodasPecas(direcao);
		
		if (!tabuleiroJogo.colocarPecaAleatoria()) {
			estado = EstadoJogo.PERDEU;
		}
		
		else if ( tabuleiroJogo.maiorPeca() == 2048) {
			estado = EstadoJogo.GANHOU;
		}
	}


	public void iniciaJogo() {
		tabuleiroJogo.colocarPecaAleatoria();
		
		estado = EstadoJogo.JOGANDO;
	}
}
