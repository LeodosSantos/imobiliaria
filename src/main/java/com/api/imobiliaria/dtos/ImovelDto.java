package com.api.imobiliaria.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ImovelDto {
	
	@NotBlank
	private String tipoImovel;
	@NotBlank
	private String enderecoImovel;
	@NotNull
	private boolean garagemImovel;
	@NotBlank
	private String locadorImovel;
	
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
	public String getLocadorImovel() {
		return locadorImovel;
	}
	public void setLocadorImovel(String locadorImovel) {
		this.locadorImovel = locadorImovel;
	}
	public String getLocatarioImovel() {
		return locatarioImovel;
	}
	public void setLocatarioImovel(String locatarioImovel) {
		this.locatarioImovel = locatarioImovel;
	}
	@NotBlank
	private String locatarioImovel;
	
	
}
