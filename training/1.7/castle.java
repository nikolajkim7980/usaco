/*
import java.util.StringTokenizer;
ID: nkkim201
LANG: JAVA
TASK: castle
*/

//complete
import java.io.*;
import java.util.*;

class castle {
    // static int[][] guide;
    static int[][] ar;
    static int[][] cord;
    static HashMap<Integer, Integer> map;
    static int cnt;
    static int sum;
    static int max;
    static int ii;
    static int jj;
    static char dir;

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("castle.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] guide = {{0, 0, 0, 0},{0, 0, 0, 1}, {1, 0, 0, 0}, {1, 0, 0, 1}, {0, 0, 1, 0}, {0, 0, 1, 1}, {1, 0, 1, 0}, {1, 0, 1, 1}, {0, 1, 0, 0}, {0, 1, 0, 1}, {1, 1, 0, 0,}, {1, 1, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 1, 1, 0}, {1, 1, 1, 1}};
        ar = new int[N][M];
        cord = new int[N][M];
        map = new HashMap<>();
        cnt = 0;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j< M; j++){
                int val = Integer.parseInt(st.nextToken());
                cord[i][j] = val;
                ar[i][j] = -1;
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j< M; j++){
                int val = cord[i][j];
                if(cord[i][j] != -1){
                    sum = 0;
                    solve(i, j, guide);
                    map.put(cnt, sum);
                    cnt++;
                }
            }
        }

        max = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(j != M-1 && ar[i][j] != ar[i][j+1]){
                    checkR(i, j);
                }
                if(i != N-1 && ar[i][j] != ar[i+1][j]){
                    checkD(i, j);
                }
            }
        }

        out.println(map.size());
        int ret = 0;
        for(int key: map.keySet()){
            ret = Math.max(ret, map.get(key));
        }
        out.println(ret);
        out.println(max);
        out.println(ii+1 + " " + (jj+1) + " "+ dir);
        

        
        out.close();
    }

    static void checkR(int i, int j){
        int key1 = ar[i][j];
        int key2 = ar[i][j+1];
        int newSum = map.get(key1) + map.get(key2);
        if(newSum > max){
            max = newSum;
            ii = i;
            jj = j;
            dir = 'E';
        }
        else if(newSum == max){
            if(j<jj){
                ii = i;
                jj = j;
                dir = 'E';
                return;
            }
            if(j>jj) return;
            if(i > ii){
                ii = i;
                jj = j;
                dir = 'E';
                return;
            }
            if(i < ii) return;
        }
    }

    static void checkD(int i, int j){
        int key1 = ar[i][j];
        int key2 = ar[i+1][j];
        int newSum = map.get(key1) + map.get(key2);

        if(newSum > max){
            max = newSum;
            ii = i+1;
            jj = j;
            dir = 'N';
        }
        else if(newSum == max){
            if(j<jj){
                ii = i+1;
                jj = j;
                dir = 'N';
                return;
            }
            if(j>jj) return;
            if(j==jj && i > ii){
                ii = i+1;
                jj = j;
                dir = 'N';
                return;
            }
            if(i<ii) return;
            if(dir == 'E'){
                ii = i+1;
                jj = j;
                dir = 'N';
                return;
            }
        }
    }

    static void solve(int i, int j, int[][]guide){
        int val = cord[i][j];
        if(val == -1) return;
        cord[i][j] = -1;
        if(ar[i][j] == -1){
            sum++;
        }
        ar[i][j] = cnt;
        if(guide[val][0] == 0 && valid(i-1, j)){
            solve(i-1, j, guide);
        }
        if(guide[val][1] == 0 && valid(i+1, j)){
            solve(i+1, j, guide);
        }
        if(guide[val][2] == 0 && valid(i, j+1)){
            solve(i, j+1, guide);
        }
        if(guide[val][3] == 0 && valid(i, j-1)){
            solve(i, j-1, guide);
        }
    }
    static boolean valid(int x, int y){
        if(x < 0 || y < 0 || x >= ar.length || y >= ar[0].length) return false;
        return true;
    }    
}
