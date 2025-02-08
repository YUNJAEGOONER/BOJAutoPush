#include <string>
#include <vector>

using namespace std;

int solution(vector<int> array) {
    int answer = 0;
    for (int i = 0 ; i < array.size() ; i ++ ){
        string temp = to_string(array[i]);
        for(auto a : temp){
            if(a == '7') answer++;
        }
    }
    return answer;
}