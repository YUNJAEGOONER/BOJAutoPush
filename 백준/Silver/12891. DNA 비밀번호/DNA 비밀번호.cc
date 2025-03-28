//
// Created by Yunjae on 2025-03-28.
//
#include<iostream>
using namespace std;

int main() {
    int s, p;
    cin >> s >> p;

    s = abs(s);
    p = abs(p);

    string str;
    cin >> str;

    int A, C, G, T;
    cin >> A >> C >> G >> T;

    int a, c, g, t;
    a = 0;
    c = 0;
    g = 0;
    t = 0;

    for(int i = 0 ; i < p ; i ++ ) {
        if(str[i] == 'A') a ++;
        else if(str[i] == 'C') c ++;
        else if(str[i] == 'G') g ++;
        else if(str[i] == 'T') t ++;
    }

    int answer = 0;
    if(a >= A && c >= C && g >= G && t >= T) answer ++;

    for(int i = p ; i < s ; i ++) {
        if(str[i - p] == 'A') a --;
        else if(str[i - p] == 'C') c --;
        else if(str[i - p] == 'G') g --;
        else if(str[i - p] == 'T') t --;

        if(str[i] == 'A') a ++;
        else if(str[i] == 'C') c ++;
        else if(str[i] == 'G') g ++;
        else if(str[i] == 'T') t ++;

        if(a >= A && c >= C && g >= G && t >= T) answer ++;
    }

    cout << answer << '\n';

    return 0;
}