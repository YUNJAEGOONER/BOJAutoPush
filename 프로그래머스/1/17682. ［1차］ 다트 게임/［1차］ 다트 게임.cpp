#include <string>
#include <iostream>
#include <vector>

using namespace std;

int solution(string dartResult) {
    int answer = 0;
    vector<int> result;
    int pre_idx = -1;

    int num = 0;
    for(int i = 0 ; i < dartResult.length() ; i ++ ){
        vector <char> to_num;
        while(true){
            if((48 <= dartResult[i]) && (dartResult[i] <= 57)){
                to_num.push_back(dartResult[i++]);
            }
            else{
                break;
            }
        }

        string str_num(to_num.begin(), to_num.end());
        num = stoi(str_num);

        if(dartResult[i] == 'D'){
            num = num * num;
        }
        else if(dartResult[i] == 'T'){
            num = num * num * num;
        }
        i ++;

        result.push_back(num);

        if(dartResult[i] == '*'){
            if(pre_idx == -1){
                result[0] = result[0] * 2;
            }
            else{
                result[pre_idx] = result[pre_idx] * 2;
                result[pre_idx + 1] = result[pre_idx + 1] * 2;
            }
        }
        else if(dartResult[i] == '#'){
            result[pre_idx + 1] = result[pre_idx + 1] * (-1);
        }
        else{
            i -- ;
        }
        pre_idx ++;
    }

    for(int i = 0 ; i < result.size() ; i ++ )
    {
        cout << result[i] << ' ';
        answer = answer + result[i];
    }
    return answer;
}