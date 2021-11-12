package br.com.loja.celular.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import br.com.loja.celular.form.VendaItemForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_VENDA_ITEM")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendaItemEntity implements Serializable{
	
	private static final long serialVersionUID = 5179198825344890962L;

	@ManyToOne
    @Id
    @JoinColumn(name = "ID_VENDA")
	private VendaEntity idVenda;
	
	@Id
	@Column(name = "NR_ITEM_VENDA")
	private Long nrItemVenda;
	
	@OneToOne
	@JoinColumn(name = "ID_PRODUTO")
	private ProdutoEntity produto;
	
	@Column(name = "QTD_ITEM")
	private Long qtdItem;
	
	@Column(name = "VL_ITEM")
	private Double vlItem;
	
	public static List<VendaItemEntity> convertToEntity(List<VendaItemForm> list) {
		ModelMapper modelMapper = new ModelMapper();
		List<VendaItemEntity> vendaItemList = new ArrayList<VendaItemEntity>();
		
		list.forEach(item->{
			VendaItemEntity vendaEntity = modelMapper.map(item, VendaItemEntity.class);
			vendaItemList.add(vendaEntity);
		});
				
		return vendaItemList;
	}
}
