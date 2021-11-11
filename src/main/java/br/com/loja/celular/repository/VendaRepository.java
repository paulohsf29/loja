package br.com.loja.celular.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.loja.celular.model.entity.VendaEntity;

@Repository
public interface VendaRepository extends JpaRepository<VendaEntity, Long>{

}
