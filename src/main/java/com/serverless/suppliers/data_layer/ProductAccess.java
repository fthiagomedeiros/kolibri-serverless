package com.serverless.suppliers.data_layer;

import com.serverless.suppliers.model.Product;

import java.sql.SQLException;

public interface ProductAccess {
    Product createProduct(Product product) throws SQLException;
}
