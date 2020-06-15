package com.serverless.suppliers.business_logic;

import com.serverless.suppliers.data_layer.ProductAccess;
import com.serverless.suppliers.data_layer.ProductAccessImpl;
import com.serverless.suppliers.model.Product;
import com.serverless.suppliers.request.CreateProductRequest;

import java.sql.SQLException;

public class ProductServiceImpl implements ProductService {

    private final ProductAccess productAccess = new ProductAccessImpl();

    @Override
    public Product createProduct(CreateProductRequest product) throws SQLException {
        return new Product();
    }
}
