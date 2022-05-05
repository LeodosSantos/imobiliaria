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
@Table(name = "TB_LOCATARIO")
public class LocatarioModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column(length = 100)
	private String nomeLocatario;
	@Column(nullable = false, length = 15)
	private String cpfLocatario;
	@Column(nullable = false, length = 22)
	private String telefone;
	@Column(nullable = false, length = 60)
	private String emailLocatario;

	@OneToMany(mappedBy = "locatario", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	private List<ImovelModel> imoveis = new ArrayList<ImovelModel>();

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNomeLocatario() {
		return nomeLocatario;
	}

	public void setNomeLocatario(String nomeLocatario) {
		this.nomeLocatario = nomeLocatario;
	}

	public String getCpfLocatario() {
		return cpfLocatario;
	}

	public void setCpfLocatario(String cpfLocatario) {
		this.cpfLocatario = cpfLocatario;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmailLocatario() {
		return emailLocatario;
	}

	public void setEmailLocatario(String emailLocatario) {
		this.emailLocatario = emailLocatario;
	}

	public List<ImovelModel> getImoveis() {
		return imoveis;
	}

	public void setImoveis(List<ImovelModel> imoveis) {
		this.imoveis = imoveis;
	}

}
