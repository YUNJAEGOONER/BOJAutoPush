#include <iostream>
#include <vector>
using namespace std;

int main(){
    int m, n;
    cin >> n >> m;

    vector<vector<int>> square;

    for(int i = 0 ; i < n ; i ++ ){
        vector<int> row;
        string input;
        cin >> input;
        for(int j = 0 ; j < m ; j ++ ){
            row.push_back(input[j]-48);
        }
        square.push_back(row);
    }

    int result = 1;
    for(int i = 0 ; i < n ; i ++ ){
        for(int j = 0; j < m ; j ++ ){
            int current_value = square[i][j];
            int current_i = i;
            int current_j = j;
            int a = 0;
            for(int k = current_j + 1 ; k < m ; k ++ ){
                if(current_value == square[current_i][k]){
                    a = k - current_j + 1;
                }
                //동일 row에 같은 수가 있는 경우
                if(a != 0){
                    int interval = a - 1;
                    if(current_i + interval < n){
                        //interval 만큼 더한 row에서 양 숫자가 같고, 그 숫자가 current value랑 같다면
                        if((square[current_i + interval][current_j] == square[current_i + interval][current_j + interval])
                           && square[current_i + interval][current_j] == current_value){
                            if(result < a * a){
                                result = a * a;
                            }
                        }
                    }
                }
            }



        }
    }
    cout << result;
}