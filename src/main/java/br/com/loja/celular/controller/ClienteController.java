package br.com.loja.celular.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja.celular.model.dto.ClienteDto;
import br.com.loja.celular.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "API Rest Loja")
public class ClienteController {

	@Autowired
	ClienteService service;
	
	@GetMapping("/cliente/buscarTodos")
	@ApiOperation(value = "Busca todos os clientes")
	public ResponseEntity<List<ClienteDto>> buscarClientes(){
		List<ClienteDto> listCliente = service.buscarTodosClientes();
		
		return ResponseEntity.ok(listCliente);
	}
	
	@PostMapping("/cliente/cadastrar")
	public ResponseEntity<Boolean> cadastrarCliente(@RequestBody ClienteDto cliente){
		
		Boolean cadastroCliente = service.cadastraCliente(cliente);
		
		return ResponseEntity.ok(true);
	}
	
}
