#include <string>
#include <vector>
using namespace std;

int solution(int n) {
    int answer = 0;
    
    for(int i = 1; i <= n ; i ++ ){
        int cnt = 0;
        for(int j = 2; j < i ; j ++ ){
            if (!(i % j)) cnt++;
        }
        if(cnt)answer++;
    }
    return answer;
}