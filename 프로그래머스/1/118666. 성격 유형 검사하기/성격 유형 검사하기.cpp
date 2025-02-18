#include <string>
#include <vector>
#include <map>

using namespace std;

string solution(vector<string> survey, vector<int> choices) {
    string answer = "";
    
    map<char, int> mmap;
    
    for(int i = 0 ; i < choices.size() ; i ++ ){
        if(1 <= choices[i] && choices[i] <= 3){
            if(choices[i] == 1) mmap[survey[i][0]] += 3;
            else if(choices[i] == 2) mmap[survey[i][0]] += 2;
            else mmap[survey[i][0]] += 1;
        }
        else if(4 < choices[i]){
            if(choices[i] == 5) mmap[survey[i][1]] += 1;
            else if(choices[i] == 6) mmap[survey[i][1]] += 2;
            else mmap[survey[i][1]] += 3;
        }
    }
    
    if(mmap['R'] >= mmap['T']){
        answer = answer + 'R';
    }
    else{
        answer = answer + 'T';
    }
    
    if(mmap['C'] >= mmap['F']){
        answer = answer + 'C';
    }
    else{
        answer = answer + 'F';
    }
    
    if(mmap['J'] >= mmap['M']){
        answer = answer + 'J';
    }
    else{
        answer = answer + 'M';
    }    
    
    if(mmap['A'] >= mmap['N']){
        answer = answer + 'A';
    }
    else{
        answer = answer + 'N';
    }
    
    return answer;
}