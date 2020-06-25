// https://www.interviewbit.com/problems/compare-version-numbers/

public class Solution {
    public int compareVersion(String A, String B) {
        String[] v1 = A.split("\\.");
        String[] v2 = B.split("\\.");
        
        int size = Math.max(v1.length, v2.length);
        int i = 0;
        while (i < size){
            try{
            long ver1 = i >= v1.length ? 0 : Long.parseLong(v1[i]);
            long ver2 = i >= v2.length ? 0 : Long.parseLong(v2[i]);
            
            if(ver1 > ver2)
                return 1;
            if(ver1 < ver2)
                return -1;
            }catch(Exception e){
                int r = v1[i].compareTo(v2[i]);
                if(r != 0)
                  return r > 0 ? 1 : -1;
            }
            i++;
        }
        
        return 0;
    }
}
