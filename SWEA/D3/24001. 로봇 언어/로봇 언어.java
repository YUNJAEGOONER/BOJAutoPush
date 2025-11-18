import java.io.*;

public class Solution {
	
	public static void main(String [] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int test = Integer.parseInt(br.readLine());
         
        for(int t = 0 ; t < test ; t ++ ) {
            String input = br.readLine();
             
            char [] arr = new char[input.length()];
             
            for(int i = 0 ; i < input.length() ; i ++ ) {
                arr[i] = input.charAt(i);
            }
            
            int max = 0;
            
            int onlyRight = 0;
            int onlyLeft = 0;
            
			for(int i = 0 ; i < input.length() ; i ++ ) {
				if(arr[i] == 'L') {
					onlyRight --;
					onlyLeft --;
				}
				else if(arr[i] == 'R') {
					onlyRight ++;
					onlyLeft ++;
				}
				else {
					onlyRight ++;
					onlyLeft --;
				}
				
				if(Math.abs(onlyLeft) > max) {
					max = Math.abs(onlyLeft);
				}
				else if(Math.abs(onlyRight) > max) {
					max = Math.abs(onlyRight);
				}
						
				
			}
			
			System.out.println(max);
			
       
            
            
            
        }
         
    }

}

