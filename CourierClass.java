package ch08;
import java.util.*;
public class CourierClass {

	public static void main(String[] args) {
		
		Courier cour1 = new Courier(3000);
		cour1.getSenderInfo();
		cour1.getRecipientInfo();
		cour1.showCourierInfo();
		
		CourierHalf cour2 = new CourierHalf(200);
		cour2.getSenderInfo();
		cour2.getRecipientInfo();
		cour2.showCourierInfo();
		
		CourierHalf cour3 = new CourierHalf(1200);
		cour3.getSenderInfo();
		cour3.getRecipientInfo();
		cour3.showCourierInfo();
		
		Courier cour4 = new Courier(6400);
		cour4.getSenderInfo();
		cour4.getRecipientInfo();
		cour4.showCourierInfo();

	}

}

class Courier {
	Scanner scanner = new Scanner(System.in);
	
	protected String senderName;
	protected String senderAddress;
	protected String recipientName;
	protected String recipientAddress;
	protected int weight;
	protected int charge;
	
	protected int chargeBase = 4000;
	
	public Courier(int w) {
		weight = w;
	}
	
	public void getSenderInfo() {
		System.out.print("보내는 사람 이름 : ");
		senderName = scanner.next();
		
		System.out.print("보내는 사람 주소 : ");
		senderAddress = scanner.next();
	}
	
	public void getRecipientInfo() {
		System.out.print("받는 사람 이름 : ");
		recipientName = scanner.next();
		
		System.out.print("받는 사람 주소 : ");
		recipientAddress = scanner.next();
	}
	
	public int calcCharge() {
		if (weight <= 2000) {
			charge = chargeBase;
		}
		else {
			charge = chargeBase + (weight - 2000) * 500 / 1000;
		}
		
		return charge;
	}
	
	public void showCourierInfo() {
		System.out.println(senderName + " 님의 택배가 접수 되었습니다. 요금은 " + this.calcCharge() + "원 입니다.");
	}
}

class CourierHalf extends Courier {
	
	public CourierHalf(int w) {
		super(w);
		chargeBase = 1600;
	}
	
	public int calcCharge() {
		if (weight <= 500) {
			charge = chargeBase;
		}
		else {
			charge = chargeBase + (weight - 500) * 200 / 1000;
		}
		
		return charge;
	}
	
	public void showCourierInfo() {
		System.out.println(senderName + " 님의 반값 택배가 접수 되었습니다. 요금은 " + this.calcCharge() + "원 입니다.");
	}
}
