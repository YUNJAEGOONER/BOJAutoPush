#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<long long> solution(vector<long long> numbers) {
    vector<long long> answer;
    
    for(int i = 0 ; i < numbers.size() ; i ++ ){
        long long cur = numbers[i];

        if(cur % 2 == 0){
            answer.push_back(cur + 1);
        }
        else{
            vector<int> temp;
            while(cur){
                temp.push_back(cur % 2);
                cur /= 2;
            }
            temp.push_back(0);
            
            for(int i = 0 ; i < temp.size() ; i ++ ){
                if(temp[i] == 0){
                    temp[i] = 1;
                    temp[i - 1] = 0;
                    break;
                }
            }
            
            long long sum = 0;
            long long btod = 1;
            for(int i = 0 ; i < temp.size() ; i ++){
                sum += (btod * temp[i]);
                btod *= 2;
            }
            answer.push_back(sum);
        }
        

    }
     
    
    return answer;
}