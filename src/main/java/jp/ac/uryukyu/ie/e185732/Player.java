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
     * @param defense プレイヤーのポケモンの防御力
     */
    public Player (String name, int maximumHP, int attack, int defense) {
        super(name,maximumHP,attack,defense);
    }

    /**
     * 対象へ攻撃するメソッド。（以下４つのメソッド。）
     * offensiveに応じて乱数でダメージを算出し、opponent.wounded()によりダメージを処理。
     * @param opponent 攻撃対象
     */

    //かえんほうしゃ
    public void Flamethrower (LivingThing opponent){
        if ( isDead() == false ) {
            int offensive = getAttack();
            int damage = (int) (Math.random() * offensive +1)*2;
            System.out.printf("%sのかえんほうしゃ！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    //フレアドライブ
    public void FlareBlitz (LivingThing opponent) {
        if ( isDead() == false ) {
            int offensive = getAttack();
            int damage = (int) (Math.random() * offensive + 1)*3;
            System.out.printf("%sのフレアドライブ！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    //きりさく
    public void Slash (LivingThing opponent) {
        if ( isDead() == false ) {
            int offensive = getAttack();
            int damage = (int) (Math.random() * offensive + 1);
            System.out.printf("%sのきりさく！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    //そらをとぶ
    public void Fly (LivingThing opponent) {
        if ( isDead() == false ) {
            int offensive = getAttack();
            int damage = (int) (Math.random() * offensive + 1)*2;
            System.out.printf("%sのそらをとぶ！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
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
        int def_val = getDefense();

        if (def_val == 0) {
            num -= damage;
            setHitPoint(num);
        }

        if (def_val == 1) {
            num -= (damage /= 2);
            setHitPoint(num);
            System.out.printf("プレイヤーの%sは防御している。\n", getName());
            def_val = 0;
            setDefense(def_val);
        }

        if( num < 0 ) {
            setDead(true);
            System.out.printf("プレイヤーの%sは倒れた。\nプレイヤーは目の前が真っ暗になった。\n", getName());
        }
    }
}