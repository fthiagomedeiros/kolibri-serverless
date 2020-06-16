package com.serverless.suppliers.business_logic;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.serverless.routes.business_logic.RouteServiceImpl;
import com.serverless.suppliers.data_layer.ProductAccess;
import com.serverless.suppliers.data_layer.ProductAccessImpl;
import com.serverless.suppliers.model.Product;
import com.serverless.suppliers.request.CreateProductRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.UUID;

public class ProductServiceImpl implements ProductService {

    private static final Logger LOG = LogManager.getLogger(RouteServiceImpl.class);
    private final ObjectMapper mapper = new ObjectMapper();
    private final ProductAccess productAccess = new ProductAccessImpl();

    @Override
    public Product createProduct(CreateProductRequest product) throws SQLException {
        Product aNewProduct = mapper.convertValue(product, Product.class);
        aNewProduct.setUuid(UUID.randomUUID().toString());

        return productAccess.createProduct(aNewProduct);
    }
}
