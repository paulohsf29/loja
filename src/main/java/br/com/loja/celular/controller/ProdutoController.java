package br.com.loja.celular.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja.celular.form.ProdutoAlterarForm;
import br.com.loja.celular.form.ProdutoForm;
import br.com.loja.celular.model.dto.ProdutoDto;
import br.com.loja.celular.service.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api/produto", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "API Rest Loja")
public class ProdutoController {

	@Autowired
	ProdutoService service;
	
	@GetMapping("/buscarTodos")
	@ApiOperation(value = "Busca todos os produtos")
	public ResponseEntity<List<ProdutoDto>> buscarTodosProdutos(){
		List<ProdutoDto> produtoList = service.buscarTodosProdutos();
		return ResponseEntity.ok(produtoList);
	}
	
	@GetMapping("/buscarProduto/{idProduto}")
	@ApiOperation(value = "Busca produto por id")
	public ResponseEntity<ProdutoDto> buscaProdutoPorId(@RequestParam final Long idProduto){
		ProdutoDto produto = service.buscarProdutoPorId(idProduto);
		return ResponseEntity.ok(produto);
	}
	
	@PostMapping("/cadastrar")
	@ApiOperation(value = "Cadastrar novo Produto")
	public ResponseEntity<Boolean> cadastrarProduto(@Valid @RequestBody ProdutoForm produtoForm){
		
		Boolean cadastroProduto = service.cadastrarProduto(produtoForm);
		
		return ResponseEntity.ok(cadastroProduto);
	}
	
	@PutMapping("/alterar")
	@ApiOperation(value = "Atualizar produto")
	public ResponseEntity<Boolean> atualizarCadastroProduto(@Valid @RequestBody ProdutoAlterarForm produtoForm){
		
		Boolean cadastroProduto = service.atualizarCadastroProduto(produtoForm);
		
		return ResponseEntity.ok(cadastroProduto);
	}
}
