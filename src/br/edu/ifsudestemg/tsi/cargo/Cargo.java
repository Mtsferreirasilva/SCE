package br.edu.ifsudestemg.tsi.cargo;

import br.edu.ifsudestemg.tsi.persistencia.CargoBD;

/**
 * Manipula dados referentes a cargos
 * 
 * @author Mateus Ferreira
 * @author Vinicius Lehmann
 * 
 * @see CargoBD
 */
public class Cargo extends CargoBD{

		private String nome;
		private int qtdDigitos;
		
		/**
		 * Construtor default
		 */
		public Cargo() {
			super();
		}

		/**Cria um cargo com nome e quantidade de d�gitos espec�ficos
		 * 
		 * @param nome <code>String</code> com nome do cargo
		 * @param qtdDigitos <code>Int</code> com quantidade de d�gitos para o n�mero deste cargo 
		 */
		public Cargo(String nome, int qtdDigitos) {
			super();
			this.nome = nome.toUpperCase();
			this.qtdDigitos = qtdDigitos;
		}

		/**Retorna nome do cargo
		 * 
		 * @return Uma <code>String</code> com nome do cargo
		 */
		public String getNome() {
			return nome;
		}

		/**Adiciona nome a um cargo
		 * 
		 * @param nome <code>String</code> com nome do cargo
		 */
		public void setNome(String nome) {
			this.nome = nome.toUpperCase();
		}

		/**Retorna quantidade de d�gitos do cargo
		 * 
		 * @return <code>String</code> com quantidade de d�gitos do cargo
		 */
		public int getQtdDigitos() {
			return qtdDigitos;
		}

		/**Adiciona quantidade de d�gitos a um cargo
		 * 
		 * @param qtdDigitos <code>String</code> com quantidade d�gitos do cargo
		 */
		public void setQtdDigitos(int qtdDigitos) {
			this.qtdDigitos = qtdDigitos;
		}
}
