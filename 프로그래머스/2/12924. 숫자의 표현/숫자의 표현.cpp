#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    int sum;
    for(int i = 1 ; i <= n ; i ++ ){
        sum = 0;
        for(int j = i ; j <= n ; j ++ ){
            sum = sum + j;
            if(sum >= n) break;
        }
        if(sum == n) answer ++;
    }
    return answer;
}