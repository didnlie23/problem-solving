import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
//			원하는 값 입력
			int M = Integer.parseInt(br.readLine());
//			0의 출현 빈도수를 저장할 배열
			int[] countZero = new int[M + 1];
//			1의 출현 빈도수를 저장할 배열
			int[] countOne = new int[M + 1];
//			피보나치 수의 1번째 수 초기화
			if (M >= 0) {
				countZero[0] = 1;
				countOne[0] = 0;
			}
//			피보나치 수의 2번째 수 초기화
			if (M >= 1) {
				countZero[1] = 0;
				countOne[1] = 1;
			}
//			0과 1의 출현 빈도수 누적
			for (int j = 2; j < M + 1; j++) {
				countZero[j] = countZero[j - 1] + countZero[j - 2];
				countOne[j] = countOne[j - 1] + countOne[j - 2];
			}
			bw.write(String.valueOf(countZero[M]) + " " + String.valueOf(countOne[M]) + "\n");
		}
		bw.flush();
		bw.close();

	}

}