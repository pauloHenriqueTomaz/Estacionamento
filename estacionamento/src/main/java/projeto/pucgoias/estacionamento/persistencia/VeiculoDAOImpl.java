package projeto.pucgoias.estacionamento.persistencia;

import org.springframework.stereotype.Repository;

import projeto.pucgoias.estacionamento.entidade.Veiculo;

/**
 * Classe que define as operacoes da camada de persistencia de Veiculos
 * @author Paulo Henrique
 *
 */
@Repository
public class VeiculoDAOImpl extends GenericoDAOImpl<Veiculo, Integer> implements
		VeiculoDAO {

}