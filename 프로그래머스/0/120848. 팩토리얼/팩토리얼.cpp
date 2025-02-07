#include <string>
#include <vector>
#include <iostream>

using namespace std;

int factorial(int n){
    if(n == 1 || n == 0) return 1;
    else return n * factorial(n - 1);
}

int solution(int n) {
    int answer = 0;
    while(factorial(answer) <= n){
       answer ++; 
    }
    return answer - 1;
}