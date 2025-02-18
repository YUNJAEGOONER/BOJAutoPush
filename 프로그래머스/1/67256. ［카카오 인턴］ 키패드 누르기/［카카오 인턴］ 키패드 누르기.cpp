#include <string>
#include <vector>
#include <iostream>

using namespace std;

int get_distance(int start, int target){
    int dis = 0;
    while(start != target){
        if(start - target < 0){
            if(start - target == -1){
                start += 1;
                dis ++;
            }
            else{
                start += 3;
                dis++;
            }
        }
        //차이가 양수인 경우
        else{
            if(start - target == 1){
                start -= 1;
                dis ++;
            }
            else{
                start -= 3;
                dis++;
            }            
        }
    }
    return dis;
}

string solution(vector<int> numbers, string hand) {
    string answer = "";
    
    int LC = 10;
    int RC = 12;
    
    for(int i = 0 ; i < numbers.size() ; i ++ ){
        if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
            answer = answer + 'L';
            LC = numbers[i];
        }
        else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
            answer = answer + 'R';
            RC = numbers[i];
        }
        else{
            int target = numbers[i];
            if(target == 0) target = 11;
            
            int left = get_distance(LC, target);
            int right = get_distance(RC, target);
            
            if(left > right){
                answer += "R";
                RC = numbers[i];
            }
            else if(left < right){
                answer += "L";
                LC = numbers[i];
            }
            else{
                if(hand == "right"){
                    answer += "R";
                    RC = numbers[i];                    
                }
                else{
                    answer += "L";
                    LC = numbers[i];                    
                }
            }
            
            if(!RC) RC+=11;
            if(!LC) LC+=11;
        }
    }
    

    

    
    
    
    return answer;
}