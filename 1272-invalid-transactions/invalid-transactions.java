import java.util.*;

class Solution {
    
    // Helper class to store parsed transaction details
    private static class Transaction {
        int index;
        String name;
        int time;
        int amount;
        String city;
        String raw;

        public Transaction(int index, String raw) {
            this.index = index;
            this.raw = raw;
            String[] parts = raw.split(",");
            this.name = parts[0];
            this.time = Integer.parseInt(parts[1]);
            this.amount = Integer.parseInt(parts[2]);
            this.city = parts[3];
        }
    }

    public List<String> invalidTransactions(String[] transactions) {
        List<Transaction> list = new ArrayList<>();
        for (int i = 0; i < transactions.length; i++) {
            list.add(new Transaction(i, transactions[i]));
        }

        Set<Integer> invalidIndices = new HashSet<>();

        for (int i = 0; i < list.size(); i++) {
            Transaction t1 = list.get(i);

            // Condition 1: Amount exceeds $1000
            if (t1.amount > 1000) {
                invalidIndices.add(t1.index);
            }

            // Condition 2: Check against all other transactions
            for (int j = 0; j < list.size(); j++) {
                if (i == j) continue;
                Transaction t2 = list.get(j);

                // Same name, different city, and time difference <= 60 minutes
                if (t1.name.equals(t2.name) && 
                    !t1.city.equals(t2.city) && 
                    Math.abs(t1.time - t2.time) <= 60) {
                    invalidIndices.add(t1.index);
                    break; // Once marked invalid, no need to check further for t1
                }
            }
        }

        // Collect the original strings of invalid transactions
        List<String> result = new ArrayList<>();
        for (int idx : invalidIndices) {
            result.add(transactions[idx]);
        }

        return result;
    }
}