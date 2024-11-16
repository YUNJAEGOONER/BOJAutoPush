#include <string>
#include <vector>
#include <map>
#include <iostream>

using namespace std;

int solution(vector<int> citations) {
    int answer = 0;
    
    map<int, int> mymap; //인용횟수 - 논문의 수
    for(int i = 0 ; i < citations.size() ; i ++ ){
        mymap[citations[i]]++;
    }

    int sum = 0;
    int max = (--mymap.end())->first ;
    for(int i = 0 ; i < max ; i ++ ){
        cout << "i : " << i << " sum = " << sum << '\n';
        if(i <= citations.size() - sum && sum <= i) answer = i;
        sum = sum + mymap[i];
    }
	
    return answer;
}