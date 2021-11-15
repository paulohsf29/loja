package br.com.loja.celular.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendaItemForm {

	private Long nrItemVenda;
	private Long produto;
	private Long qtdItem;
	private Double vlItem;
	
}
