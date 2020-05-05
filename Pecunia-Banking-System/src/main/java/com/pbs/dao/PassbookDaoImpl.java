package com.pbs.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PassbookDaoImpl implements IPassbookDao {
	
	public List<Transaction> updatePassbook(long accountId){
		Map<String, Transaction> transactionStore = TransactionDaoImpl.transactionStore;
		List<Transaction> transactions = new ArrayList<>(transactionStore.values());
		List<Transaction> result = new ArrayList<>();
		for (Transaction transaction : transactions) {
			if (transaction.gettransactionId().equals(accountId)) {
				result.add(transaction);
			}
		}
		return result;
	}

}
