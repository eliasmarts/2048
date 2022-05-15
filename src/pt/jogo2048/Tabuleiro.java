package pt.jogo2048;

public class Tabuleiro {
	private Peca tab[][];

	
	public Tabuleiro() {
		tab = new Peca[4][4];
		
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				tab[i][j] = new Peca(true, 0);
				tab[i][j].setTabuleiro(this);
			}
	}
	
	
	public int getValorPeca(int x, int y) {
		return tab[x][y].isVazio() ? 0: tab[x][y].getValor();
	}
	
	
	public void imprimeTabuleiro() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (tab[i][j].isVazio())
					System.out.print("- ");
				else
					System.out.print(tab[i][j].getValor() + " ");
			 }
			System.out.println();
		}
	}
	
	
	public void colocarPeca(Peca p, int x, int y) {
		p.setTabuleiro(this);
		tab[x][y] = p;
	}
	
	
	public void removerPeca(int x, int y) {
		tab[x][y].setVazio(true);
	}
	
	
	public void dobrarPeca(int x, int y) {
		tab[x][y].dobrar();
	}
	
	
	public int maiorPeca() {
		int maior = 0;
		
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				if (tab[i][j].getValor() > maior)
					maior = tab[i][j].getValor();
		
		return maior;
	}
}
