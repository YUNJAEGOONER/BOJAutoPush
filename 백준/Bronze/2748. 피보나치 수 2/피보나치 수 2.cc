#include <iostream>
using namespace std;

//memoization
long long dp_result [100] = {0,};

long long fibbo_(int x){
    if(x == 0){
        return 0;
    }
    if(x == 1){
        return 1;
    }
    if(dp_result[x] != 0){
        return dp_result[x];
    }
    return dp_result[x] = fibbo_(x-1) + fibbo_(x-2);
}

int main(){
    int n;
    cin >> n;
    long long result = fibbo_(n);
    cout << result;
}