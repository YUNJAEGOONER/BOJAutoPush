#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(int n, long long left, long long right) { 
    vector<int> answer;
    
//     vector<int> whole_row;
    
//     int row = 1;
//     for(int i = 0 ; i < (n * n) ; i ++ ){
//         if(row > i % n + 1){
//             whole_row.push_back(row);
//         }
//         else{
//             whole_row.push_back(i % n + 1);
//         }
//         if((i + 1) % n == 0){
//             row = row + 1;
//         }
//     }
    
    int row = left / n + 1 ;
    for(long long i = left ; i < right + 1; i ++ ){
        if(row > i % n + 1){
            answer.push_back(row);
        }
        else{
            answer.push_back(i % n + 1);
        }
        if((i + 1) % n == 0){
            row = row + 1;
        }
    }
    
    // for(long long i = left ; i < right + 1 ; i ++ ){
    //     answer.push_back(whole_row[i]);
    // }
    
    return answer;
}