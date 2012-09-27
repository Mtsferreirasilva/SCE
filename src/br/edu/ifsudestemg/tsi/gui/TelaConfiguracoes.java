package br.edu.ifsudestemg.tsi.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.edu.ifsudestemg.tsi.eventos.TratadorEventoConfiguracao;

/**
 * Cria conte�do gr�fico da tela de configura��es
 * 
 * @author Mateus Ferreira
 * @author Vinicius Lehmann
 *
 * @see JDialog
 */
public class TelaConfiguracoes extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Icones
	private ImageIcon iconePersonalizado = new ImageIcon("icones/logo2.png" );
	private ImageIcon fundo = new ImageIcon( "imagens/config.png") ;

	//Paineis
	private JPanel painelTitulo = new JPanel();
	private JPanel painelLogo = new JPanel();
	private JPanel painelAtivarHoraSistema = new JPanel();
	private JPanel painelLimparBaseDados = new JPanel();

	//R�tulos
	private JLabel tituloLabel = new JLabel("Configura��es");
	private JLabel ativarHoraSistemaLabel = new JLabel(" Hor�rio para vota��o: ");
	private JLabel logoLabel = new JLabel(fundo);
	
	//Bot�es
	private JButton limparBaseDados = new JButton("Limpar Banco de Dados");
	private JButton aplicar = new JButton("Aplicar");

	//Fonte
	private Font fonte = new Font("Arial", Font.BOLD, 20);
	
	//Combo Box
	private String[] itens = {"Ativado", "Desativado"};
	private JComboBox<String> ativarHoraSistemaCB = new JComboBox<String>(itens);

	/**
	 * Construtor default que criar� todo conte�do gr�fico da tela
	 */
	public TelaConfiguracoes() {
		super();

		//-----------------------------TITULO DO DIALOGO-----------------------------
		tituloLabel.setFont(fonte);
		painelTitulo.add(tituloLabel);
		
		//-----------------------------ADICIONANDO LOGO------------------------------
		painelLogo.add(logoLabel);
		
		if(Interface.horarioAtivado)
			ativarHoraSistemaCB.setSelectedIndex(0);
		else
			ativarHoraSistemaCB.setSelectedIndex(1);
		
		//-----------------------------ADICIONANDO ITENS-----------------------------
		TratadorEventoConfiguracao tratadorEventos = new TratadorEventoConfiguracao(this);
		ativarHoraSistemaCB.addMouseListener(tratadorEventos);
		painelAtivarHoraSistema.add(ativarHoraSistemaLabel);
		painelAtivarHoraSistema.add(ativarHoraSistemaCB);
		
		limparBaseDados.addActionListener(tratadorEventos);
		aplicar.addActionListener(tratadorEventos);
		limparBaseDados.setFocusable(false);
		aplicar.setFocusable(false);
		limparBaseDados.setToolTipText("Apaga todos os registros do Banco de Dados");
		painelAtivarHoraSistema.add(limparBaseDados);
		painelAtivarHoraSistema.add(aplicar);

		//----------------------------ADICIONANDO COR BRANCA-------------------------
		painelTitulo.setBackground(Color.WHITE);
		painelLimparBaseDados.setBackground(Color.WHITE);
		painelAtivarHoraSistema.setBackground(Color.WHITE);
		painelLogo.setBackground(Color.WHITE);

		//---------------------------ADICIOANANDO OS PAINEIS-------------------------
		add(painelTitulo,BorderLayout.NORTH);
		add(painelLogo,BorderLayout.WEST);
		add(painelAtivarHoraSistema,BorderLayout.CENTER);

		//------------------------------ICONE DA JANELA------------------------------
		setIconImage( iconePersonalizado.getImage());

		//-----------------------SETANDO ATRIBUTOS DO JFRAME-------------------------
		setTitle("Configura��es");
		setModal(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(new Dimension(335,140));
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/** Retorna refer�ncia do <code>JButton</code> limparBaseDados
	 * 
	 * @return refer�ncia do <code>JButton</code> limparBaseDados
	 * 
	 * @see JButton
	 */
	public JButton getLimparBaseDados() {
		return limparBaseDados;
	}

	/** Retorna refer�ncia do JComboBox<String> ativarHoraSistemaCB
	 * 
	 * @return refer�ncia do {@code JComboBox<String>} ativarHoraSistemaCB
	 * 
	 * @see JComboBox
	 */
	public JComboBox<String> getAtivarHoraSistemaCB() {
		return ativarHoraSistemaCB;
	}

	/** Retorna refer�ncia do <code>JButton</code> aplicar
	 * 
	 * @return refer�ncia do <code>JButton</code> aplicar
	 * 
	 * @see JButton
	 */
	public JButton getAplicar() {
		return aplicar;
	}
	
}
