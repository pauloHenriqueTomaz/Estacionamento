package projeto.pucgoias.estacionamento.entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="veiculo")
public class Veiculo implements Serializable{

	
	private static final long serialVersionUID = 9182909078816852162L;

	/** Classe Modelo do Veiculo
	 * @author Paulo Henrique
	 */

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="idveiculo")
		private Integer idveiculo;
		
		@Column(name="descVeiculo")
		private String descVeiculo;
		
		@Column(name="tempUso")
		private Integer tempUso;

		@Column(name="locVaga")
		private String locVaga;
		
		@Column(name="placVeiculo")
		private String placVeiculo;
		


		@Column(name="dataEntrada")
		private Date dataEntrada;
		
		@Column(name="dataSaida")
		private Date dataSaida;
		

		@Column(name="valorPagar")
		private float valorPagar;
	
		public String getPlacVeiculo() {
			return placVeiculo;
		}


		public void setPlacVeiculo(String placVeiculo) {
			this.placVeiculo = placVeiculo;
		}
		
		

		public Integer getIdveiculo() {
			return idveiculo;
		}


		public void setIdveiculo(Integer idveiculo) {
			this.idveiculo = idveiculo;
		}


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


		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		


		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((idveiculo == null) ? 0 : idveiculo.hashCode());
			return result;
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Veiculo other = (Veiculo) obj;
			if (idveiculo == null) {
				if (other.idveiculo != null)
					return false;
			} else if (!idveiculo.equals(other.idveiculo))
				return false;
			return true;
		}


}
