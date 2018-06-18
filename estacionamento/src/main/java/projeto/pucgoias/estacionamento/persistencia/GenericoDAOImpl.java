package projeto.pucgoias.estacionamento.persistencia;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import projeto.pucgoias.estacionamento.util.VeiculoException;


/**
 * Classe que define as operacoes da camada de persistencia generica
 * @author Paulo Henrique
 *
 */
public class GenericoDAOImpl<T, ID extends Serializable> implements GenericoDAO<T, ID> {

	private EntityManager entityManager;
	private final Class<T> oClass;

	//Classe a ser persistida
	public Class<T> getObjectClass() {
		return this.oClass;
	}

	//Gerenciador de persistencia
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext(unitName="estacionamento")
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	public GenericoDAOImpl(){
		this.oClass = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * Inclui um objeto T na base de dados
	 * @param object
	 * @return
	 * @throws VeiculoException
	 */
	public T incluir(T object) throws VeiculoException {
		try{
			getEntityManager().merge(object);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new VeiculoException(e,"Nao foi possivel realizar a inclusao.");
		}
		return object;
	}

	/**
	 * Altera um objeto T na base de dados
	 * @param object
	 * @return
	 * @throws VeiculoException
	 */
	public T alterar(T object) throws VeiculoException {
		try{
			getEntityManager().merge(object);
		}
		catch (Exception e) {
			throw new VeiculoException(e,"Nao foi possivel realizar a alteracao.");
		}
		return object;
	}

	/**
	 * Consulta um objeto T da base de dados
	 * @param id
	 * @return
	 * @throws VeiculoException
	 */
	public T consultar(Integer id) throws VeiculoException {
		T object = null;
		try{
			object = getEntityManager().find(getObjectClass(), id);
		}
		catch (EntityNotFoundException e) {
			throw new VeiculoException(e,"Registro nao encontrado.");
		}
		catch (Exception e) {
			throw new VeiculoException(e,"Nao foi possivel realizar a consulta.");
		}
		return object;
	}

	/**
	 * Exclui um objeto T  da base de dados
	 * @param id
	 * @throws VeiculoException
	 */
	public void excluir(Integer id) throws VeiculoException {
		try{
			getEntityManager().remove(getEntityManager().getReference(getObjectClass(), id ));
		}
		catch (EntityNotFoundException e) {
			throw new VeiculoException(e,"Registro nao encontrado para exclusao.");
		}
		catch (Exception e) {
			throw new VeiculoException(e,"Nao foi possivel realizar a exclusao.");
		}
		
	}

	/**
	 * Lista os objetos T da base de dados
	 * @return
	 * @throws VeiculoException
	 */
	@SuppressWarnings("unchecked")
	public List<T> listar() throws VeiculoException {
		List<T> lista = null;  
        try {  
            Query query = getEntityManager().createQuery("SELECT object(o) FROM " + getObjectClass().getSimpleName() + " AS o");  
            lista = query.getResultList();  
        } catch (Exception e) {  
            throw new VeiculoException(e, "Problemas na localizacao dos objetos");  
        }  
        return lista;  
     }

}