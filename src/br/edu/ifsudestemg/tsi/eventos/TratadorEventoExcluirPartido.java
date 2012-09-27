package br.edu.ifsudestemg.tsi.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import br.edu.ifsudestemg.tsi.gui.TelaExcluirCargo;
import br.edu.ifsudestemg.tsi.gui.TelaExcluirPartido;
import br.edu.ifsudestemg.tsi.persistencia.PartidoBD;

/**Tratador de eventos para a tela de excluir partido
 * 
 * @author Mateus Ferreira
 * @author Vinicius Lehmann
 * 
 * @see ActionListener
 * @see KeyAdapter
 *
 */
public class TratadorEventoExcluirPartido extends KeyAdapter implements ActionListener {

	TelaExcluirPartido gui;
	PartidoBD partidoBD = new PartidoBD();

	/** Construtor default
	 * @param gui <code>TelaExcluirCargo</code> com a refer�ncia da tela de excluir partido
	 * 
	 * @see TelaExcluirCargo
	 */
	public TratadorEventoExcluirPartido(TelaExcluirPartido gui) {
		super();
		this.gui = gui;
	}

	@Override
	public void actionPerformed(ActionEvent evento) {

		//Bot�o excluir
		if(evento.getSource() == gui.getExcluir()){
			//Se digitou os dois valida os dois juntos
			if( (!gui.getSiglaField().getText().isEmpty() && !gui.getNumeroField().getText().isEmpty()) &&
					( !partidoBD.pesquisaPartido(gui.getSiglaField().getText().toString(),
							Integer.parseInt( gui.getNumeroField().getText())) ) ){
				JOptionPane.showMessageDialog(null, "Partido n�o cadastrado","Erro",
						JOptionPane.ERROR_MESSAGE);
			}
			else
				//valida unicidade das chaves separadamente
				if(!gui.getNumeroField().getText().isEmpty() && 
						!partidoBD.pesquisaPartido(Integer.parseInt( gui.getNumeroField().getText() )) ){
					JOptionPane.showMessageDialog(null, "N�mero do partido n�o cadastrado","Erro",
							JOptionPane.ERROR_MESSAGE);
				}
				else
					if(!gui.getSiglaField().getText().isEmpty() && 
							!partidoBD.pesquisaPartido(gui.getSiglaField().getText().toString())){
						JOptionPane.showMessageDialog(null, "Sigla do partido n�o cadastrada","Erro",
								JOptionPane.ERROR_MESSAGE);
					}
					//Realiza remo��o dos dados no banco de dados
					else  
					{
						int op;
						op = JOptionPane.showConfirmDialog(null, "Aten��o: Caso haja candidatos cadastrados com este " +
								"\npartido o seu registro ser� excluido. Tem certeza que deseja \nexcluir este partido ?" , 
								"Aten��o" , JOptionPane.YES_NO_OPTION);

						//Caso tenha clicado em SIM
						if(op != 1){
							if(!gui.getNumeroField().getText().isEmpty())
								partidoBD.removePartidoBD(Integer.parseInt( gui.getNumeroField().getText()));
							else
								if(!gui.getSiglaField().getText().isEmpty())
									partidoBD.removePartidoBD(gui.getSiglaField().getText().toString());
						}
						gui.dispose();
					}
		}

		//Bot�o limpar
		if(evento.getSource() == gui.getLimpar()){
			gui.getSiglaField().setText("");
			gui.getNumeroField().setText("");
			gui.getExcluir().setEnabled(false);
		}

	}

	//VALIDA CAMPOS PARA LIBERAR O BOTAO CADASTRAR----------
	public void keyReleased(KeyEvent evento) {
		if(!gui.getSiglaField().getText().isEmpty() || !gui.getNumeroField().getText().isEmpty()){
			gui.getExcluir().setEnabled(true);
		}
		else
			gui.getExcluir().setEnabled(false);
	}

}
