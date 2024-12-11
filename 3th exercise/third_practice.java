package collection_package;

import java.util.*;

public class third_practice {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HashMap<String, Integer> count = new HashMap<String, Integer>();

		String contry_population_answer = "null";
		String country = "null";
		int population = 0;
		String country_population_search = "null";

		System.out.println("나라 이름과 인구를 입력하세요.(예: Korea 5000)");

		while (true) {
			System.out.print("나라 이름, 인구 >> ");
			contry_population_answer = scanner.nextLine();

			// "그만"을 입력한 경우 처리
			if (contry_population_answer.equals("그만")) {
				while (true) {
					System.out.print("인구 검색 >> ");
					country_population_search = scanner.nextLine();
					if (country_population_search.equals("그만")) {
						break;
					} else {
						if (count.containsKey(country_population_search)) {
							System.out.println(
									country_population_search + " 인구는 " + count.get(country_population_search));
						} else {
							System.out.println(country_population_search + " 나라는 없습니다.");
						}
					}
				}
				break;
			}

			// "그만"이 아니면 입력을 공백으로 나누어 나라 이름과 인구를 구분
			String[] strArr = contry_population_answer.split(" ");
			country = strArr[0];
			try {
				population = Integer.parseInt(strArr[1]);
				count.put(country, population);
			} catch (NumberFormatException e) {
				System.out.println("인구는 숫자여야 합니다.");
			}

		}

		scanner.close();
	}
}
