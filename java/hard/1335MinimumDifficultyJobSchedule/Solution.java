public class Solution {

    static class CacheKey {
        private int pos;
        private int days;
        private int cm;

        public CacheKey(int pos, int days, int cm) {
            this.pos = pos;
            this.days = days;
            this.cm = cm;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            CacheKey cacheKey = (CacheKey) o;
            return pos == cacheKey.pos && days == cacheKey.days && cm == cacheKey.cm;
        }

        @Override
        public int hashCode() {
            return Objects.hash(pos, days, cm);
        }
    }

    private HashMap<CacheKey, Integer> cache = new HashMap<>();

    public int minDifficulty(int[] jobDifficulty, int d) {
        if (d > jobDifficulty.length) {
            return -1;
        }
        return this.split(d, jobDifficulty, 0, 0, jobDifficulty[0]);
    }

    private int split(int d, int[] jobDifficulty, int pos, int daysPassed, int currentDayMax) {

        CacheKey key = new CacheKey(pos, daysPassed, currentDayMax);
        Integer val = cache.get(key);

        if (val != null) {
            return val;
        }

        if (pos == jobDifficulty.length - 1) {
            if (daysPassed + 1 == d) {
                cache.put(key, currentDayMax);
                return currentDayMax;
            } else {
                cache.put(key, -1);
                return -1;
            }
        }

        if (daysPassed + 1 + jobDifficulty.length - (pos + 1) < d || daysPassed >= d) {
            cache.put(key, -1);
            return -1;
        }

        int prolongedDay = this.split(d, jobDifficulty, pos + 1, daysPassed, Math.max(currentDayMax, jobDifficulty[pos + 1]));
        int newDay = this.split(d, jobDifficulty, pos + 1, daysPassed + 1, jobDifficulty[pos + 1]);

        if (prolongedDay == -1 && newDay == -1) {
            cache.put(key, -1);
            return -1;
        }

        if (prolongedDay == -1) {
            cache.put(key, newDay + currentDayMax);
            return newDay + currentDayMax;
        }
        if (newDay == -1) {
            cache.put(key, prolongedDay);
            return prolongedDay;
        }

        int min = Math.min(prolongedDay, newDay + currentDayMax);
        cache.put(key, min);
        return min;
    }
}