package com.api.imobiliaria.dtos;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ImovelDto {
	
	private UUID id;
	@NotBlank
	private String tipoImovel;
	@NotBlank
	private String enderecoImovel;
	@NotNull
	private boolean garagemImovel;
	
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
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
	
	
}
