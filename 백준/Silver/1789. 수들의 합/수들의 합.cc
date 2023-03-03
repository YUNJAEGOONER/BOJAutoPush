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

//    int result = 0;
//    for(int j = 1 ; j < (i-1) ; j ++ ){
//        cout << j << " ";
//        result = result + j;
//    }
//    cout << '\n';
//    cout << result;
}