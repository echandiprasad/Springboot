package com.chandi.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chandi.dao.UserDao;
import com.chandi.model.UserDetails;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<UserDetails> getUserDetails() {
		Criteria criteria = sessionFactory.openSession().createCriteria(UserDetails.class);
		return criteria.list();
	}

	public UserDetails findUserByEmail(String email) {
		UserDetails userDetails = null;
		Criteria criteria = sessionFactory.openSession().createCriteria(UserDetails.class);
		criteria.add(Restrictions.eq("email", email));
		List<UserDetails> entityList = criteria.list();
		if(!entityList.isEmpty()) {
			userDetails = entityList.get(0);
		}
		return userDetails;
	}

}
