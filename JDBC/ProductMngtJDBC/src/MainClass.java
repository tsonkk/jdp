import java.util.List;
import java.util.Scanner;

import daos.CategoryDAO;
import daos.ProductDAO;
import entities.Category;
import entities.Product;

public class MainClass {

	public static void main(String[] args) throws Exception {
		// menu
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("---------------------");
			System.out.println("0. Exit");
			System.out.println("1. Get all categories");
			System.out.println("2. Get details a category");
			System.out.println("3. Search categories");
			System.out.println("4. Add new a category");
			System.out.println("5. Update a category");
			System.out.println("6. Delete a category");
			System.out.println("7. Get all products");
			System.out.println("8. Get details a product");
			System.out.println("9. Search products");
			System.out.println("10. Add new a product");
			System.out.println("11. Update a product");
			System.out.println("12. Delete a product");
			System.out.print("Enter cmd: ");
			int cmd = Integer.valueOf(scanner.nextLine());
			if (cmd == 0) {
				break;
			} else if (cmd == 1) {
				List<Category> cats = CategoryDAO.getAll();
				for (Category cat : cats) {
					System.out.println(cat.id + " | " + cat.name);
				}
			} else if (cmd == 2) {
				System.out.print("Enter id: ");
				int id = Integer.valueOf(scanner.nextLine());
				Category cat = CategoryDAO.getDetails(id);
				if (cat != null) {
					System.out.println(cat.id + " | " + cat.name);
					List<Product> prods = ProductDAO.getByCatID(cat.id);
					for (Product prod : prods) {
						System.out.println("\t" + prod.id + " | " + prod.name + " | " + prod.price);
					}
				}
			} else if (cmd == 3) {
				System.out.print("Enter keyword: ");
				String keyword = scanner.nextLine();
				List<Category> cats = CategoryDAO.search(keyword);
				for (Category cat : cats) {
					System.out.println(cat.id + " | " + cat.name);
				}
			} else if (cmd == 4) {
				System.out.print("Enter name: ");
				String name = scanner.nextLine();
				Category newCat = new Category(0, name);
				/*
				 * boolean result = CategoryDAO.insert(newCat); if (result) {
				 * System.out.println("OK BABY!"); } else { System.out.println("SORRY BABY!"); }
				 */
				int newID = CategoryDAO.insert2newID(newCat);
				if (newID > 0) {
					System.out.println("OK BABY! newID = " + newID);
				} else {
					System.out.println("SORRY BABY!");
				}
			} else if (cmd == 5) {
				System.out.print("Enter id: ");
				int id = Integer.valueOf(scanner.nextLine());
				System.out.print("Enter name: ");
				String name = scanner.nextLine();
				Category newCat = new Category(id, name);
				boolean result = CategoryDAO.update(newCat);
				if (result) {
					System.out.println("OK BABY!");
				} else {
					System.out.println("SORRY BABY!");
				}
			} else if (cmd == 6) {
				System.out.print("Enter id: ");
				int id = Integer.valueOf(scanner.nextLine());
				boolean result = CategoryDAO.delete(id);
				if (result) {
					System.out.println("OK BABY!");
				} else {
					System.out.println("SORRY BABY!");
				}
			} else if (cmd == 7) {
				List<Product> prods = ProductDAO.getAll();
				for (Product prod : prods) {
					System.out.println(prod.id + " | " + prod.name + " | " + prod.price + " | " + prod.catID);
				}
			} else if (cmd == 8) {
				System.out.print("Enter id: ");
				int id = Integer.valueOf(scanner.nextLine());
				Product prod = ProductDAO.getDetails(id);
				if (prod != null) {
					Category cat = CategoryDAO.getDetails(prod.catID);
					System.out.println(prod.id + " | " + prod.name + " | " + prod.price + " | " + prod.catID + " : " + cat.name);
				}
			} else if (cmd == 9) {
				System.out.print("Enter keyword: ");
				String keyword = scanner.nextLine();
				List<Product> prods = ProductDAO.search(keyword);
				for (Product prod : prods) {
					System.out.println(prod.id + " | " + prod.name + " | " + prod.price + " | " + prod.catID);
				}
			} else if (cmd == 10) {
				System.out.print("Enter name: ");
				String name = scanner.nextLine();
				System.out.print("Enter price: ");
				int price = Integer.valueOf(scanner.nextLine());
				System.out.print("Enter catID: ");
				int catID = Integer.valueOf(scanner.nextLine());
				Product newProd = new Product(0, name, price, catID);
				boolean result = ProductDAO.insert(newProd);
				if (result) {
					System.out.println("OK BABY!");
				} else {
					System.out.println("SORRY BABY!");
				}
			} else if (cmd == 11) {
				System.out.print("Enter id: ");
				int id = Integer.valueOf(scanner.nextLine());
				System.out.print("Enter name: ");
				String name = scanner.nextLine();
				System.out.print("Enter price: ");
				int price = Integer.valueOf(scanner.nextLine());
				System.out.print("Enter catID: ");
				int catID = Integer.valueOf(scanner.nextLine());
				Product newProd = new Product(id, name, price, catID);
				boolean result = ProductDAO.update(newProd);
				if (result) {
					System.out.println("OK BABY!");
				} else {
					System.out.println("SORRY BABY!");
				}
			} else if (cmd == 12) {
				System.out.print("Enter id: ");
				int id = Integer.valueOf(scanner.nextLine());
				boolean result = ProductDAO.delete(id);
				if (result) {
					System.out.println("OK BABY!");
				} else {
					System.out.println("SORRY BABY!");
				}
			}
		}
		scanner.close();
		System.out.println("END PROGRAM");
	}

}