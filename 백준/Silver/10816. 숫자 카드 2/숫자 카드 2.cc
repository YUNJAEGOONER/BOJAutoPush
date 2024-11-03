#include<iostream>
#include<map>
using namespace std;

int main() {
    
    ios::sync_with_stdio(false);
    cin.tie(0);
    
    int N;
    cin >> N;
    map<int, int> card;
    while(N --) {
        int a;
        cin >> a;
        card[a] ++;
    }

    int M;
    cin >> M;
    while(M--) {
        int b;
        cin >> b;
        cout << card[b] << ' ';
    }

    return 0;
}
