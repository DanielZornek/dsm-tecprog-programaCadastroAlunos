package br.edu.fatecpg.tecprog.listas.view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.fatecpg.tecprog.listas.model.Aluno;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class JFrame1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_nome;
	private JTextField txt_telefone;
	private static ArrayList<Aluno> listaAlunos = new ArrayList<>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame1 frame = new JFrame1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrame1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_nome = new JTextField();
		txt_nome.setToolTipText("Nome do Aluno");
		txt_nome.setBounds(120, 12, 470, 30);
		contentPane.add(txt_nome);
		txt_nome.setColumns(10);
		
		txt_telefone = new JTextField();
		txt_telefone.setToolTipText("Telefone do Aluno");
		txt_telefone.setBounds(120, 86, 470, 30);
		contentPane.add(txt_telefone);
		txt_telefone.setColumns(10);
		
		JButton btn_cadastrar = new JButton("Cadastrar");
		btn_cadastrar.setBackground(new Color(143, 240, 164));
		// clicando duas vezes pelo editor cria isso aqui direto
		btn_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txt_nome.getText();
				String telefone = txt_telefone.getText();
				if(!nome.isEmpty() && !telefone.isEmpty()) {
					//Aluno aluno = new Aluno(nome, telefone);
					//listaAlunos.add(aluno);
					// ou
					listaAlunos.add(new Aluno(nome, telefone));
					JOptionPane.showMessageDialog(btn_cadastrar, "Cadastrado com Sucesso!");
					txt_nome.setText("");
					txt_telefone.setText("");
				}else {
					JOptionPane.showMessageDialog(btn_cadastrar, "Por favor não deixe os campos vazios");
				}
			}
		});
		btn_cadastrar.setBounds(349, 148, 207, 41);
		contentPane.add(btn_cadastrar);
		
		JButton btn_listar = new JButton("Listar");
		btn_listar.setBackground(new Color(153, 193, 241));
		btn_listar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame2 jframe2 = new JFrame2(listaAlunos);
				jframe2.setVisible(true);
			}
		});
		btn_listar.setBounds(557, 348, 124, 36);
		contentPane.add(btn_listar);
	}
}
