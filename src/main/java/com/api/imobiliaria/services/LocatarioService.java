package com.api.imobiliaria.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.imobiliaria.models.ImovelModel;
import com.api.imobiliaria.models.LocatarioModel;
import com.api.imobiliaria.repositories.LocatarioRepository;

@Service
public class LocatarioService {

	final LocatarioRepository locatarioRepository;

	public LocatarioService(LocatarioRepository locatarioRepository) {
		this.locatarioRepository = locatarioRepository;
	}

	@Transactional
	public LocatarioModel save(LocatarioModel locatarioModel) {
		return locatarioRepository.save(locatarioModel);
	}

	public List<LocatarioModel> findAll() {
		return locatarioRepository.findAll();
	}

	public Optional<LocatarioModel> findById(UUID id) {
		return locatarioRepository.findById(id);
	}
	
	@Transactional
	public void delete(LocatarioModel imovelModel) {
		 locatarioRepository.delete(imovelModel);
		
	}
}
