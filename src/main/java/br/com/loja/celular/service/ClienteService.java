package br.com.loja.celular.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.celular.form.ClienteAlterarForm;
import br.com.loja.celular.form.ClienteForm;
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

		dtoList = ClienteDto.convertListToDto(entityList);

		return dtoList;
	}

	public Boolean cadastraCliente(ClienteForm clienteForm) {

		ClienteEntity clienteEntity = repository.findByNrCpf(clienteForm.getNrCpf());

		if (clienteEntity != null) {
			// TODO Implementar exceção para cliente já existe
			return false;
		}

		repository.saveAndFlush(ClienteEntity.convertToEntity(clienteForm));

		return true;
	}

	public ClienteDto buscarClientePorId(Long idCliente) {
		ClienteEntity clienteEntity;

		clienteEntity = repository.getById(idCliente);

		if (clienteEntity == null) {
			return null;
		}

		return ClienteDto.convertToDto(clienteEntity);
	}

	public Boolean atualizarCadastroCliente(ClienteAlterarForm clienteForm) {

		ClienteEntity clienteEntity = repository.findByIdCliente(clienteForm.getIdCliente());

		if (clienteEntity == null) {
			// TODO Implementar exceptions
			return false;
		}

		repository.saveAndFlush(ClienteEntity.convertToEntity(clienteForm));

		return true;
	}

	public Boolean deletarCliente(Long idCliente) {
		ClienteEntity clienteEntity = repository.getById(idCliente);

		if (clienteEntity == null) {
			// TODO Implementar exceptions
			return false;
		}

		repository.delete(clienteEntity);

		return true;
	}

}
