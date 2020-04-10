/**
 * 
 */
package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.ProductEntity;
import com.example.demo.dao.ProductDao;
import com.example.demo.service.ProductService;

/**
 * @author ChinhTQ
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;
	
	@Override
	public ProductEntity getProductEntity(Integer id) {
		ProductEntity entity = dao.getProduct(id);
		return entity;
	}

}
