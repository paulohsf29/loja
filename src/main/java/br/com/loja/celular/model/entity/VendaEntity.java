package br.com.loja.celular.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_VENDA")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_VENDA")
	private Long idVenda;
	
	@Column(name = "VL_VENDA")
	private Double vlVenda;
	
	@OneToMany
	@JoinColumn(name = "ITENS")
	private List<ProdutoEntity> itens;
	
	@ManyToOne
	@JoinColumn(name = "ID_CLIENTE")
	private ClienteEntity cliente;
}
