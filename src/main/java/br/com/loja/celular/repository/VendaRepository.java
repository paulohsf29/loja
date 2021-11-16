package br.com.loja.celular.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.loja.celular.model.entity.VendaEntity;

@Repository
public interface VendaRepository extends JpaRepository<VendaEntity, Long>{

	@Query(value = "Select MAX(ID_VENDA) FROM TB_VENDA", nativeQuery = true)
	public Long getMaxId();

}
