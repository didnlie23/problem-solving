import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visited;
	static int Min = Integer.MAX_VALUE;
	static int MinIndex = -1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

//		인접 리스트
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			list.get(A - 1).add(B - 1);
			list.get(B - 1).add(A - 1);
		}

//		각 사람마다 bfs 탐색을 통해 케빈 베이컨의 수 계산
		for (int i = 0; i < N; i++) {
			bfs(i);
		}

		bw.write(String.valueOf(MinIndex + 1));
		bw.flush();
		bw.close();

	}

	public static void bfs(int start) {
		LinkedList<int[]> queue = new LinkedList<>();
		visited = new boolean[N];
		int[] array = new int[N];
		queue.add(new int[] { start, 0 });
		visited[start] = true;
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
//			케빈 베이컨의 수를 계산하고자 하는 사람이 아니라면 값 저장
			if (temp[0] != start) {
				array[temp[0]] = temp[1];
			}
			ArrayList<Integer> tlist = list.get(temp[0]);
			for (int i = 0, end = tlist.size(); i < end; i++) {
				if (!visited[tlist.get(i)]) {
					queue.add(new int[] { tlist.get(i), temp[1] + 1 });
					visited[tlist.get(i)] = true;
				}
			}
		}
		int result = 0;
//		전체 값 합산
		for (int i = 0; i < N; i++) {
			result += array[i];
		}

//		가장 작은 값 갱신
		if (Min > result) {
			Min = result;
			MinIndex = start;
		}
	}

}