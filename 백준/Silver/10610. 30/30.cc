#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int Size;
vector<int> numbers;

int main(){
    
    string input;
    cin >> input;

    int check_three = 0;

    Size = input.size();

    for(int i = 0 ; i < input.size() ; i++ ) {
        check_three = check_three + (input[i] - 48);
        numbers.push_back(input[i] - 48);
    }
    std::sort(numbers.begin(), numbers.end());


    if(check_three != 0 and check_three % 3 == 0 and numbers[0] == 0){
        for(int i = Size - 1 ; i > - 1; i--){
            cout << numbers[i];
        }
    }
    else{
        cout << -1;
    }

}