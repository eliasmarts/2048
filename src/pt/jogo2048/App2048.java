package pt.jogo2048;

public class App2048 {
	
	public static void main(String[] args) {
		Tabuleiro t = new Tabuleiro();
		t.colocarPecaAleatoria();
		
		t.imprimeTabuleiro();
	}
}
