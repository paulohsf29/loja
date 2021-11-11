package br.com.loja.celular.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDto implements Serializable{

	private static final long serialVersionUID = 6215865146972151059L;
	
	private Long idProduto;
	private String nmProduto;
	private String dsProduto;
	private Integer qtdProduto;
	
}
