#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> num_list) {
    vector<int> answer;
    for(auto itr = num_list.end()-1; itr > num_list.begin() - 1; itr --){
        answer.push_back(*itr);
    }
    return answer;
}