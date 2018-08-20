package com.webage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webage.domain.Purchase;
import com.webage.repository.PurchaseRepository;

@Service
public class PurchaseServiceImpl implements PurchaseService {
	@Autowired
	private PurchaseRepository repo;


	public void savePurchase(Purchase purchase) {
		repo.save(purchase);
	}


	public Iterable<Purchase> findAllPurchases() {
		return repo.findAll();
	}


	public Purchase findPurchaseById(long id) {
		return repo.findOne(id);
	}

}
