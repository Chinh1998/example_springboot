package com.example.demo.controller;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.ProductEntity;
import com.example.demo.service.ProductService;
import com.example.demo.ultil.CustomException;
import com.example.demo.ultil.CustomStatus;

/**
 * 
 * @author ChinhTQ
 *
 */

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	/**
	 * @author ChinhTQ
	 * @return All Product
	 */
	@RequestMapping(value = "/api/product", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<ProductEntity>> getProduct() {
		List<ProductEntity> entities = null;
		try {
			entities = productService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<ProductEntity>>(HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(entities);

	}

	/**
	 * @author ChinhTQ
	 * @param id
	 * @return One Product
	 */
	@RequestMapping(value = "/api/product/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CustomStatus> getProduct(@PathVariable Integer id) {
		ProductEntity entity = null;
		CustomStatus customStatus = null;
		try {
			entity = productService.getProductById(id);
		} catch (Exception e) {
			e.printStackTrace();
			customStatus = new CustomStatus(HttpStatus.PAYMENT_REQUIRED, e.getMessage());
			return new ResponseEntity(customStatus, HttpStatus.BAD_REQUEST);
		}
		customStatus = new CustomStatus(HttpStatus.OK, "OK", entity);
		return ResponseEntity.ok(customStatus);

	}

	/**
	 * 
	 * @param json
	 * @return Create Product
	 */
	@RequestMapping(value = "/api/product", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CustomStatus> createProduct(@RequestBody String json) {
		ProductEntity productEntity = null;
		CustomStatus customStatus = null;
		try {
			productEntity = productService.create(json);
		} catch (CustomException e) {
			e.getStackTrace();
			customStatus = new CustomStatus(HttpStatus.PAYMENT_REQUIRED, e.getMessage());
			return new ResponseEntity(customStatus, HttpStatus.PAYMENT_REQUIRED);
		}
		customStatus = new CustomStatus(HttpStatus.OK, "OK", productEntity);
		return ResponseEntity.ok(customStatus);
	}

	/**
	 * 
	 * @param json
	 * @param id
	 * @return Update Product
	 */
	@RequestMapping(value = "/api/product/{id}", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CustomStatus> upDate(@RequestBody String json, @PathVariable Integer id) {
		CustomStatus customStatus = null;
		ProductEntity productEntity = null;
		try {
			productEntity = productService.update(json, id);
		} catch (CustomException e) {
			e.getStackTrace();
			customStatus = new CustomStatus(HttpStatus.PAYMENT_REQUIRED, e.getMessage());
			return new ResponseEntity(customStatus, HttpStatus.PAYMENT_REQUIRED);
		}
		customStatus = new CustomStatus(HttpStatus.OK, "OK", productEntity);
		return ResponseEntity.ok(customStatus);
	}

	/**
	 * 
	 * @param id Delete Product
	 */
	@RequestMapping(value = "/api/product/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CustomStatus> delete(@PathVariable Integer id) {
		CustomStatus customStatus = null;
		try {
			productService.deleteById(id);
		} catch (CustomException e) {
			e.printStackTrace();
			customStatus = new CustomStatus(HttpStatus.PAYMENT_REQUIRED, e.getMessage());
			return new ResponseEntity(customStatus, HttpStatus.PAYMENT_REQUIRED);
		}
		customStatus = new CustomStatus(HttpStatus.OK, "Xóa thành công");
		return ResponseEntity.ok(customStatus);
	}
}
