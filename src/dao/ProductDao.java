package PosSystem.dao;

import PosSystem.model.Product;
import java.util.List;

public interface ProductDao {

    public List<Product> getProducts();
    public boolean addProduct();
    public Product searchProductByBarcode(int barcode);
    public Product searchProductByName(String name);
    public boolean updateProductByBarcode(Product p);
    
}
