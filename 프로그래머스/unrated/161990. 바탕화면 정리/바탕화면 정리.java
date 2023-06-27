class Solution {
    public int[] solution(String[] wallpaper) {
        int height1 = wallpaper.length;
        int height2 = 0;
        int width1 = wallpaper[0].length();
        int width2 = 0;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0 ; j < wallpaper[0].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    height1 = Math.min(height1,i);
                    height2 = Math.max(height2,i);
                    width1 = Math.min(width1,j);
                    width2 = Math.max(width2,j);
                }
            }
        }
        return new int[]{height1, width1, height2 + 1, width2 + 1};
    }
}