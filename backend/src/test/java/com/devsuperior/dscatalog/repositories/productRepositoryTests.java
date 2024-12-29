package com.devsuperior.dscatalog.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.devsuperior.dscatalog.entities.Product;

@DataJpaTest
public class productRepositoryTests {

	@Autowired
	private ProductRepository repository;
	
	@Test
	public void deleteShouldDeleteObjectWhenIdExists() {
		long existingId = 1L;
		
		repository.deleteById(existingId);
		
		Optional<Product> result = repository.findById(existingId);
		Assertions.assertFalse(result.isPresent());
		// https://stackoverflow.com/questions/54205486/how-to-avoid-sharing-is-only-supported-for-boot-loader-classes-because-bootstra
	}
}
