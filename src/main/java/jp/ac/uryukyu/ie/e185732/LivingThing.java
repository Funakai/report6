package jp.ac.uryukyu.ie.e185732;

/**
 * 基本的なステータスのクラス。
 *  String name; //名前
 *  int hitPoint; //HP
 *  int attack; //攻撃力
 *  int defense; //防御力
 *  boolean dead; //生死状態。true=死亡。
 */
public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private int defense;
    private boolean dead;

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name ポケモン名
     * @param maximumHP ポケモンのHP
     * @param attack ポケモンの攻撃力
     * @param defense ポケモンの防御力。初期値は0。
     */
    public LivingThing (String name, int maximumHP, int attack, int defense) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        this.defense = defense;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * getterメソッドと同等。生死をboolean表現しているためメソッド名をisDead()とした。
     * @return boolean
     */
    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }


    /**
     * 対象へ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、opponent.wounded()によりダメージ処理を実行。
     * @param opponent 攻撃対象
     */
    public void attack(LivingThing opponent){
        if ( isDead() == false ) {
            int damage = (int)(Math.random() * attack +1);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    /**
     * 自分自身を防御するメソッド。
     * 「2.ぼうぎょ」することで1ターンの間、防御力を1あげる。防御している間はダメージを半減できる。
     */
    public void defend(){
        defense = 1;
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){

        if ( defense == 1) {
            hitPoint -= (damage /= 2);
            System.out.println(name + "は防御している。");
        }
        switch ( defense ){
            case 1:
                hitPoint -= damage;
        } if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }
}