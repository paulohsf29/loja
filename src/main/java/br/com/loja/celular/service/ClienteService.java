package br.com.loja.celular.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.celular.model.dto.ClienteDto;
import br.com.loja.celular.model.entity.ClienteEntity;
import br.com.loja.celular.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public List<ClienteDto> buscarTodosClientes() {
		List<ClienteDto> dtoList = new ArrayList<ClienteDto>();
		List<ClienteEntity> entityList = new ArrayList<ClienteEntity>();
		
		entityList = repository.findAll();
		
		dtoList = ClienteDto.convertToDto(entityList);
		
		return dtoList;
	}

	public Boolean cadastraCliente(ClienteDto cliente) {
		
		
		
		return null;
	}
	
}
