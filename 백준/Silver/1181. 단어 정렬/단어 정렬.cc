#include <iostream>
#include <map>
#include <set>
using namespace std;

int main(){
    map<int, set<string>> memebers;
    int N;
    cin >> N;

    while (N--){
        string word;
        cin >> word;
        memebers[word.size()].insert(word);
    }
    //set -> already sorted and also do not allow same element(duplication)
    for(auto a: memebers){
        for(auto b : a.second){
            cout << b <<'\n';
        }
    }
}