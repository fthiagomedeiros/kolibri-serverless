package com.serverless.suppliers.business_logic;


import com.serverless.suppliers.model.Product;
import com.serverless.suppliers.request.CreateProductRequest;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    Product createProduct(CreateProductRequest product) throws SQLException;
    List<Product> getProducts(String supplier) throws SQLException;
}
