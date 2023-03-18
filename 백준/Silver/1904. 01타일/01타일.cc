#include <iostream>
using namespace std;

long long result [1000001] = {0,};

long long tile(long long n){
    if(n == 1 or n == 2){
        return result[n];
    }
    else{
        if(result[n] != 0){
            return result[n];
        }
        else{
            return result[n] = (tile(n-1) % 15746 + tile(n-2) % 15746) % 15746;
        }
    }
}

int main(){
    result[1] = 1;
    result[2] = 2;
    int N;
    cin >> N;
    cout << tile(N) ;
}