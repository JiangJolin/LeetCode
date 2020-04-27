#include <stdlib.h>
#include <iostream>
#include <vector>
using namespace std;

class Solution1 {
public:
    void rotate(vector<vector<int> >& matrix) {
        int n = matrix.size();
        //horizontal reverse
        for (int i = n/2; i > 0 ; i--){
            for (int j = 0; j < n; j++){
                int temp = matrix[j][i-1];
                matrix[j][i-1] = matrix[j][n-i];
                matrix[j][n-i] = temp;
            }
        }
        //diagonal reverse
        for (int i = 1; i < n ; i++){
            for (int j = 0; j < n-i; j++){
                int k = n - j - i -1;
                // cout << "(" << j << "," << k << ")" << "<->" << "(" << j+i << "," << k+i << ")"<<endl;
                int temp = matrix[j][k];
                matrix[j][k] = matrix[j+i][k+i];
                matrix[j+i][k+i] = temp;
            }
        }
    }
};
class Solution2 {
public: 
    void rotate(vector<vector<int> >& matrix) {
        int n = matrix.size();
         for (int i = 0; i < n/2; i++ ) {
             for (int j = i; j < n - i - 1; j ++ ){
                 int temp = matrix[i][j];
                 matrix[i][j] = matrix[n-j-1][i];
                 matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                 matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                 matrix[j][n-i-1] = temp;
             }
         }    
    }
};


int main(){
    int n = 4;
    vector<vector<int> > matrix (n, vector<int>(n));
    int start = 1;
    for (int i = 0; i < n; i++){
        for (int j = 0; j < n; j++){
            matrix[i][j] = start;
            start ++;
            cout << matrix[i][j] << " ";
        }
        cout << endl;
    }
    Solution2 a;
    a.rotate(matrix);
    cout << "After Rotation:" << endl;
    for (int i = 0; i < n; i++){
        for (int j = 0; j < n; j++){
            cout << matrix[i][j] << " ";
        }
        cout << endl;
    }
    return 0;
}

//Java
// class Solution {
//     public void rotate(int[][] matrix) {
//         int n = matrix.length;
//         // 先以对角线（左上-右下）为轴进行翻转
//         for (int i = 0; i < n - 1; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 int tmp = matrix[i][j];
//                 matrix[i][j] = matrix[j][i];
//                 matrix[j][i] = tmp;
//             }
//         }
//         // 再对每一行以中点进行翻转
//         int mid = n >> 1;
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < mid; j++) {
//                 int tmp = matrix[i][j];
//                 matrix[i][j] = matrix[i][n - 1 - j];
//                 matrix[i][n - 1 - j] = tmp;
//             }
//         }
//     }
// }