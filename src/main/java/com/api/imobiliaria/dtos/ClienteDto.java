package com.api.imobiliaria.dtos;

import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotBlank;

public class ClienteDto {
	
	private UUID id;
	@NotBlank
	private String nome;
	@NotBlank
	private String cpf;
	@NotBlank
	private String telefone;
	@NotBlank
	private String email;

	private List<ImovelDto> imoveisLocatario;
	
	private List<ImovelDto> imoveisLocador;
	
	private List<ImovelDto> imoveisProprietario;

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

	public List<ImovelDto> getImoveisLocatario() {
		return imoveisLocatario;
	}

	public void setImoveisLocatario(List<ImovelDto> imoveisLocatario) {
		this.imoveisLocatario = imoveisLocatario;
	}

	public List<ImovelDto> getImoveisLocador() {
		return imoveisLocador;
	}

	public void setImoveisLocador(List<ImovelDto> imoveisLocador) {
		this.imoveisLocador = imoveisLocador;
	}

	public List<ImovelDto> getImoveisProprietario() {
		return imoveisProprietario;
	}

	public void setImoveisProprietario(List<ImovelDto> imoveisProprietario) {
		this.imoveisProprietario = imoveisProprietario;
	}


}
