package pt.jogo2048.UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pt.jogo2048.jogo.EstadoJogo;
import pt.jogo2048.jogo.IControleJogo;

public class TelaFim extends Tela {
	private Tela telaInicio;
	private Tela telaJogo;
	private JButton renicia, continua;
	private JLabel text;
	

	public TelaFim(Jogo2048UI jogo, Tela telaInicio, Tela telaJogo) {
		super(jogo);
		this.telaInicio = telaInicio;
		this.telaJogo = telaJogo;
		setLayout(new BorderLayout());
		
		addTexto();
		addBotoes();
	}


	private void addTexto() {
		text = new JLabel();
		text.setFont(new Font("Arial", Font.BOLD, 100));
		add(text, BorderLayout.CENTER);
	}
	
	
	private void addBotoes() {
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout());
		
		addBotaoContinua(container);
		addBotaoRenicia(container);
		
		
		add(container, BorderLayout.SOUTH);
	}
	
	private void addBotaoContinua(JPanel container) {
		continua = new JButton("Continuar");
		continua.addActionListener((arg0) -> jogo.mudaTela(telaJogo));
		continua.setFont(new Font("Arial", Font.BOLD, 30));
		
		container.add(continua);
	}
	
	
	private void addBotaoRenicia(JPanel container) {
		renicia = new JButton("Reniciar");
		renicia.addActionListener(new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				jogo.getControleJogo().iniciaJogo();
				jogo.mudaTela(telaInicio);
			}
			
		});
		
		renicia.setFont(new Font("Arial", Font.BOLD, 30));
		
		container.add(renicia);
	}
	
	
	protected void atualiza() {
		if (jogo.getControleJogo().getEstado() == EstadoJogo.GANHOU) {
			text.setText("Voce ganhou");
			continua.setVisible(true);
		}
		else {
			text.setText("Voce perdeu");
			continua.setVisible(false);
		}
	}
}
