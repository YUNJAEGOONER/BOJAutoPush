#include <string>
#include <vector>
#include <map>

using namespace std;

string solution(string s) {
    string answer = "";
    map<char, int> mmap;
    for(int i = 0 ; i < s.length() ; i ++){
        mmap[s[i]] ++;
    }
    
    for(auto e: mmap){
        if(e.second == 1){
            answer = answer + e.first;
        }
    }
    
    return answer;
}