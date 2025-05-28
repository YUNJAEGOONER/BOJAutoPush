import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int target = sc.nextInt();
        target -= 1;

        int [][] medals = new int [n][3];

        for(int i = 0 ; i < n ; i ++ ){
            int team = sc.nextInt();
            for(int j = 0 ; j < 3 ; j ++ ){
                int medal = sc.nextInt();
                medals[team - 1][j] = medal;
            }

        }

        int rank = 0;
        for(int i = 0 ; i < n ; i ++ ){
            if(i != target){
                if(medals[target][0] < medals[i][0]){
                    rank ++;
                }
                else if (medals[target][0] == medals[i][0] && medals[target][1] < medals[i][1]){
                    rank ++;
                }
                else if(medals[target][0] == medals[i][0] && medals[target][1] == medals[i][1]
                    && medals[target][2] < medals[i][2]){
                    rank ++;
                }
            }
        }

        System.out.println(rank + 1);
    }
}
