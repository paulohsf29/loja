package br.com.loja.celular.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import br.com.loja.celular.form.VendaItemForm;
import br.com.loja.celular.model.dto.VendaItemDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_VENDA_ITEM")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(VendaItemEntity.class)
public class VendaItemEntity implements Serializable{
	
	private static final long serialVersionUID = 5179198825344890962L;

	
    @Id
    @JoinColumn(name = "ID_VENDA")
    @ManyToOne(fetch = FetchType.LAZY)
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
	
//	public static List<VendaItemEntity> convertToEntity(List<VendaItemForm> formList){
//		List<VendaItemEntity> entityList = new ArrayList<VendaItemEntity>();
//		
//		formList.forEach(form->{
//			VendaItemEntity entity = new VendaItemEntity();
//			
//			entity.setIdVenda(null);
//			entity.setNrItemVenda(form.getNrItemVenda());
//			entity.setProduto(ProdutoEntity.convertToEntity(form.getProduto()));
//			entity.setQtdItem(form.getQtdItem());
//			entity.setVlItem(form.getVlItem());
//			
//			entityList.add(entity);
//		});
//		
//		return entityList;
//	}
}
