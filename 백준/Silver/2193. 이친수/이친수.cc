#include <iostream>
using namespace std;

long long result_array[90] = {0,};

int main(){
    result_array[1] = 1;
    result_array[2] = 1;

    int N;
    cin >> N;

    for(int i = 3 ; i < N + 1; i ++ ){
        result_array[i] = result_array[i - 1] + result_array[i -2];
    }

    cout << result_array[N];
}