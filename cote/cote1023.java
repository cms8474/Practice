import java.util.*;

public class cote1023{
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 줄넘김

        //////////////////////////
        Map<Integer, String> h = new HashMap<>(){{
            put(1, "one");
            put(2, "two");
        }};
        h.put(3, "three");
        h.put(4, "four");
        System.out.println(h.get(1));
        


        //////////////////////////


        //
        int result1 = solution.solution(1);
        //System.out.println(result1);
        
    }
}

class Solution{
    public int solution(int num){
        //System.out.println("test");
        int[] arr = {0, 1, 2, 3};

        return arr[num];
    }
}


