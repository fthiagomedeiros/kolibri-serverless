package com.serverless.suppliers.data_layer;

import com.serverless.routes.services.DataStorage;
import com.serverless.routes.services.MemoryStorage;
import com.serverless.suppliers.model.Product;

import java.sql.SQLException;

public class ProductAccessImpl implements ProductAccess {

    private final DataStorage dataStorage = new MemoryStorage();

    @Override
    public Product createProduct(Product product) throws SQLException {
        return null;
    }
}
