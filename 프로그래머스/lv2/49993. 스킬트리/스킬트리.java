class Solution {
    public int solution(String skill, String[] skill_trees) {
        int result = 0;
        for(String nowSkill : skill_trees){
            String tempSkill = nowSkill;

            for (int i = 0; i < nowSkill.length(); i++){
                String now = String.valueOf(nowSkill.charAt(i));
                if (!skill.contains(now)){
                    tempSkill = tempSkill.replace(now,"");
                }
            }
            if (skill.indexOf(tempSkill)==0)result++;
        }
        return result;
    }
}