package jp.ac.uryukyu.ie.e185732;

import java.util.Scanner;

/**
 * Pokemon Battle.
 */
public class Main {
    public static void main(String[] args){
        Player player = new Player("リザードン", 78, 9,0);
        Enemy enemy = new Enemy("フシギバナ", 88,7,0);

        System.out.printf("%s vs. %s\n", player.getName(), enemy.getName());

        int turn = 0;
        while( player.isDead() == false && enemy.isDead() == false ){
            turn++;
            System.out.printf("\n%dターン目開始！\nプレイヤーはどうする？\n1.たたかう 2.ぼうぎょ\n", turn);
            Scanner scan = new Scanner(System.in);
            int val = scan.nextInt();

            switch (val){
                case 1:
                    System.out.println("1.かえんほうしゃ 2.フレアドライブ 3.きりさく 4.そらをとぶ");

                    Scanner scn = new Scanner(System.in);
                    int num = scn.nextInt();

                    switch (num){
                        case 1:
                            player.Flamethrower(enemy);
                            break;
                        case 2:
                            player.FlareBlitz(enemy);
                            break;
                        case 3:
                            player.Slash(enemy);
                            break;
                        case 4:
                            player.Fly(enemy);
                            break;
                    }
                    break;
                case 2:
                    player.defend();
                    break;
            }

            int number = (int)(Math.random() * 4 +1);

            switch (number){
                case 1:
                    enemy.SolarBeam(player);
                    break;
                case 2:
                    enemy.SludgeBomb(player);
                    break;
                case 3:
                    enemy.HyperBeam(player);
                    break;
                case 4:
                    enemy.Earthquake(player);
                    break;
            }

            player.getHitPoint();
            enemy.getHitPoint();
        }
        System.out.println("戦闘終了");
    }
}