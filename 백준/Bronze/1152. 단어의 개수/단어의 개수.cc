#include <iostream>
using namespace std;

int main(){
    string sentence;
    getline(cin, sentence, '\n');
    int word = 1;

    for(int i = 0 ; i < sentence.size(); i ++ ){
        if (i != 0 and sentence[i] == ' '){
            word ++;
        }
    }

   if (sentence[sentence.size() - 1] == ' '){
       word --;
   }

   cout << word;
};