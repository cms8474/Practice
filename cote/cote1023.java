<<<<<<< HEAD
import java.util.*;
=======
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
>>>>>>> 7e55f61d1a1688bbcd77b1cd8b913ae22133ff75

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
        List<Character> chList = List.of('일', '이', '삼');
        

        

        return chList.size();
    }
}


