package com.api.imobiliaria.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.imobiliaria.models.LocatarioModel;

@Repository  // NÃO É OBRIGATÓRIO DECLARAR, NESTE CASO, PORQUE FOI EXTENDIDO
public interface LocatarioRepository extends JpaRepository<LocatarioModel, UUID> {
	
	// Criando queries manualmente
//	@Query("select * from ImovelModel where tipo =:tipo")
//	public ImovelModel retornaImovelPeloTipo(String tipo);
	

}
