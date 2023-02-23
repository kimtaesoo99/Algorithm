import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String,Integer> map = new HashMap<>();
        List<Song> lists = new ArrayList<>();
        for(int i = 0 ; i < genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            map.put(genre,map.getOrDefault(genre,0)+play);
            lists.add(new Song(i,genre,play));
        }
        Collections.sort(lists);

        List<String> sortedGenre = new ArrayList<>();
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(i-> sortedGenre.add(i.getKey()));

        StringBuilder sb = new StringBuilder();
        for(int i = sortedGenre.size()-1; i >=0; i--){
            String genre = sortedGenre.get(i);
            int size = 0;
            for (int j = 0 ; j < lists.size(); j++){
                if (lists.get(j).genre.equals(genre)){
                    sb.append(lists.get(j).number).append(" ");
                    size++;
                }
                if (size==2)break;
            }
        }
        return Arrays.stream(sb.toString().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}


class Song implements Comparable<Song>{
    int number;
    String genre;
    int play;

    @Override
    public int compareTo(Song s){
        if (this.number == s.number) return this.number - s.number;
        return s.play - this.play;
    }


    public Song(int number, String genre, int play){
        this.number = number;
        this.genre = genre;
        this.play = play;
    }
}

