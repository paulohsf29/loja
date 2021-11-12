package br.com.loja.celular.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import br.com.loja.celular.model.entity.ClienteEntity;
import br.com.loja.celular.model.entity.ProdutoEntity;
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
	
	
	public static ProdutoDto convertToDto(ProdutoEntity entity) {
		ModelMapper modelMapper = new ModelMapper();
		//ClienteDto clienteDto = modelMapper.map(order, OrderDTO.class);
		ProdutoDto clienteDto = modelMapper.map(entity, ProdutoDto.class);
		return clienteDto;
	}

	public static List<ProdutoDto> convertListToDto(List<ProdutoEntity> entityList) {
		List<ProdutoDto> dtoList = new ArrayList<ProdutoDto>();
		entityList.forEach(entity ->{
			ProdutoDto clienteDto = convertToDto(entity);
			dtoList.add(clienteDto);
		});
		
		return dtoList;
	}
	
}
