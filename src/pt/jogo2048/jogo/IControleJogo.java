package pt.jogo2048.jogo;

public interface IControleJogo extends IControleJogoProperties {
	public void movimento(char direcao);
	
	public void iniciaJogo();

	public Tabuleiro getTabuleiroJogo();
}
