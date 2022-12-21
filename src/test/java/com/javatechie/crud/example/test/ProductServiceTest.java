package com.javatechie.crud.example.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.javatechie.crud.example.entity.Product;
import com.javatechie.crud.example.repository.ProductRepository;
import com.javatechie.crud.example.service.ProductService;

@RunWith(SpringRunner.class)
public class ProductServiceTest {
	@InjectMocks
	ProductService productservice;
	@Mock
	ProductRepository productrepository;

	Product product = new Product();
	List<Product> products = new ArrayList<>();

	@Before
	public void Service() {
		product.setId(1);
		product.setName("rava");
		product.setPrice(45.00);
		product.setQuantity(100);

		products.add(product);

	}

	@Test
	public void saveProductTest() {
		when(productrepository.save(product)).thenReturn(product);
		Product ver = productservice.saveProduct(product);

		assertEquals(ver.getName(), product.getName());
	}

	@Test
	public void saveProductsTest() {

		when(productrepository.saveAll(products)).thenReturn(products);
		List<Product> cer = productservice.saveProducts(products);

		assertEquals(products.get(0).getName(), cer.get(0).getName());
	}
}