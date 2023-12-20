package a;

import java.util.Scanner;

public class a1ch1 {

	public static boolean isVowel(int i) {
		if (i == 0 || i == 4 || i == 8 || i == 14 || i == 20)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int t = s.nextInt();

		s.nextLine();
		for (int i = 1; i <= t; ++i) {
			String str = s.nextLine();
			int[] ch = new int[26];

			int conso = 0, vow = 0;

			for (int j = 0; j < str.length(); ++j) {
				int index = str.charAt(j) - 'A';
				ch[index]++;
				if (isVowel(index)) {
					vow++;
				} else {
					conso++;
				}
			}

			int ans = Integer.MAX_VALUE;
			int temp;

			for (int j = 0; j < 26; ++j) {
				if (isVowel(j))
					temp = conso + 2 * (vow - ch[j]);
				else
					temp = vow + 2 * (conso - ch[j]);

				ans = Math.min(ans, temp);
			}

			System.out.println("Case #" + i + ": " + ans);

		}

		s.close();
	}

}
