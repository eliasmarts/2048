package pt.jogo2048;

public class App2048 {
	
	public static void main(String[] args) {
		Tabuleiro t = new Tabuleiro(4, 4);
		Peca p = new Peca(false, 2), g = new Peca(false, 4);
		t.colocarPeca(p, 2, 2);
		t.colocarPeca(g, 0, 1);
		
		t.imprimeTabuleiro();
		
		System.out.println();
		
		
		p.mover(2, 2, 'a');
		g.mover(0, 1, 'd');

		t.imprimeTabuleiro();
	}
}
