package projeto.pucgoias.estacionamento.controller;


import java.util.Date;
import org.springframework.stereotype.Component;

/**
 * Classe que representa o formulario web de Veiculo
 * @author Paulo Henrique
 *
 */
/*a mesma serve para indicar ao framework que aquela classe é um bean que deverá ser administrado pela implementação de Container do Spring.*/
@Component
public class VeiculoBean {
	

	private Integer idveiculo;
	private String descVeiculo;
	private Integer tempUso;
	private String locVaga;
	private String placVeiculo;
	private Date dataEntrada;
	private Date dataSaida;
	private float valorPagar;
	
	
	
	
	
	public Integer getTempUso() {
		return tempUso;
	}
	public void setTempUso(Integer tempUso) {
		this.tempUso = tempUso;
	}
	public String getLocVaga() {
		return locVaga;
	}
	public void setLocVaga(String locVaga) {
		this.locVaga = locVaga;
	}
	public String getDescVeiculo() {
		return descVeiculo;
	}
	public void setDescVeiculo(String descVeiculo) {
		this.descVeiculo = descVeiculo;
	}
	public Date getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public Date getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
	public float getValorPagar() {
		return valorPagar;
	}
	public void setValorPagar(float valorPagar) {
		this.valorPagar = valorPagar;
	}

	public Integer getIdveiculo() {
		return idveiculo;
	}
	public void setIdveiculo(Integer idveiculo) {
		this.idveiculo = idveiculo;
	}
	public String getPlacVeiculo() {
		return placVeiculo;
	}
	public void setPlacVeiculo(String placVeiculo) {
		this.placVeiculo = placVeiculo;
	}
	
	
}



