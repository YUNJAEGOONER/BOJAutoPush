#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(int storey) {
    int answer = 0;
    
    while(storey){
        int n = storey % 10; 
        //앞자리 수 고려해서 올림 또는 내림 수행
        if(n == 5){
            //내림 발생하는 경우
            //1.한 자리수만 남은 경우
            //2.앞자리가 5보다 작은 경우
            if(storey < 10 || (storey >= 10 && storey % 100 < 50)){
                storey -= n;
                answer += n;
            }
            else{
                storey += (10 - n);
                answer += (10 - n);
            }
        }
        else if(n > 5){
            storey += (10 - n);
            answer += (10 - n);
        }
        //무조건 내림 발생
        else{
            storey -= n;
            answer += n;
        }
        cout << n << '\n';
        storey /= 10;
    }
    
    return answer;
}