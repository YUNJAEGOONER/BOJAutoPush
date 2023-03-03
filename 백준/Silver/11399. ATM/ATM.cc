#include <iostream>
#include <vector>
using namespace std;

int main(){
    int N;
    cin >> N;

    vector<int> times;

    while(N--){
        int t;
        cin >> t;
        times.push_back(t);
    }

    //bubble_sort
    for(int i = 0; i < times.size() - 1 ; i ++ ){
        for(int j = 0 ; j < times.size() - 1 - i ; j ++ ){
            if(times[j] > times[j+1]){
                int temp = times[j];
                times[j] = times[j+1];
                times[j+1] = temp;
            }
        }
    }

    int sum = 0;
    for(int i = 0; i < times.size() ; i ++ ){
        sum = sum + times[i] * (times.size() - i);
    }
    cout << sum;
}