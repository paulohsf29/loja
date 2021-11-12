package br.com.loja.celular.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import br.com.loja.celular.model.entity.ClienteEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto implements Serializable{

	private static final long serialVersionUID = 2400383012853997095L;

	private Long idCliente;
	private String nmCliente;
	private String nrCpf;
	private String telefone;
	private String email;
	
//	public ClienteDto(ClienteEntity entity) {
//		this.idCliente = entity.getIdCliente();
//		this.nmCliente = entity.getNmCliente();
//		this.email = entity.getEmail();
//		this.nrCpf = entity.getNrCpf();
//		this.telefone = entity.getTelefone();
//	}
	
	public static ClienteDto convertToDto(ClienteEntity entity) {
		ModelMapper modelMapper = new ModelMapper();
		//ClienteDto clienteDto = modelMapper.map(order, OrderDTO.class);
		ClienteDto clienteDto = modelMapper.map(entity, ClienteDto.class);
		return clienteDto;
	}

	public static List<ClienteDto> convertListToDto(List<ClienteEntity> entityList) {
		List<ClienteDto> dtoList = new ArrayList<ClienteDto>();
		entityList.forEach(entity ->{
			ClienteDto clienteDto = convertToDto(entity);
			dtoList.add(clienteDto);
		});
		
		return dtoList;
	}
	
}
