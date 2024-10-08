#include<algorithm>
#include<vector>
#include<iostream>
#include<map>
using namespace std;

int main()
{
    int n;
    cin >> n;
    map<int, int> count;
    while(n--){
        int element;
        cin >> element;
        count[element]++;
    }
    
    for(auto itr : count){
        for(int i = 0 ; i < itr.second ; i ++ ){
            cout << itr.first << '\n';
        }
    }
}