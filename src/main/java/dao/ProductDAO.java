package dao;
import java.util.List;

import model.Product;;

public interface ProductDAO {

	public void add(Product product);
	public boolean  delete(int barcodeNo );
	public boolean update(Product product);
	public Product findByBarcode (int bacodeNo);
	public int getTotalCount();
	public List<Product> getAll();
}
