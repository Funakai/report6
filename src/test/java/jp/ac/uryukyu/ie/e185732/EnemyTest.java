package jp.ac.uryukyu.ie.e185732;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {
    /**
     * 敵が死んだら攻撃ができないことを確認。死亡判定の確認。
     */
    @Test
    public void hyperBeam() {
        int playerHP = 50;
        Player player = new Player("リザードン", playerHP, 9, 0);
        Enemy enemy = new Enemy("フシギバナ", 88, 7, 0);
        enemy.setDead(true);
        
        if(enemy.isDead() == false ){
            for ( int i = 0; i < 5; ++i ){
                enemy.HyperBeam(player);//複数回実行して攻撃してみる
            }
        }
        assertEquals(playerHP, player.getHitPoint());
    }
}