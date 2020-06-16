package com.serverless.suppliers.data_layer;

import com.serverless.database.DataStorage;
import com.serverless.database.RdsStorage;
import com.serverless.suppliers.model.Product;

import java.sql.SQLException;

public class ProductAccessImpl implements ProductAccess {

    private final DataStorage dataStorage = new RdsStorage();

    @Override
    public Product createProduct(Product product) throws SQLException {
        return dataStorage.save(product);
    }
}
