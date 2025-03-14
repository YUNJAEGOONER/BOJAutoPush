#include<iostream>
using namespace std;

int main(){
    int answer = 0;
    int y;
    cin >> y;
    
    if(!(y % 4)){
        if(y % 100 || !(y % 400)){
            answer = 1;
        }
    }
    
    cout << answer;
}
