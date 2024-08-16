#include <string>
#include <vector>

using namespace std;

int solution(string s) {
//     int answer = 0;
        
//     int num = 1;
//     for(int i = s.length() - 1 ; i > 0 ; i --){
//         answer = answer + ((s[i] - 48) * num); 
//         num = num * 10;
//     }
    
//     if(s[0] == '-'){
//         answer = answer * -1;
//     }
//     else if(s[0] == '+'){
//          answer = answer;
//     }
//     else{
//         answer = answer + ((s[0] - 48) * num); 
//     }
//     return answer;
    
    return stoi(s);
}