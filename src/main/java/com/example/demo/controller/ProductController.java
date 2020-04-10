package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.ProductEntity;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/api/product", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ProductEntity> getProduct(@PathVariable Integer id) {
		ProductEntity entity = null;
		try {
			entity = productService.getProductEntity(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ProductEntity>(HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(entity);

	}

}
