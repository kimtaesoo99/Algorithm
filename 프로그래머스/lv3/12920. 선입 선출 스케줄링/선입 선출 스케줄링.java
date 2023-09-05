class Solution {
    public int solution(int n, int[] cores) {
        int answer = 0;
        int min = 0;
        int max = cores[0] * n;
        int time = 0;
        int work = 0;

        while (min <= max) {
            int mid = (min + max) / 2;

            int count = countWork(mid, cores);

            if (count >= n) {
                max = mid - 1;
                time = mid;
                work = count;
            } else {
                min = mid + 1;
            }
        }

        work -= n;

        for (int i = cores.length - 1; i >= 0; i--) {
            if (time % cores[i] == 0) {
                if (work == 0) {
                    answer = i + 1;
                    break;
                }
                work--;
            }
        }

        return answer;
    }

    private int countWork(int time, int[] cores) {
        if (time == 0) {
            return cores.length;
        }

        int count = cores.length;

        for (int core : cores) {
            count += (time / core);
        }

        return count;
    }
}
