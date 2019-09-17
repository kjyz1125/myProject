import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Generator {
	
	public static void main(String[] args) {
		
		Number number = new Number();
		
		System.out.println("줄 단위 입력");
		Scanner sc = new Scanner(System.in);
		
		int count = sc.nextInt();
		
		sc.close();
		
		ArrayList<int[]> getNumber = number.generate(count);
		
		for(int i=0;i<count;i++){
			
			for(int j=0;j<6;j++){
				
				int[] tempNumber = new int[6];

				tempNumber =  getNumber.get(i);
				
				Arrays.sort(tempNumber);
				
				if(j==0){
					System.out.print(tempNumber[j]);
				}else{
					System.out.print(" "+tempNumber[j]);
				}
				
			}
			
			System.out.println("");
		}	
	}
}

class Number{
	
	public ArrayList<int[]> generate(int count){
		
		ArrayList<int[]> generatedArray = new ArrayList<>();
		
		for(int i=0;i<count;i++){
			int tempNumber = 0;
			
			int[] randomNumber = new int[6];
			
			for(int j=0;j<6;j++){
				
				if(j==0){
					tempNumber = (int)(Math.random() * 45 + 1);
					randomNumber[j]=tempNumber;
				}else{
				
					tempNumber = (int)(Math.random() * 45 + 1);

					boolean isCheck = false;
					
					for(int k=0;k<randomNumber.length;k++){
						if(isCheck == false){
							if(randomNumber[k] == tempNumber){
								isCheck = true;
							}
						}
					}						
					if(isCheck == false){
						randomNumber[j] = tempNumber;
					}else{
						j--;
					}
				}
			}
			generatedArray.add(randomNumber);
		}
		return generatedArray;
	}	
	
}