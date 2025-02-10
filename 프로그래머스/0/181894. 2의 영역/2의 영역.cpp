#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> answer;
    int start = -1;
    int end = -1;
    
    for(int i = 0 ; i < arr.size() ; i ++){
        if(arr[i] == 2){
            start = i;
            break;
        }
    }
    
    if(start == -1){
        answer.push_back(-1);
    }
    else{
        for(int i = arr.size() - 1; i > - 1; i --){
            if(arr[i] == 2){
                end = i;
                break;
            }
        }
        for(int i = start ; i < end + 1 ; i ++ ){
            answer.push_back(arr[i]);
        }
    }
    
    
    return answer;
}