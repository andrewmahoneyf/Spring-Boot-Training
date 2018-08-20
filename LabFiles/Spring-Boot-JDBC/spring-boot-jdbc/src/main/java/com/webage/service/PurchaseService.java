package com.webage.service;

import java.util.Collection;

import com.webage.domain.Purchase;

public interface PurchaseService {
	public void savePurchase(Purchase purchase);
	public Collection<Purchase> findAllPurchases();
	public Purchase findPurchaseById(int id);
}
