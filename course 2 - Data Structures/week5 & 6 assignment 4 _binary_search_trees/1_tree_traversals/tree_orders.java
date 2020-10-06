import java.util.*;
import java.io.*;

public class tree_orders {
    class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
	
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public class TreeOrders {
		int n;
		int[] key, left, right;
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			key = new int[n];
			left = new int[n];
			right = new int[n];
			for (int i = 0; i < n; i++) { 
				key[i] = in.nextInt();
				left[i] = in.nextInt();
				right[i] = in.nextInt();
			}
		}

		List<Integer> inOrder() {
			return iny(0);
		}
		ArrayList<Integer> r1 = new ArrayList<Integer>();
		List<Integer> preOrder() {
			return pre(0);
		}
		ArrayList<Integer> r2 = new ArrayList<Integer>();
		List<Integer> postOrder() {
			return pos(0);
		}
		public ArrayList<Integer> pos(int a)
		{
			if(a!=-1)
			{
				pos(left[a]);
				pos(right[a]);
				r2.add(key[a]);
			}
			return r2;
		}
		ArrayList<Integer> r= new ArrayList<Integer>();
		public ArrayList<Integer> iny(int a)
		{
			if(a!=-1)
			{
				iny(left[a]);
				r.add(key[a]);
				iny(right[a]);
			}
			return r;
		}
		public ArrayList<Integer> pre(int a)
		{

			if(a!=-1)
			{
				r1.add(key[a]);
				pre(left[a]);
				pre(right[a]);
			}
			return r1;
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_orders().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}

	public void print(List<Integer> x) {
		for (Integer a : x) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public void run() throws IOException {
		TreeOrders tree = new TreeOrders();
		tree.read();
		print(tree.inOrder());
		print(tree.preOrder());
		print(tree.postOrder());
	}
}
