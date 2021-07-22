import java.util.*;
public class EMS {

	public static void main(String[] args) {
		ProductList refrigerator = new ProductList("refrigerator");
		
		refrigerator.addProduct();
		refrigerator.addProduct();
		refrigerator.addProduct();
		
		refrigerator.showList();
		
	}

}

class Product {
	private String name;
	private String exDate;
	
	public Product(String name) {
		this.name = name;
	}
	
	public void inputDate(int y, int m, int d) {
		exDate = String.format("%d%02d%02d", y, m, d);
	}
	
	public void showProduct() {
		System.out.println(name + " " + exDate);
	}
}

class ProductList {
	Scanner scanner = new Scanner(System.in);
	
	private ArrayList<Product> productList = new ArrayList<Product>();
	private String listName;
	
	public ProductList(String name) {
		listName = name;
	}
	
	public void addProduct() {
		Product prod;
		
		System.out.print("제품명 : ");
		String name = scanner.next();
		System.out.print("유통기한 yyyy : ");
		int year = scanner.nextInt();
		System.out.print("유통기한 MM : ");
		int month = scanner.nextInt();
		System.out.print("유통기한 dd : ");
		int day = scanner.nextInt();
		
		prod = new Product(name);
		
		prod.inputDate(year, month, day);
		
		productList.add(prod);
	}
	
	public void showList() {
		for (int i = 0; i < productList.size(); i++) {
			productList.get(i).showProduct();
		}
	}
}