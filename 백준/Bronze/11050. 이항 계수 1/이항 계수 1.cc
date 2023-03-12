#include <iostream>
using namespace std;

int main(){
    int N, K;
    cin >> N >> K;

    int result = 1;
    for(int i = 0; i < K; i ++ ){
        result = result * (N - i);
    }

    for(int j = 1 ; j < K + 1; j ++  ){
        result = result / j;
    }

    cout << result;
}