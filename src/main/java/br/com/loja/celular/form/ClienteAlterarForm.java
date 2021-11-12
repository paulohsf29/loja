package br.com.loja.celular.form;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteAlterarForm extends ClienteForm{

	@NotNull(message = "idCliente não pode estar vazio")
	private Long idCliente;
	
}
