#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(string s) {
    vector<int> answer;
    int zero_sum = 0;
    int iter = 0;
    
    while(s != "1"){
        iter ++;
        int zero_count = 0;
        for(int i = 0 ; i < s.length() ; i ++ ){
            if(s[i] == '0'){
                zero_count ++;
            }
        }
        
        int num = s.length() - zero_count;
        
        vector<char> to_binary;
        while(num != 0){
            to_binary.push_back((num % 2) + 48);
            num = num / 2;
        }
        s = string(to_binary.begin(), to_binary.end());
        zero_sum = zero_sum + zero_count;
    }
    
    answer.push_back(iter);
    answer.push_back(zero_sum);
    return answer;
}