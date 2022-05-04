package com.api.imobiliaria.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.imobiliaria.models.ImovelModel;
import com.api.imobiliaria.repositories.ImovelRepository;

@Service
public class ImovelService {

	final ImovelRepository imovelRepository;

	public ImovelService(ImovelRepository imovelRepository) {
		this.imovelRepository = imovelRepository;
	}

	@Transactional
	public ImovelModel save(ImovelModel imovelModel) {
		return imovelRepository.save(imovelModel);
	}

	public List<ImovelModel> findAll() {
		return imovelRepository.findAll();
	}

	public Optional<ImovelModel> findById(UUID id) {
		return imovelRepository.findById(id);
	}
	
	@Transactional
	public void delete(ImovelModel imovelModel) {
		 imovelRepository.delete(imovelModel);
		
	}
}
