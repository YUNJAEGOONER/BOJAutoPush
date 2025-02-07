#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> visit;
int sum = 0;

int answer = 0;

void mybfs(vector<int> temp, int e, vector<vector<int>> dungeons, int k, int depth) {
    
    if(answer <= depth){
        answer = depth;
    }
    
    for(int i = 0 ; i < e ; i ++ ){
        if(visit[i]){continue;}
        if(k >= dungeons[i][0]){
            visit[i] = 1;
            temp.push_back(i);
            k = k - dungeons[i][1];
            mybfs(temp, e, dungeons, k, depth + 1);
            visit[i] = 0;
            k = k + dungeons[i][1];
            temp.pop_back();
        }
    }
}

int solution(int k, vector<vector<int>> dungeons) {
    vector<int> temp;
    
    visit = vector<int>(dungeons.size());

    mybfs(temp, dungeons.size(), dungeons, k, 0);
    
    return answer;
}