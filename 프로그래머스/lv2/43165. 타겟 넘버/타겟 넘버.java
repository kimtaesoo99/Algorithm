class Solution {
    static int result = 0;

    public int solution(int[] numbers, int target) {

        DFS(numbers, 0, target, 0);

        return result;
    }

    static void DFS(int[] numbers, int index, int target, int sum) {
        if (index == numbers.length) {
            if (target == sum) {
                result++;
            }
        } else {
            DFS(numbers, index + 1, target, sum + numbers[index]);
            DFS(numbers, index + 1, target, sum - numbers[index]);
        }
    }
}
