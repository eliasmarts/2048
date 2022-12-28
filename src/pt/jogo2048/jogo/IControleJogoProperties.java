package pt.jogo2048.jogo;

public interface IControleJogoProperties {
	public int getPontuacao();
	
	public EstadoJogo getEstado();
	
	
	public void setTamX(int tamX);
	
	public void setTamY(int tamY);
	
	public int getTamX();
	
	public int getTamY();
}
