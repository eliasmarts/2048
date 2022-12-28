package pt.jogo2048;

import pt.jogo2048.UI.ITelaJogo;
import pt.jogo2048.UI.TelaJogo;
import pt.jogo2048.jogo.ControleJogo;
import pt.jogo2048.jogo.IControleJogo;

public class App2048 {
	
	public static void main(String[] args) {
		ITelaJogo tela = new TelaJogo();
		IControleJogo controle = new ControleJogo();
		controle.setTamX(4);
		controle.setTamY(4);
		
		tela.connect(controle);
		
		tela.iniciaJogo();
	}
}
