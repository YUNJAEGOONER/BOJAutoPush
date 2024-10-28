#include<iostream>
using namespace std;

int main(){
	int n;
    cin >> n;
    int count = 0;
    while(n--){
        count ++;
        int answer = 0;
    	int m;
        cin >> m;
        while(m--){
        	int a, b;
            cin >> a >> b;
            answer = answer + (b - a) + 1;
        }
        cout << '#' << count << ' ' << answer << '\n';
    }
}