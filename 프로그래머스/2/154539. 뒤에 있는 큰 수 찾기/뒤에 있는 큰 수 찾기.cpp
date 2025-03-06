#include <string>
#include <vector>
#include <stack>

using namespace std;

vector<int> solution(vector<int> numbers) {
    vector<int> answer(numbers.size(), -1);
    
    stack<int> index;
    
    for(int i = 0 ; i < numbers.size() - 1 ; i ++ ){
        if(numbers[i] >= numbers[i + 1]){
            index.push(i);
        }
        else{
            answer[i] = numbers[i + 1];
            while(index.size() && (numbers[index.top()] < numbers[i + 1])){
                answer[index.top()] = numbers[i + 1];
                index.pop();
            }
        }
    }
    
    
    return answer;
}