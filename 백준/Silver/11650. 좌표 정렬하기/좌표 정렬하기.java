import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		TreeMap <Integer, ArrayList<Integer>> hmap = new TreeMap<>();
		
		int x,y;
		while(n > 0) {
			x = sc.nextInt();
			y = sc.nextInt();
			if(hmap.containsKey(x)) {
				hmap.get(x).add(y);
			}
			else {
				ArrayList<Integer> arr = new ArrayList<Integer>();
				hmap.put(x, arr);
				hmap.get(x).add(y);
			}
			n = n - 1;
		}
		
		
		for(Integer key : hmap.keySet()) {
			ArrayList<Integer> arr = hmap.get(key);
			Collections.sort(arr);
			for(Integer value : arr) {
				System.out.println(key + " " + value);
			}
		}
		
		
	}
}
