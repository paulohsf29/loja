package br.com.loja.celular.form;

import java.util.List;

import br.com.loja.celular.model.dto.ClienteDto;
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
