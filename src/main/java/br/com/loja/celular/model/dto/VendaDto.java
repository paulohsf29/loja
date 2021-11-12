package br.com.loja.celular.model.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendaDto implements Serializable{
	
	private static final long serialVersionUID = -7206994494867353950L;
	
	private Long idVenda;
	private Double vlVenda;
	private List<VendaItemDto> itens;
	private ClienteDto cliente;
}
