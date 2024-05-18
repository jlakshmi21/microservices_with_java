package com.dailycodebuffer.productservice.service;

import com.dailycodebuffer.productservice.model.ProductRequest;
import com.dailycodebuffer.productservice.model.ProductResponse;

public interface ProductService {
	long addProduct(ProductRequest productRequest);

	ProductResponse getProductById(Long id);
}
