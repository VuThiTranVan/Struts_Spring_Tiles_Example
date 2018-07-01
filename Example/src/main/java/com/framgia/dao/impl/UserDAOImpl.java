package com.framgia.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.framgia.dao.UserDAO;
import com.framgia.model.User;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {

	@Override
	public List<User> getUsers(String username) {
		CriteriaBuilder builder = getSessionFactory().getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<User> cr = builder.createQuery(User.class);
		Root<User> root = cr.from(User.class);
		 cr.select(root).where(
		 builder.like(root.get("username"), "%" + username + "%"));
		cr.select(root);
		return currentSession().createQuery(cr).getResultList();
	}

	@Override
	public void createUsser(User user) {
		getSessionFactory().getCurrentSession().save(user);
	}
}
