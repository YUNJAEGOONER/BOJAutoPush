import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-- > 0){
            int pnum = sc.nextInt();
            Map<String, List<String>> mmap = new HashMap<String, List<String>>();
            for(int i = 0 ; i < pnum ; i++){
                String name = sc.next();
                String type = sc.next();
                if(!mmap.containsKey(type)){
                    List<String> nlist = new ArrayList<>();
                    nlist.add(name);
                    mmap.put(type, nlist);
                }
                else{
                    mmap.get(type).add(name);
                }
            }

            int result = 1;
            for(String type : mmap.keySet()){
                result *= (mmap.get(type).size() + 1);
            }
            System.out.println(result - 1);
        }
    }
}
