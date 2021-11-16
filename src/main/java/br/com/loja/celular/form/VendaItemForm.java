package br.com.loja.celular.form;

import br.com.loja.celular.model.dto.ProdutoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendaItemForm {

	//private Long idVenda;
	private Long nrItemVenda;
	private ProdutoDto produto;
	private Long qtdItem;
	private Double vlItem;
	
}
