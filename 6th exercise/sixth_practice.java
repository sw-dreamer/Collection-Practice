package collection_package;

import java.util.*;

class Location {
	private String cityName;
	private int longitude; // 경도
	private int latitude; // 위도

	public Location(String cityName, int latitude, int longitude) {
		this.cityName = cityName;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public void display() {
		System.out.println(cityName + " " + latitude + " " + longitude);
	}
}

public class sixth_practice {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		HashMap<String, Location> city = new HashMap<>();
		String answer = "null";
		String new_cityName = "null";
		int new_longitude = 0;
		int new_latitude = 0;
		String findCity = "null";

		while (city.size() < 4) {
			try {
				System.out.println("도시, 경도, 위도를 입력하세요 >");
				answer = scanner.nextLine();
				String split_answer[] = answer.split(",");
				new_cityName = split_answer[0];
				new_longitude = Integer.parseInt(split_answer[1]);
				new_latitude = Integer.parseInt(split_answer[2]);
				city.put(new_cityName, new Location(new_cityName, new_longitude, new_latitude));
			} catch (NumberFormatException e) {
				System.out.println("경도와 위도는 숫자여야 합니다.");
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("입력 형식이 잘못되었습니다. 다시 시도해주세요.");
			}

		}
		System.out.println("---------------------------------");
		while (true) {
			System.out.print("도시 이름 >> ");
			findCity = scanner.nextLine();
			if (findCity.equals("그만")) {
				break;
			} else {
				if (city.containsKey(findCity)) {
					city.get(findCity).display();
				} else {
					System.out.println(findCity + "는 없습니다.");
				}
			}
		}
		scanner.close();
	}

}
