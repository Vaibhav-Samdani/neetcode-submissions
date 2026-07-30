class Solution {

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        

        int[][] pairs = new int[n][2];

        for (int i = 0; i < n; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));

        double lastTime = 0;
        int fleet = 0;

        for (int i = 0; i < n; i++) {
            double time = (target - pairs[i][0])/(double)pairs[i][1];

            if(time > lastTime){
                fleet++;
                lastTime = time;
            }
        }

        return fleet;
    }
}