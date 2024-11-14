package br.edu.fatecpg.tecprog.listas.view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.fatecpg.tecprog.listas.model.Aluno;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;

public class JFrame2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_muda_nome;
	private JTextField txt_muda_telefone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame2 frame = new JFrame2(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrame2(ArrayList<Aluno> listaAlunos) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox comboBox = new JComboBox<>(listaAlunos.toArray(new Aluno[0]));
		comboBox.setBounds(28, 48, 332, 50);
		contentPane.add(comboBox);

		JLabel lbl_nome = new JLabel("New label");
		lbl_nome.setFont(new Font("Dialog", Font.BOLD, 16));
		lbl_nome.setBounds(494, 51, 194, 43);
		contentPane.add(lbl_nome);

		JLabel lbl_telefone = new JLabel("New label");
		lbl_telefone.setFont(new Font("Dialog", Font.BOLD, 16));
		lbl_telefone.setBounds(494, 119, 194, 43);
		contentPane.add(lbl_telefone);

		System.out.println(listaAlunos);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(btnExcluir, "Deseja mesmo excluir?");
				Aluno alunoSelecionado = (Aluno) comboBox.getSelectedItem();

				if (resposta == JOptionPane.YES_OPTION) {
					if (listaAlunos.indexOf(alunoSelecionado) == -1) {
						JOptionPane.showMessageDialog(btnExcluir, "Usuário já excluído anteriormente");
					} else {
						listaAlunos.remove(listaAlunos.indexOf(alunoSelecionado));
						JOptionPane.showMessageDialog(btnExcluir, "Usuário excluído");
						comboBox.removeItem(alunoSelecionado);
					}

				} else if (resposta == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(btnExcluir, "Ok, usuário ainda cadastrado");
				} else {
					JOptionPane.showMessageDialog(btnExcluir, "Operação Cancelada");
				}
			}
		});

		btnExcluir.setFont(new Font("Dialog", Font.BOLD, 16));
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setBackground(new Color(192, 28, 40));
		btnExcluir.setBounds(142, 365, 149, 43);
		contentPane.add(btnExcluir);

		txt_muda_nome = new JTextField();
		txt_muda_nome.setToolTipText("Alterar o nome");
		txt_muda_nome.setBounds(28, 146, 313, 36);
		contentPane.add(txt_muda_nome);
		txt_muda_nome.setColumns(10);

		txt_muda_telefone = new JTextField();
		txt_muda_telefone.setToolTipText("Alterar o Telefone");
		txt_muda_telefone.setColumns(10);
		txt_muda_telefone.setBounds(28, 219, 313, 36);
		contentPane.add(txt_muda_telefone);

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aluno alunoSelecionado = (Aluno) comboBox.getSelectedItem();
				if (alunoSelecionado != null) {
					lbl_nome.setText(alunoSelecionado.getNome());
					lbl_telefone.setText(alunoSelecionado.getTelefone());
				}
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Aluno alunoSelecionado = (Aluno) comboBox.getSelectedItem();
				if(txt_muda_nome.getText().isEmpty() || txt_muda_telefone.getText().isEmpty()) {
					JOptionPane.showMessageDialog(txt_muda_nome, "Os campos não podem estar vazios para alterar os valores atuais!");
				}else {
					int resposta = JOptionPane.showConfirmDialog(txt_muda_nome, "Deseja mesmo editar?");
					if (resposta == JOptionPane.YES_OPTION) {
						System.out.println(alunoSelecionado.getNome()+ " - " + alunoSelecionado.getTelefone());
						alunoSelecionado.setNome(txt_muda_nome.getText());
						alunoSelecionado.setTelefone(txt_muda_telefone.getText());
						JOptionPane.showMessageDialog(txt_muda_nome,"Alteração realizada com sucesso");
						System.out.println(alunoSelecionado.getNome()+ " - " + alunoSelecionado.getTelefone());
					}else if(resposta == JOptionPane.NO_OPTION) {
						JOptionPane.showMessageDialog(txt_muda_nome, "Dados não serão alterados");
					}else {
						JOptionPane.showMessageDialog(txt_muda_nome, "Operação Cancelada!");
					}
				}
			}
		});
		
		btnEditar.setForeground(Color.BLACK);
		btnEditar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnEditar.setBackground(new Color(229, 165, 10));
		btnEditar.setBounds(431, 365, 149, 43);
		contentPane.add(btnEditar);

	}
}
