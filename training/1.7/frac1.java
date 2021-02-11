/*
import java.util.StringTokenizer;
ID: nkkim201
LANG: JAVA
TASK: frac1
*/

//complete
import java.io.*;
import java.util.*;

class frac1 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("frac1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        boolean[][] ar = new boolean[N+1][N+1];
        Queue<Integer> denom= new LinkedList<>();
        HashSet<Fraction> fractions = new HashSet<>();
        TreeMap<Integer, Fraction> map = new TreeMap<>();
        int LCM = 0;
        
        if(N==1){
            out.println(0+"/"+1);
            out.println(1+"/"+1);
        }
        else{
            for(int d = 2; d <= N; d++){
                for(int n = 1; n < d; n++){
                    int gcd = gcd(n, d);
                    if(!ar[n/gcd][d/gcd]){
                        ar[n/gcd][d/gcd] = true;
                        denom.add(d/gcd);
                        fractions.add( new Fraction(n/gcd, d/gcd, 0) );
                    }
                }
            }
    
            //calc LCM
            int result = denom.remove();
            while(!denom.isEmpty()){
                int u = denom.remove();
                result = lcm(result, u);
            }
            LCM = result;
    
            //populate map
            for(Fraction a: fractions){
                a.mult = Math.abs(a.num*(LCM/a.den));
                // System.out.println(a.mult + ": "+ a);
                map.put(a.mult, a);
            }
            // System.out.println(map);
    
            //iterate 
            out.println(0+"/"+1);
            for(int key : map.keySet()) {
                out.println(map.get(key));
            }
            out.println(1+"/"+1);
        }
        out.close();
    }
    
    static int lcm(int a, int b){
        return a * (b / gcd(a, b));
    }
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}

class Fraction{
    int num;
    int den;
    int mult;
    public Fraction(int num, int den, int mult){
        this.num = num;
        this.den = den;
        this.mult = mult;
    }
    public String toString(){
        return num+"/"+den;
    }
    
}
