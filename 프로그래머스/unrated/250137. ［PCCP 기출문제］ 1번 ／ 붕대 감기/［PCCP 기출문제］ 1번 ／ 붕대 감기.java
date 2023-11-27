class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int nowHP = health;
        int preAttacktime = 0;

        for (int[] attack : attacks) {
            int attackTime = attack[0];
            int damage = attack[1];

            int healTime = attackTime - preAttacktime;

            nowHP += ((healTime * bandage[1]) + (healTime / bandage[0]) * bandage[2]);

            if (nowHP > health) {
                nowHP = health;
            }

            nowHP -= damage;

            if (nowHP <= 0) {
                return -1;
            }

            preAttacktime = attackTime + 1;
        }

        if (nowHP <= 0) {
            return -1;
        }

        return nowHP;
    }
}
