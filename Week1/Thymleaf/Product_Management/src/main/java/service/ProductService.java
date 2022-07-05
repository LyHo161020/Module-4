package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService{
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "John", 2000000, "adasdsad","NVA"));
        products.put(2, new Product(2, "Kelvin", 3000000, "addáasdsad","NVB"));
        products.put(3, new Product(3, "Adam", 4000000, "ada212sdsad","NVC"));
        products.put(4, new Product(4, "Rose", 5000000, "ada3466sdsad","NVD"));
        products.put(5, new Product(5, "Juliet", 6000000, "ajgfjdasdsad","NVE"));
        products.put(6, new Product(6, "Jame", 7000000, "đâsdsdasd","NVF"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);

    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
