package collection_package;
import java.util.Vector;
import java.util.Scanner;
public class first_practice {

	public static void main(String[] args) {
		Vector<Integer> v= new Vector<Integer>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("정수(-1이 입력될 때까지)");
		int max = -1;
		
		while(true) {
			int number = scanner.nextInt();
			
			if(number < -1) {
				System.out.println("잘못된 값을 입력하였습니다.");
				
			}
			else if (number == -1){
				for(int i=0;i<v.size();i++) {
					if(max<v.elementAt(i)) {
						max=v.elementAt(i);
					}
				}
				break;
			}
			else {
				v.add(number);
			}
			
		}
		System.out.println(v);
		System.out.println("최대값은 "+ max+"입니다");
		scanner.close();
	}

}
