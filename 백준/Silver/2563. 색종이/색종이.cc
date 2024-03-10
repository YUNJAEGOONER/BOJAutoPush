#include<iostream>
using namespace std;

int main(){
    int backgroud[100][100] ={0,};
    int n;
    int result = 0;
    cin >> n;
    while(n--){
        int x, y;
        cin >> x >> y;
        for(int i = x ; i < x + 10; i ++ ){
            for(int j = y ; j < y + 10 ;  j ++ ){
                if(backgroud[i][j] != 1){
                    result ++ ;
                    backgroud[i][j] = 1;
                };
            }
        }
    }
    cout << result;
    
}