class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for(int i = 0; i < m;i++){
            freq1[s1.charAt(i)-'a']++;
        }

        int i = 0;

        for(int j =0; j<n;j++){

            freq2[s2.charAt(j)-'a']++;

            while( i<j && j-i+1 > m){
                freq2[s2.charAt(i)-'a']--;
                i++;
            }

            if(j-i + 1 == m){
                if(check(freq1,freq2)){
                    return true;
                }
            }
        }

        return false;
    }

    boolean check(int[] arr1, int[] arr2){
        for(int i = 0; i<arr1.length;i++){
            if(arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}