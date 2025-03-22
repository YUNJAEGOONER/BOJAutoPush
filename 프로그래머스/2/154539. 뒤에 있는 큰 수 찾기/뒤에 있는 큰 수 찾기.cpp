#include <string>
#include <vector>
#include <stack>

using namespace std;

vector<int> solution(vector<int> numbers) {
    vector<int> answer(numbers.size(), -1);
    
    stack<int> idx;
    idx.push(0);
    
    for(int i = 1 ; i < numbers.size(); i ++ ){
        int cur = numbers[i];
        while(!idx.empty()){
            int sidx = idx.top();
            if(numbers[sidx] < cur){
                answer[sidx] = cur;
                idx.pop();
            }
            else{
                break;
            }
        }
        idx.push(i);
    }
    
    
    
    return answer;
}