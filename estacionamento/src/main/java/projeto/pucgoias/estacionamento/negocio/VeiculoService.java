package projeto.pucgoias.estacionamento.negocio;

import java.util.List;

import projeto.pucgoias.estacionamento.entidade.Veiculo;
import projeto.pucgoias.estacionamento.util.VeiculoException;


/**
 * Interface que define as operacoes da camada de negocio dos veiculos
 * @author Paulo Henrique
 *
 */
public interface VeiculoService {
	
	/**
	 * Inclui um Veiculo
	 * @param veiculo
	 * @return
	 * @throws VeiculoException
	 */
	public  Veiculo incluir( Veiculo veiculo) throws VeiculoException;
	
	/**
	 * Altera um dado do veiculo
	 * @param veiculo
	 * @return
	 * @throws VeiculoException
	 */
	public  Veiculo alterar( Veiculo veiculo) throws VeiculoException;
	
	/**
	 * Exclui um veiculo
	 * @param id
	 * @throws VeiculoException
	 */
	public void excluir(Integer id) throws VeiculoException;
	
	/**
	 * Consulta um veiculo pelo identificador
	 * @param id
	 * @return
	 * @throws VeiculoException
	 */
	public  Veiculo consultar(Integer id) throws VeiculoException;
	
	/**
	 * Lista todos os Veiculos cadastradas
	 * @return
	 * @throws VeiculoException
	 */
	public List<Veiculo> listar() throws VeiculoException;

}
