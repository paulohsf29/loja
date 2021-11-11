package br.com.loja.celular.model.entity;

import javax.persistence.*;

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
	@Column(name = "ID_CLEINTE")
	private Long idCliente;
	
	@Column(name = "NM_CLIENTE")
	private String nmCliente;
	
	@Column(name = "NR_CPF")
	private String nrCpf;
	
	@Column(name = "NR_TELEFONE")
	private String telefone;
	
	@Column(name = "EMAIL")
	private String email;
	

}
