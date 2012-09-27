package br.edu.ifsudestemg.tsi.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.ifsudestemg.tsi.classes.Maxlength;
import br.edu.ifsudestemg.tsi.eventos.TratadorEventoExcluirCargo;

/**
 * Cria conte�do gr�fico da tela de excluir cargo
 * 
 * @author Mateus Ferreira
 * @author Vinicius Lehmann
 *
 * @see JDialog
 */
public class TelaExcluirCargo extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Icones
	private ImageIcon iconePersonalizado = new ImageIcon("icones/logo2.png" );

	//Paineis
	private JPanel painelTitulo = new JPanel();
	private JPanel painelItens = new JPanel(new GridBagLayout());
	private JPanel painelBotao = new JPanel();

	//R�tulos
	private JLabel tituloLabel = new JLabel("Excluir Cargo");
	private JLabel nomeCargoLabel = new JLabel(" Cargo: ");

	//Fonte
	private Font fonte = new Font("Arial", Font.BOLD, 20);
	private Font fonte2 = new Font("Arial", Font.BOLD, 12);

	//Campos de texto
	private JTextField nomeCargoField = new JTextField(new Maxlength(30),"",10);

	//Bot�o 
	private JButton excluir = new JButton("Excluir");
	private JButton limpar = new JButton("Limpar");

	//Grid
	private GridBagConstraints gbc = new GridBagConstraints();

	/**
	 * Construtor default que criar� todo conte�do gr�fico da tela
	 */
	public TelaExcluirCargo(){
		super();
		TratadorEventoExcluirCargo tratadorEventos = new TratadorEventoExcluirCargo(this);
		
		//-----------------------------TITULO DO DIALOGO-----------------------------
		tituloLabel.setFont(fonte);
		painelTitulo.add(tituloLabel);

		//GBC
		gbc.insets = new Insets(5, 15, 10, 10); // Setando espa�os para o GridBadLayout 
		gbc.fill = GridBagConstraints.BOTH;  // Preenche todo a coluna

		//-------------------------------CAMPO NOME CARGO-----------------------------
		nomeCargoLabel.setFont(fonte2);
		gbc.gridx = 0;
		gbc.gridy = 0;
		painelItens.add(nomeCargoLabel,gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		nomeCargoField.addKeyListener(tratadorEventos);
		painelItens.add(nomeCargoField,gbc);

		//-------------------------------ADICIONANDO BOTOES-----------------------------
		limpar.addActionListener(tratadorEventos);
		excluir.addActionListener(tratadorEventos);
		excluir.setEnabled(false);
		limpar.setFocusable(false);
		excluir.setFocusable(false);
		painelBotao.add(limpar);
		painelBotao.add(excluir);

		//----------------------------ADICIONANDO COR BRANCA-----------------------------
		painelTitulo.setBackground(Color.WHITE);
		painelItens.setBackground(Color.WHITE);
		painelBotao.setBackground(Color.WHITE);

		//---------------------------ADICIOANANDO OS PAINEIS-----------------------------
		add(painelTitulo,BorderLayout.NORTH);
		add(painelItens);
		add(painelBotao,BorderLayout.SOUTH);

		//--------------------------------ICONE DA JANELA-------------------------------
		setIconImage( iconePersonalizado.getImage() );

		//--------------------------SETANDO ATRIBUTOS DO JFRAME--------------------------
		pack();
		setTitle("Excluir Cargo");
		setModal(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/** Retorna refer�ncia do <code>JTextField</code> nomeCargoField
	 * 
	 * @return refer�ncia do <code>JTextField</code> nomeCargoField
	 * 
	 * @see JTextField 
	 */
	public JTextField getNomeCargoField() {
		return nomeCargoField;
	}

	/** Retorna refer�ncia do <code>JButton</code> excluir
	 * 
	 * @return refer�ncia do <code>JButton</code> excluir
	 * 
	 * @see JButton 
	 */
	public JButton getExcluir() {
		return excluir;
	}

	/** Retorna refer�ncia do <code>JButton</code> limpar
	 * 
	 * @return refer�ncia do <code>JButton</code> limpar
	 * 
	 * @see JButton 
	 */
	public JButton getLimpar() {
		return limpar;
	}
	
	
}
