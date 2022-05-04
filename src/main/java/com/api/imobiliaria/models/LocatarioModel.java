package com.api.imobiliaria.models;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_LOCATARIO")
public class LocatarioModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column(length = 100)
	private String nomeLocatario;
	@Column (nullable = false, length = 15)
	private String cpfLocatario;
	@Column(nullable = false, length=22)
	private String telefone;
	@Column(nullable = false, length= 60)
	private String emailLocatario;
	
	
    @OneToMany(mappedBy="locatarioModel")
	private List<ImovelModel> imovelModel;
	
	
	
	
	
 
}
