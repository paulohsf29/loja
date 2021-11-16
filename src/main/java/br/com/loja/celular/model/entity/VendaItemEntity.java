package br.com.loja.celular.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class VendaItemEntity implements Serializable {

	private static final long serialVersionUID = 5179198825344890962L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ITEM_VENDA")
	private Long idVendaItem;

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

		list.forEach(item -> {
			VendaItemEntity vendaEntity = modelMapper.map(item, VendaItemEntity.class);
			vendaItemList.add(vendaEntity);
		});

		return vendaItemList;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VendaItemEntity other = (VendaItemEntity) obj;
		return Objects.equals(idVendaItem, other.idVendaItem) && Objects.equals(nrItemVenda, other.nrItemVenda)
				&& Objects.equals(produto, other.produto) && Objects.equals(qtdItem, other.qtdItem)
				&& Objects.equals(vlItem, other.vlItem);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idVendaItem, nrItemVenda, produto, qtdItem, vlItem);
	}
}
