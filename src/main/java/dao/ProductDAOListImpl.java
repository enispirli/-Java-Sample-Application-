package dao;

import java.util.ArrayList;
import java.util.List;

import model.Product;

public class ProductDAOListImpl implements ProductDAO {

	public List<Product> producDB = new ArrayList<Product>();

	public void add(Product product) {
		if (producDB.isEmpty()) {
			product.setBarcodeNo(1);
		} else {
			product.setBarcodeNo(producDB.get(producDB.size() - 1).getBarcodeNo() + 1);
		}
		producDB.add(product);

	}

	public boolean delete(int barcodeNo) {
		for (Product product : producDB) {
			if (product.getBarcodeNo() == barcodeNo) {
				producDB.remove(product);
				return true;
			}
		}

		// for (int i = 0; i < producDB.size();i++) {
		// if(producDB.get(i).getBarcodeNo() == barcodeNo) {
		// producDB.remove(i);
		// }
		// }

		return false;
	}

	public boolean update(Product newProduct) {
		for (Product product : producDB) {
			if (product.getBarcodeNo() == newProduct.getBarcodeNo()) {
				product.setName(newProduct.getName());
				product.setCost(newProduct.getCost());
				return true;
			}
		}

		return false;
	}

	public Product findByBarcode(int barcodeNo) {
		for (Product product : producDB) {
			if (product.getBarcodeNo() == barcodeNo) {
				return product;
			}
		}

		return null;
	}

	public int getTotalCount() {

		return producDB.size();
	}

	public List<Product> getAll() {

		return producDB;
	}

}
