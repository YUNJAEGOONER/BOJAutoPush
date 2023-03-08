#include <iostream>
using namespace std;
int p_array[1000001] = {0,};
int p_result[1000001] = {0,};

int main(){

    int count = 0;
    int N, K;
    cin >> N >> K;

    for(int i = 2; i < K + 1; i ++){
        if(p_array[i] == 0){
            p_result[count++] = i;
            int k = 2;
            while((i * k) <= K){
                if(p_array[ i * k ] == 0){
                    p_array[ i * k ] = 1;
                }
                k ++;
            }
        }
    }

    for(int i = 0 ; i < count ; i ++ ){
        if( N <= p_result[i]){
            cout << p_result[i] << '\n';
        }
    }
}