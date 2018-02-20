package fr.ul.cassebrique.Models.brick;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import fr.ul.cassebrique.Models.GameWorld;

public class EmptyBrick extends Brick{

    public EmptyBrick(int x, int y) {
        super(x, y, 0);
    }

    @Override
    public void draw(SpriteBatch sb) {
    }

    @Override
    public void addBody(GameWorld gw) {
    }
}
