#include <string>
#include <vector>
#include <map>
#include <iostream>

using namespace std;

vector<int> solution(int n, vector<string> words) {
    vector<int> answer;
    map<string, int> memo;
    
    memo[words[0]]++;
    int count = 1;
    
    for(int i = 1 ; i < words.size() ; i ++ ){
        if(memo[words[i]] || (words[i-1][words[i-1].size() - 1] != words[i][0])){
            break;
        }
        memo[words[i]]++;
        count ++;
    }
    
    cout << "count : " << count << '\n';
    if(count == words.size()){
        answer.push_back(0);
        answer.push_back(0);
    }
    else{
        answer.push_back((count % n) + 1);
        answer.push_back((count / n) + 1);
    }
    

    return answer;
}