import java.util.Arrays;

class Solution {
    public String[] solution(String[] files) {

        File[] result = new File[files.length];
        for (int i = 0; i < files.length; i++) {
            result[i] = division(files[i], i);
        }
        
        return Arrays.stream(result)
                .sorted()
                .map(file -> file.result)
                .toArray(String[]::new);
    }

    private File division(String file, int index) {
        StringBuilder sb = new StringBuilder();
        File nowFile = new File();
        nowFile.count = index;
        int num = 0;
        for (int i = 0; i < file.length(); i++) {
            char now = file.charAt(i);
            if (num == 0 && Character.isDigit(now)) {
                nowFile.head = sb.toString();
                num++;
                sb.setLength(0);
            } else if (num == 1 && !Character.isDigit(now)) {
                nowFile.number = sb.toString();
                num++;
                sb.setLength(0);
            }
            sb.append(now);
        }
        if (nowFile.number.equals("")) {
            nowFile.number = sb.toString();
        } else {
            nowFile.tail = sb.toString();
        }
        nowFile.setResult();
        return nowFile;
    }
}

class File implements Comparable<File> {
    String head = "";
    String number = "";
    String tail = "";
    int count;
    String result;

    public void setResult() {
        result = head + number + tail;
    }

    @Override
    public int compareTo(File o) {
        String str1 = this.head.toUpperCase();
        String str2 = o.head.toUpperCase();
        if (str1.equals(str2)) {
            int num1 = Integer.parseInt(this.number);
            int num2 = Integer.parseInt(o.number);
            if (num1 == num2) {
                return this.count - o.count;
            }
            return num1 - num2;
        }
        return str1.compareTo(str2);
    }
}