class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        for (int i = 0; i < piles.length; i++) {
            high = Math.max(piles[i], high);
        }

        high++;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (isPossible(piles, h, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    boolean isPossible(int[] piles, int h, int mid){

        for(int i = 0; i<piles.length;i++){
            h -= (piles[i] + mid -1)/mid;
        }

        return h >= 0;
    }
}
