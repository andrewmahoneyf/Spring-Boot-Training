package com.webage.service;

import com.webage.domain.Purchase;

public interface PurchaseService {
	public void savePurchase(Purchase purchase);
	public Iterable<Purchase> findAllPurchases();
	public Purchase findPurchaseById(long id);
}
