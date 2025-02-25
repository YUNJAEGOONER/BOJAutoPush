#include <string>
#include <vector>
#include <map>
#include <iostream>

using namespace std;

int solution(string skill, vector<string> skill_trees) {
    int answer = 0;
    
    for(int i = 0 ; i < skill_trees.size() ; i ++ ){
        
        map<char, int> myskill;
        
        for(int j = 0 ; j < skill_trees[i].size() ; j ++){
            myskill[skill_trees[i][j]] = (j + 1);
        }
        
        bool available = true;
            
        for(int j = 1 ; j < skill.size() ; j ++ ){
            int prev = myskill[skill[j - 1]];
            int cur = myskill[skill[j]];
            if(cur != 0 && (prev == 0 || prev > cur)){
                available = false;
                break;
            }
        }
        
        if(available) answer ++;
    }
    
    return answer;
}