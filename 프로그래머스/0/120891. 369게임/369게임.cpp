#include <string>
#include <vector>

using namespace std;

int solution(int order) {
    int answer = 0;
    
    string mystr = to_string(order);
    for(int i = 0 ; i < mystr.length(); i++ ){
        if(mystr[i] == '3' || mystr[i] == '6' || mystr[i] == '9'){
            answer ++;
        }
    }
    
    return answer;
}