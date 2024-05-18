package com.dailycodebuffer.productservice.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycodebuffer.productservice.entity.Product;
import com.dailycodebuffer.productservice.model.ProductRequest;
import com.dailycodebuffer.productservice.model.ProductResponse;
import com.dailycodebuffer.productservice.repository.ProductRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public long addProduct(ProductRequest productRequest) {
		log.info("Adding Product");
		Product product = Product.builder().productName(productRequest.getName()).quantity(productRequest.getQuantity())
				.price(productRequest.getPrice()).build();
		productRepository.save(product);
		log.info("Product created");

		return product.getProductId();
	}

	@Override
	public ProductResponse getProductById(Long id) {
		log.info("get the product for id" + id);
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Product with given id is not found"));

		ProductResponse productResponse = new ProductResponse();
		BeanUtils.copyProperties(product, productResponse);

		return productResponse;

	}
}
