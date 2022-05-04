package com.api.imobiliaria.contollers;

import java.time.LocalDateTime;
import java.time.ZoneId;
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
import com.api.imobiliaria.dtos.LocatarioDto;
import com.api.imobiliaria.models.ImovelModel;
import com.api.imobiliaria.models.LocatarioModel;
import com.api.imobiliaria.services.ImovelService;
import com.api.imobiliaria.services.LocatarioService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/imobiliaria")
public class ImovelController {

	final ImovelService imovelService; //inicializa ponto de injecao
	final LocatarioService locatarioService;

	public ImovelController (ImovelService imovelService,LocatarioService locatarioService ) {
		this.imovelService = imovelService;
		this.locatarioService = locatarioService;
	}
	
//Metodo para cadastrar ou criar uma instancia
	
	
	@PostMapping("/locatario")
	public ResponseEntity<Object>saveLocatario(@RequestBody @Valid LocatarioDto locatarioDto){
		var locatarioModel = new LocatarioModel();
		BeanUtils.copyProperties(locatarioDto, locatarioModel);
		//locatarioModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(locatarioService.save(locatarioModel));
	}
	
			
	@PostMapping
	public ResponseEntity<Object>saveImovel(@RequestBody @Valid ImovelDto imovelDto){
		var imovelModel = new ImovelModel();
		BeanUtils.copyProperties(imovelDto, imovelModel);
		imovelModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(imovelService.save(imovelModel));
	}
	
	@GetMapping // gera uma listagem de com todas as instancias - getAll//
	public ResponseEntity<List<ImovelModel>>getAllImovel(){
		return ResponseEntity.status(HttpStatus.OK).body(imovelService.findAll());	
	}
	
	@GetMapping("/id") // BUSCA UM ID EPECIFICO
	public ResponseEntity<Object> getOneImovel (@PathVariable(value = "id") UUID id){
		Optional<ImovelModel>imovelModelOptional = imovelService.findById(id);
		if(!imovelModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" Imovel not found");
			
	}
			
		return ResponseEntity.status(HttpStatus.OK).body(imovelModelOptional.get());
	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteImobiliaria(@PathVariable(value=" id")UUID id){
		Optional<ImovelModel> imovelModelOptional = imovelService.findById(id);
		if (!imovelModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" Imobiliaria not found. ");
		}
		imovelService.delete(imovelModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Imobiliaria deleted successfully. ");
		
	}
	
}
