package fightinggame.game;

import java.util.ArrayList;

public class Terrain extends WorldEntity{
    private Effectbox hitBox;

    public Terrain(String name, ArrayList<Integer> pos, int width, int height) {
        super(name, pos);
        this.hitBox = new Effectbox(this, getPoint(), false, width, height);
    }

    public Effectbox getHitBox() {
        return hitBox;
    }
    
    public boolean hitboxCollision(Effectbox effectbox) {
        // TODO DELEGATE LOGIC TO EFFECTBOX
        //NB: SJEKKER BARE FOR UNDER Y AKKURAT NÅ
        if ((effectbox.getPosY() + effectbox.getHeight() + 3) > (hitBox.getPosY()) && (effectbox.getPosY() < (hitBox.getPosY() + hitBox.getHeight()))) {
            if ((hitBox.getPosX() < (effectbox.getPosX() + effectbox.getWidth())) && 
            ((hitBox.getPosX() + hitBox.getWidth()) > (effectbox.getPosX()))) {
                return true;
            }
        }
        return false;
    }
    
    
}
