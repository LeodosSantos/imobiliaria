package com.api.imobiliaria.dtos;

import java.util.List;

import javax.validation.constraints.NotBlank;

import com.api.imobiliaria.models.ImovelModel;

public class LocatarioDto {

	@NotBlank
	private String nomeLocatario;
	@NotBlank
	private String cpfLocatario;
	@NotBlank
	private String telefone;
	@NotBlank
	private String emailLocatario;

	private List<ImovelModel> imovelModel;

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

	public List<ImovelModel> getImovelModel() {
		return imovelModel;
	}

	public void setImovelModel(List<ImovelModel> imovelModel) {
		this.imovelModel = imovelModel;
	}
	

}
