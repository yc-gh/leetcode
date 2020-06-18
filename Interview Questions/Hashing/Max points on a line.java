//

class Solution {
    public int maxPoints(int[][] points) {
        if(points == null) return 0;
        int n = points.length, result = 0;
        if(n <= 2) return n;
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++)
        {
            map.clear();
            int overlap = 0, max = 0;
            for(int j = i + 1 ; j < n ; j++)
            {
                int x=points[j][0]-points[i][0];
        	    int y=points[j][1]-points[i][1];
        	    if (x==0 && y==0)
                {
        	        overlap++;
                    continue;
        	    }
       		    int gcd = gcd(x,y); // gcd will never be zero.
    		    x/=gcd;
  		        y/=gcd;
                // String key = x + ":" + y;
                String key = new StringBuilder().append(x).append("/").append(y).toString();
                if (map.containsKey(key)) 
                        map.put(key,map.get(key) + 1);
                else 
                    map.put(key, 1);
                max = Math.max(max, map.get(key));
            }
            result = Math.max(result, max+overlap+1);
        }
        return result;
    }
    
    private static int gcd(int a, int b)
    {
        if(b==0) return a;
        return gcd(b,a%b);
    }
}
