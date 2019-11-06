package br.com.team.ordenador_numerico.aplicacao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import br.com.team.ordenador_numerico.negocio.ProcessoOrdenacao;

public class Janela {

	protected JPanel basePane;

	public Janela(JPanel basePane) {
		setBasePane(basePane);
		setNewPane(window(), basePane);
	}

	public JPanel window() {

		JPanel contentPane = new JPanel();

		contentPane.setBackground(new Color(50, 53, 58));

		JLabel lbSaudacao = new JLabel("Bem-vindo");
		lbSaudacao.setBounds(45, 80, 250, 30);
		lbSaudacao.setForeground(Color.lightGray);
		lbSaudacao.setFont(new Font(lbSaudacao.getFont().getName(), lbSaudacao.getFont().getStyle(), 30));
		contentPane.add(lbSaudacao);

		JLabel lbDesc = new JLabel("Obs: Os arquivos gerados ficaram no diretório 'C:\\Temp\\Coordenadas'");
		lbDesc.setBounds(45, 120, 400, 30);
		lbDesc.setForeground(Color.lightGray);
		lbDesc.setFont(new Font(lbDesc.getFont().getName(), lbDesc.getFont().getStyle(), 10));
		contentPane.add(lbDesc);

		JLabel lbNomeArquivo = new JLabel("Digite o nome do arquivo:");
		lbNomeArquivo.setBounds(45, 170, 350, 30);
		lbNomeArquivo.setForeground(Color.lightGray);
		contentPane.add(lbNomeArquivo);

		JTextField campoNomeArquivo = new JTextField(20);
		campoNomeArquivo.setBounds(45, 200, 350, 30);
		campoNomeArquivo.setEditable(true);
		campoNomeArquivo.setForeground(Color.white);
		campoNomeArquivo.setBackground(new Color(48, 48, 48));
		campoNomeArquivo
				.setFont(new Font(campoNomeArquivo.getFont().getName(), campoNomeArquivo.getFont().getStyle(), 15));
		contentPane.add(campoNomeArquivo);

		JLabel lbQtdCoord = new JLabel("Digite a quantidade de coordenadas:");
		lbQtdCoord.setBounds(45, 230, 350, 30);
		lbQtdCoord.setForeground(Color.lightGray);
		contentPane.add(lbQtdCoord);

		JTextField campoQtdCoord = new JTextField(20);
		campoQtdCoord.setBounds(45, 260, 350, 30);
		campoQtdCoord.setEditable(true);
		campoQtdCoord.setForeground(Color.white);
		campoQtdCoord.setBackground(new Color(48, 48, 48));
		campoQtdCoord.setFont(
				new Font(campoQtdCoord.getFont().getName(), campoQtdCoord.getFont().getStyle(), 15));
		contentPane.add(campoQtdCoord);

		JLabel lbTempoExec = new JLabel("Tempo decorrido:");
		lbTempoExec.setBounds(45, 290, 100, 30);
		lbTempoExec.setForeground(Color.lightGray);
		contentPane.add(lbTempoExec);

		JTextArea tareaTempoExec = new JTextArea(1, 2);
		tareaTempoExec.setBounds(45, 315, 350, 60);
		tareaTempoExec.setEditable(false);
		tareaTempoExec.setLineWrap(true);
		tareaTempoExec.setForeground(Color.white);
		tareaTempoExec.setFont(new Font(tareaTempoExec.getFont().getName(), tareaTempoExec.getFont().getStyle(), 12));
		tareaTempoExec.setWrapStyleWord(true);
		tareaTempoExec.setBackground(new Color(48, 48, 48));
		contentPane.add(tareaTempoExec);

		JButton btnGerar = new JButton("Gerar / Ordenar");
		btnGerar.setBounds(45, 390, 150, 30);
		btnGerar.setBackground(new Color(0, 159, 0));
		btnGerar.setForeground(Color.white);
		btnGerar.setOpaque(true);
		btnGerar.setBorderPainted(false);
		contentPane.add(btnGerar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(295, 390, 100, 30);
		btnLimpar.setBackground(new Color(0, 102, 255));
		btnLimpar.setForeground(Color.white);
		btnLimpar.setOpaque(true);
		btnLimpar.setBorderPainted(false);
		contentPane.add(btnLimpar);

		btnGerar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String inputNomeArquivo = campoNomeArquivo.getText();
				int inputTamanhoArquivo = Integer.parseInt(campoQtdCoord.getText());
				ProcessoOrdenacao processo = new ProcessoOrdenacao(inputNomeArquivo, inputTamanhoArquivo);
				String resultadoExec = processo.iniciar();
				tareaTempoExec.setText(resultadoExec);
			}
		});
		
		btnLimpar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				campoNomeArquivo.setText("");	
				campoQtdCoord.setText("");
			}
		});

		return contentPane;

	}

	public void setNewPane(JPanel contentPane, JPanel basePane) {

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBounds(0, 0, 450, 500);
		basePane.add(contentPane);

	}

	public void setBasePane(JPanel basePane) {
		this.basePane = basePane;
	};

}
