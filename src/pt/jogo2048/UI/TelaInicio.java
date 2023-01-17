package pt.jogo2048.UI;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaInicio extends Tela {
	private Tela telaJogo;
	private JButton botaoIniciar;
	
	
	public TelaInicio(Jogo2048UI jogo) {
		super(jogo);
		
		
		
		setLayout(new BorderLayout());
		
		JPanel container = new JPanel();
		
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		container.add(criaLogo());
		
		container.add(criaBotaoIniciar());
		
		add(container, BorderLayout.CENTER);
	}
	
	
	private JButton criaBotaoIniciar() {
		JButton botaoInicio = new JButton("Iniciar Jogo");
		
		botaoInicio.addActionListener((action) -> jogo.mudaTela(telaJogo));
		
		return botaoInicio;
	}


	private JLabel criaLogo() {
		JLabel logo = new JLabel("2048");
		
		logo.setFont(new Font("Arial", CENTER, 100));
		
		return logo;
	}


	public Tela getTelaJogo() {
		return telaJogo;
	}
	
	
	public void setTelaJogo(Tela telaJogo) {
		this.telaJogo = telaJogo;
	}


	@Override
	protected void atualiza() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mostra() {
		super.mostra();
		setSize(getParent().getSize());
	}
	
	
}
