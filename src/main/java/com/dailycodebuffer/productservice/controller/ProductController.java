package com.dailycodebuffer.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.productservice.model.ProductRequest;
import com.dailycodebuffer.productservice.model.ProductResponse;
import com.dailycodebuffer.productservice.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping
	public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest) {
		long productId = productService.addProduct(productRequest);
		// System.out.println("hello");
		return new ResponseEntity<>(productId, HttpStatus.CREATED);
	}

	public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id) {
		ProductResponse productResponse = productService.getProductById(id);
		return new ResponseEntity<>(productResponse, HttpStatus.OK);
	}
}
