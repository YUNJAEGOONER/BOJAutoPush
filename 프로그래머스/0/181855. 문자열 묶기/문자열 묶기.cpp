#include <string>
#include <vector>
#include <map>

using namespace std;

int solution(vector<string> strArr) {
    int answer = 0;
    
    map<int, int> mymap;
    for(int i = 0 ; i < strArr.size(); i ++ ){
        int strlen = strArr[i].size();
        mymap[strlen] ++;
        if(mymap[strlen] > answer) answer = mymap[strlen];
    }
    return answer;
}