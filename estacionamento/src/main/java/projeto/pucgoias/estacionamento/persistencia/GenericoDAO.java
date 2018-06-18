package projeto.pucgoias.estacionamento.persistencia;

import java.io.Serializable;
import java.util.List;

import projeto.pucgoias.estacionamento.util.VeiculoException;

/**
 * Interface que define as operacoes da camada de persistencia generica
 * @author Paulo Henrique
 *
 */
public interface GenericoDAO<T, ID extends Serializable> {
	
	/**
	 * Retorna a classe a ser persistida
	 * @return
	 */
	public Class<T> getObjectClass();
	
	/**
	 * Inclui um objeto T na base de dados
	 * @param object
	 * @return
	 * @throws VeiculoException
	 */
	public T incluir(T object) throws VeiculoException;
	
	/**
	 * Altera um objeto T na base de dados
	 * @param object
	 * @return
	 * @throws VeiculoException
	 */
	public T alterar(T object) throws VeiculoException;
	
	/**
	 * Consulta um objeto T da base de dados
	 * @param id
	 * @return
	 * @throws VeiculoException
	 */
	public T consultar(Integer id) throws VeiculoException;
	
	/**
	 * Exclui um objeto T  da base de dados
	 * @param id
	 * @throws VeiculoException
	 */
	public void excluir(Integer id) throws VeiculoException;
	
	/**
	 * Lista os objetos T da base de dados
	 * @return
	 * @throws VeiculoException
	 */
	public List<T> listar() throws VeiculoException;
}
