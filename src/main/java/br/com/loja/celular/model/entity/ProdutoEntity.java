package br.com.loja.celular.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_PRODUTO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PRODUTO")
	private Long idProduto;
	
	@Column(name = "NM_PRODUTO")
	private String nmProduto;
	
	@Column(name = "DS_PRODUTO")
	private String dsProduto;
	
	@Column(name = "VL_PRODUTO")
	private Double vlProduto;
	
	@Column(name = "QTD_PRODUTO_ESTOQUE")
	private Integer qtdProdutoEstoque;
	
	public static ProdutoEntity convertToEntity(Object form) {
		ModelMapper modelMapper = new ModelMapper();
		ProdutoEntity produtoEntity = modelMapper.map(form, ProdutoEntity.class);
		return produtoEntity;
	}
}
