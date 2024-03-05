#include <iostream>
using namespace std;

int main(){
    string input;
    cin >> input;
    int alphabet[26];

    for(int i = 0; i < 26; i ++ ){
        alphabet[i] = -1;
    }

    for(int i = 0 ; i < input.size() ; i ++ ){
        if(alphabet[input[i] - 97] == -1){
            alphabet[input[i] - 97] = i;
        }
    }

    for(int i = 0; i < 26; i ++ ){
        cout << alphabet[i] << " ";
    }


}