#include <string>
#include <vector>

using namespace std;

vector<string> solution(string myStr) {
    vector<string> answer;
    string temp = "";
    for(int i = 0 ; i < myStr.size() ; i ++ ){
        if(myStr[i] == 'a' || myStr[i] == 'b' || myStr[i] == 'c'){
            if(temp.size()) answer.push_back(temp);
            temp = "";
        }
        else{
            temp = temp + myStr[i];
        }
    }
    if(temp.size()) answer.push_back(temp);
    if(!answer.size()) answer.push_back("EMPTY");
    return answer;
}