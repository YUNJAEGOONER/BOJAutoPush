#include <string>
#include <vector>
#include <iostream>

using namespace std;


int solution(string s) {
    int answer = 0;
    for(int i = 0 ; i < s.size() ; i ++ ){
        char target = s[i];
        int cur = 1;
        int others = 0; 
        while(cur != others){
            if(s[++i] == target) cur++;
            else others++;
        }
        answer ++;
    }
    return answer;
}