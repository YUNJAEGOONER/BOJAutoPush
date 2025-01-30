#include <string>
#include <vector>

using namespace std;

string solution(string my_string, vector<int> indices) {
    string answer = "";
    for(int i = 0 ; i < indices.size() ; i ++ ){
        my_string[indices[i]] = '0';
    }
    
    vector<char> myvec;
    for(int i = 0 ; i < my_string.size(); i ++){
        if(my_string[i] != '0'){
            myvec.push_back(my_string[i]);
        }
    }
    
    answer = string(myvec.begin(), myvec.end());
    
    
    return answer;
}