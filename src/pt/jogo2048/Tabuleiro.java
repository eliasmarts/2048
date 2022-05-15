package pt.jogo2048;

public class Tabuleiro {
	private Peca tab[][];

	
	public Tabuleiro() {
		tab = new Peca[4][4];
		
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				tab[i][j] = new Peca();
	}
	
	
	public int getValorPeca(int x, int y) {
		return tab[x][y].getValor();
	}
	
	
	public void imprimeTabuleiro() {
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				if (tab[i][j].isVazio())
					System.out.print("- ");
				else
					System.out.println(tab[i][j].getValor() + " ");
			 }
			System.out.println();
	}
	
	
	public void moverPeca(int x, int y, int novox, int novoy) {
		tab[novox][novoy] = tab[x][y].clone();
		tab[x][y].setVazio(true);
	}
	
	
	public void removerPeca(int x, int y) {
		tab[x][y].setVazio(true);
	}
}
