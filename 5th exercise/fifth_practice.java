package collection_package;

import java.util.*;

class StudentInfo {
	private String student_name;
	private String department_information;
	private int student_number;
	private double student_score;

	public StudentInfo(String student_name, String department_information, int student_number, double student_score) {
		this.student_name = student_name;
		this.department_information = department_information;
		this.student_number = student_number;
		this.student_score = student_score;
	}

	public void printStudentInfo() {
		System.out.println("이름: " + student_name + ", 학과: " + department_information + ", 학번: " + getStudent_number()
				+ ", 학점 평균: " + getStudent_score());
	}

	public int getStudent_number() {
		return student_number;
	}

	public double getStudent_score() {
		return student_score;
	}

}

public class fifth_practice {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		ArrayList<StudentInfo> insert_student = new ArrayList<>();
		int number = 0;
		while (true) {
			System.out.print("입력 받고 싶은 인원의 수는 몇명인가요? ");
			try {
				number = scanner.nextInt();
				scanner.nextLine();

				for (int i = 0; i < number; i++) {
					boolean isduplicated = false;
					System.out.println("학생 " + (i + 1) + "의 정보를 입력하세요:");

					System.out.print("이름: ");
					String student_name = scanner.nextLine();

					System.out.print("학과: ");
					String department_information = scanner.nextLine();

					int student_number = 0;
					while (true) {
						System.out.print("학번: ");
						try {
							student_number = Integer.parseInt(scanner.next());
							isduplicated = false;
							for (StudentInfo student : insert_student) {
								if (student.getStudent_number() == student_number) {
									isduplicated = true;
									System.out.println("이미 존재하는 학번입니다. 다른 학번을 입력해주세요.");
									break;
								}
							}
							if (isduplicated == false) {
								break;
							}
						} catch (NumberFormatException e) {
							System.out.println("숫자로 입력하세요");
						}

					}
					scanner.nextLine();

					double student_score = 0;
					while (true) {
						System.out.print("학점 평균: ");
						try {
							student_score = Double.parseDouble(scanner.next());
							if (student_score < 0 || student_score > 4.5) {
								System.out.println("점수를 잘못 입력하였습니다. 다시 입력하세요.");
							} else {
								break;
							}
						}

						catch (NumberFormatException e) {
							System.out.println("숫자를 입력하세요");
							scanner.nextLine();
						}
					}

					scanner.nextLine();

					insert_student
							.add(new StudentInfo(student_name, department_information, student_number, student_score));

				}
				break;
			} catch (InputMismatchException e) {
				System.out.println("숫자를 입력하세요");
				scanner.next();
			}

		}

		System.out.println("입력된 학생 정보:");
		for (StudentInfo student : insert_student) {
			student.printStudentInfo();
		}

		double sum = 0.0;
		double result = 0.0;
		for (StudentInfo student : insert_student) {
			sum += student.getStudent_score();
		}
		result = sum / number;
		System.out.println("입력된 학생들의 학점 합은 " + sum + "이고 입력된 학생들의 학접 평균은 " + result + "입니다");

		scanner.close();
	}
}
