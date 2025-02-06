#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    
    int cur = 0;
    
    while(cur != progresses.size()){
        int count = 0;
        for(int i = 0 ; i < progresses.size() ; i ++ ){
            progresses[i] = progresses[i] + speeds[i];
        }
        if(progresses[cur] >= 100){
            while(progresses[cur] >= 100){
                cur++;
                count++; 
                if(cur == progresses.size()) break;
            }
        }
        if(count) answer.push_back(count);
    }
    return answer;
}