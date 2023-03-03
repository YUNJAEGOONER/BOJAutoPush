#include <iostream>
using namespace std;

int main(){
    long long int N;
    cin >> N;

    long long int sum = 0;
    long long int i = 1;

    while(sum <= N){
        sum = sum + i;
        i ++ ;
    }

    cout << (i -2);
}