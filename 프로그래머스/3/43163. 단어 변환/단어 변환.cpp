#include <string>
#include <vector>
#include <iostream>
#include <queue>

using namespace std;

vector<int> visited;

bool get_distance(string word1, string word2){
    int diff = 0;
    for(int i = 0 ; i < word1.size() ; i ++ ){
        if(word1[i] != word2[i]){
            diff ++;
            if(diff >= 2){
                return false;
            }
        }
    }
    return true;
}

int solution(string begin, string target, vector<string> words) {
    int answer = 0;
    
    visited = vector<int>(words.size());
    queue<pair<string, int>> mq;
    mq.push(make_pair(begin, 0));
    
    while(!mq.empty()){
        string cur = mq.front().first;
        int depth = mq.front().second;
        mq.pop();
        if(cur == target){
            answer = depth;
            break;
        }
        
        for(int i = 0; i < words.size() ; i ++ ){
            if(visited[i] == 0 && get_distance(cur, words[i])){
                visited[i] = 1;
                mq.push(make_pair(words[i], depth + 1));
            }
        }
    }
    
    return answer;
}