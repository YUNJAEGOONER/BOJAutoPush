#include <string>
#include <vector>
#include <set>
#include <iostream>

using namespace std;

int solution(int x, int y, int n) {
    int answer = 0;
    
    vector<set<int>> results;
    
    set<int> row0;
    row0.insert(x);
    results.push_back(row0);
    
    int idx = 1;
    bool mresult = true;
    
    while(mresult && *(results[idx - 1].begin()) <= y){
        set<int> row;
        for(auto e : results[idx - 1]){
            if(e == y){
                answer = idx - 1;
                mresult = false;
            }
            else{
                row.insert(e + n);
                row.insert(e * 2);
                row.insert(e * 3);                
            }
        }
        
        results.push_back(row);
        idx ++;
    }
    
    if(mresult) answer = -1;
    return answer;
}