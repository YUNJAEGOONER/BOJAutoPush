#include <string>
#include <vector>
#include <map>
#include <iostream>
#include <algorithm>

using namespace std;

bool cmp(pair<string, int> &p1, pair<string, int> &p2){
    int num1 = stoi(p1.first);
    int num2 = stoi(p2.first);
    if(num1 == num2){
        return p1.second < p2.second;
    }
    return num1 < num2;
}

vector<string> solution(vector<string> files) {
    vector<string> answer;

    //HEAD, vector<pair<NUMBER, index>>
    map<string, vector<pair<string, int>>> dic;

    for(int i = 0 ; i < files.size() ; i ++ ){
        string cur = files[i];
        
        //get_head
        string head = "";
        int h = 0;
        while(true){
            int small = 0;
            if('0' <= cur[h] && cur[h] <= '9'){
                break;
            }
            if('a' <= cur[h] && cur[h] <= 'z'){
                small = 32;
            }
            head += (cur[h++] - small);
        }
        
        string num = "";
        while(true){
            if('0' > cur[h] || cur[h] > '9'){
                break;
            }
            num += cur[h++];
        }
        
        //cout << head << " " << num << '\n';
        dic[head].push_back(make_pair(num, i));
    }
    
    for(auto a : dic){
        vector<pair<string, int>> row = a.second;
        sort(row.begin(), row.end(), cmp);
        for(auto b : row){
            //cout << b.second << " ";
            answer.push_back(files[b.second]);
        }
    }
    
    
    
    
    return answer;
}