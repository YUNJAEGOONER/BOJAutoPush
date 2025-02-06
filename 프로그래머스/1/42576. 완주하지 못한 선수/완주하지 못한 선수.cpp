#include <string>
#include <vector>
#include <map>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    string answer = "";
    map<string, int> hmap;
    
    for(int i = 0 ; i < participant.size() ; i ++ ){
        hmap[participant[i]]++;
    }

    for(int i = 0 ; i < completion.size() ; i ++){
        hmap[completion[i]]--;
    }
    
    
    for(auto itr : hmap){
        if(itr.second == 1){
            answer = itr.first;
        }
    }
    
    return answer;
}