package com.pbs.dao;

import java.util.List;

public interface IPassbookDao {

	public List<Transaction> updatePassbook(long accountId);
	
}
