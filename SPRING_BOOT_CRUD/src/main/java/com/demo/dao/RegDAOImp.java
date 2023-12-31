package com.demo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.RegVO;



@Repository
public class RegDAOImp implements RegDAO{

	@Autowired SessionFactory sessionFactory;
	
	
	public void insert(RegVO regVO)
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(regVO);
	}
	
	
	public List search()
	{
			Session session = sessionFactory.openSession();
			
			Query q=session.createQuery("from RegVO");
			
			List ls=q.list();
	
		return ls;
	}
	
	
	public void delete(RegVO regVO) 
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(regVO);
	}
	
	
	public List edit(RegVO regVO)
	{
			Session session = sessionFactory.openSession();
			
			Query q=session.createQuery("from RegVO where id="+regVO.getId());
			
			List ls=q.list();
	
		return ls;
	}
	
	
}
