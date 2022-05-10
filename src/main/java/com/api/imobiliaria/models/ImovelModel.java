package com.api.imobiliaria.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "TB_IMOVEL")
public class ImovelModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Type(type = "org.hibernate.type.UUIDCharType")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column(nullable = false, length = 10)
	private String tipoImovel;
	@Column(nullable = false, length = 100)
	private String enderecoImovel;
	@Column(nullable = false, length = 1)
	private boolean garagemImovel;
	
	@Column(nullable = false)
	private LocalDateTime registrationDate;

	@ManyToOne
	@JoinColumn(name = "LOCATARIO_ID")
	private ClienteModel locatario;
		
	@ManyToOne
	@JoinColumn(name = "LOCADOR_ID")
	private ClienteModel locador;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "PROPRIETARIO_ID")
	private ClienteModel proprietario;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTipoImovel() {
		return tipoImovel;
	}

	public void setTipoImovel(String tipoImovel) {
		this.tipoImovel = tipoImovel;
	}

	public String getEnderecoImovel() {
		return enderecoImovel;
	}

	public void setEnderecoImovel(String enderecoImovel) {
		this.enderecoImovel = enderecoImovel;
	}

	public boolean isGaragemImovel() {
		return garagemImovel;
	}

	public void setGaragemImovel(boolean garagemImovel) {
		this.garagemImovel = garagemImovel;
	}

	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}

	public ClienteModel getLocatario() {
		return locatario;
	}

	public void setLocatario(ClienteModel locatario) {
		this.locatario = locatario;
	}

	public ClienteModel getLocador() {
		return locador;
	}

	public void setLocador(ClienteModel locador) {
		this.locador = locador;
	}

	public ClienteModel getProprietario() {
		return proprietario;
	}

	public void setProprietario(ClienteModel proprietario) {
		this.proprietario = proprietario;
	}
	

}
