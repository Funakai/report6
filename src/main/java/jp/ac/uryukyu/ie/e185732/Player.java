package jp.ac.uryukyu.ie.e185732;

/**
 * プレイヤークラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 */
public class Player extends LivingThing {

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name プレイヤーのポケモン名
     * @param maximumHP プレイヤーのポケモンのHP
     * @param attack プレイヤーのポケモンの攻撃力
     */
    public Player (String name, int maximumHP, int attack) {
        super(name,maximumHP,attack);
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        int num = getHitPoint();
        num -= damage;
        setHitPoint(num);
        if( num < 0 ) {
            setDead(true);
            System.out.printf("プレイヤー%sは道半ばで力尽きてしまった。\n", getName());
        }
    }

}