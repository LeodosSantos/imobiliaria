package com.api.imobiliaria.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.imobiliaria.models.ImovelModel;
import com.api.imobiliaria.models.ClienteModel;
import com.api.imobiliaria.repositories.ClienteRepository;

@Service
public class ClienteService {

	final ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@Transactional
	public ClienteModel save(ClienteModel clienteModel) {
		return clienteRepository.save(clienteModel);
	}

	public List<ClienteModel> findAll() {
		return clienteRepository.findAll();
	}

	public Optional<ClienteModel> findById(UUID id) {
		return clienteRepository.findById(id);
	}
	
	@Transactional
	public void delete(ClienteModel imovelModel) {
		 clienteRepository.delete(imovelModel);
		
	}
}
