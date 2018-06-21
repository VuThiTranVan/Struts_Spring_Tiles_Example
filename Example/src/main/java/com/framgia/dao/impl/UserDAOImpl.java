package com.framgia.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.SessionFactory;

import com.framgia.dao.UserDAO;
import com.framgia.model.User;

public class UserDAOImpl implements UserDAO {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<User> getUsers(String username) {
		CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<User> cr = builder.createQuery(User.class);
		Root<User> root = cr.from(User.class);
		 cr.select(root).where(
		 builder.like(root.get("username"), "%" + username + "%"));
		cr.select(root);
		return sessionFactory.getCurrentSession().createQuery(cr).getResultList();
	}
}
