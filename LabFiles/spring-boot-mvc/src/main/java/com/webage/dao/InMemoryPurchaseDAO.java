package com.webage.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.webage.domain.Purchase;

@Repository
public class InMemoryPurchaseDAO implements PurchaseDAO {

	private Map<Integer, Purchase> purchases=new HashMap<>();
	
	{
		DateFormat df=new SimpleDateFormat("MMM d, yyyy");
		try {
			savePurchase(new Purchase(1, "Susan", df.parse("May 12, 2010"), "Mountain Bike"));
			savePurchase(new Purchase(2, "Bob", df.parse("Apr 30, 2010"), "Football"));
			savePurchase(new Purchase(3, "Jill", df.parse("June 5, 2010"), "Kayak"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void savePurchase(Purchase purchase) {
		purchases.put(purchase.getId(), purchase);
	}

	@Override
	public Collection<Purchase> getAllPurchases() {
		return purchases.values();
	}

	@Override
	public Purchase getPurchase(int id) {
		return purchases.get(id);
	}

}
