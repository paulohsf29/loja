package br.com.loja.celular.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.celular.form.ProdutoAlterarForm;
import br.com.loja.celular.form.ProdutoForm;
import br.com.loja.celular.model.dto.ProdutoDto;
import br.com.loja.celular.model.entity.ProdutoEntity;
import br.com.loja.celular.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository repository;

	public List<ProdutoDto> buscarTodosProdutos() {

		List<ProdutoDto> dtoList = new ArrayList<ProdutoDto>();
		List<ProdutoEntity> entityList = new ArrayList<ProdutoEntity>();

		entityList = repository.findAll();

		dtoList = ProdutoDto.convertListToDto(entityList);

		return dtoList;
	}

	public Boolean cadastrarProduto(ProdutoForm produtoForm) {

		repository.saveAndFlush(ProdutoEntity.convertToEntity(produtoForm));

		return true;
	}

	public ProdutoDto buscarProdutoPorId(Long idProduto) {
		ProdutoEntity produtoEntity;

		produtoEntity = repository.getById(idProduto);

		if (produtoEntity == null) {
			// TODO implementar exception
			return null;
		}

		return ProdutoDto.convertToDto(produtoEntity);
	}

	public Boolean atualizarCadastroProduto(ProdutoAlterarForm produtoForm) {
		ProdutoEntity produtoEntity = repository.getById(produtoForm.getIdProduto());

		if (produtoEntity == null) {
			// TODO Implementar exceptions
			return false;
		}

		repository.saveAndFlush(ProdutoEntity.convertToEntity(produtoForm));

		return true;
	}

}
