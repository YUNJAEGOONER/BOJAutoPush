#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(string my_string) {
    int answer = 0;
    
    for(int i = 0 ; i < my_string.length() ; i ++ ){
        string temp = "";
        if('0' <= my_string[i] && my_string[i] <= '9'){
            while('0' <= my_string[i] && my_string[i] <= '9'){
                temp = temp + my_string[i++];
            }
            i = i - 1;
            answer = answer + stoi(temp);
        }    
    }
    return answer;
}