package pt.jogo2048;
import java.util.Random;

public class Tabuleiro {
	private Peca tab[][];
	private int tamX, tamY;

	
	public Tabuleiro(int tamX, int tamY) {
		tab = new Peca[tamX][tamY];
		this.tamX = tamX;
		this.tamY = tamY;
		
		for (int i = 0; i < tamX; i++)
			for (int j = 0; j < tamY; j++) {
				tab[i][j] = new Peca(true, 0);
				tab[i][j].setTabuleiro(this);
			}
	}
	
	
	public int getTamX() {
		return tamX;
	}


	public int getTamY() {
		return tamY;
	}
	
	
	/**
	 * se a peca estiver visivel, retorna seu valor, se nao
	 * estiver retorna -1
	 */
	public int getValorPeca(int x, int y) {
		return tab[x][y].isVazio() ? -1: tab[x][y].getValor();
	}
	
	
	private String fill(String s, int tam) {
		String nova = s;
		
		for (int i = 0; i < tam - s.length(); i++)
			nova += " ";
		
		return nova;
	}
	
	public void imprimeTabuleiro() {
		int maiorP = maiorPeca();
		String s = Integer.toString(maiorP);
		// quantos espacos deve ter para aparecer alinhado
		int tamF = s.length() + 1;

		for (int i = 0; i < tamX; i++) {
			for (int j = 0; j < tamY; j++) {
				if (tab[i][j].isVazio())
					System.out.print(fill("-", tamF));
				else
					System.out.print(fill(Integer.toString(tab[i][j].getValor()), tamF));
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
		
		for (int i = 0; i < tamX; i++)
			for (int j = 0; j < tamY; j++)
				if (tab[i][j].getValor() > maior)
					maior = tab[i][j].getValor();
		
		return maior;
	}
	
	
	private int contarLugaresVazios() {
		int vazios = 0;
		
		for (int i = 0; i < tamX; i++)
			for (int j = 0; j < tamY; j++)
				if (tab[i][j].isVazio())
					vazios++;
		
		return vazios;
	}
	
	
	/**
	 * se exitistirem lugares vazios, gera um numero aleatorio n, 
	 * busca o enésimo lugar, coloca a peca e retorna true.
	 * se não existir retorna false.
	 */
	public boolean colocarPecaAleatoria() {
		int numVazio = contarLugaresVazios();
		boolean colocou = false;
		
		if (numVazio != 0) {
			Random ale = new Random();
			Peca novaPeca = new Peca(false, 2);
			int lugar = ale.nextInt(numVazio), lugarVazioAtual = 0;
			
			for (int i = 0; i < tamX; i++) {
				for (int j = 0; j < tamY; j++) {
					if (!tab[i][j].isVazio())
						continue;
	
					if (lugarVazioAtual == lugar) {
						colocarPeca(novaPeca, i, j);
						colocou = true;
						break;
					}
					lugarVazioAtual++;
				}
				if (colocou)
					break;
			}
				
		}
		
		return colocou;
	}
	
	
	private void moverPecasCima() {
		for (int i = 0; i < tamX; i++)
			for (int j = 0; j < tamY; j++)
				if (!tab[i][j].isVazio())
					tab[i][j].mover(i, j, 'w');
					
	}
	

	private void moverPecasBaixo() {
		for (int i = tamX - 1; i >= 0; i--)
			for (int j = 0; j < tamY; j++)
				if (!tab[i][j].isVazio())
					tab[i][j].mover(i, j, 's');
					
	}
	
	
	private void moverPecasEsquerda() {
		for (int i = 0; i < tamX; i++)
			for (int j = 0; j < tamY; j++)
				if (!tab[i][j].isVazio())
					tab[i][j].mover(i, j, 'a');
					
	}
	
	
	private void moverPecasDireita() {
		for (int i = 0; i < tamX; i++)
			for (int j = tamY - 1; j >= 0; j--)
				if (!tab[i][j].isVazio())
					tab[i][j].mover(i, j, 'd');
					
	}
	
	
	public void moverTodasPecas(char direcao) {
		if (direcao == 'w')
			moverPecasCima();
		else if (direcao == 's')
			moverPecasBaixo();
		else if (direcao == 'a')
			moverPecasEsquerda();
		else
			moverPecasDireita();
	}
}
