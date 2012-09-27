package br.edu.ifsudestemg.tsi.persistencia;

/**Manipula configura��es gerais do programa
 * 
 * @author Mateus Ferreira
 * @author Vinicius Lehmann
 *
 */
public class ConfiguracoesBD extends Database{

	/**Construtor default
	 * 
	 */
	public ConfiguracoesBD() {
		super();
	}

	/**Verifica se hor�rio para vota��o est� ativado
	 * 
	 * @return Um <code>boolean</code> com <code>true</code> caso hor�rio esteja ativado e <code>false</code> caso contr�rio
	 */
	public boolean statusHoraAtivado(){
		abreConexao();
		if( consultaSQLGenerica("SELECT horarioativo FROM configuracoes").toString().equalsIgnoreCase("[true]")){
			fechaConexao();
			return true;
		}
		fechaConexao();
		return false;
	}
	
	/**Altera status de hor�rio para vota��o
	 * 
	 * @param status <code>boolean</code> com status de hor�rio de vota��o
	 */
	public void alteraStatus(boolean status){
		abreConexao();
		gravar("UPDATE configuracoes SET horarioativo = "+status+" WHERE horarioativo = "+!status);
		fechaConexao();
	}
}
