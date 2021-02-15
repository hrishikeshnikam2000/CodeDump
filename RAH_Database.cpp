#include<iostream>
using namespace std;
bool  is_int(string val) {
    int len = val.length();
    for(int i = 0; i < len; i++) {
        if(val[i] < '0' || val[i] > '9') return false; 
    }
    return true;
}
void borer(int A[], int len) {
    cout<<"+";
    for(int i = 0; i < len; i++) {
        for(int j = 0; j < A[i] + 2; j++) {
            cout<<"-";
        }
        cout<<"+";
    } cout<<endl;
}
int main() {
    ios_base::sync_with_stdio(0);
    int tc;
    cin>>tc;
    while(tc--) {
        int m, n;
        cin>>m>>n;
        string Header[m];
        int attr_len[m];
        int max_cell[m];
        for(int i = 0; i < m; i++) {
            cin>>Header[i];
            attr_len[i] = Header[i].length();
            max_cell[i] = attr_len[i];
        }
        string data[n][m];
        int data_len[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                cin>>data[i][j];
                data_len[i][j] = data[i][j].length();
                if(max_cell[j] < data_len[i][j]) max_cell[j] = data_len[i][j];
            }  
        }
        
        //Header
        borer(max_cell, m);
        cout<<"|";
        for(int i = 0; i < m; i++) {
            cout<<" "<<Header[i];
            for(int j = 0; j < max_cell[i] - attr_len[i] + 1; j++) {
                cout<<" ";
            } cout<<"|";
        } cout<<endl;
        borer(max_cell, m);
        
        //data
        for(int i = 0; i < n; i++) {
            cout<<"|";
            for(int j = 0; j < m; j++) {
                if(is_int(data[i][j])) {
                    for(int k = 0; k < max_cell[j] - data_len[i][j] + 1; k++) {
                        cout<<" ";
                    }
                    cout<<data[i][j]<<" ";
                } else {
                    cout<<" "<<data[i][j];
                    for(int k = 0; k < max_cell[j] - data_len[i][j] + 1; k++) {
                        cout<<" ";
                    }
                }
                cout<<"|";
            } cout<<endl; 
        }
        borer(max_cell, m);
    }
    return 0;    
}





// sample output:

// +-------------+------------+--------+------------+--------+
// | name        | dob        | f_name | date       | amount |
// +-------------+------------+--------+------------+--------+
// | AnshulKumar | 07/07/1995 | Tamal  | 30/02/2019 |  20000 |
// | RahulKumar  | 07/02/1995 | Manish | 31/03/2019 |  16000 |
// +-------------+------------+--------+------------+--------+