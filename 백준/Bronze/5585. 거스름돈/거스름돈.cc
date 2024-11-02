#include <iostream>
using namespace std;

int main() {

    int change;
    cin >> change;
    change = 1000 - change;

    int a;
    int b;
    int c;
    int d;
    int e;
    int f;

    a = change / 500;
    change = change - a * 500;

    b = change / 100;
    change = change - b * 100;

    c = change / 50;
    change = change - c * 50;

    d = change / 10;
    change = change - d * 10;

    e = change / 5;
    change = change - e * 5;

    f = change;

    cout << a + b + c + d + e + f;

    return 0;
}