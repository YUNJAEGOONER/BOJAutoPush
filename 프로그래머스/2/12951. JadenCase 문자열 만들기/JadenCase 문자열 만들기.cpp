#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(string s) {
    vector<char> charvec;
    for(int i = 0 ; i < s.length() ; i ++ ){
        char letter = s[i];
        if (65 <= letter && letter <= 90){
            letter = letter + 32;
        }
        charvec.push_back(letter);
    }
    
    for(int i = 0; i < charvec.size() ; i ++ ){
        if(i == 0){
            if (97 <= charvec[i] && charvec[i] <= 122){
                charvec[i] = charvec[i] - 32;
            }
        }
        else if (charvec[i] == ' '){
            if (97 <= charvec[i + 1] && charvec[i + 1] <= 122){
                charvec[i + 1] = charvec[i + 1] - 32;
            }
        }
    }
    string answer(charvec.begin(), charvec.end());
    
    return answer;
}