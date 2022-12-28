package pt.jogo2048;

import java.util.Scanner;

import pt.jogo2048.UI.TelaJogo;

public class App2048 {
	
	public static void main(String[] args) {
		TelaJogo tela = new TelaJogo(4, 4);
		
		tela.iniciaJogo();
	}
}
