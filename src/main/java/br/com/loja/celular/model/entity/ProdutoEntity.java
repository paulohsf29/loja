package br.com.loja.celular.model.entity;

import java.io.Serializable;

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
public class ProdutoEntity implements Serializable{
	
	private static final long serialVersionUID = 6670419581284363679L;

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
	private Long qtdProdutoEstoque;
	
	public static ProdutoEntity convertToEntity(Object form) {
		ModelMapper modelMapper = new ModelMapper();
		ProdutoEntity produtoEntity = modelMapper.map(form, ProdutoEntity.class);
		return produtoEntity;
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		ProdutoEntity other = (ProdutoEntity) obj;
//		return Objects.equals(dsProduto, other.dsProduto) && Objects.equals(idProduto, other.idProduto)
//				&& Objects.equals(nmProduto, other.nmProduto)
//				&& Objects.equals(qtdProdutoEstoque, other.qtdProdutoEstoque)
//				&& Objects.equals(vlProduto, other.vlProduto);
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(dsProduto, idProduto, nmProduto, qtdProdutoEstoque, vlProduto);
//	}
}
