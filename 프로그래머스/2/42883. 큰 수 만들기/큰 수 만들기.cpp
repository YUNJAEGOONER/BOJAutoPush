#include <string>
#include <vector>
#include <iostream>
#include <stack>

using namespace std;

string solution(string num, int K) {
    
    int N = num.size();

    string answer = "";

    stack<char> stk;
    stk.push(num[0]);

    int cnt = 0;
    for(int i = 1; i < num.size() ; i ++ ) {
        while(!stk.empty() && stk.top() < num[i] && cnt < K) {
            stk.pop();
            cnt ++;
        }
        stk.push(num[i]);
    }

    while(!stk.empty()) {
        answer += stk.top();
        stk.pop();
    }


    return string(answer.rbegin(), answer.rend()).substr(0, N - K);


    return answer;
}