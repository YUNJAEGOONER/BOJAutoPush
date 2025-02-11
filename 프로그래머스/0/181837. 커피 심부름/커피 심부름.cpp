#include <string>
#include <vector>

using namespace std;

int solution(vector<string> order) {
    int answer = 0;
    
    int a = 0;
    int l = 0;
    
    for(int i = 0 ; i < order.size() ; i ++ ){
        if(order[i].find("latte") != string::npos){
            l ++;
        }
        else{
            a ++;
        }
    }
    
    answer = 4500 * a + 5000 * l;
    
    
    return answer;
}