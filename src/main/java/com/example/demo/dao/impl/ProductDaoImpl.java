package com.example.demo.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.ProductEntity;
import com.example.demo.dao.ProductDao;

/**
 * 
 * @author ChinhTQ
 *
 */
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public ProductEntity getById(Integer id) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT pe ");
		sql.append(" FROM ");
		sql.append("    ProductEntity pe ");
		sql.append(" WHERE ");
		sql.append("    pe.productId = :id ");

		Query query = this.entityManager.createQuery(sql.toString());
		// truyen bien vao cau query
		query.setParameter("id", id);
		ProductEntity entity = null;
		try {
			entity = (ProductEntity) query.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return entity;
		// ve tim hieu
		// ProductEntity entity = query.getResultList();

	}

	@Override
	public void create(ProductEntity productEntity) {
		entityManager.persist(productEntity);

	}

	@Override
	public List<ProductEntity> getAll() {
		StringBuilder sql = new StringBuilder();
		sql.append(" FROM ");
		sql.append("    ProductEntity pe ");

		Query query = this.entityManager.createQuery(sql.toString());

		List<ProductEntity> lProductEntities = query.getResultList();

		return lProductEntities;
	}

	@Override
	public void updateById(ProductEntity productEntity) {

		this.entityManager.merge(productEntity);

	}

	@Override
	public void deleteProduct(ProductEntity productEntity) {

		this.entityManager.remove(productEntity);
	}

}
