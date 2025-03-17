#include<vector>
#include<queue>
#include<iostream>
using namespace std;

int solution(vector<vector<int> > maps)
{
    int answer = 0;
    
    queue<pair<int, pair<int, int>>> mq;
    mq.push(make_pair(1, make_pair(0,0)));
    
    while(!mq.empty()){
        int i = mq.front().second.first;
        int j = mq.front().second.second;
        int depth = mq.front().first;
        mq.pop();
        
        if(i == maps.size() - 1 && j == maps[0].size() - 1){
            answer = depth;
            break;
        }
        
        if(i - 1 >= 0 && maps[i - 1][j]){
            mq.push(make_pair(depth + 1, make_pair(i - 1, j)));
            maps[i - 1][j] = 0;
        }
        if(i + 1 < maps.size() && maps[i + 1][j]){
            mq.push(make_pair(depth + 1, make_pair(i + 1, j)));
            maps[i + 1][j] = 0;
        }
        if(j - 1 >= 0 && maps[i][j - 1]){
            mq.push(make_pair(depth + 1, make_pair(i, j - 1)));
            maps[i][j - 1] = 0;            
        }
        if(j + 1 < maps[0].size() && maps[i][j + 1]){
            mq.push(make_pair(depth + 1, make_pair(i, j + 1)));
            maps[i][j + 1] = 0;           
        }
    
    }
    
    if(!answer) answer = -1;
    
    
    return answer;
}