#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main(){
    vector<int> ropes;

    int N;
    cin >> N;

    while(N -- ){
        int rope;
        cin >> rope;
        ropes.push_back(rope);
    }
    sort(ropes.begin(), ropes.end());

    vector<int> weight;
    for(int i = 0 ; i < ropes.size() ; i ++ ){
        weight.push_back(ropes[i] * (ropes.size() - i));
    }
    std::sort(weight.begin(), weight.end());

    cout << * (weight.end()-1);
}