package com.api.imobiliaria.repositories;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.support.Repositories;
import org.springframework.test.context.junit4.SpringRunner;

import com.api.imobiliaria.models.ImovelModel;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ImovelRepositoryTest {

	
	@Autowired
	private ImovelRepository repository;
	
	@Test
	public void testVerificaBuscaPorTipoMovel() {
		String tipoImovel = " casa ";
		List<ImovelModel> imovel = repository.findByTipoImovel(tipoImovel);
		Assert.assertNotNull(imovel);
		Assert.assertEquals(tipoImovel, imovel);
	}

}
