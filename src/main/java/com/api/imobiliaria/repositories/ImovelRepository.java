package com.api.imobiliaria.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.imobiliaria.models.ImovelModel;

@Repository  // NÃO É OBRIGATÓRIO DECLARAR, NESTE CASO, PORQUE FOI EXTENDIDO
public interface ImovelRepository extends JpaRepository<ImovelModel, UUID> {
	
	// Criando queries manualmente
//	@Query("select * from ImovelModel where tipo =:tipo")
//	public ImovelModel retornaImovelPeloTipo(String tipo);
	public List<ImovelModel> findByTipoImovel(String tipo);

	public List<ImovelModel> findByGaragem(boolean garagem);
	

}
