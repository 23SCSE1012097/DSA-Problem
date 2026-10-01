import java.util.*;

class TweetCounts {

    private Map<String, List<Integer>> tweets;

    public TweetCounts() {
        tweets = new HashMap<>();
    }

    public void recordTweet(String tweetName, int time) {
        tweets.putIfAbsent(tweetName, new ArrayList<>());
        tweets.get(tweetName).add(time);
    }

    public List<Integer> getTweetCountsPerFrequency(
        String freq,
        String tweetName,
        int startTime,
        int endTime
    ) {
        int chunkSize;

        if (freq.equals("minute")) {
            chunkSize = 60;
        } else if (freq.equals("hour")) {
            chunkSize = 3600;
        } else {
            chunkSize = 86400;
        }

        int chunks = (endTime - startTime) / chunkSize + 1;

        int[] count = new int[chunks];

        if (tweets.containsKey(tweetName)) {
            for (int time : tweets.get(tweetName)) {
                if (time >= startTime && time <= endTime) {
                    int index = (time - startTime) / chunkSize;
                    count[index]++;
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int value : count) {
            result.add(value);
        }

        return result;
    }
}