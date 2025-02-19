#include <string>
#include <vector>
#include <map>

using namespace std;

vector<string> solution(vector<string> players, vector<string> callings) {
    vector<string> answer;
    
    map<string, int> name;
    map<int, string> rank;
    
    for(int i = 0 ; i < players.size() ; i ++ ){
        name[players[i]] = i + 1;
        rank[i + 1] = players[i];
    }
    
    for(int i = 0 ; i < callings.size() ; i ++ ){
        string back = callings[i]; //kai
        int rback = name[back]; //kai순위
        
        int rfront = rback - 1; //kai 앞 순위
        string front = rank[rfront]; // poe
        
        rank[rfront] =  back;
        name[back] = rfront;
        
        rank[rback] = front;
        name[front] = rback;    
        
    }
    
    for(auto a : rank){
        answer.push_back(a.second);
    }
        
    return answer;
}