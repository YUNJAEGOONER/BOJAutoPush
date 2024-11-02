#include <iostream>
using namespace std;

int main(){
      int test;
    cin >> test;

    while(test--) {
        int change;
        cin >> change;

        int a;
        int b;
        int c;
        int d;

        a = change / 25;
        change = change - a * 25;

        b = change / 10;
        change = change - b * 10;

        c = change / 5;
        change = change - c * 5;

        d = change;

        cout << a << " " << b << " " << c << " "<< d << '\n';
    }
    return 0;
}