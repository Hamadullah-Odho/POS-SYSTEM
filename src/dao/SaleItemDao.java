package PosSystem.dao;

import PosSystem.model.SaleItem;
import java.util.List;

public interface SaleItemDao {
    
    public List<SaleItem> getSaleItems();
    public boolean AddSaleItem(SaleItem si);
    public boolean getDailySaleItemReport(String currentDate);
    public boolean searchSaleItemByProduct(int ProductId);
    
}
