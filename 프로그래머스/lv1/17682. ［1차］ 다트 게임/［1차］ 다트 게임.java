import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


class Solution {
    public int solution(String dartResult) {
        List<Integer> numbers = Arrays.stream(dartResult.replaceAll("S|D|T",",")
                .replaceAll("#|[*]","").split(",")).map(Integer::parseInt).collect(Collectors.toList());

        List<String> option = Arrays.stream(dartResult.replaceAll("S","S,")
                .replaceAll("D","D,").replaceAll("T","T,").split(",",3))
                .collect(Collectors.toList());
        return getScore(numbers,option);
    }

    private int getScore(List<Integer> numbers, List<String> option){
        int first =  getFirstMultiOrMinusScore(getPowScore(numbers.get(0),option.get(0)), option.get(1),option.get(2));
        int second = getSecondMultiOtMinusScore(getPowScore(numbers.get(1),option.get(1)),option.get(2));
        int third = getThirdMultiOrMinusScore(getPowScore(numbers.get(2),option.get(2)),option.get(2));
        return first+second+third;
    }

    private int getPowScore(int score, String option){
        if (option.contains("S")){
            return score;
        }
        if (option.contains("D")){
            return (int) Math.pow(score,2);
        }
        return (int)Math.pow(score,3);
    }

    private int getFirstMultiOrMinusScore(int score,String option,String option2){
        if (option.startsWith("#"))score *= (-1);
        if (option.startsWith("*")) score *= 2;
        if (option2.startsWith("*"))score *= 2;
        return score;
    }
    private int getSecondMultiOtMinusScore(int score,String option){
        if (option.startsWith("#"))score *= (-1);
        if (option.startsWith("*"))score *= 2;
        if (option.endsWith("*"))score *= 2;
        return score;
    }

    private int getThirdMultiOrMinusScore(int score, String option){
        if (option.endsWith("#"))score *=(-1);
        if (option.endsWith("*"))score *=2;
        return score;
    }
}