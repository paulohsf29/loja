package br.com.loja.celular.form;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoForm {

	@NotNull(message = "Nome do produto")
	private String nmProduto;
	
	@NotNull(message = "Descricao do produto")
	private String dsProduto;
	
	private Integer qtdProdutoEstoque;
	
}
