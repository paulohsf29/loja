package br.com.loja.celular.form;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteForm {

	@NotNull(message = "Nome não pode estar vazio")
	private String nmCliente;
	
	@NotNull(message = "CPF não pode estar vazio")
	private String nrCpf;
	
	private String telefone;
	private String email;
	
}
