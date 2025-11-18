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
            
            int [][] mmap = new int [input.length() + 1][2];
            
            mmap[0][0] = 0;
            mmap[0][1] = 0;
            
			for(int i = 1 ; i < input.length() + 1 ; i ++ ) {
				if(arr[i - 1] == 'L') {
					mmap[i][0] = mmap[i - 1][0] - 1;
					mmap[i][1] = mmap[i - 1][1] - 1;
				}
				else if(arr[i - 1] == 'R') {
					mmap[i][0] = mmap[i - 1][0] + 1;
					mmap[i][1] = mmap[i - 1][1] + 1;
				}
				else {
					if(mmap[i - 1][0] < mmap[i - 1][1]) {
						mmap[i][0] = mmap[i - 1][0] - 1;
						mmap[i][1] = mmap[i - 1][1] + 1;
					}
					else {
						mmap[i][0] = mmap[i - 1][1] - 1;
						mmap[i][1] = mmap[i - 1][0] + 1;
					}
				}
				
				if(max < Math.abs(mmap[i][0])) {
					max = Math.abs(mmap[i][0]);
				}
				if(max < Math.abs(mmap[i][1])) {
					max = Math.abs(mmap[i][1]);
				}
			}
			
			System.out.println(max);
			
       
            
            
            
        }
         
    }

}
