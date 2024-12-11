package collection_package;

import java.util.*;

public class seventh_practice {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HashMap<String, Double> student = new HashMap<String, Double>();
		String studentinfo = "null";
		double score = 0.0;
		String studentname = "null";
		double criteria_score = 0.0;

		System.out.println("미래장학금관리시스템입니다. 이름과 학점(4.5만점)을 입력하세요.");

		while (student.size() < 5) {
			System.out.print("이름과 학점 >>  ");
			studentinfo = scanner.nextLine();

			String[] strArr = studentinfo.split(" ");
			studentname = strArr[0];
			try {
				score = Double.parseDouble(strArr[1]);
				if (score < 0 || score > 4.5) {
					System.out.println("점수를 잘못 입력하였습니다.");
				} else {
					student.put(studentname, score);
				}
			} catch (NumberFormatException e) {
				System.out.println("점수는 숫자여야 합니다.");
			}
		}
		/*
		 * // 학생 목록 출력 System.out.println("-------------------------"); for
		 * (Map.Entry<String, Double> entry : student.entrySet()) {
		 * System.out.println("학생 이름: " + entry.getKey() + ", 학점: " + entry.getValue());
		 * } System.out.println("-------------------------");
		 */
		// 점수로 정렬

		// student의 엔트리 세트를 studentList로 변환
		List<Map.Entry<String, Double>> studentList = new ArrayList<>(student.entrySet());

		// 2. 내림차순 정렬 (value 기준)
		studentList.sort((entry1, entry2) -> Double.compare(entry2.getValue(), entry1.getValue()));
		/*
		 * System.out.println("오름차순 정렬 (학점 기준):"); for (Map.Entry<String, Double> entry
		 * : studentList) { System.out.println(entry.getKey() + " : " +
		 * entry.getValue()); }
		 */
//      장학생 선발
		System.out.println("장학생 선발 학점 기준 입력 >> ");
		try {
			criteria_score = Double.parseDouble(scanner.next());
			if (criteria_score < 0 || criteria_score > 4.5) {
				System.out.println("잘못 입력하였습니다.");
			} else {
				// criteria_score 이상인 학생들을 출력
				System.out.print("장학생 명단 : ");
				for (Map.Entry<String, Double> entry : student.entrySet()) {
					if (entry.getValue() >= criteria_score) {
						System.out.print(entry.getKey() + " ");
					}
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("학점은 숫자여야 합니다.");
		}
		scanner.close();
	}
}
