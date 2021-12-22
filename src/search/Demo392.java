package search;

public class Demo392 {
        public static boolean isSubsequence(String s, String t) {
            int sIndex=0;
            int tIndex=0;
            while (tIndex<t.length() && sIndex<s.length()){
                if(t.charAt(tIndex) == s.charAt(sIndex)){
                    sIndex++;
                }
                tIndex++;
            }
            if(sIndex==s.length()){
                return true;
            }
            return false;
        }

    public static void main(String[] args) {
        isSubsequence("abc","ahbgdc");
    }
}
