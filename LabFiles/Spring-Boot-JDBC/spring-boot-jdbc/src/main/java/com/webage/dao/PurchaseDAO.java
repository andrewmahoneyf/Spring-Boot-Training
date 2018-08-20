package com.webage.dao;

import java.util.Collection;

import com.webage.domain.Purchase;

public interface PurchaseDAO {
	public void savePurchase(Purchase purchase);
	public Collection<Purchase> getAllPurchases();
	public Purchase getPurchase(int id);
}
