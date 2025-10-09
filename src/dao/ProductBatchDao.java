package PosSystem.dao;

import PosSystem.model.ProductBatch;
import java.util.List;

public interface ProductBatchDao {
    
    public List<ProductBatch> getProductBatches();
    public boolean addPorductBatch(ProductBatch pb);
    public boolean updateProductBatch(ProductBatch pb);
    public boolean updateProductBatchQuantity(ProductBatch pb);
    
}
