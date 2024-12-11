package collection_package;

import java.util.*;

public class eigth_practice {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HashMap<String, Integer> point = new HashMap<String, Integer>();
		String answer = "null";
		String name = "null";
		int score = 0;
		System.out.println("포인트 관리 프로그램입니다");
		while (true) {
			System.out.println("이름과 포인트 입력 >> ");
			answer = scanner.nextLine();
			if (answer.equals("그만")) {
				break;
			}
			String[] strArr = answer.split(" ");
			name = strArr[0];
			try {
				score = Integer.parseInt(strArr[1]);

				if (point.containsKey(name)) {
					score += point.get(name);
				}
				point.put(name, score);
				for (Map.Entry<String, Integer> entry : point.entrySet()) {
					System.out.print("(" + entry.getKey() + "," + entry.getValue() + ")");
				}
				System.out.println();

			} catch (NumberFormatException e) {
				System.out.println("포인트는 숫자여야 합니다.");
			}

		}

		scanner.close();
	}

}
