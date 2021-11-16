package br.com.loja.celular.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

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
	
	@OneToMany(mappedBy = "venda",cascade = CascadeType.ALL)
	//@JoinColumn(name = "ITENS")
	private List<VendaItemEntity> itens;
	
	@ManyToOne
	@JoinColumn(name = "ID_CLIENTE")
	private ClienteEntity cliente;
	
	public static VendaEntity convertToEntity(Object form) {
		ModelMapper modelMapper = new ModelMapper();
		VendaEntity vendaEntity = modelMapper.map(form, VendaEntity.class);
		return vendaEntity;
	}
	
//	public static VendaEntity convertToEntity(VendaForm form) {
//		VendaEntity entity = new VendaEntity();
//		
//		entity.setCliente(ClienteEntity.convertToEntity(form.getIdCliente()));
//		entity.setIdVenda(null);
//		entity.setItens(VendaItemEntity.convertToEntity(form.getItens()));
//		entity.setVlVenda(form.getVlVenda());
//		
//		return entity;
//	}
	
}
