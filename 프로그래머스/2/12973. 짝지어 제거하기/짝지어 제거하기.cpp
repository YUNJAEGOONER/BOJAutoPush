#include <iostream>
#include <string>
#include <vector>
using namespace std;

int solution(string s)
{
    int answer = 0;
    
    vector<char> mystack;
    mystack.push_back(s[0]);
    
    for(int i = 1 ; i < s.size() ; i ++ ){
        if(*(mystack.end()-1) == s[i]){
            mystack.erase(mystack.end() - 1);
        }
        else{
            mystack.push_back(s[i]);
        }
    }
    
    if(mystack.empty()) answer = 1;

    return answer;
}