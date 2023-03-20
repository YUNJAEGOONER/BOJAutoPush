#include <iostream>
#include <map>
#include <vector>
using namespace std;

int main(){
    map<int, vector<string>> memebers;
    int N;
    cin >> N;

    while (N--){
        int age;
        string name;
        cin >> age >> name;
        memebers[age].push_back(name);
    }
    //map -> already sorted by key value
    for(auto a: memebers){
        for(auto b : a.second){
            cout << a.first << ' ' << b <<'\n';
        }
    }
}