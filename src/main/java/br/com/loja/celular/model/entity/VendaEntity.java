package br.com.loja.celular.model.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
public class VendaEntity implements Serializable{

	private static final long serialVersionUID = 4292790744267054174L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_VENDA")
	private Long idVenda;
	
	@Column(name = "VL_VENDA")
	private Double vlVenda;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<VendaItemEntity> itens;
	
	@ManyToOne
	@JoinColumn(name = "ID_CLIENTE")
	private ClienteEntity cliente;
	
	public static VendaEntity convertToEntity(Object form) {
		ModelMapper modelMapper = new ModelMapper();
		VendaEntity vendaEntity = modelMapper.map(form, VendaEntity.class);
		return vendaEntity;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VendaEntity other = (VendaEntity) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(idVenda, other.idVenda)
				&& Objects.equals(itens, other.itens) && Objects.equals(vlVenda, other.vlVenda);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, idVenda, itens, vlVenda);
	}

}
