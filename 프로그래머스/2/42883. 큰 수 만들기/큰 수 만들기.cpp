#include <string>
#include <vector>

using namespace std;

string solution(string number, int k) {
    string answer = "";
    
    int cur_idx = 0;
    
    for(int i = 0; i < number.size() - k ; i ++ ){
        int max = 0;
        int midx = 0;
        for(int j = cur_idx ; j < k + (i + 1) ; j ++ ){
            if(max < number[j]){
                max = number[j];
                midx = j;
            }
        }
        cur_idx = midx;
        answer += number[cur_idx];
        cur_idx ++;
    }
    
    
    
    return answer;
}