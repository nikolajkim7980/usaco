/*
import java.util.StringTokenizer;
ID: nkkim201
LANG: JAVA
TASK: milk3
*/

//complete
import java.io.*;
import java.util.*;

class milk3 {
    static int[] maxSize;
    static HashSet<Integer> ans;
    static boolean[][][] ar;
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("milk3.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));

        maxSize = new int[3];
        ar = new boolean[21][21][21];
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i =0; i < 3; i++){
            maxSize[i] = Integer.parseInt(st.nextToken());
        }
        ans = new HashSet<Integer>();

        ///////////////////////////////////////
        solve(0, 0, maxSize[2]);

        int[]ret = new int[ans.size()];
        int cnt = 0;
        for(int v: ans){
            ret[cnt] = v;
            cnt++;
        }
        Arrays.sort(ret);
        cnt = 0;
        for(int v: ret){
            cnt++;
            if(cnt == ans.size()) out.println(v);
            else out.print(v+" ");
        }
        out.close();
    }

    static void solve(int a, int b, int c ){
        if(ar[a][b][c]){
            return;
        }  
        ar[a][b][c] = true;
        if(a == 0) ans.add(c);
        if(a!=0){
            add(a, b, c, 0, 1);
            add(a, b, c, 0, 2);
        }
        if(b!=0){
            add(a, b, c, 1, 0);
            add(a, b, c, 1, 2);
        }
        if(c!=0){
            add(a, b, c, 2, 0);
            add(a, b, c, 2, 1);
        }
    }
    static void add(int x, int y, int z, int a, int b){
        int[]temp = {x, y, z};
        int dif = (temp[a]+temp[b]) - maxSize[b];
        if(dif < 0) dif = 0;
        temp[b] = temp[a]+temp[b]-dif;
        temp[a] = dif;
        
        a = temp[0];
        b = temp[1];
        int c = temp[2];
        solve(a, b, c);   
    }
}
