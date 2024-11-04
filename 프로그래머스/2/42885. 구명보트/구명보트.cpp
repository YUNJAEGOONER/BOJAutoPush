#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

bool cmp(int a, int b){return a < b;}

int solution(vector<int> people, int limit) {
    int answer = 0;
    
    //내림차순 정렬
    sort(people.begin(), people.end(), cmp);
    
    vector<int> visit (people.size());
    
    int light = 0;
    for(int i = people.size() - 1 ; i > -1 ; i -- ){
        int sum = 0;
        if(!visit[i]){
            answer ++;
            sum = sum + people[i];
            if(sum + people[light] <= limit) visit[light++] = 1; 
        }
    }
    return answer;
}