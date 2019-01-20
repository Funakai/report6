package jp.ac.uryukyu.ie.e185732;

/**
 * 敵クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 */
public class Enemy extends LivingThing {

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name 敵のポケモン名
     * @param maximumHP 敵のポケモンのHP
     * @param attack 敵のポケモンの攻撃力
     * @param defense 敵のポケモンの防御力
     */
    public Enemy (String name, int maximumHP, int attack, int defense) {
        super(name,maximumHP,attack,defense);
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
            System.out.printf("相手の%sは倒れた。\nプレイヤーは勝利した。", getName());
        }
    }
}