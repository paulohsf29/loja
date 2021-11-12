package br.com.loja.celular.form;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendaForm {

	private Double vlVenda;
	private List<VendaItemForm> itens;
	private Long idCliente;
}
