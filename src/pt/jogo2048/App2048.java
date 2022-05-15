package pt.jogo2048;

public class App2048 {
	
	public static void main(String[] args) {
		Tabuleiro t = new Tabuleiro();
		Peca p = new Peca(false, 2);
		t.colocarPeca(p, 2, 0);
		
		t.imprimeTabuleiro();
	}
}
