package br.com.loja.celular.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja.celular.form.ClienteAlterarForm;
import br.com.loja.celular.form.ClienteForm;
import br.com.loja.celular.model.dto.ClienteDto;
import br.com.loja.celular.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api/cliente", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "API Rest Loja")
public class ClienteController {

	@Autowired
	ClienteService service;
	
	@GetMapping("/buscarTodos")
	@ApiOperation(value = "Busca todos os clientes")
	public ResponseEntity<List<ClienteDto>> buscarTodosClientes(){
		List<ClienteDto> clienteList = service.buscarTodosClientes();
		return ResponseEntity.ok(clienteList);
	}
	
	@GetMapping("/buscarCliente/{idCliente}")
	@ApiOperation(value = "Busca cliente por id")
	public ResponseEntity<ClienteDto> buscaClientePorId(@RequestParam final Long idCliente){
		ClienteDto cliente = service.buscarClientePorId(idCliente);
		return ResponseEntity.ok(cliente);
	}
	
	@GetMapping("/buscarCliente/{cpfCliente}")
	@ApiOperation(value = "Busca cliente por CPF")
	public ResponseEntity<ClienteDto> buscaClientePorCpf(@RequestParam final String cpfCliente){
		ClienteDto cliente = service.buscaClientePorCpf(cpfCliente);
		
		return ResponseEntity.ok(cliente);
	}
	
	@PostMapping("/cadastrar")
	@ApiOperation(value = "Cadastrar novo cliente")
	public ResponseEntity<Boolean> cadastrarCliente(@Valid @RequestBody ClienteForm clienteForm){
		
		Boolean cadastroCliente = service.cadastraCliente(clienteForm);
		
		return ResponseEntity.ok(cadastroCliente);
	}
	
	@PutMapping("/alterar")
	@ApiOperation(value = "Atualizar Cliente")
	public ResponseEntity<Boolean> atualizarCadastroCliente(@Valid @RequestBody ClienteAlterarForm clienteForm){
		
		Boolean cadastroCliente = service.atualizarCadastroCliente(clienteForm);
		
		return ResponseEntity.ok(cadastroCliente);
	}
	
	@DeleteMapping("/deletar/{idCliente}")
	@ApiOperation(value = "Deletar Cliente")
	public ResponseEntity<Boolean> deletarCliente(@RequestParam final Long idCliente){
		
		Boolean cadastroCliente = service.deletarCliente(idCliente);
		
		return ResponseEntity.ok(cadastroCliente);
	}
	
}
