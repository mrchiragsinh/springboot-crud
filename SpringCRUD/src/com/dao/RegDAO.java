package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.vo.RegVO;

@Repository
public class RegDAO {
	
	@Autowired
	private  SessionFactory sessionFactory;

	public void insert(RegVO regvo) {
		// TODO Auto-generated method stub
		
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(regvo);
			transaction.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<RegVO> search() {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		Query q=session.createQuery("from RegVO");
		List<RegVO> ls=q.list();
		return ls;
	}
	
	public void delete(RegVO regvo) {
		// TODO Auto-generated method stub
		
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.delete(regvo);
			transaction.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<RegVO> edit(RegVO regvo) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		Query q=session.createQuery("from RegVO where id="+regvo.getId());
		List<RegVO> ls=q.list();
		
		return ls;
	}

}
