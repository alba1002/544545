package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Thor extends Hero{
    private boolean deafening;

    public Thor(int health, int damage) {
        super(health, damage, SuperAbility.DEAFENING);
    }

    public boolean isDeafening() {
        return deafening;
    }

    public void setDeafening(boolean deafening) {
        this.deafening = deafening;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        boolean trueFalseDeafening = RPG_Game.random.nextBoolean();
        this.setDeafening(trueFalseDeafening);
        for (int i = 0; i < heroes.length; i++) {
            if(heroes[i].getHealth() > 0 && this == heroes[i] && this.isDeafening() == true){
                boss.setDamage(0);
            } else {
                boss.setDamage(50);
            }
        }

    }
}
