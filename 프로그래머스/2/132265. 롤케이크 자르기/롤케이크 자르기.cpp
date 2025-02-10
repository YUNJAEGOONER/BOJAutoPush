#include <string>
#include <vector>
#include <map>
#include <set>

using namespace std;

int solution(vector<int> topping) {
    int answer = 0;
    
    map<int, int> mmap;
    
    for(int i = 0 ; i < topping.size() ; i ++){
        mmap[topping[i]]++;
    }
    
    set<int> mset;
    
    for(int i = 0 ; i < topping.size() ; i ++ ){
        int t = topping[i];
        mset.insert(t);
        mmap[t]--;
        if(!mmap[t])mmap.erase(t);
        if(mmap.size() == mset.size()) answer++;
    }
    
    return answer;
}