import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeGroundFrog {
	public static void main(String args[]) throws Exception {
		new CodeGroundFrog();
	}
	
	int arr[];
	int arrout[];
	int N, K;
	
	CodeGroundFrog() throws Exception {
		FastScanner fsc = new FastScanner();
		int TC;
		int test_case;
		TC = fsc.nextInt();        
		for(test_case = 1; test_case <= TC; test_case++) {
			// ÃÊ±âÈ­
			N = fsc.nextInt();
			arr = new int[N+1];
			arrout = new int[N+1];
			for(int i=1; i<=N; i++) {
				arr[i] = fsc.nextInt();
				arrout[i] = 2000000000;
			}
			K = fsc.nextInt();
	    
			System.out.println("Case #" + test_case);
			System.out.println(dp());
			
		}
	}
	
	int dp() {
		for(int j=0; j<N; j++) {
			for(int m=1; m<=K; m++) {
				if(j+m>N) break;
				if(K>=arr[j+m]-arr[j]) {
					arrout[j+m] = Math.min(arrout[j+m], arrout[j]+1);
				} else break;
			}
		}
		if(arrout[N]==2000000000) return -1;
		else return arrout[N];
	}
	
	class FastScanner {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int nextInt() throws Exception {
            if (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(in.readLine());
            }
            return Integer.parseInt(st.nextToken());
        }
    }
}
