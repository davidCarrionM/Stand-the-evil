package com.davidcarrion.game.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.davidcarrion.game.Helper.AssetLoader;
import com.davidcarrion.game.Helper.Constant;
import com.davidcarrion.game.Helper.HitParticle;
import com.davidcarrion.game.MyGame;

/**
 * Esta clase define un objeto, un rectangulo que colisionara con el resto de objetos del juego
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class Arrow {
    /**
     * Posición del objeto.
     */
    private Vector2 position;
    /**
     * Velocidad del objeto.
     */
    private Vector2 velocity;
    /**
     * Radio del circulo de animación del objeto.
     */
    private int rad;
    /**
     * Orientación del objeto.
     */
    private int rotation;
    /**
     * Rectangulo de la animación del objeto.
     */
    private Rectangle sRect;
    /**
     * Circulo de colisión del objeto.
     */
    private Circle circle;
    /**
     * Objeto tipo enemigo que lanza el objeto.
     */
    private SpecialEnemyArrow enemy;
    /**
     * Variable que indica los frames.
     */
    float frame = 0f;
    /**
     * Booleana que indica si golpea al enemigo o no.
     */
    private boolean hitEnemy;
    /**
     * Objeto caballero con el que puede colisionar el objeto.
     */
    private Knight knigth;

    /**
     * Constructor para Arrow.
     *
     * @param x        Posicion en x.
     * @param y        Posicion en y.
     * @param rad      Radio del circulo del objeto.
     * @param enemy    Objeto enemigo con el que puede colisionar.
     * @param knigth   Objeto caballero con el que puede colisionar.
     * @param rotation Orientación del objeto.
     */
    public Arrow(float x, float y, int rad, SpecialEnemyArrow enemy, Knight knigth, int rotation) {
        position = new Vector2(x, y);
        this.rad = rad;
        circle = new Circle(position.x, position.y, rad);
        sRect = new Rectangle(position.x - rad, position.y - rad, rad * 2, rad * 2);
        this.enemy = enemy;
        this.knigth = knigth;

        this.rotation = rotation;
        if (rotation == 0) {
            velocity = new Vector2(100 * Constant.density, 0);
        }
        if (rotation == 1) {
            velocity = new Vector2(-100 * Constant.density, 0);
        }
        hitEnemy = false;
    }

    /**
     * Metodo que gestiona los cambios de las variables y las actualiza.
     *
     * @param delta delta time
     */
    public void update(float delta) {
        if (rotation == 0) {
            velocity = new Vector2(300 * Constant.density, 0);
        } else {
            velocity = new Vector2(-300 * Constant.density, 0);
        }

        if (position.x + rad > 0 - rad * 2 && position.x + rad < Gdx.graphics.getWidth() + rad * 2) {
            position.add(velocity.cpy().scl(delta));
            circle.x = position.x;
            circle.y = position.y;
            sRect.x = position.x - rad;
            sRect.y = position.y - rad;
        } else {
            enemy.deleteArrow();
        }

        colider();
    }

    /**
     * Metodo que dibuja las animaciones y texturas.
     *
     * @param shapeRenderer Dibujador de figuras.
     * @param batch         Dibujador de animaciones.
     * @param runtime       Delta time.
     */
    public void draw(ShapeRenderer shapeRenderer, SpriteBatch batch, float runtime) {
        frame += runtime;
           /* shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
            if (hitEnemy) {
                shapeRenderer.setColor(Color.GREEN);
            } else {
                shapeRenderer.setColor(Color.RED);
            }
            shapeRenderer.circle(circle.x, circle.y, circle.radius);
            shapeRenderer.rect(sRect.x, sRect.y, sRect.width, sRect.height);
            shapeRenderer.end();*/
        batch.begin();
        if (rotation == 0) {
            batch.draw((TextureRegion) AssetLoader.specialEnemyArrowArrowAnimationRight.getKeyFrame(frame), sRect.x, sRect.y, sRect.width, sRect.height);
        } else {
            batch.draw((TextureRegion) AssetLoader.specialEnemyArrowArrowAnimation.getKeyFrame(frame), sRect.x, sRect.y, sRect.width, sRect.height);
        }
        batch.end();
    }

    /**
     * Metodo que comprueba y gestiona las colisiones.
     */
    public void colider() {
        if (!hitEnemy && Intersector.overlaps(circle, knigth.getAllPositionRect())) {
            hitEnemy = true;
        }
        if (Intersector.overlaps(circle, knigth.getRect())) {
            if (!knigth.state.equals(Knight.State.DYING)) {
                knigth.live -= 1;
                Gdx.input.vibrate(100);
                knigth.state = Knight.State.HURT;
                MyGame.prefs.setHits(MyGame.prefs.getHits()+1);
                HitParticle particle = new HitParticle(enemy, "epowerKnight");
                enemy.getKnight().particles.add(particle);
            }
            enemy.deleteArrow();
        }
        if (knigth.getSword() != null && !hitEnemy) {
            if (Intersector.overlaps(circle, knigth.getSword().rect)) {
                if (rotation == 0) {
                    rotation = 1;
                } else {
                    rotation = 0;
                }
                hitEnemy = true;
            }
        }
        if (knigth.getPower1() != null) {
            if (knigth.getPower1().getCircle().overlaps(circle)) {
                enemy.deleteArrow();
            }
        }
        if (knigth.getPower2() != null) {
            if (knigth.getPower2().getMeteors() != null) {
                Meteor[] meteors = knigth.getPower2().getMeteors();
                for (int i = 0; i < meteors.length; i++) {
                    if (meteors[i].getCircle().overlaps(circle)) {
                        enemy.deleteArrow();
                    }
                }
            }
        }

    }

    public int getRotation() {
        return rotation;
    }

    public Vector2 getPosition() {
        return position;
    }

    public int getRad() {
        return rad;
    }

    public Circle getCircle() {
        return circle;
    }

    public boolean isHitEnemy() {
        return hitEnemy;
    }

}
