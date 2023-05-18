class Solution {
    public long solution(int[] sequence) {
        int[] firstSequence = new int[sequence.length];
        int[] secondSequence = new int[sequence.length];

        for (int i = 0; i < sequence.length; i++) {
            if (i % 2 == 0) {
                firstSequence[i] = sequence[i];
                secondSequence[i] = (sequence[i] * (-1));
                continue;
            }
            firstSequence[i] = (sequence[i] * (-1));
            secondSequence[i] = sequence[i];
        }

        return Math.max(findMax(firstSequence), findMax(secondSequence));
    }

    private long findMax(int[] sequence) {
        long max = 0;
        long sum = 0;

        for (int i = 0; i < sequence.length; i++) {
            sum += sequence[i];
            if (max < sum) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}