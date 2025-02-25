#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
   
    priority_queue<int, vector<int>, greater<int>> pq;
    
    for(int e : scoville){
        pq.push(e);
    }
    
    while(pq.top() < K){
        if(pq.size() == 1){
            return -1;
        }
        int lowest = pq.top();
        pq.pop();
        int lowest2 = pq.top();
        pq.pop();
        pq.push(lowest + (2 * lowest2));
        answer ++;
    }
    
    return answer;
}