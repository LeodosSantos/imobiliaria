package com.api.imobiliaria.contollers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.imobiliaria.dtos.ImovelDto;
import com.api.imobiliaria.dtos.ClienteDto;
import com.api.imobiliaria.dtos.ImovelComProprietarioDto;
import com.api.imobiliaria.models.ImovelModel;
import com.api.imobiliaria.models.ClienteModel;
import com.api.imobiliaria.services.ImovelService;
import com.api.imobiliaria.services.ClienteService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/imobiliaria")
public class ImovelController {

	final ImovelService imovelService; // inicializa ponto de injecao
	final ClienteService locatarioService;

	public ImovelController(ImovelService imovelService, ClienteService locatarioService) {
		this.imovelService = imovelService;
		this.locatarioService = locatarioService;
	}

//Metodo para cadastrar ou criar uma instancia

	@PostMapping("/locatario")
	public ResponseEntity<Object> saveLocatario(@RequestBody @Valid ClienteDto clienteDto) {
		var clienteModel = new ClienteModel();
		BeanUtils.copyProperties(clienteDto, clienteModel);
		ImovelModel imovelModel;
		if (clienteDto.getImoveisProprietario() != null) {
			for (ImovelDto imovelDto : clienteDto.getImoveisProprietario()) {
				imovelModel = new ImovelModel();
				BeanUtils.copyProperties(imovelDto, imovelModel);
				imovelModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
				imovelModel.setLocatario(clienteModel);
				clienteModel.getImoveisProprietario().add(imovelModel);
			}
			
		}

		clienteModel = locatarioService.save(clienteModel);
		BeanUtils.copyProperties(clienteModel, clienteDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteDto);
	}

	@PostMapping
	public ResponseEntity<Object> saveImovelComProprietario(@RequestBody @Valid ImovelComProprietarioDto imovelComProprietarioDto) {
		var imovelModel = new ImovelModel();
		BeanUtils.copyProperties(imovelComProprietarioDto, imovelModel);
		if(imovelComProprietarioDto.getProprietario() != null) {
			var proprietarioModel = new ClienteModel();
			List<ImovelModel> imoveis = new ArrayList<ImovelModel>();
			imoveis.add(imovelModel);	
			BeanUtils.copyProperties(imovelComProprietarioDto.getProprietario() , proprietarioModel);
			imovelModel.setProprietario(proprietarioModel);
			proprietarioModel.setImoveisProprietario(imoveis);
					
		}
		
		imovelModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
		imovelModel = imovelService.save(imovelModel);
		BeanUtils.copyProperties( imovelModel, imovelComProprietarioDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(imovelComProprietarioDto);
	}

	@GetMapping("/getAll") // gera uma listagem de com todas as instancias - getAll//
	public ResponseEntity<List<ImovelModel>> getAllImovel() {
		List<ImovelModel> findAll = imovelService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(findAll);
	}

	@GetMapping("/{id}") // BUSCA UM ID EPECIFICO
	public ResponseEntity<Object> getOneImovel(@PathVariable(value = "id") UUID id) {
		Optional<ImovelModel> imovelModelOptional = imovelService.findById(id);
		if (!imovelModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" Imovel not found");

		}

		return ResponseEntity.status(HttpStatus.OK).body(imovelModelOptional.get());

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteImobiliaria(@PathVariable(value = " id") UUID id) {
		Optional<ImovelModel> imovelModelOptional = imovelService.findById(id);
		if (!imovelModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" Imobiliaria not found. ");
		}
		imovelService.delete(imovelModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Imobiliaria deleted successfully. ");

	}

}
