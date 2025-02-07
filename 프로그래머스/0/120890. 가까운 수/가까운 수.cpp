#include <string>
#include <vector>

using namespace std;

int solution(vector<int> array, int n) {
    int answer = 0;
    int dis = abs(n - array[0]);
    answer = array[0];
    
    for(int i = 1 ; i < array.size() ; i ++ ){
        int temp = abs(n - array[i]);
        if(dis > temp){
            dis = temp;
            answer = array[i];
        }
        else if(dis == temp){
            if(answer > array[i]) answer = array[i];
        }
    }
    
    return answer;
}