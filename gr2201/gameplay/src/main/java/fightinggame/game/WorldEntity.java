package fightinggame.game;

import java.util.ArrayList;
import java.util.function.Predicate;

public abstract class WorldEntity {
	protected int id;
	protected Effectbox hitBox;
	protected Action currentAction = null;
	protected boolean isAlive;
	protected String name;
	protected Point point;

	public WorldEntity(String name, ArrayList<Integer> pos) {
		this.name = name;
		this.point = new Point((double) pos.get(0), (double) pos.get(1));
	}
	    
	public void setOnGround(boolean b) {}
	
	public void setOnRight(boolean b) {}

	public void setOnLeft(boolean b) {}

	public void setOnTop(boolean b) {}

	public void setCurrentAction(Integer actionNumber) {}

	public void doAction(){}

	public Action getAction(int actionNumber) {
        return null;
    }

	public Predicate<String> getPredicate() {
		return null;
	}

	public ArrayList<String> getAvailKeys() {
		return null;
	}

	public int getFacingDirection() {
        return 0;
    }

	public String getName() {
		return name;
	}

	public Point getPoint() {
		return point;
	}

	public Effectbox getHurtBox() {
        return null;
    }

	public Effectbox getHitBox() {
        return null;
    }

	private void setHitBox(Effectbox hitBox) {
		this.hitBox = hitBox;
	}

	public Action getCurrentAction() {
		return currentAction;
	}

	public int getCurrentFrame(){
		return currentAction.getCurrentFrame();
	}

	public boolean isAlive() {
		return isAlive;
	}

	private void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public int getJumpCounter() {
        return 0;
    }

}
