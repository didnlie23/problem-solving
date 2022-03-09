import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int M;
	static int N;
	static int K;
	static boolean[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

//			배추 위치 파악
			map = new boolean[N][M];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				map[Y][X] = true;
			}

			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
//					배추를 발견할 때마다 지렁이를 배치하고 count++
					if (map[i][j]) {
						dfs(i, j);
						count++;
					}
				}
			}
			bw.write(String.valueOf(count) + "\n");
		}

		bw.flush();
		bw.close();

	}

//	배치된 지렁이는 보호 가능한 배추를 false처리
	public static void dfs(int row, int column) {
		map[row][column] = false;
		for (int i = 0; i < 4; i++) {
			int nr = row + dr[i];
			int nc = column + dc[i];
			if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc]) {
				dfs(nr, nc);
			}
		}
	}

}