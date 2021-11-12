package br.com.loja.celular.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja.celular.form.VendaForm;
import br.com.loja.celular.service.VendaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api/venda", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "API Rest Loja")
public class VendaController {
	
	@Autowired
	VendaService vendaService;
	
	@PostMapping("/venda")
	@ApiOperation(value = "Efetuar nova venda")
	public ResponseEntity<Boolean> efetuarVenda(@Valid @RequestBody VendaForm vendaForm){
		
		Boolean novaVenda = vendaService.efetuarVenda(vendaForm);
		
		
		return ResponseEntity.ok(novaVenda);
		
	}
	

}
