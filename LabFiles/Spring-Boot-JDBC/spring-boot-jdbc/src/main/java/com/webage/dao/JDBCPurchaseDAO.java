package com.webage.dao;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.webage.domain.Purchase;

@Repository
public class JDBCPurchaseDAO implements PurchaseDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void savePurchase(Purchase purchase) {
        // Add code here.
    }

    @Override
    public Collection<Purchase> getAllPurchases() {
        return jdbcTemplate.query("Select * from PURCHASE", new BeanPropertyRowMapper<Purchase>(Purchase.class));
    }

    @Override
    public Purchase getPurchase(int id) {
        // Add code here
        return null;
    }

}
