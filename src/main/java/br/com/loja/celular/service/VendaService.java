package br.com.loja.celular.service;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.loja.celular.form.VendaForm;
import br.com.loja.celular.model.entity.ClienteEntity;
import br.com.loja.celular.model.entity.ProdutoEntity;
import br.com.loja.celular.model.entity.VendaEntity;
import br.com.loja.celular.repository.ClienteRepository;
import br.com.loja.celular.repository.ProdutoRepository;
import br.com.loja.celular.repository.VendaRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class VendaService {

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	VendaRepository vendaRepository;

	public Boolean efetuarVenda(VendaForm vendaForm) {
		VendaEntity vendaEntity = new VendaEntity();

		if (vendaForm.getCliente() != null) {
			if (clienteRepository.getById(vendaForm.getCliente().getIdCliente()) == null) {
				log.error("Objeto não encontrado, do tipo: " + ClienteEntity.class);
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
			}

			vendaEntity.setCliente(clienteRepository.getById(vendaForm.getCliente().getIdCliente()));
		}

		vendaEntity = VendaEntity.convertToEntity(vendaForm);
		
		vendaEntity.getItens().forEach(item -> {
			//if(item.getProduto().getQtdProdutoEstoque() > 
		});

		vendaRepository.save(vendaEntity);

		vendaEntity.getItens().forEach(item -> {
			ProdutoEntity produtoAtualizado = produtoRepository.findByIdProduto(item.getProduto().getIdProduto());
			produtoAtualizado.setQtdProdutoEstoque(produtoAtualizado.getQtdProdutoEstoque() - item.getQtdItem());
			produtoRepository.save(produtoAtualizado);
		});

		return true;
	}

}
