#include <vector>
#include <map>
using namespace std;

int solution(vector<int> nums)
{
    int answer = 0;
    
    map<int, int> temp;
    for(int i = 0 ; i < nums.size() ; i ++ ){
        temp[nums[i]]++;
    }
    
    if(temp.size() >= (nums.size()/2)){
        answer = (nums.size())/2;
    }
    else{
        answer = temp.size();
    }
    return answer;
}