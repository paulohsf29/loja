package br.com.loja.celular.model.entity;

import javax.persistence.*;
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
	
	@Column(name = "QTD_PRODUTO")
	private Integer qtdProduto;
}
