#include<iostream>
#include<string>
using namespace std;

int main() {
    int a, b;
    cin >> a >> b;
    int answer = -1;
    int count = 0;

    while(b) {
        if (a == b) {
            answer = count + 1;
            break;
        }
        else if(b % 2 == 0) {
            b = b / 2;
            count ++;
        }
        else {
            if(b % 10 == 1) {
                b = b - 1;
                b = b / 10;
                count ++;
            }
            else {
                break;
                answer = -1;
            }
        }
    }
    cout << answer << endl;
    return 0;
}