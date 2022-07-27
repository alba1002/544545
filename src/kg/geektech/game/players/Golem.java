package kg.geektech.game.players;

public class Golem extends Hero{
    private int defender;

    public int getDefender() {
        return defender;
    }

    public void setDefender(int defender) {
        this.defender = defender;
    }

    public Golem(int health, int damage) {
        super(health, damage, SuperAbility.DEFENDER);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (this.getHealth() > 0 && this != heroes[i] && boss.getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - (boss.getDamage() - 10));
                setDefender(boss.getDamage() / 5);
                heroes[i].setHealth(heroes[i].getHealth() - (heroes.length * getDefender()));
            }
        }
    }
}
