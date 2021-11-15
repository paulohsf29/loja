package br.com.loja.celular.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.loja.celular.form.VendaForm;
import br.com.loja.celular.model.entity.VendaEntity;
import br.com.loja.celular.model.entity.VendaItemEntity;
import br.com.loja.celular.repository.ClienteRepository;
import br.com.loja.celular.repository.ProdutoRepository;
import br.com.loja.celular.repository.VendaRepository;

@Service
public class VendaService {

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	VendaRepository vendaRepository;

	public Boolean efetuarVenda(VendaForm vendaForm) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Transactional
//	public Boolean efetuarVenda(VendaForm vendaForm) {
//		VendaEntity vendaEntity;
//		if(vendaForm.getIdCliente() != null) {
//			
//			if(clienteRepository.getById(vendaForm.getIdCliente()) == null) {
//				//TODO Implementar Exceptions
//				return false;
//			}
//		}
//		List<VendaItemEntity> vendaItemEntity= VendaItemEntity.convertToEntity(vendaForm.getItens());
//		
//		vendaEntity = VendaEntity.convertToEntity(vendaForm);
//		
//		//vendaEntity.setItens(vendaItemEntity);
//		
//		vendaRepository.save(vendaEntity);
//		
//		
//		return null;
//	}

}
