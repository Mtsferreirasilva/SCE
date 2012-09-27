package br.edu.ifsudestemg.tsi.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Cria conte�do gr�fico da tela de cr�ditos
 * 
 * @author Mateus Ferreira
 * @author Vinicius Lehmann
 *
 * @see JDialog
 */
public class TelaCreditos extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Icones
	private ImageIcon iconePersonalizado = new ImageIcon("icones/logo2.png" );

	//Paineis
	private JPanel painelTitulo = new JPanel();
	private JPanel painelTexto = new JPanel();

	//R�tulos
	private JLabel tituloLabel = new JLabel("Cr�ditos");
	private JLabel textoLabel = new JLabel();

	//Fonte
	private Font fonte = new Font("Arial", Font.BOLD, 20);
	private Font fonte2 = new Font("Arial", Font.PLAIN, 13);
	/**
	 * Construtor default que criar� todo conte�do gr�fico da tela
	 */
	public TelaCreditos(){
		super();

		//-----------------------------TITULO DO DIALOGO-----------------------------
		tituloLabel.setFont(fonte);
		painelTitulo.add(tituloLabel);

		//----------------------------ADICIONANDO COR BRANCA-------------------------
		painelTitulo.setBackground(Color.WHITE);
		painelTexto.setBackground(Color.WHITE);
		
		//------------------------------ADICIONANDO TEXTOS---------------------------
		textoLabel.setFont(fonte2);
		textoLabel.setText(
				"<html><center>" +
				"<font size='5' color='#68B92C'><b>Instituto Federal de Educa��o," +
				"<b><br>Ci�ncia e Tecnologia</font>" +
				"<br><font size = '3' color='#000000'><hr><br><b>Mateus Ferreira Silva</b> - TSI 3� Per�odo - Barbacena" +
				"<b><br>Vinicius Lehmann</b> - TSI 3� Per�odo - Barbacena</font>" +
				"<br></html>");
	
		painelTexto.add(textoLabel,BorderLayout.WEST);
		painelTexto.setBorder(BorderFactory.createTitledBorder(""));

		//------------------------------ICONE DA JANELA------------------------------
		setIconImage( iconePersonalizado.getImage() );

		//---------------------------ADICIOANANDO OS PAINEIS-------------------------
		add(painelTitulo,BorderLayout.NORTH);
		add(painelTexto,BorderLayout.CENTER);

		//-----------------------SETANDO ATRIBUTOS DO JFRAME-------------------------
		setTitle("Cr�ditos");
		setModal(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(new Dimension(330,200));
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
