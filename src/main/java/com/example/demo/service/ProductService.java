package com.example.demo.service;

import java.util.List;

import com.example.demo.bean.ProductEntity;
import com.example.demo.ultil.CustomException;

public interface ProductService {

	public List<ProductEntity> getAll();

	public ProductEntity getProductById(Integer id) throws CustomException;

	public ProductEntity create(String json) throws CustomException;

	public ProductEntity update(String json, Integer id) throws CustomException;

	public void deleteById(Integer id) throws CustomException;
}
