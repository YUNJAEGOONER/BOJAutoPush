#include<iostream>
#include<map>
#include<set>
using namespace std;

int main(){
    int n, m;
    cin >> n >> m;

    map<string, int> mymap;

    for(int i = 0 ; i < m ; i ++ ) {
        string s;
        cin >> s;
        mymap[s] ++;
    }

    set<string> result;
    for(int i = 0 ; i < n ; i ++ ) {
        string s;
        cin >> s;
        if(mymap[s])result.insert(s);
    }

    cout << result.size() << '\n';
    for(auto a : result) cout << a << '\n';
    return 0;
}
