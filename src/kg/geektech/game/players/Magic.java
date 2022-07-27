package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Magic extends Hero {
    private int boostDamage;

    public Magic(int health, int damage) {
        super(health, damage, SuperAbility.BOOST);
    }

    public int getBoostDamage() {
        return boostDamage;
    }

    public void setBoostDamage(int boostDamage) {
        this.boostDamage = boostDamage;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            int boost = RPG_Game.random.nextInt(3) + 2;
            this.setBoostDamage(boost);
            if (this.getHealth() > 0 && heroes[i].getHealth() > 0 && this != heroes[i]) {
                heroes[i].setDamage(heroes[i].getDamage() + getBoostDamage());
            }
        }
    }
}