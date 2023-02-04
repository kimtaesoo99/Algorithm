import java.util.*;


class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new PriorityQueue<>(new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                if (Math.abs((Integer) o1)==Math.abs((Integer) o2)){
                    return ((Integer) o1).compareTo((Integer) o2);
                }
                return Math.abs((Integer) o1)-Math.abs((Integer) o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        for (int i =0; i< N; i++){
            int value = sc.nextInt();
            if (value == 0 && q.isEmpty()) {
                sb.append(0).append("\n");
            } else if (value == 0 && !q.isEmpty()) {
                sb.append(q.poll()).append("\n");
            } else {
                q.add(value);
            }
        }
        System.out.println(sb);
    }

}

