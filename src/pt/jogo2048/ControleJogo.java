package pt.jogo2048;

import java.util.HashSet;
import java.util.Scanner;

public class ControleJogo {
	private Tabuleiro tabuleiroJogo;
	
	
	
	public void iniciaJogo(int tamX, int tamY) {
		tabuleiroJogo = new Tabuleiro(tamX, tamY);
		tabuleiroJogo.colocarPecaAleatoria();
	}
	
	
	public void jogar(int tamX, int tamY) {
		Scanner entrada = new Scanner(System.in);
		char comando;
		boolean ganhou = false;
		HashSet<Character> comandosValidos = new HashSet<Character>(4);
		comandosValidos.add('w');
		comandosValidos.add('a');
		comandosValidos.add('s');
		comandosValidos.add('d');
		comandosValidos.add('q');
		
		
		iniciaJogo(tamX, tamY);

		while (true) {
			tabuleiroJogo.imprimeTabuleiro();
			System.out.println("(w) cima, (s) baixo, (a) esquerda, (d) direita, (q) sair");
			
			comando = entrada.next().charAt(0);
			
			if (!comandosValidos.contains(comando)) {
				System.out.println("Movimento invalido");
				continue;
			}
			
			
			if (comando == 'q')
				break;
			
			tabuleiroJogo.moverTodasPecas(comando);
			
			if (!tabuleiroJogo.colocarPecaAleatoria()) {
				System.out.println("Voce perdeu =(");
				break;
			}
			
			if (!ganhou && tabuleiroJogo.maiorPeca() == 2048) {
				System.out.println("Voce ganhou!!!");
				ganhou = true;
			}
		}
		
		entrada.close();
	}
}
