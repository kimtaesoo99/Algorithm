import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

class Solution {
    static HashMap<Integer, String> matchingTimeAndTitle = new HashMap<>();

    public String solution(String m, String[] musicInfos) {
        for (String musicInfo : musicInfos) {
            findMatchMusic(m, musicInfo);
        }

        Optional<Entry<Integer, String>> max = matchingTimeAndTitle
                .entrySet()
                .stream()
                .max(Comparator.comparingInt(Entry::getKey));
        
        return max.map(Map.Entry::getValue)
                .orElse("(None)");
    }

    private void findMatchMusic(String m, String music) {
        String[] musicInfo = music.split(",");

        m = changeMusic(m);
        String target = changeMusic(musicInfo[3]);

        int runtime = findRuntime(musicInfo[0], musicInfo[1]);

        StringBuilder totalMusic = new StringBuilder();
        for (int i = 0; i < runtime; i++) {
            totalMusic.append(target.charAt(i % target.length()));
        }

        if (isCorrectMatchingMusic(totalMusic, m, runtime)) {
            matchingTimeAndTitle.put(runtime, musicInfo[2]);
        }
    }

    private String changeMusic(String music) {
        return music.replace("A#", "H")
                .replace("C#", "I")
                .replace("D#", "J")
                .replace("F#", "K")
                .replace("G#", "L");
    }

    private int findRuntime(String startTime, String endTime) {
        String[] endTimeSplit = endTime.split(":");
        String[] startTimeSplit = startTime.split(":");

        int endHour = Integer.parseInt(endTimeSplit[0]);
        int endMinute = Integer.parseInt(endTimeSplit[1]);
        int startHour = Integer.parseInt(startTimeSplit[0]);
        int startMinute = Integer.parseInt(startTimeSplit[1]);

        int end = endHour * 60 + endMinute;
        int start = startHour * 60 + startMinute;

        return end - start;
    }

    private boolean isCorrectMatchingMusic(StringBuilder totalMusic, String m, int runtime) {
        return totalMusic.toString().contains(m) && !matchingTimeAndTitle.containsKey(runtime);
    }
}