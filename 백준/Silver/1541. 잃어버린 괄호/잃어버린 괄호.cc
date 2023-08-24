#include <iostream>
#include "math.h"
#include <vector>
using namespace std;

int main(){
    int result = 0;
    string problem;
    cin >> problem;

    vector<int> pn;
    vector<int> count;
    int num_count;

    pn.push_back(1);
    for(int i = 0; i < problem.length() ; i ++ ){
        num_count = 0;
        if(problem[i] == '-' or problem[i] == '+'){
            if(problem[i] == '-'){
                pn.push_back(-1);
                //cout << "negative" <<'\n';
            }
            else{
                pn.push_back(+1);
                //cout << "positive" <<'\n';
            }
        }
        else{
            while(0 <= (problem[i] - 48) and (problem[i] - 48) <= 9){
                ++num_count;
                i ++;
                //cout << problem[i++];
            }
            count.push_back(num_count);
            //cout <<'\n'<< num_count << '\n';
            i = i - 1;
        }
    }

    int j = 0;
    int previous = 1;

    for(int i = 0 ; i < count.size() ; i ++ ){
        int current = pn[i];
        int sum = 0;
        int num = count[i] - 1;
        while(0 <= (problem[j] - 48) and (problem[j] - 48) <= 9){
            sum = sum + ((problem[j++] - 48) * pow(10,num--));
        }
        j = j + 1;
        sum = sum * current;
        if(i != 0){
            if(previous == -1 && current == 1){
                sum = sum * -1;
                previous = -1;
            }
            else{
                previous = current;
            }
        }
        result = result + sum;
        //cout << sum << '\n';
    }
    cout << result;
    //cout << problem.length();
}