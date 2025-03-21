//
// Created by Yunjae on 2025-03-21.
//
#include <iostream>
#include <stack>
#include <vector>
#include <deque>
using namespace std;

deque<int> to_arrb5430(string str){
    string temp = "";
    deque<int> result;
    for(int i = 0 ; i < str.size() ; i ++ ) {
        if('0' <= str[i] && str[i] <= '9') {
            temp += str[i];
        }
        else if(str[i] == ',') {
            result.push_back(stoi(temp));
            temp = "";
        }
    }
    if(temp != "") {
        result.push_back(stoi(temp));
    }
    // for(auto a : result) {
    //     cout << a << ' ';
    // }
    return result;
}

void result_b5430(int front, deque<int> arr, bool error) {
    string temp ="";
    if(error) {
        cout << "error" << '\n';
    }
    else if(arr.size() == 0) {
        cout << "[]" << '\n';
    }
    else{
        temp += "[";
        //정방향 출력
        if(front % 2 == 0) {
            for(auto itr = arr.begin(); itr != arr.end() - 1 ; itr ++) {
                temp += to_string(*itr);
                temp += ",";
            }
            temp += to_string(*(arr.end() - 1));
        }
        else {
            //역방향 출력
            for(auto itr = arr.rbegin(); itr != arr.rend() - 1 ; itr ++) {
                temp += to_string(*itr);
                temp += ",";
            }
            temp += to_string(*(arr.rend() - 1));
        }
        temp += "]";
        cout << temp << '\n';
    }
}


int main() {
    int t;
    cin >> t;

    while(t--) {
        string cmd, n, nums;
        cin >> cmd >> n >> nums ;

        stack<char> cmds;

        for(int i = 0 ; i < cmd.size() ; i ++) {
            if(cmds.empty()) {
                cmds.push(cmd[i]);
            }
            else if(cmd[i] == 'R' && cmds.top() == 'R') {
                cmds.pop();
            }
            else {
                cmds.push(cmd[i]);
            }
        }

        vector<char> temp;
        while(!cmds.empty()) {
            temp.push_back(cmds.top());
            //cout << cmds.top() << ' ';
            cmds.pop();
        }
        //cout << '\n';

        vector<char> command = vector<char>(temp.rbegin(), temp.rend());
        // for(int i = temp.size() - 1 ; i > -1 ; i -- ) {
        //     command.push_back(temp[i]);
        // }

        // for(int i = 0 ; i < command.size() ; i ++ ) {
        //     cout << command[i] << ' ';
        // }

        deque <int> dq = to_arrb5430(nums);

        int front = 0;

        bool error = false;
        for(int i = 0; i < command.size() ; i ++ ) {
            if(command[i] == 'D') {
                if(dq.size() == 0) {
                    error = true;
                    break;
                }
                //정방향
                if(front % 2 == 0) {
                    dq.pop_front();
                }
                else {
                    dq.pop_back();
                }
            }
            else {
                front ++;
            }
        }

        result_b5430(front, dq, error);

    }

    return 0;
}