package run;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.ProductDAO;
import dao.ProductDAOListImpl;
import model.Product;

public class Main {

	private static ProductDAO productDAO = new ProductDAOListImpl();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Lütfen yapmak istediğiniz işlemi seçin");
			System.out.println("1-Urun ekle\n2-urun sil\n3-urun guncelle\n4- urun bul\n5-toplam sayi\n6-listele");

			int selection = scanner.nextInt();
			if (selection == -1) {
				return;
			} else if (selection == 1) {
				addProduct(scanner);
			} else if (selection == 2) {
				deleteProduct(scanner);

			} else if (selection == 3) {
				updateProduct(scanner);

			} else if (selection == 4) {
				findProduct(scanner);

			} else if (selection == 5) {
				totalcountProduct();

			} else if (selection == 6) {

				listAll();
			}

		}
	}

	public static void addProduct(Scanner scanner) {
		Product product = new Product();
		System.out.println("Ürünün adı" + "nı girin\n");
		String name = scanner.next();
		System.out.println("Urunun fiyatını giriniz\n");
		int cost = Integer.parseInt(scanner.next());
		product.setCost(cost);
		product.setName(name);
		productDAO.add(product);
	}

	public static void listAll() {
		List<Product> all = productDAO.getAll();
		for (Product product : all) {
			System.out.println(product);
		}

	}

	public static void deleteProduct(Scanner scanner) {
		System.out.println("Sileceğiniz ürünün barcode nosunu girin\n");
		int barcodeNo = Integer.parseInt(scanner.next());
		productDAO.delete(barcodeNo);
		System.out.println("Ürün Silindi");

	}

	public static void updateProduct(Scanner scanner) {
		Product product = new Product();

		System.out.println("güncellemek istediğiniz verinin barcode nosunu giriniz ");
		int barcodeNo = Integer.parseInt(scanner.next());
		System.out.println("Ürünün adı" + "nı girin\n");
		String name = scanner.next();
		System.out.println("Urunun fiyatını giriniz\n");
		int cost = Integer.parseInt(scanner.next());
		product.setBarcodeNo(barcodeNo);
		product.setCost(cost);
		product.setName(name);
		productDAO.update(product);

	}

	public static void findProduct(Scanner scanner) {
		System.out.println("Bulmak istediğiniz verinin barcode nosunu giriniz ");
		int barcodeNo = Integer.parseInt(scanner.next());
		Product findByBarcode = productDAO.findByBarcode(barcodeNo);
		System.out.println("Aradıgınız ürün:" + findByBarcode);
	}

	public static void totalcountProduct() {
		int totalCount = productDAO.getTotalCount();
		System.out.println("Toplam kayıt sayısı:" + totalCount);

	}

}
