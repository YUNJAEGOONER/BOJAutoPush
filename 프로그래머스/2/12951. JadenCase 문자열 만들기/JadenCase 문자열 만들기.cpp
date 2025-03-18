#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    string answer = "";
    for(int i = 0 ; i < s.size() ; i ++ ){
        if('A' <= s[i] && s[i] <= 'Z'){
            s[i] = (s[i] + 32);
        }
    }
    
    for(int i = 0 ; i < s.size(); i ++ ){
        if(i == 0 && ('a' <= s[i] && s[i] <= 'z')){
            s[i] = (s[i] - 32);
        }
        else if(s[i - 1] == ' ' && ('a' <= s[i] && s[i] <= 'z')){
            s[i] = (s[i] - 32);
        }
    }
    
    return s;

}