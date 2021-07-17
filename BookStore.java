package ch09;

public class BookStore {

	public static void main(String[] args) {
		
		VIPMember guest1 = new VIPMember(54000);
		guest1.guest();
		
		FamilyMember guest2 = new FamilyMember(13000);
		guest2.guest();
		
		VIPMember guest3 = new VIPMember(25000);
		guest3.guest();
		
		FamilyMember guest4 = new FamilyMember(62000);
		guest4.guest();
	}

}

abstract class BookMember {
	protected String level;
	protected int price;
	protected int discountedPrice;
	protected int point;
	
	public BookMember(int price) {
		this.price = price;
	}
	
	public void hello() {
		System.out.println("어서오십시오.");
	}
	
	public void goodBye() {
		System.out.println("감사합니다.\n");
	}
	
	public void showLevel() {
		System.out.println(level + " 등급 회원입니다.");
	}
	
	abstract void pay();
	
	final void guest() {
		hello();
		showLevel();
		pay();
		goodBye();
	}
}

class VIPMember extends BookMember {
	public VIPMember(int price) {
		super(price);
		
		level = "VIP";
		discountedPrice = price*5/100;
		point = price*5/100;
		
	}

	@Override
	void pay() {
		System.out.println((price-discountedPrice) + "원 결제되었습니다.");
		System.out.println(point + "포인트 적립되었습니다.");
	}
	
}

class FamilyMember extends BookMember {

	public FamilyMember(int price) {
		super(price);
		
		level = "family";
		point = price*2/100;
	}

	@Override
	void pay() {
		System.out.println(price + "원 결제되었습니다.");
		System.out.println(point + "포인트 적립되었습니다.");
	}
	
}
