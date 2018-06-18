//desmarca todos os radios deixando apenas o selecionado marcado
function desmarcar(radio){
	var formulario = document.getElementById('formulario');
	for(var item=0; item<formulario.length; item++){
    	campo = formulario[item];
        if(campo.type=='radio' && campo.name!=radio.name){    
        	campo.checked = false;
    	}
    }
}
//armazena o identificador do item escolhido
function selecionarItem(campoHidden,radioSelecionado){
	document.getElementById(campoHidden).value = radioSelecionado.value;
	desmarcar(radioSelecionado);
}

//desmarca todos os radios deixando apenas o selecionado marcado
function desmarcarTodos(){
	var formulario = document.getElementById('formulario');
	for(var item=0; item<formulario.length; item++){
    	campo = formulario[item];
        if(campo.type=='radio' && campo.checked){    
        	campo.checked = false;
    	}
    }
}


//verifica se algum item esta selecionado
function validarSelecionado(){
	var formulario = document.getElementById('formulario');
	var campo;
	var campo1;
	var campo2;
	var campo3;
	var campo4;
	var campo5;
	
	for(var item=0; item<formulario.length; item++){
  	campo = formulario[item];
      if(campo.type=='radio' && campo.checked){    
      	return true;
  	}
  }
	for(var item=0; item<formulario.length; item++){
  	campo1 = formulario[item];
      if(campo1.type=='radio' && campo1.checked){    
      	return true;
  	}
  }
	for(var item=0; item<formulario.length; item++){
  	campo2 = formulario[item];
      if(campo2.type=='radio' && campo2.checked){    
      	return true;
  	}
  }
	for(var item=0; item<formulario.length; item++){
  	campo3 = formulario[item];
      if(campo3.type=='radio' && campo3.checked){    
      	return true;
  	}
  }
	for(var item=0; item<formulario.length; item++){
  	campo4 = formulario[item];
      if(campo4.type=='radio' && campo4.checked){    
      	return true;
  	}
  }
	for(var item=0; item<formulario.length; item++){
  	campo5 = formulario[item];
      if(campo5.type=='radio' && campo5.checked){    
      	return true;
  	}
  }
	
  alert('Necessário selecionar um item da lista.');
  return false;
}
