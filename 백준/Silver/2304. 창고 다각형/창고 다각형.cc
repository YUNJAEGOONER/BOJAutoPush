#include <iostream>
#include <map>
#include <vector>

using namespace std;

int main(){
    map<int, int> mymap;

    int max_idx =  -1;
    int max_val =  -1;

    int n;
    cin >> n;
    while(n --) {
        int a, b;
        cin >> a >> b;
        mymap[a] = b;
        if(max_val <= b) {
            max_idx = a;
            max_val = b;
        }
    }

    vector<int> v((--mymap.end())->first + 1);

    int max = 0;
    for(int i = 0 ; i < max_idx + 1 ; i ++){
        if(mymap[i] && max <= mymap[i]) max = mymap[i];
        v[i] = max;
    }

    int min = (--mymap.end())->second;

    for(int i = v.size() - 1 ; i > max_idx ; i --) {
        if(min <= mymap[i]) min = mymap[i];
        v[i] = min;
    }

    int result = 0;
    for(auto e : v) result = result + e;
    cout << result << endl;

    return 0;
}