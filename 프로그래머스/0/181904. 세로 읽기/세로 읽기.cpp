#include <string>
#include <vector>

using namespace std;

string solution(string my_string, int m, int c) {
    vector<char> answer;
    while(c <= my_string.size()){
        answer.push_back(my_string[c - 1]);
        c = c + m;
    }
    //vector<char> -> int
    return string(answer.begin(), answer.end());
}