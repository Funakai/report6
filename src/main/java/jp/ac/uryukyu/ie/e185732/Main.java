package jp.ac.uryukyu.ie.e185732;

/**
 * Pokemon Battle.
 */
public class Main {
    public static void main(String[] args){
        Player player = new Player("リザードン", 80, 9,0);
        Enemy enemy = new Enemy("フシギバナ", 88,7,0);

        System.out.printf("%s vs. %s\n", player.getName(), enemy.getName());

        int turn = 0;
        while( player.isDead() == false && enemy.isDead() == false ){
            turn++;
            System.out.printf("\n%dターン目開始！\nプレイヤーはどうする？\n1.たたかう 2.ぼうぎょ\n", turn);

            BattleScene.PlayerBattle(player,enemy);
            BattleScene.EnemyBattle(player,enemy);

            if ( player.isDead() == false && enemy.isDead() == false ){
                System.out.printf("\n%sの残りHPは%d。\n%sの残りHPは%d。\n", player.getName(), player.getHitPoint(), enemy.getName(), enemy.getHitPoint());
            }
        }
        System.out.println("戦闘終了");
    }
}