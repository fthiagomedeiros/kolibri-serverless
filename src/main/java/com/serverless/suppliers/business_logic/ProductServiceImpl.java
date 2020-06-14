package com.serverless.suppliers.business_logic;

import com.serverless.suppliers.model.Product;
import com.serverless.suppliers.request.CreateProductRequest;

import java.sql.SQLException;

public class ProductServiceImpl implements ProductService {

    @Override
    public Product createProduct(CreateProductRequest product) throws SQLException {
        return new Product();
    }
}
