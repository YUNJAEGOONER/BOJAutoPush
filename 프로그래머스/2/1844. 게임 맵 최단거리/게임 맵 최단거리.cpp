#include<vector>
#include<iostream>
using namespace std;

int solution(vector<vector<int> > maps)
{
    int answer = 0;
    int result = -1;
    
    int n = maps.size();
    int m = maps[0].size();
    

    vector<pair<pair<int, int>, int>> myqueue;
    myqueue.push_back(make_pair(make_pair(0, 0), 1));
    maps[0][0] = 0;
    
    while(!myqueue.empty()){
        int dis = myqueue.begin()->second;
        int cur_i = myqueue.begin()->first.first;
        int cur_j = myqueue.begin()->first.second;
        if(cur_i == n - 1 && cur_j == m - 1){
            result = dis;
            break;
        }
        
        myqueue.erase(myqueue.begin());
        //top
        if(cur_i - 1 >= 0 && maps[cur_i - 1][cur_j]){
            myqueue.push_back(make_pair(make_pair(cur_i - 1, cur_j),dis + 1));
            maps[cur_i - 1][cur_j] = 0;
        }
        //down
        if(cur_i + 1 < n && maps[cur_i + 1][cur_j]){
            myqueue.push_back(make_pair(make_pair(cur_i + 1, cur_j) ,dis + 1));
            maps[cur_i + 1][cur_j] = 0;
        }
        //left
        if(cur_j - 1 >= 0 && maps[cur_i][cur_j - 1]){
            myqueue.push_back(make_pair(make_pair(cur_i, cur_j - 1), dis + 1));
            maps[cur_i][cur_j - 1] = 0;
        }
        //right
        if(cur_j + 1 < m && maps[cur_i][cur_j + 1]){
            myqueue.push_back(make_pair(make_pair(cur_i, cur_j + 1), dis + 1));
            maps[cur_i][cur_j + 1] = 0;
        }
    }
    
    return result;
}