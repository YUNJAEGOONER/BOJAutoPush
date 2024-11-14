#include <string>
#include <vector>
#include <set>

using namespace std;

int solution(vector<int> elements) {
    
    set<int> answerset;
    
    for(int i = 0 ; i < elements.size();  i ++ ){
        for(int j = 0 ; j < elements.size() ; j ++ ){
            int sum = 0;
            for(int k = j ; k < (j + i + 1); k ++ ){
                sum = sum + elements[k % elements.size()];
            }
            answerset.insert(sum);
        }
    }
    
    int answer = answerset.size();
    return answer;
}