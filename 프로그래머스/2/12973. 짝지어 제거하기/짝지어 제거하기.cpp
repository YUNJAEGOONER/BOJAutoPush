#include <iostream>
#include<string>
#include <stack>
using namespace std;

int solution(string s)
{
    int answer = 0;
    
    stack<char> mstack;
    mstack.push(s[0]);

    for(int i = 1 ; i < s.size() ; i ++ ){
        if(!mstack.empty()){
            if(mstack.top() == s[i]){
                mstack.pop();
            }
            else{
                mstack.push(s[i]);
            }
        }
        else{
            mstack.push(s[i]);
        }
    }
    
    if(!mstack.size()) answer = 1;
    return answer;
}