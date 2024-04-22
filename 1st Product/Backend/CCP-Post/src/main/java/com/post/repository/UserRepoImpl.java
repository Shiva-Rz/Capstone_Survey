//package com.post.repository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.post.entity.User;
//
//import jakarta.persistence.EntityManager;
//
//@Repository
//public class UserRepoImpl implements UserRepo{
//
//	@Autowired
//	EntityManager em;
//	
//	
//	@Override
//	public void updateUser(User user) {
//		em.getTransaction().begin();
//		em.persist(user);
//		em.getTransaction().commit();
//		
//	}
//
//}
