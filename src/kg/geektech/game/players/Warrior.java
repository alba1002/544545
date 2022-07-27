package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Warrior extends Hero {
    private int CriticalDamage;

    public Warrior(int health, int damage) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE);
    }


    public int getCriticalDamage() {
        return CriticalDamage;
    }

    public void setCriticalDamage(int criticalDamage) {
        CriticalDamage = criticalDamage;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        //this logic is realized in hit method
    }

    public void hit (Boss boss){
        if(this.getHealth() > 0 && boss.getHealth() > 0){
            int coefficient = RPG_Game.random.nextInt(2) + 2;
            boss.setHealth(boss.getHealth() - (this.getDamage() * coefficient));
        }
    }
}
