package com.javatechie.crud.example.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
//import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
//import org.springframework.test.context.junit4.SpringRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.javatechie.crud.example.entity.Product;
import com.javatechie.crud.example.repository.ProductRepository;
import com.javatechie.crud.example.service.ProductService;

@ExtendWith(MockitoExtension.class)

 class ProductServiceTest {
	@InjectMocks
	ProductService productservice;
	@Mock
	ProductRepository productrepository;

	Product product = new Product();
	List<Product> products = new ArrayList<>();

	@BeforeEach
	public void Service() {
		product.setId(1);
		product.setName("rava");
		product.setPrice(45.00);
		product.setQuantity(100);

		products.add(product);

	}

	@Test
	 void saveProductTest() {
		// when(productrepository.save(product)).thenReturn(product);
		doReturn(product).when(productrepository).save(product);
		Product ver = productservice.saveProduct(product);

		assertEquals(ver.getName(), product.getName());
	}

	@Test
      void saveProductsTest() {

		//when(productrepository.saveAll(products)).thenReturn(products);
		 doReturn(products).when(productrepository).saveAll(products);

		List<Product> cer = productservice.saveProducts(products);

		assertEquals(products.get(0).getName(), cer.get(0).getName());
	}
}