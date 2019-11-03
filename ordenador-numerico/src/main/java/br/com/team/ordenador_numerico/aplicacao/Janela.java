package br.com.team.ordenador_numerico.aplicacao;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Janela{
	
	protected JPanel basePane;

	public Janela(JPanel basePane) {
		
		SetBasePane(basePane);
		SetNewPane(Window(), basePane);
		
	}

	public JPanel Window() {
		
		JPanel contentPane = new JPanel();
		
		contentPane.setBackground(new Color(50, 53, 58));
		
		JLabel desc = new JLabel("Para começar clique no botão");
		desc.setBounds(80, 80, 400, 30);
		desc.setForeground(Color.lightGray);
		desc.setFont(new Font(desc.getFont().getName(), desc.getFont().getStyle(), 20));;
		contentPane.add(desc);
		
		JLabel desc2 = new JLabel("'Gerar / Ordenar'");
		desc2.setBounds(140, 120, 400, 30);
		desc2.setForeground(Color.lightGray);
		desc2.setFont(new Font(desc.getFont().getName(), desc.getFont().getStyle(), 20));;
		contentPane.add(desc2);
		
		JLabel log = new JLabel("Tempo decorrido:");
		log.setBounds(48, 228, 100, 30);
		log.setForeground(Color.lightGray);
		contentPane.add(log);
						
		JTextArea t1 = new JTextArea(1,2);
		t1.setBounds(45, 260, 350, 100);
		t1.setEditable(false);
		t1.setLineWrap(true);
		t1.setWrapStyleWord(true);
		t1.setBackground(new Color(48, 48, 48));
		contentPane.add(t1);
		
		JButton gerar = new JButton("Gerar / Ordenar");
		gerar.setBounds(45, 390, 150, 30);
		gerar.setBackground(new Color(0, 159, 0));
		gerar.setForeground(Color.white);
		gerar.setOpaque(true);
		gerar.setBorderPainted(false);
		contentPane.add(gerar);		
		
		JButton limpar = new JButton("Limpar");
		limpar.setBounds(295, 390, 100, 30);
		limpar.setBackground(new Color(0, 102, 255));
		limpar.setForeground(Color.white);
		limpar.setOpaque(true);
		limpar.setBorderPainted(false);
		contentPane.add(limpar);
		
		//event listeners
		
		return contentPane;
		
	}
	
	public void SetNewPane(JPanel contentPane, JPanel basePane) {
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBounds(0, 0, 450, 500);
		basePane.add(contentPane);
		
	}
	
	public void SetBasePane(JPanel basePane){
		this.basePane = basePane;
	};
	
}
