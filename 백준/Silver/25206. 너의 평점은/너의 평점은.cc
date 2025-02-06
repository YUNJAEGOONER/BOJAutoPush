#include <iostream>
#include <map>
#include <vector>
using namespace std;

int main(){

    map<string, double> points;
    vector<string> grade = {"A+", "A0", "B+", "B0",
                            "C+", "C0", "D+", "D0", "F"};
    double score = 4.5;
    for(int i = 0 ; i < grade.size() ; i ++ ) {
        if(grade[i] == "F") {
            points[grade[i]] = 0.0;
        }
        else {
            points[grade[i]] = score;
            score = score - 0.5;
        }
    }

    double sum = 0;
    double total = 0;

    for(int i = 0 ; i < 20 ; i ++ ) {
        string name;
        double etc;
        string grd;
        cin >> name >> etc >> grd;
        if(grd != "P") {
            sum = sum + etc;
            total = total + (etc * points[grd]);
        }
    }

    double gpa = total / sum;
    cout << gpa ;

    return 0;
}