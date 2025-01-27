#include <string>
#include <vector>
#include <map>
#include <iostream>

using namespace std;

vector<int> solution(vector<string> keymap, vector<string> targets) {
    vector<int> answer;
    
    map<int, int> temp_keys;
    for(int i = 0 ; i < 26; i ++ ){
        temp_keys[i] = -1;
    }
    
    vector<map<int, int>> keyboards;
    
    for(int i = 0 ; i < keymap.size() ; i ++ ){
        map<int, int> tmap = temp_keys;
        for(int j = 0 ; j < keymap[i].size() ; j ++ ){
            int idx = keymap[i][j] -'A';
            if(tmap[idx] == -1) tmap[idx] = (j + 1);
        }
        keyboards.push_back(tmap);
    }
    
    for(int i = 0 ; i < targets.size(); i ++){
        int cnt = 0;
        for(int j = 0 ; j < targets[i].size(); j ++){
            //cout << targets[i][j] << " ";
            int push = 101;
            for(int k = 0; k < keyboards.size(); k ++){
                if(keyboards[k][targets[i][j] - 'A'] != -1 && keyboards[k][targets[i][j] - 'A'] <= push){
                    push = keyboards[k][targets[i][j] - 'A'];
                }  
            }
            cnt = cnt + push;
            if(push == 101){
                cnt = -1;
                break;
            }
        }
        answer.push_back(cnt);
    }
    
    
    return answer;
}