package com.serverless.suppliers.business_logic;


import com.serverless.suppliers.model.Product;
import com.serverless.suppliers.request.CreateProductRequest;

import java.sql.SQLException;

public interface ProductService {
    Product createProduct(CreateProductRequest product) throws SQLException;
}
