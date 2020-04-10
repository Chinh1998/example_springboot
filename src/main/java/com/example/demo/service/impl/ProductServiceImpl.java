/**
 * 
 */
package com.example.demo.service.impl;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.ProductEntity;
import com.example.demo.dao.ProductDao;
import com.example.demo.service.ProductService;
import com.example.demo.ultil.CustomException;

/**
 * @author ChinhTQ
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;

	@Override
	public ProductEntity getProductById(Integer id) throws CustomException {
		ProductEntity entity = dao.getById(id);
		if (entity == null) {
			throw new CustomException("Không tồn tại sản phẩm ");
		}
		return entity;
	}

	@Override
	public ProductEntity create(String json) throws CustomException {
		JSONObject productJson = new JSONObject(json);
		if (productJson.isEmpty()) {
			throw new CustomException("moi ban nhap thong tin");
		}
		ProductEntity productEntity = new ProductEntity();
		productEntity.setProductName(productJson.getString("productName"));
		productEntity.setProductPrice(productJson.getDouble("productPrice"));
		productEntity.setProductAmount(productJson.getInt("productAmount"));
		dao.create(productEntity);
		return productEntity;
	}

	@Override
	public List<ProductEntity> getAll() {
		List<ProductEntity> lProductEntities = dao.getAll();

		return lProductEntities;
	}

	@Override
	public ProductEntity update(String json, Integer id) throws CustomException {
		JSONObject productJson = new JSONObject(json);
		if (productJson.isEmpty()) {
			throw new CustomException("moi ban nhap thong tin");
		}
		ProductEntity productEntity = this.getProductById(id);
		productEntity.setProductName(productJson.getString("productName"));
		productEntity.setProductPrice(productJson.getDouble("productPrice"));
		productEntity.setProductAmount(productJson.getInt("productAmount"));
		dao.updateById(productEntity);
		return productEntity;
	}

	@Override
	public void deleteById(Integer id) throws CustomException {

		ProductEntity productEntity = this.getProductById(id);
		dao.deleteProduct(productEntity);

	}

}
