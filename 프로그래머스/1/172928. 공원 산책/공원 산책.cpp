#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<string> park, vector<string> routes) {
    vector<int> answer;
    
    //getstartposition
    int si, sj;
    for(int i = 0 ; i < park.size() ; i ++ ){
        for(int j = 0 ; j < park[i].size() ; j ++){
            if(park[i][j] == 'S'){
                si = i;
                sj = j;
                break;
            }
        }
    }
    
    for(int i = 0 ; i < routes.size() ; i ++ ){
        char direction = routes[i][0];
        int steps = stoi(routes[i].substr(2));
        
        //1.범위를 벗어나지 않는지
        
        if(direction == 'E'){
            if(sj + steps < park[0].size()){
                int temp = sj;
                for(int s = 0; s < steps ; s ++){
                    if(park[si][++sj] == 'X'){
                        sj = temp;
                        break;
                    }
                }
            }
        }
        else if(direction == 'W'){
            if(sj - steps >= 0){
                int temp = sj;
                for(int s = 0; s < steps ; s ++){
                    if(park[si][--sj] == 'X'){
                        sj = temp;
                        break;
                    }
                }
            }            
        }
        else if(direction == 'S'){
            if(si + steps < park.size()){
                int temp = si;
                for(int s = 0; s < steps ; s ++){
                    if(park[++si][sj] == 'X'){
                        si = temp;
                        break;
                    }
                }
            }                        
        }
        else{
            if(si - steps >= 0){
                int temp = si;
                for(int s = 0; s < steps ; s ++){
                    if(park[--si][sj] == 'X'){
                        si = temp;
                        break;
                    }
                }
            }               
        }
    }
    
    answer.push_back(si);
    answer.push_back(sj);
    return answer;
}