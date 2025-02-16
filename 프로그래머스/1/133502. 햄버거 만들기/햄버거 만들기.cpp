#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(vector<int> ingredient) {
    int answer = 0;
    
    vector<int> svec;
    
    for(int i = 0 ; i < ingredient.size() ; i ++ ){
        svec.push_back(ingredient[i]);
        if(ingredient[i] == 1 && svec.size() >= 4){
            int cur = svec.size() - 1;
            if(svec[cur - 1] == 3 && svec[cur - 2] == 2 && svec[cur - 3] == 1){
                svec.pop_back();
                svec.pop_back();
                svec.pop_back();
                svec.pop_back();
                answer ++;
            }
        }
    }
    
    return answer;
}