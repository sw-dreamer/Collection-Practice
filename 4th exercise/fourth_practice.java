package collection_package;
import java.util.*;
public class fourth_practice {

	public static void main(String[] args) {
		Vector<Integer> v= new Vector<Integer>();
		Scanner scanner = new Scanner(System.in);

		int average;
		int count=0;
		while(true) {
			System.out.print("강수량 입력 (0 입력시 종료) >>");
			int number = scanner.nextInt();
			if(number == 0) {
				v.add(number);
				break;
			}else {
				v.add(number);
				count++;
				int sum = 0;
				System.out.println(v);
				for(int i=0;i<v.size();i++) {
					sum=sum+v.elementAt(i);
				}
				System.out.println("현재 합은 "+sum+"입니다");
				average=sum/count;
				System.out.println("현재 평균은 "+average+"입니다");
			}
			
			
		}
		System.out.println(v);
		

		scanner.close();
	}

}
