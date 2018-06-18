package projeto.pucgoias.estacionamento.controller;


import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import projeto.pucgoias.estacionamento.controller.VeiculoBean;
import projeto.pucgoias.estacionamento.entidade.Veiculo;
import projeto.pucgoias.estacionamento.negocio.VeiculoService;
import projeto.pucgoias.estacionamento.util.VeiculoException;

/**
 * Classe que controla as requisicoes do usuario web
 * @author Paulo Henrique
 *
 */

@ManagedBean(name="veiculoController")

/*libera a memoria mais rápido com isso temos uma aplicação que tende a escalar melhor. */
@RequestScoped

/*indica que uma classe particular serve como um controlador, atuando como um estereótipo para a classe anotada */
@Controller
public class VeiculoController {
	/*Para marcar a injeção de suas dependencias @autowired */
	@Autowired
	private VeiculoBean veiculoBean;
	@Autowired
	private List<VeiculoBean> listaveiculoBean;
	@Autowired
	private VeiculoService veiculoService;


	/**
	 * Construtor da classe de veiculo
	 */
	public VeiculoController(){
		veiculoBean = new VeiculoBean();
	}
	
	/**
	 * Inclui um veiculo na base de dados
	 * @return
	 */
	public String incluir() {
		try{

			Veiculo veiculo = new Veiculo();

			//preenche os dados da tela no objeto persistente
			veiculo.setIdveiculo(veiculoBean.getIdveiculo());
			veiculo.setDescVeiculo(veiculoBean.getDescVeiculo());
			veiculo.setTempUso(veiculoBean.getTempUso());
			veiculo.setLocVaga(veiculoBean.getLocVaga());
			veiculo.setPlacVeiculo(veiculoBean.getPlacVeiculo());
			veiculo.setDataEntrada(veiculoBean.getDataEntrada());
			veiculo.setDataSaida(veiculoBean.getDataSaida());
			veiculo.setValorPagar(veiculoBean.getTempUso()*5);

			getVeiculoService().incluir(veiculo);
			
			return "sucesso";
		}
		catch (Exception e) {
			String msg = "Inclusao nao realizada. Motivo: "  + e.getMessage();
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}

	/**
	 * Lista os veiculos cadastradas
	 * @return
	 */
	public String listar() {
		try{

			List<Veiculo> listaveiculo = getVeiculoService().listar();

			if(listaveiculo==null || listaveiculo.size()==0){
				FacesMessage message = new FacesMessage("Nenhum registro encontrado.");
				this.getFacesContext().addMessage("formulario", message);
			}

			//preeche a lista de veiculos da tela
			listaveiculoBean = new ArrayList<VeiculoBean>();
			for (Veiculo veiculo : listaveiculo) {
				VeiculoBean veiculoBean = new VeiculoBean();
				veiculoBean.setIdveiculo(veiculo.getIdveiculo());
				veiculoBean.setDescVeiculo(veiculo.getDescVeiculo());
				veiculoBean.setTempUso(veiculo.getTempUso());
				veiculoBean.setLocVaga(veiculo.getLocVaga());
				veiculoBean.setPlacVeiculo(veiculo.getPlacVeiculo());
				veiculoBean.setDataEntrada(veiculo.getDataEntrada());
				veiculoBean.setDataSaida(veiculo.getDataSaida());
				veiculoBean.setValorPagar(veiculo.getTempUso()*5);
				
				listaveiculoBean.add(veiculoBean);		
				
			}

			return "listar";
		}
		catch (Exception e) {
			e.printStackTrace();
			String msg = "Listagem nao realizada. Motivo: " + ((e instanceof VeiculoException ? ((VeiculoException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}

	/**
	 * Consulta um veiculo cadastrado
	 * @return
	 */
	public String consultar() {
		try{

			String idveiculo = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idveiculo");
			
			Veiculo veiculo = getVeiculoService().consultar(Integer.valueOf(idveiculo));

			if(veiculo==null || veiculo.getIdveiculo()==null){
				FacesMessage message = new FacesMessage("Nenhum registro encontrado.");
				this.getFacesContext().addMessage("formulario", message);
				return "listar";
			}

			//preenche os dados do bean da tela
			veiculoBean.setIdveiculo(veiculo.getIdveiculo());
			veiculoBean.setDescVeiculo(veiculo.getDescVeiculo());
			veiculoBean.setTempUso(veiculo.getTempUso());
			veiculoBean.setLocVaga(veiculo.getLocVaga());
			veiculoBean.setPlacVeiculo(veiculo.getPlacVeiculo());
			veiculoBean.setDataEntrada(veiculo.getDataEntrada());
			veiculoBean.setDataSaida(veiculo.getDataSaida());
			veiculoBean.setValorPagar(veiculo.getTempUso()*5);
			
			return "editar";
		}

		catch (Exception e) {
			String msg = "Consulta nao realizada. Motivo: " + e.getMessage();
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}


	/**
	 * Cria um novo veiculo
	 * @return
	 */
	public String criar() {
		try{

			veiculoBean = new VeiculoBean();
			
			return "criar";
		}
		catch (Exception e) {
			String msg = "Criacao nao realizada. Motivo: " + e.getMessage();
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}

	/**
	 * Exclui um veiculo cadastrado
	 * @return
	 */
	public String excluir() {
		try{
			
			String idveiculo = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idveiculo");
			
			Veiculo veiculo = getVeiculoService().consultar(Integer.valueOf(idveiculo));

			if(veiculo==null || veiculo.getIdveiculo()==null){
				FacesMessage message = new FacesMessage("Nenhum registro encontrado.");
				this.getFacesContext().addMessage("formulario", message);
				return "listar";
			}

			getVeiculoService().excluir(veiculo.getIdveiculo());
			
			return "sucesso";
		}
		catch (Exception e) {
			e.printStackTrace();
			String msg = "Exclusao nao realizada. Motivo: " + ((e instanceof VeiculoException ? ((VeiculoException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}
	
	/**
	 * Altera um veiculo cadastrado
	 * @return
	 */
	public String alterar() {
		try{

			Veiculo veiculo = getVeiculoService().consultar(veiculoBean.getIdveiculo());

			if(veiculo==null || veiculo.getIdveiculo()==null){
				FacesMessage message = new FacesMessage("Nenhum registro encontrado.");
				this.getFacesContext().addMessage("formulario", message);
				return "listar";
			}

			//preenche os dados da tela no objeto persistente
			veiculo.setIdveiculo(veiculoBean.getIdveiculo());
			veiculo.setDescVeiculo(veiculoBean.getDescVeiculo());
			veiculo.setTempUso(veiculoBean.getTempUso());
			veiculo.setLocVaga(veiculoBean.getLocVaga());
			veiculo.setPlacVeiculo(veiculoBean.getPlacVeiculo());
			veiculo.setDataEntrada(veiculoBean.getDataEntrada());
			veiculo.setDataSaida(veiculoBean.getDataSaida());
			veiculo.setValorPagar(veiculoBean.getTempUso()*5);
			

			getVeiculoService().alterar(veiculo);
			return "sucesso";
			
		}
		catch (Exception e) {
			String msg = "Alteracao nao realizada. Motivo: " + ((e instanceof VeiculoException ? ((VeiculoException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}
	
	private FacesContext getFacesContext(){
		return FacesContext.getCurrentInstance();
	}
	

	
	public VeiculoBean getVeiculoBean() {
		return veiculoBean;
	}

	public void setVeiculoBean(VeiculoBean veiculoBean) {
		this.veiculoBean = veiculoBean;
	}

	public List<VeiculoBean> getListaveiculoBean() {
		return listaveiculoBean;
	}

	public void setListaveiculoBean(List<VeiculoBean> listaveiculoBean) {
		this.listaveiculoBean = listaveiculoBean;
	}

	public VeiculoService getVeiculoService() {
		return veiculoService;
	}

	public void setVeiculoService(VeiculoService veiculoService) {
		this.veiculoService = veiculoService;
	}

	
}
