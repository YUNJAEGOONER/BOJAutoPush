#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> queue1, vector<int> queue2) {
    int answer = 0;
    vector<int> vec;
    
    long sum1 = 0;
    long sum2 = 0;
    
    for(auto a : queue1){
        sum1 += a;
        vec.push_back(a);
    }
    
  
    for(auto b : queue2){
        sum2 += b;
        vec.push_back(b);
    }
    
    int xs = 0;
    int xe = queue1.size() - 1;
    
    int ys = queue1.size();
    int ye = vec.size() - 1;
    
    
    while(true){
        if(answer != 0 && 
           ((xs == queue1.size() - 1 && xe == 0) || (xe == queue1.size() - 1 && xs == 0))){
            answer = -1;
            break;
        }
        else{
            if(sum1 == sum2){
                break;
            }
            else if(sum1 < sum2){
                xe += 1;
                ys += 1;
                xe %= vec.size();
                ys %= vec.size();
                sum1 += vec[xe];
                sum2 -= vec[xe];
            }
            else{
                ye += 1;
                xs += 1;
                ye %= vec.size();
                xs %= vec.size();
                sum2 += vec[ye];
                sum1 -= vec[ye];
            }
            answer ++;
        }
        
    }
    return answer;
}