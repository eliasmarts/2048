package pt.jogo2048;

import java.util.Scanner;

public class App2048 {
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		ControleJogo controle = new ControleJogo();
		int tamX, tamY;
		
		System.out.println("Escolha o tamanho do tabuleiro");

		System.out.print("Linhas: ");
		tamX = entrada.nextInt();
		
		System.out.print("Colunas: ");
		tamY = entrada.nextInt();
		System.out.println();
		
		System.out.println("Iniciando jogo");
		controle.jogar(tamX, tamY);
	}
}
