#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> people, int limit) {
    int answer = 0;
    
    sort(people.rbegin(), people.rend());

    vector<int> visited(people.size());
    int min_idx = people.size() - 1;
    
    for(int i = 0 ; i < people.size() ; i ++ ){
        if(visited[i] == 0){
            visited[i] = 1;
            if(people[i] + people[min_idx] <= limit){
                visited[min_idx] = 1;
                min_idx --;
            }
            answer++;
        }
    }
    
    return answer;
}