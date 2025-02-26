#include <string>
#include <vector>
#include <stack>
#include <iostream>

using namespace std;

int solution(vector<int> order) {
    int answer = 0;
    
    vector<int> pack;
    for(int i = 0 ; i < order.size() ; i ++ ){
        pack.push_back(i + 1);
    }
    
    stack<int> mstck;
    
    int idx = 0;
    
    while(idx != order.size()){
        if(pack[idx] == order[answer]){
            idx ++ ;
            answer ++;
        }
        else{
            if(mstck.empty()){
                mstck.push(pack[idx]);
                idx ++;
            }
            else{
                //stack이랑 비교
                if(mstck.top() == order[answer]){
                    answer ++;
                    mstck.pop();
                }
                else{
                    mstck.push(pack[idx]);
                    idx ++;
                }
                
            }
        }
    }
    
    while (answer < order.size() && mstck.top() == order[answer]){
        answer ++;
        mstck.pop();
    }
    
    return answer;
}