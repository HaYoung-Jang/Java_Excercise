import java.util.*;
public class GradeCalc {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("학점 계산기 - 성적 입력 : A+ 4.5, A0 4.0 ... 숫자로 입력");
		
		System.out.print("총 학기 수 : ");
		int semNum = scanner.nextInt();
		
		Semester[] semArr = new Semester[semNum];
		String semName;
		int subNum;
		
		for (int i = 0; i < semArr.length; i++) {
			System.out.print("학기 이름 : ");
			semName = scanner.next();
			System.out.print("과목 수 : ");
			subNum = scanner.nextInt();
			
			semArr[i] = new Semester(semName, subNum);
			
			semArr[i].inputGradeAll();
			
			System.out.println(semName + " 총 평점 : " + semArr[i].gradePointAverage() + " 이수 학점 : " + semArr[i].totUnit() + "\n");
		}
		
		System.out.println("");
		Semester.gpaAllSem = Semester.gradeUnitAllSem / (double) Semester.unitAllSem;
		System.out.println("전체 학기 총 평점 : " + Semester.gpaAllSem + " 이수 학점 : " + Semester.unitAllSem);
		
		scanner.close();
	}

}

class Subject {
	private String subName;
	private int unit;
	private double grade;
	
	public Subject(String name) {
		subName = name;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}
}

class Semester {
	Scanner scanner = new Scanner(System.in);
	
	private String semName;
	private int subNum;
	private double gpa;
	private int totUnit;
	
	static int unitAllSem = 0;
	static double gpaAllSem = 0.0;
	static double gradeUnitAllSem = 0.0;
	
	private ArrayList<Subject> subList = new ArrayList<Subject>();
	
	public Semester(String name, int num) {
		semName = name;
		subNum = num;
	}
	
	public void inputGrade() {
		Subject sub;
		
		System.out.print("과목 이름 : ");
		String name = scanner.next();
		
		System.out.print("이수 학점 : ");
		int unit = scanner.nextInt();
		
		System.out.print("과목 성적 : ");
		double grade = scanner.nextDouble();
		
		sub = new Subject(name);
		sub.setUnit(unit);
		sub.setGrade(grade);
		
		subList.add(sub);
	}
	
	public void inputGradeAll() {
		for (int i = 0; i < subNum; i++) {
			inputGrade();
		}
	}
	
	public int totUnit() {
		totUnit = 0;
		for (int i = 0; i < subNum; i++) {
			totUnit += subList.get(i).getUnit();
		}
		
		return totUnit;
	}
	
	public double gradePointAverage() {
		double gradeUnitSum = 0;
		
		for (int i = 0; i < subNum; i++) {
			gradeUnitSum += subList.get(i).getGrade() * (double) subList.get(i).getUnit();
		}
		
		gpa = gradeUnitSum / (double) totUnit();
		
		gradeUnitAllSem += gradeUnitSum;
		unitAllSem += totUnit();
		
		return gpa;
	}
}
