#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<string> solution(string myString) {
    vector<string> answer;

    vector<char> temp;
    for(int i = 0 ; i < myString.size() ; i ++ ){
        if (myString[i] == 'x'){
            if(!temp.empty()){
                string str = string(temp.begin(), temp.end());
                answer.push_back(str);
                temp.erase(temp.begin(), temp.end());
            }
        }
        else{
            temp.push_back(myString[i]);
        }
    }
    
    if(!temp.empty()) answer.push_back(string(temp.begin(), temp.end()));
    
    sort(answer.begin(), answer.end());
    return answer;
}