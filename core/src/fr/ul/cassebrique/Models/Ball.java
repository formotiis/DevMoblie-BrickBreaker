package fr.ul.cassebrique.Models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.*;
import fr.ul.cassebrique.DataFactories.TextureFactory;

public class Ball {

    private static float rayon = 12f;
    private GameWorld gw;
    private Body body;
    private int[] pos;
    private Texture tex;

    public Ball(GameWorld gw, int x, int y) {
        this.gw = gw;
        this.pos = new int[2];
        this.pos[0] = x;
        this.pos[1] = y;
        this.tex = TextureFactory.getTexBall();
        BodyDef bd = new BodyDef();
        bd.type = BodyDef.BodyType.DynamicBody;

        bd.bullet = true;
        bd.fixedRotation = false;
        FixtureDef fd = new FixtureDef();
        fd.shape = new CircleShape();
        fd.shape.setRadius(rayon * gw.getPixelsToMeters());
        fd.density = 1f;
        fd.restitution = 1f;
        fd.friction = 0f;
        body = gw.getWorld().createBody(bd);
        body.createFixture(fd);

        body.setUserData(this);
        body.setTransform(x * gw.getPixelsToMeters(), y * gw.getPixelsToMeters(), 0f);
    }

    public void place(int x, int y){
        body.setTransform(x * gw.getPixelsToMeters(), y * gw.getPixelsToMeters(), 0f);
    }

    public void draw(SpriteBatch sb){
        sb.draw(tex, (body.getPosition().x*gw.getMetersToPixels()-12), (body.getPosition().y*gw.getMetersToPixels()-12));
    }

    public void setSpeed(float x, float y) {
        body.setLinearVelocity(x * gw.getPixelsToMeters(), y * gw.getPixelsToMeters());
    }

    public void setSpeedFloat(float x, float y) {
        body.setLinearVelocity(x , y );
    }

    public float getSpeedX(){
        return body.getLinearVelocity().x;
    }

    public float getSpeedY(){
        return body.getLinearVelocity().y;
    }

    public boolean ballOut(){
        return body.getPosition().y < -0.15f;
    }

    public void remBody(World wd){
        wd.destroyBody(body);
        body.setUserData(null);
        body = null;
    }

}
