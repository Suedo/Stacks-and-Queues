public class Subset {
	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);
		// System.out.println(" num is : " + num);

		// System.out.print("enter string input: ");
		String line = StdIn.readLine();
		String[] ip = line.split("[ ]+");

		int N = ip.length;
		for (int i = 0; i < N; i++) {
			int r = i + StdRandom.uniform(N - i); // between i and N-1
			String temp = ip[i];
			ip[i] = ip[r];
			ip[r] = temp;
		}
		// System.out.print("displaying shuffled input: ");
		// for(String i : ip)
		// System.out.print(" " + i);

		// System.out.print("\n\n\n displaying required output: ");
		for (int i = 0; i < num; i++) {
			System.out.println(ip[i]);
		}

	}

}
