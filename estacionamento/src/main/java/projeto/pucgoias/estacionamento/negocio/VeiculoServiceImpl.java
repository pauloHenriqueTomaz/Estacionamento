package projeto.pucgoias.estacionamento.negocio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import projeto.pucgoias.estacionamento.entidade.Veiculo;
import projeto.pucgoias.estacionamento.persistencia.VeiculoDAO;
import projeto.pucgoias.estacionamento.util.VeiculoException;


/**
 * Classe que define as operacoes da camada de negocio dos Veiculos
 * @author Paulo Henrique
 *
 */
/*Anotação que serve para definir uma classe como pertencente à camada de Serviço da aplicação. */
@Service

/* afim de definir que determinado método deverá esta dentro de uma transação.*/
@Transactional
public class VeiculoServiceImpl implements VeiculoService {

	//Interface da persistencia
	private VeiculoDAO veiculoDAO;

	

	public VeiculoDAO getVeiculoDAO() {
		return veiculoDAO;
	}

	@Autowired
	public void setVeiculoDAO(VeiculoDAO veiculoDAO) {
		this.veiculoDAO = veiculoDAO;
	}

	/**
	 * Inclui um veiculo
	 * @param veiculo
	 * @return
	 * @throws VeiculosException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Veiculo incluir(Veiculo veiculo) throws VeiculoException {
		return getVeiculoDAO().incluir(veiculo);
	}

	/**
	 * Altera um veiculo
	 * @param veiculo
	 * @return
	 * @throws VeiculosException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public Veiculo alterar(Veiculo veiculo) throws VeiculoException {
		
		return getVeiculoDAO().alterar(veiculo);
	}

	/**
	 * Exclui um veiculo cadastrado
	 * @param veiculo
	 * @throws VeiculoException
	 */
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public void excluir(Integer id) throws VeiculoException {
		
		//exclui todos os itens antes de excluir o veiculo
		Veiculo veiculoExistente = this.consultar(id);

		getVeiculoDAO().excluir(veiculoExistente.getIdveiculo());
	}

	/**
	 * Consulta um veiculo pelo identificador
	 * @param id
	 * @return
	 * @throws veiculoException
	 */
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public Veiculo consultar(Integer id) throws VeiculoException {
		Veiculo veiculo = getVeiculoDAO().consultar(id);
		
		return veiculo;
	}

	/**
	 * Lista todos os veiculos cadastrados
	 * @return
	 * @throws VeiculoException
	 */
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	public List<Veiculo> listar() throws VeiculoException {
		return getVeiculoDAO().listar();
	}

}
