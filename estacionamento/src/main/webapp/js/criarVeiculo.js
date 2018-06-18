//valida o formulario
function validarFormulario() {
	var campo = document.getElementById('formulario:descVeiculo');
	if (campo.value.length == 0) {
		alert('O campo descrição deve ser preenchido.');
		campo.focus();
		return false;
	}
	var campo = document.getElementById('formulario:tempUso');
	if (campo.value.length == 0) {
		alert('O campo tempo de uso deve ser preenchido.');
		campo.focus();
		return false;
	}
	var campo = document.getElementById('formulario:locVaga');
	if (campo.value.length == 0) {
		alert('O campo local da vaga deve ser preenchido.');
		campo.focus();
		return false;
	}
	
	var campo = document.getElementById('formulario:placVeiculo');
	if (campo.value.length == 0) {
		alert('O campo data placa do veiculo deve ser preenchido.');
		campo.focus();
		return false;
	}
	
	var campo = document.getElementById('formulario:dataEntrada');
	if (campo.value.length == 0) {
		alert('O campo data de entrada deve ser preenchido.');
		campo.focus();
		return false;
	}
	var campo = document.getElementById('formulario:dataSaida');
	if (campo.value.length == 0) {
		alert('O campo data de saida deve ser preenchido.');
		campo.focus();
		return false;
	}

	return true;
}

function validarTempo() {
	var campo = document.getElementById('formulario:tempUso');
	if (campo.value.length == 0) {
		alert('O campo tempo de uso deve ser preenchido com valor inteiro.');
		campo.focus();
		return false;
	}
}

function validarLocal(locVaga) {
	padrao = /^[a-zA-Z]{1}\d{1}$/
		pl= padrao.exec(locVaga);
		if (!pl){
			alert("Codigo da Vaga no formato incorreto deve ser 1 letra e 1 numero!");
			campo.locVaga.focus();
		}	
}

function validarPlaca(placVeiculo) {
	padrao = /^[a-zA-Z]{3}\d{4}$/
		pl= padrao.exec(placVeiculo);
		if (!pl){
			alert("Placa no formato incorreto!");
			campo.placVeiculo.focus();
		}	
}
	
