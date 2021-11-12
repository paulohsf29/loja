package br.com.loja.celular.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.loja.celular.model.entity.ClienteEntity;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long>{
	
	public ClienteEntity findByNrCpf(String nrCpf);
	
	public ClienteEntity findByIdCliente(Long idCliente); 

}
