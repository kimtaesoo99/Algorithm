import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        List<Homework> list = new ArrayList<>();

        for (String[] plan : plans) {
            String name = plan[0];
            String[] startTimeInfo = plan[1].split(":");
            int startTime = Integer.parseInt(startTimeInfo[0]) * 60 + Integer.parseInt(startTimeInfo[1]);
            int remainTime = Integer.parseInt(plan[2]);
            list.add(new Homework(name, startTime, remainTime));
        }
        Collections.sort(list);
        Stack<Homework> stack = new Stack<>();

        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (!stack.isEmpty()) {
                int gap = list.get(i).startTime - stack.peek().startTime;
                while (gap > 0) {
                    if (stack.isEmpty()) {
                        break;
                    }
                    int pre = stack.peek().remainTime;
                    stack.peek().remainTime -= gap;
                    gap -= pre;

                    if (stack.peek().remainTime <= 0) {
                        answer[index++] = stack.pop().name;
                    }
                }
            }
            stack.add(list.get(i));
        }
        while (!stack.isEmpty()) {
            answer[index++] = stack.pop().name;
        }
        return answer;
    }
}

class Homework implements Comparable<Homework> {
    public String name;
    public int startTime;
    public int remainTime;

    @Override
    public int compareTo(Homework h) {
        return this.startTime - h.startTime;
    }

    public Homework(String name, int startTime, int remainTime) {
        this.name = name;
        this.startTime = startTime;
        this.remainTime = remainTime;
    }
}