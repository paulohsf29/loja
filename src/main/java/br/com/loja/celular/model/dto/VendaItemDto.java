package br.com.loja.celular.model.dto;

import br.com.loja.celular.model.entity.ProdutoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendaItemDto {
	
	private Long idVenda;
	private Long nrItemVenda;
	private ProdutoEntity produto;
	private Long qtdItem;
	private Double vlItem;

}
