package com.api.imobiliaria.dtos;

import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotBlank;

public class LocatarioDto {
	
	private UUID id;
	@NotBlank
	private String nomeLocatario;
	@NotBlank
	private String cpfLocatario;
	@NotBlank
	private String telefone;
	@NotBlank
	private String emailLocatario;

	private List<ImovelDto> imoveis;

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

	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public List<ImovelDto> getImoveis() {
		return imoveis;
	}

	public void setImoveis(List<ImovelDto> imoveis) {
		this.imoveis = imoveis;
	}

}
