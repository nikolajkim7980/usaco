/*
import java.util.StringTokenizer;
ID: nkkim201
LANG: JAVA
TASK: numtri
*/

//complete
import java.io.*;
import java.util.*;

class numtri {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("numtri.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int R = Integer.parseInt(st.nextToken());
        int[][] ar = new int[R][R];
        int[][] arr = new int[R][R];
        int max = 0;
        for(int i =0; i < R; i++){
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j <= i; j++){
                ar[i][j] = Integer.parseInt(st.nextToken());
                arr[i][j] = ar[i][j];
            }
        }
        for(int i = 0; i < R-1; i++){
            for(int j = 0; j <= i; j++){
                int val = arr[i][j];
                if(arr[i+1][j] != 0){
                    arr[i+1][j] = Math.max(arr[i+1][j], ar[i+1][j]+val);
                }
                else if(arr[i+1][j] == 0){
                    arr[i+1][j] = ar[i+1][j] + val;
                }
                if(arr[i+1][j+1] != 0){
                    arr[i+1][j+1] = Math.max(arr[i+1][j+1], ar[i+1][j+1]+val);
                }
                else if(arr[i+1][j+1] == 0){
                    arr[i+1][j+1] = ar[i+1][j+1] + val;
                }
            }
        }
        for(int i = 0; i < R; i++){
            max = Math.max(max, arr[R-1][i]);
        }
        out.println(max);
        out.close();
    }
}




