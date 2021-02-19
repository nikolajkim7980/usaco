/*
import java.util.StringTokenizer;
ID: nkkim201
LANG: JAVA
TASK: sort3
*/

//complete
import java.io.*;
import java.util.*;

class sort3 {
    static int cap1;
    static int cap2;
    static int cap3;
    static TreeSet<Integer>[] ar;
    static int[] count;
    static int[] nums;
    static int ret;
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("sort3.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        nums = new int[N];
        count = new int[4];
        ar = new TreeSet[4];
        ret = 0;
        
        for(int i = 0; i < N; i++){
            int v = Integer.parseInt(f.readLine());
            count[v]++;
            nums[i] = v;
        }
        for(int i = 0; i < 4; i++){
            ar[i] = new TreeSet<Integer>();
        }
        cap1 = count[1]-1;
        cap2 = cap1+count[2];
        cap3 = cap2+count[3];
        for(int i = 0; i < N; i++){
            int val = nums[i];
            int region = findSection(i);
            if(val!=region){
                ar[val].add(i);
            }
        }

        for(int i = 0; i < N; i++){
            int val = nums[i];
            int region = findSection(i);
            if(val!=region){
                swap(val, region, i);
            }
        }
        
        out.println(ret);
        out.close();
    }

    static void swap(int val, int region, int ind){
        int newInd = -1;
        for(int v: ar[region]){
            if(findSection(v) == val){
                newInd = v;
                ar[region].remove(v);
                break;
            }
        }
        if(newInd == -1){
            newInd = ar[region].first();
            ar[region].remove(newInd);
        }
        
        int temp = nums[newInd];
        nums[newInd] = val;
        nums[ind] = temp;
        /////////////////////
        ar[val].remove(ar[val].first());
        if(findSection(newInd)!=val){
            ar[val].add(newInd);
        }
        ret++;
    }

    static int findSection(int ind){
        if(ind <= cap1){
            return 1;
        }
        if(ind <= cap2){
            return 2;
        }
        return 3;
    }
}
