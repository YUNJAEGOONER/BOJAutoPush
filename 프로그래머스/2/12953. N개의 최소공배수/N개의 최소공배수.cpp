#include <string>
#include <vector>
#include <iostream>

using namespace std;

int gcd(int a, int b){
    if(a < b){
        int temp = a;
        a = b;
        b = temp;
    }
    if(b == 0) return a;
    else return gcd(b, a % b);

}

int solution(vector<int> arr) {
    int answer = arr[0];
    for(int i = 1 ; i < arr.size() ; i ++ ){
        answer = (answer * arr[i]) / gcd(answer, arr[i]);
    }

    return answer;
}