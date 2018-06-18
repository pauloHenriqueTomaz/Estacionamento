package projeto.pucgoias.estacionamento.util;

	/**
	 * Classe que encapsula as excecoes da aplicacao Estacionamento
	 * @author Paulo Henrique
	 *
	 */

public class VeiculoException  extends Exception {
		
		private static final long serialVersionUID = 1189188521388183949L;
		private Exception ex;
		private String msg;

		public VeiculoException(Exception e){
			ex = e;
			msg = e.getMessage();
		}

		public VeiculoException(Exception e, String mensagem){
			e.printStackTrace();
			ex = e;
			msg = mensagem;
		}

		public Exception getEx() {
			return ex;
		}

		public String getMsg() {
			return msg;
		}
		
	}


