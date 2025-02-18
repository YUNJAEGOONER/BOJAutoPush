#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(string new_id) {
    string answer = "";
    //new_id = "...!@BaT#*..y.abcdefghijklm...";
    vector<char> temp;
    
    //1단계, 2단계
    for(int i = 0 ; i < new_id.size(); i ++ ){
        if('A' <= new_id[i] && new_id[i] <= 'Z'){
            temp.push_back(new_id[i] + 32);
        }
        else if('0' <= new_id[i] && new_id[i] <= '9'){
             temp.push_back(new_id[i]);
        }
        else if('a' <= new_id[i] && new_id[i] <= 'z'){
             temp.push_back(new_id[i]);
        }
        else if(new_id[i] == '-' || new_id[i] == '_' || new_id[i] == '.'){
            temp.push_back(new_id[i]);
        }
    }
    
    vector<char> vec34;
    //3단계
    for(int i = 0 ; i < temp.size(); i ++ ){
        vec34.push_back(temp[i]);
        if(temp[i] == '.'){
            while(temp[i] == '.'){
                i = i + 1;
                if(i >= temp.size()){
                    break;
                }
            }
            i = i - 1;
        }
    }
    //4단계
    if(vec34.size() && vec34[0] == '.') vec34.erase(vec34.begin());
    if(vec34.size() && vec34[vec34.size() - 1] == '.') vec34.pop_back();
    temp = vec34;
    
    //5단계
    if(temp.empty()){
        temp.push_back('a');
    }
    
    //6단계, 7단계
    while(temp.size() >= 16 || temp.size() < 3){
        if(temp.size() < 3){
            temp.push_back(temp.back());
        }
        else{            
            temp.pop_back();
            if(temp.back() == '.') temp.pop_back();
        }
    }
    
    
    
    for(auto a : temp){
        answer += a;
    }
    
    return answer;
}