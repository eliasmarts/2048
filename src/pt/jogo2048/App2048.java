package pt.jogo2048;

import pt.jogo2048.UI.IJogo2048UI;
import pt.jogo2048.UI.Jogo2048UI;
import pt.jogo2048.jogo.ControleJogo;
import pt.jogo2048.jogo.IControleJogo;

public class App2048 {
	
	public static void main(String[] args) {
		IJogo2048UI tela = new Jogo2048UI();
		IControleJogo controle = new ControleJogo();
		controle.setTamX(4);
		controle.setTamY(4);
		
		tela.connect(controle);
		
		tela.iniciaJogo();
	}
}
