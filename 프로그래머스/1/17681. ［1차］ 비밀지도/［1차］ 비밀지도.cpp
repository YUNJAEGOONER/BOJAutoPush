#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    vector<string> answer;
    
    vector<int> result;
    for(int i = 0 ; i < n ; i ++ ){
        result.push_back((arr1[i]|arr2[i]));
    }
    
    vector<int> temp(n);
    

    for(int i = 0 ; i < n ; i ++ ){
        vector<int>row = temp;
        
        int idx = n - 1;
        
        int n = result[i];
        while(n != 0){
            row[idx] = n % 2;
            n = n / 2;
            idx --;
        }
    
        vector<char> str_vec;
        for(int i = 0 ; i < row.size() ; i ++ ){
            if(row[i] == 0){
                str_vec.push_back(' ');
            }
            else{
                str_vec.push_back('#');
            }
        }
        
        string str(str_vec.begin(), str_vec.end()); 
        answer.push_back(str);
    }
  
    return answer;
}