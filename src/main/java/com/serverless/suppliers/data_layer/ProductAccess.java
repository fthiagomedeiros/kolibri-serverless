package com.serverless.suppliers.data_layer;

import com.serverless.suppliers.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductAccess {
    Product createProduct(Product product) throws SQLException;
    List<Product> getProducts(String supplier) throws SQLException;
}
