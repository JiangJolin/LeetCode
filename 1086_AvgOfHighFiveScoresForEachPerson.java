import java.util.*;

//Definition for a Record
class Record {
    public int id, score;

    public Record(int id, int score) {
        this.id = id;
        this.score = score;
    }
}

public class Solution {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person Map<Integer,
     *         Double> (student_id, average_score)
     */
    static Comparator<Record> cmp = new Comparator<Record>() {
        public int compare(Record a, Record b) {
            return a.score - b.score;
        }
    };

    public static Map<Integer, Double> highFive(Record[] results) {
        Map<Integer, Double> result = new HashMap<>();
        Map<Integer, PriorityQueue<Record>> hm = new HashMap<>();
        for (int i = 0; i < results.length; i++) {
            if (hm.containsKey(results[i].id)) {
                if (hm.get(results[i].id).size() < 5) {
                    hm.get(results[i].id).add(results[i]);
                } else {
                    PriorityQueue<Record> pq = hm.get(results[i].id);
                    if (pq.peek().score < results[i].score) {
                        pq.poll();
                        pq.add(results[i]);
                    }
                }
            } else {
                hm.put(results[i].id, new PriorityQueue<>(5, cmp));
                hm.get(results[i].id).add(results[i]);
            }
        }
        for (Integer i : hm.keySet()) {
            int sum = 0;
            PriorityQueue<Record> q = hm.get(i);
            for (int j = 0; j < 5; j++) {
                Record r = q.poll();
                sum += r.score;
            }
            double average = sum / 5.0;
            result.put(i, average);
        }
        return result;
    }

    public static void main(String[] args) {
        Random r = new Random();
        int[] person = new int[3];
        int count = 0;
        for (int i = 0; i < 3; i++) {
            person[i] = r.nextInt(3) + 5;
            count += person[i];
        }
        Record[] results = new Record[count];
        count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < person[i]; j++) {
                Record temp = new Record(i, r.nextInt(40) + 60);
                results[count] = temp;
                count++;
            }
        }
        for (int i = 0; i < count; i++) {
            System.out.printf("[%d, %d]\n", results[i].id, results[i].score);
        }
        Map<Integer, Double> result = highFive(results);
        for (Map.Entry<Integer, Double> entry : result.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }

    }
}
