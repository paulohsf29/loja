package br.com.loja.celular.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.loja.celular.form.ClienteAlterarForm;
import br.com.loja.celular.form.ClienteForm;
import br.com.loja.celular.model.dto.ClienteDto;
import br.com.loja.celular.model.entity.ClienteEntity;
import br.com.loja.celular.repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public List<ClienteDto> buscarTodosClientes() {
		List<ClienteDto> dtoList = new ArrayList<ClienteDto>();
		List<ClienteEntity> entityList = new ArrayList<ClienteEntity>();

		entityList = repository.findAll();
		
		if(entityList.isEmpty()) {
			log.error("Nenhum Objeto encontrado, do tipo: " + ClienteEntity.class);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum Cliente encontrado");
		}

		dtoList = ClienteDto.convertListToDto(entityList);

		return dtoList;
	}

	public Boolean cadastraCliente(ClienteForm clienteForm) {

		ClienteEntity clienteEntity = repository.findByNrCpf(clienteForm.getNrCpf());

		if (clienteEntity != null) {
			log.error("CPF Já cadastrado, do tipo: " + ClienteEntity.class);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF Já cadastrado");
		}

		repository.saveAndFlush(ClienteEntity.convertToEntity(clienteForm));

		return true;
	}

	public ClienteDto buscarClientePorId(Long idCliente) {
		ClienteEntity clienteEntity = null;

		clienteEntity = repository.findByIdCliente(idCliente);

		if (clienteEntity == null) {
			log.error("Objeto não encontrado, do tipo: " + ClienteEntity.class);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
		}
		
		return ClienteDto.convertToDto(clienteEntity);
		
	}

	public Boolean atualizarCadastroCliente(ClienteAlterarForm clienteForm) {

		ClienteEntity clienteEntity = repository.findByIdCliente(clienteForm.getIdCliente());

		if (clienteEntity == null) {
			log.error("Objeto não encontrado, do tipo: " + ClienteEntity.class);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
		}

		repository.saveAndFlush(ClienteEntity.convertToEntity(clienteForm));

		return true;
	}

	public Boolean deletarCliente(Long idCliente) {
		ClienteEntity clienteEntity = repository.getById(idCliente);

		if (clienteEntity == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
		}

		repository.delete(clienteEntity);

		return true;
	}

	public ClienteDto buscaClientePorCpf(String cpfCliente) {
		ClienteEntity clienteEntity = null;

		clienteEntity = repository.findByNrCpf(cpfCliente);

		if (clienteEntity == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
		}
		
		return ClienteDto.convertToDto(clienteEntity);
	}

}
