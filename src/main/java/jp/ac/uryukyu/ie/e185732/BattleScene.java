package jp.ac.uryukyu.ie.e185732;

import java.util.Scanner;

/**
 * 戦闘画面を進めるためのクラス。主にゲームの進行。
 * 数字を入力して、攻撃か防御か選択できる。攻撃を選択した場合、技が選べる。
 */
public class BattleScene {

    /**
     * プレイヤー自身が戦闘を進めるメソッド。
     * @param player プレイヤーのインスタンス。
     * @param enemy 敵のインスタンス。
     */
    public static void PlayerBattle(Player player, Enemy enemy) {

        Scanner scan = new Scanner(System.in);
        int val = scan.nextInt();

        switch (val) {
            case 1:
                System.out.println("1.かえんほうしゃ 2.フレアドライブ 3.きりさく 4.そらをとぶ");
                Scanner scn = new Scanner(System.in);
                int num = scn.nextInt();

                switch (num) {
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
    }

    /**
     * 敵自身が戦闘を進めるメソッド。ランダム変数を使って行動を行う。攻撃のみ。
     * @param player プレイヤーのインスタンス。
     * @param enemy 敵のインスタンス。
     */
    public static void EnemyBattle(Player player, Enemy enemy){

        int number = (int) (Math.random() * 4 )+ 1;

        switch (number) {
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
    }
}