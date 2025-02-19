#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <map>

using namespace std;

bool cmp(string s1, string s2){
    return s1 < s2;
}

bool solution(vector<string> phone_book) {
    bool answer = true;
    sort(phone_book.begin(), phone_book.end(), cmp);
    
    
    for(int i = 1; i < phone_book.size() ; i ++ ){
        string pre = phone_book[i-1];
        if(phone_book[i].size() >= pre.size()){
            if(phone_book[i].substr(0, pre.size()) == pre){
                return false;
            }
        }
    }
    
    return answer;
}