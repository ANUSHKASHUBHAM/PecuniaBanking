package com.pbs.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;

public class PassbookDaoImpl implements IPassbookDao {
	@Autowired
    EntityManager em;
	
	public List<Transaction> updatePassbook(long accountId){
		Query query = em.createQuery("select t from Transaction t where t.accountId=:accountId");
		query.setParameter("accountId", accountId);
		return query.getResultList();
	}
	
	public List<Transaction> accountSummary(long accountId,LocalDate startDate,LocalDate endDate){
		Query query = em.createQuery("select t from Transaction t where t.account_id=:accountId AND t.transaction_date BETWEEN :startDate AND :endDate");
		query.setParameter("accountId", accountId);
		query.setParameter("startDate", startDate);
		query.setParameter("endDate", endDate);
		
		List<Transaction> transactions = query.getResultList();
		return transactions;
	}

}
