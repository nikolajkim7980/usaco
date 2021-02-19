/*
import java.util.StringTokenizer;
ID: nkkim201
LANG: JAVA
TASK: holstein
*/

//complete
import java.io.*;
import java.util.*;

class holstein {
    static int V;
    static int G;
    static int[]req;
    static int[]req2;
    static int[][]nodes;
    static TreeSet<Integer> tset;
    static int min;
    static int[] temp;
    static Set<Integer> tempSet;

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("holstein.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));

        tset = new TreeSet<Integer>();
        min = Integer.MAX_VALUE;
        V = Integer.parseInt(f.readLine());
        req = new int[V];
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 0; i < V; i++){
            req[i] = Integer.parseInt(st.nextToken());
        }
        req2 = req.clone();
        G = Integer.parseInt(f.readLine());
        nodes = new int[G][V];
        for(int i = 0; i < G; i++){
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j < V; j++){
                nodes[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //////////////////////////////////
        for(int i = 0; i < G; i++){
            HashSet<Integer>set = new HashSet<Integer>();
            search(i, set);
        }

        out.print(min);
        for(int val:tset){
            out.print(" "+ (val+1));
        }

        out.println();
        out.close();
    }

    static int remove(int ind){
        int cnt = 0;
        for(int i = 0; i < V; i++){
            req[i] = req[i] - nodes[ind][i];
            if(req[i] <= 0) cnt++;
        }
        return cnt;
    }
    static void solve(HashSet<Integer>set){
        int cnt = -1;
        for(int val: set){
            cnt = remove(val);
            if(cnt == V){
                if(min > set.size()){
                    min = set.size();
                    tset.clear();
                    tset.addAll(set);
                }
                break;
            }
            
        }
        for(int i = 0; i < req2.length; i++){
            req[i] = req2[i];
        }
    }
    static void search(int i, HashSet<Integer>set){
        if(i == G) return;
        set.add(i);
        solve(set);
        for(int j = i+1; j < G; j++){
            search(j, set);

        }
        set.remove(i);
        return;
    }
}
