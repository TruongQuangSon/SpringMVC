package com.msita.training.database;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.msita.training.entity.Product;

@Repository
public class ProductDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<Product> getProducts(){
		return (List<Product>)sessionFactory.getCurrentSession().createQuery("from Product").list();
	}
	@Transactional
	public Product getProduct(int id){
		return (Product)sessionFactory.getCurrentSession().createQuery("from Product where idProduct="+id).uniqueResult();
	}
}
