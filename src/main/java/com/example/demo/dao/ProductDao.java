package com.example.demo.dao;

import java.util.List;

import com.example.demo.bean.ProductEntity;

public interface ProductDao {

	public List<ProductEntity> getAll();

	public ProductEntity getById(Integer id);

	public void create(ProductEntity productEntity);

	public void updateById(ProductEntity productEntity);

	public void deleteProduct(ProductEntity productEntity);
}
