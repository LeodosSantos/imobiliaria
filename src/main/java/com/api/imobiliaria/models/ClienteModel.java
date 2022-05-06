package com.api.imobiliaria.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CLIENTE")
public class ClienteModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column(length = 100)
	private String nome;
	@Column(nullable = false, length = 15)
	private String cpf;
	@Column(nullable = false, length = 22)
	private String telefone;
	@Column(nullable = false, length = 60)
	private String email;
	

	@OneToMany(mappedBy = "locatario", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	private List<ImovelModel> imoveisLocatario = new ArrayList<ImovelModel>();

	@OneToMany(mappedBy = "locador", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	private List<ImovelModel> imoveisLocador = new ArrayList<ImovelModel>();

	@OneToMany(mappedBy = "proprietario", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	private List<ImovelModel> imoveisProprietario = new ArrayList<ImovelModel>();

	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<ImovelModel> getImoveisLocatario() {
		return imoveisLocatario;
	}

	public void setImoveisLocatario(List<ImovelModel> imoveisLocatario) {
		this.imoveisLocatario = imoveisLocatario;
	}

	public List<ImovelModel> getImoveisLocador() {
		return imoveisLocador;
	}

	public void setImoveisLocador(List<ImovelModel> imoveisLocador) {
		this.imoveisLocador = imoveisLocador;
	}

	public List<ImovelModel> getImoveisProprietario() {
		return imoveisProprietario;
	}

	public void setImoveisProprietario(List<ImovelModel> imoveisProprietario) {
		this.imoveisProprietario = imoveisProprietario;
	}
	

}
