#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

bool cmp(int a, int b){
    string as = to_string(a);
    string bs = to_string(b);
    return as + bs > bs + as;
}

string solution(vector<int> numbers) {
    string answer = "";
    
    sort(numbers.begin(), numbers.end(), cmp);
    for(auto a : numbers){
        //cout << a << ' ';
        answer += to_string(a);
    }
    if(answer[0] == '0'){
        answer = "0";
    }
    return answer;
}