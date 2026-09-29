class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long min = 1;
        long max = (long) minValue(time) * totalTrips;

        while (min < max) {
            long mid = min + (max - min) / 2;

            long trips = 0;

            for (int t : time) {
                trips += mid / t;

                if (trips >= totalTrips) {
                    break;
                }
            }

            if (trips >= totalTrips) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }

    private int minValue(int[] time) {
        int min = time[0];

        for (int t : time) {
            min = Math.min(min, t);
        }

        return min;
    }
}