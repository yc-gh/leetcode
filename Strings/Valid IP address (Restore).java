// https://www.interviewbit.com/problems/valid-ip-addresses/

public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<>();
        backtrack(s, 0, 0, res, new StringBuilder());
        return res;
    }

    private void backtrack(String s, int start, int level, ArrayList<String> res, StringBuilder sb) {
        if (start > s.length() || level > 4)
            return;
        else if (start == s.length() && level == 4) {
            res.add(sb.toString());
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (start + i > s.length())
                break;
            String temp = s.substring(start, start + i);
            int num = Integer.parseInt(temp);
            if ((i == 1) || (i == 2 && num >= 10 && num <= 99) || (i == 3 && num >= 100 && num <= 255)) {
                sb.append(temp);
                if (level < 3)
                    sb.append(".");
                backtrack(s, start + i, level + 1, res, sb);
                if (level < 3)
                    sb.setLength(sb.length() - 1);
                sb.setLength(sb.length() - temp.length());
            }
        }
    }
}
