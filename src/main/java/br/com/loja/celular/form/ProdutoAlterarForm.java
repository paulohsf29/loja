package br.com.loja.celular.form;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoAlterarForm extends ProdutoForm{

	@NotNull(message="idProduto não pode ser null")
	private Long idProduto;
	
}
