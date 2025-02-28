#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int answer = 0;
    int sum = 0;
    queue<int> mq;
    
    for(int i = 0 ; i < truck_weights.size() ; i ++ ){
        if(mq.empty()){
            mq.push(truck_weights[i]);
            sum += truck_weights[i];
            answer ++;
        }
        else{
            while(true){
                //앞에 제거하고 
                if(mq.size() == bridge_length){
                    if(sum - mq.front() + truck_weights[i] <= weight){
                        answer ++;
                        sum -= mq.front();
                        sum += truck_weights[i];
                        mq.pop();
                        mq.push(truck_weights[i]);
                        break;
                    }
                    else{
                        answer ++;
                        sum -= mq.front();
                        mq.pop();
                        mq.push(0);
                    }
                }
                else{
                    if(sum + truck_weights[i] <= weight){
                        answer ++;
                        sum += truck_weights[i];
                        mq.push(truck_weights[i]);
                        break;
                    }
                    else{
                        answer ++;
                        mq.push(0);
                    }
                }
            }
        }
    }
    
    answer += bridge_length;
    
    return answer;
}