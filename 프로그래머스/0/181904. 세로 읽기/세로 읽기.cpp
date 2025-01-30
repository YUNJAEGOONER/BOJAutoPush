#include <string>
#include <vector>

using namespace std;

string solution(string my_string, int m, int c) {
    string answer = "";
    while(c <= my_string.size()){
        answer = answer + my_string[c - 1];
        c = c + m;
    }
    return answer;
}