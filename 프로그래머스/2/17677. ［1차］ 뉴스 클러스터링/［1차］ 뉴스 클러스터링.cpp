#include <string>
#include <iostream>
#include <map>
#include <set>

using namespace std;

bool isAlphabet(char c){
    bool result = false;
    if('A' <= c && c <= 'Z'){
        result = true;
    }
    return result;
}

int solution(string str1, string str2) {
    int answer = 0;
    float result = 1.f;
    
    //convert to CAPITAL
    for(int i = 0 ; i < str1.size() ; i ++ ){
        if('a' <= str1[i] && str1[i] <= 'z'){
            str1[i] = str1[i] - 32;
        }
    }
    
    for(int i = 0 ; i < str2.size() ; i ++ ){
        if('a' <= str2[i] && str2[i] <= 'z'){
            str2[i] = str2[i] - 32;
        }
    }

    set<string> keys;

    map<string, int> m1;
    map<string, int> m2;
    
    for(int i = 0 ; i < str1.size() - 1 ; i ++ ){    
        if(isAlphabet(str1[i]) && isAlphabet(str1[i + 1])){
            string temp = "";
            temp = temp + str1[i];
            temp = temp + str1[i + 1];
            m1[temp]++;
            keys.insert(temp);
        }
    }

    for(int i = 0 ; i < str2.size() - 1 ; i ++ ){    
        if(isAlphabet(str2[i]) && isAlphabet(str2[i + 1])){
            string temp = "";
            temp = temp + str2[i];
            temp = temp + str2[i + 1];
            m2[temp]++;
            keys.insert(temp);
        }
    }
    
    float inter = 0;
    float uni = 0;
    
    //intersect
    for(auto e : keys){
        if(m1[e] != 0 && m2[e] != 0){
            if(m1[e] > m2[e]){
                inter = inter + m2[e];
            }
            else{
                inter = inter + m1[e];
            }
        }
    }
    
    //union
    for(auto e : keys){
        if(m1[e] > m2[e]){
            uni = uni + m1[e];
        }
        else{
            uni = uni + m2[e];
        }
    }
      
    if(uni != 0){
        result = inter / uni;
    }
    
    answer = result * 65536;
    return answer;
}