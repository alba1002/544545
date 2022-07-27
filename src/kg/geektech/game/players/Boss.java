package kg.geektech.game.players;

public class Boss extends GameEntity {
    public Boss(int health, int damage) {
        super(health, damage);
    }

    public void hit(Hero[] heroes) {
        if (this.getHealth() > 0) {
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getHealth() > 0) {
                    if (heroes[i] instanceof Berserk) {
                        heroes[i].setHealth(heroes[i].getHealth()
                                - this.getDamage() / 2);
                        ((Berserk) heroes[i]).setSaved_damage(this.getDamage() / 2);
                    } else {
                        heroes[i].setHealth(heroes[i].getHealth()
                                - this.getDamage());
                    }
                }
            }
        }
    }
}
