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
import br.edu.ifsudestemg.tsi.eventos.TratadorEventoCadastrarPartido;
import br.edu.ifsudestemg.tsi.eventos.TratadorEventoValidarNumero;

/**
 * Cria conte�do gr�fico da tela de cadastrar partido
 * 
 * @author Mateus Ferreira
 * @author Vinicius Lehmann
 *
 * @see JDialog
 */
public class TelaCadastrarPartido extends JDialog {
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
	private JLabel tituloLabel = new JLabel("Cadastrar Partido");
	private JLabel siglaPartidoLabel = new JLabel(" Sigla: ");
	private JLabel numeroPartidoLabel = new JLabel(" Legenda: ");

	//Fonte
	private Font fonte = new Font("Arial", Font.BOLD, 20);
	private Font fonte2 = new Font("Arial", Font.BOLD, 12);

	//Campos de texto
	private JTextField siglaPartidoField = new JTextField(new Maxlength(10),"",10);
	private JTextField numeroPartidoField = new JTextField(new Maxlength(2),"",5);

	//Bot�o 
	private JButton cadastrar = new JButton("Cadastrar");
	private JButton limpar = new JButton("Limpar");

	//Grid
	private GridBagConstraints gbc = new GridBagConstraints();

	/**
	 * Construtor default que criar� todo conte�do gr�fico da tela
	 */
	public TelaCadastrarPartido() {
		super();
		TratadorEventoCadastrarPartido tratadorEventos = new TratadorEventoCadastrarPartido(this);
		TratadorEventoValidarNumero tratadorEventosNumero = new TratadorEventoValidarNumero(this);
		
		//-----------------------------TITULO DO DIALOGO-----------------------------
		tituloLabel.setFont(fonte);
		painelTitulo.add(tituloLabel);

		//GBC
		gbc.insets = new Insets(5, 15, 10, 10); // Setando espa�os para o GridBadLayout 
		gbc.fill = GridBagConstraints.BOTH;  // Preenche todo a coluna

		//-------------------------------CAMPO NOME CARGO-----------------------------
		siglaPartidoLabel.setFont(fonte2);
		gbc.gridx = 0;
		gbc.gridy = 0;
		painelItens.add(siglaPartidoLabel,gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		siglaPartidoField.addKeyListener(tratadorEventos);
		painelItens.add(siglaPartidoField,gbc);

		//-------------------------------CAMPO QTD DIGITOS-----------------------------
		numeroPartidoLabel.setFont(fonte2);
		gbc.gridx = 0;
		gbc.gridy = 1;
		painelItens.add(numeroPartidoLabel,gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		numeroPartidoField.addKeyListener(tratadorEventosNumero);
		numeroPartidoField.addKeyListener(tratadorEventos);
		painelItens.add(numeroPartidoField,gbc);

		//-------------------------------ADICIONANDO BOTOES-----------------------------
		limpar.addActionListener(tratadorEventos);
		cadastrar.addActionListener(tratadorEventos);
		cadastrar.setEnabled(false);
		limpar.setFocusable(false);
		cadastrar.setFocusable(false);
		painelBotao.add(limpar);
		painelBotao.add(cadastrar);

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
		setTitle("Cadastrar Partido");
		setModal(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/** Retorna refer�ncia do <code>JTextField</code> siglaPartidoField
	 * 
	 * @return refer�ncia do <code>JTextField</code> siglaPartidoField
	 * 
	 * @see JTextField
	 */
	public JTextField getSiglaPartidoField() {
		return siglaPartidoField;
	}

	/** Retorna refer�ncia do <code>JTextField</code> numeroPartidoField
	 * 
	 * @return refer�ncia do <code>JTextField</code> numeroPartidoField
	 * 
	 * @see JTextField
	 */
	public JTextField getNumeroPartidoField() {
		return numeroPartidoField;
	}

	/** Retorna refer�ncia do <code>JButton</code> cadastrar
	 * 
	 * @return refer�ncia do <code>JButton</code> cadastrar
	 * 
	 * @see JButton
	 */
	public JButton getCadastrar() {
		return cadastrar;
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
