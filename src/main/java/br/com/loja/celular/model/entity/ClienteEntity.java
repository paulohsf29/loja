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
@Table(name = "TB_CLIENTE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CLIENTE")
	private Long idCliente;

	@Column(name = "NM_CLIENTE")
	private String nmCliente;

	@Column(name = "NR_CPF")
	private String nrCpf;

	@Column(name = "NR_TELEFONE")
	private String telefone;

	@Column(name = "EMAIL")
	private String email;

	public static ClienteEntity convertToEntity(Object form) {
		ModelMapper modelMapper = new ModelMapper();
		ClienteEntity clienteEntity = modelMapper.map(form, ClienteEntity.class);
		return clienteEntity;
	}

}
