#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(string s, string skip, int index) {
    string answer = "";
    
    vector<int> skipvec;
    for(int i = 0 ; i <  skip.length();  i ++ ){
        skipvec.push_back(skip[i] - 'a');
    }
    
    vector<char> result;
    
    for(int i = 0 ; i < s.length() ; i ++ ){
        int count = 0;
        
        int current = s[i] - 'a';
        for(int j = 1 ; j < index + 1 ; j ++){
            current = (current + 1) % 26;
            for(int k = 0 ; k < skip.length() ; k ++ ){
                if(skipvec[k] ==  current) j --;
            }
        }     
        result.push_back((char)('a' + current));
    }    
    answer = string(result.begin(), result.end());
    return answer;
}