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
     * 対象へ攻撃するメソッド。（以下４つのメソッド。）
     * offensiveに応じて乱数でダメージを算出し、opponent.wounded()によりダメージ処理を実行。
     * @param opponent 攻撃対象
     */

    //ソーラービーム
    public void SolarBeam (LivingThing opponent) {
        if (isDead() == false) {
            int offensive = getAttack();
            int damage = (int) (Math.random() * offensive) + 15;
            System.out.printf("敵の%sのソーラービーム！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    //ヘドロばくだん
    public void SludgeBomb (LivingThing opponent) {
        if (isDead() == false) {
            int offensive = getAttack();
            int damage = (int) (Math.random() * offensive) + 5;
            System.out.printf("敵の%sのヘドロばくだん！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    //はかいこうせん
    public void HyperBeam (LivingThing opponent) {
        if (isDead() == false) {
            int offensive = getAttack();
            int damage = (int) (Math.random() * offensive) + 20;
            System.out.printf("敵の%sのはかいこうせん！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    //じしん
    public void Earthquake (LivingThing opponent) {
        if (isDead() == false) {
            int offensive = getAttack();
            int damage = (int) (Math.random() * offensive) + 10;
            System.out.printf("敵の%sのじしん！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
            opponent.wounded(damage);
        }
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