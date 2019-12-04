package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N {
	static int N;
	static double[] arr;
	static int B;
	static int C;

	// ´ä
	static long result;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		arr = new double[N];

		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Double.parseDouble(st.nextToken());
		}

		st = new StringTokenizer(bf.readLine());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			double c = arr[i];
			if(c<=B) {
				result++;
			}else {
				result += (1 + Math.ceil((c-B)/C));
			}
		}
		
		System.out.println(result);
		bf.close();
	}
}
