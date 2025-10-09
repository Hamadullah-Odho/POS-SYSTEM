package PosSystem.dao;

import PosSystem.model.Sale;
import java.util.List;

public interface SaleDao {
    
    public List<Sale> getSales();
    public boolean addSale(Sale s);
    public List<Sale> getDailySale(String currentDate);
    public Sale getSaleByUser(String user);
    
}
