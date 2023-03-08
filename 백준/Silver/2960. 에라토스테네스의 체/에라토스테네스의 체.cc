#include <iostream>
using namespace std;

int main(){
    int array [1001] = {0,};
    int result[1001] = {0,};
    int count = 0;
    int N, K;
    cin >> N >> K;

    for(int i = 2; i < N + 1; i ++){
        if(array[i] == 0){
            result[++count] = i;
            int k = 2;
            while((i * k) <= N){
                if(array[ i * k ] == 0){
                    array[ i * k ] = 1;
                    result[++count] = i * k;
                }
                k ++;
            }
        }
    }

    cout << result[K];
}