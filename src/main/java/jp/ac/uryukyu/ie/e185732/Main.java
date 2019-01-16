package jp.ac.uryukyu.ie.e185732;

import java.util.Scanner;

/**
 * Pokemon Battle.
 */
public class Main {
    public static void main(String[] args){
        Player player = new Player("プレイヤー", 10, 5);
        Enemy enemy = new Enemy("スライム", 6, 3);

        System.out.printf("%s vs. %s\n", player.getName(), enemy.getName());

        int turn = 0;
        while( player.isDead() == false && enemy.isDead() == false ){
            turn++;
            System.out.printf("\n%dターン目開始！\nプレイヤーはどうする？\n1.たたかう 2.ぼうぎょ\n", turn);
            Scanner scan = new Scanner(System.in);
            int val = scan.nextInt();

            switch (val){
                case 1:
                    System.out.println("1.かえんほうしゃ 2.ほのおパンチ 3.はたく 4.たいあたり");

                    Scanner scn = new Scanner(System.in);
                    int num = scn.nextInt();

                    switch (num){
                        case 1:
                            player.attack(enemy);
                            break;
                        case 2:
                            player.attack(enemy);
                            break;
                        case 3:
                            player.attack(enemy);
                            break;
                        case 4:
                            player.attack(enemy);
                            break;
                    }
                    break;
                case 2:
                    System.out.println("プレイヤーは防御をした。");
                    player.defend("も");
                    break;
            }

            //player.attack(enemy);
            enemy.attack(player);
            player.getHitPoint();
        }
        System.out.println("戦闘終了");
    }
}