#include <string>
#include <vector>
#include <map>
#include <iostream>

using namespace std;

int solution(string s) {
    int answer = 0;
    
    map <string, char> convert;
    convert["zero"] = '0'; convert["one"] = '1'; convert["two"] = '2';
    convert["three"] = '3'; convert["four"] = '4'; convert["five"] = '5';
    convert["six"] = '6'; convert["seven"] = '7'; convert["eight"] = '8';
    convert["nine"] = '9';
    

    
    string temp = "";
    for(int i = 0 ; i < s.size() ; i ++ ){
        if('0'<= s[i] && s[i] <= '9'){
            temp += s[i];
        }
        else{
            string str = "";
            for(int j = i ; j < s.size() ; j ++ ){
                if('A' <= s[j] && s[j] <= 'Z'){
                    str += (s[j] + 32);
                }
                else{
                    str += s[j];
                }
                if(convert[str] != '\0'){
                    temp += convert[str];
                    break;
                }
            }
            i = i + (str.size() - 1);
        }
    }
    
    cout << temp;
    answer = stoi(temp);
    
    
    return answer;
}