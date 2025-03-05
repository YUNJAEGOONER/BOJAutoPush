#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> sequence, int k) {
    vector<int> answer;
    
    
    int sum = 0;
    int start = 0;
    int end = 0;
    int len = sequence.size();
    
    for(int i = 0 ; i < sequence.size(); i ++ ){
        while(sum < k && end < sequence.size()){
            sum += sequence[end++];
        }
        if(sum == k && len > end - 1 - i){
            len = end - 1 - i;
            start = i;
        }
        sum -= sequence[i];
    }
    
    answer.push_back(start);
    answer.push_back(start + len);
    
    return answer;
}