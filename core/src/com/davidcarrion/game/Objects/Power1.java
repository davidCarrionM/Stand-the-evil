package com.davidcarrion.game.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.davidcarrion.game.Helper.Constant;

/**
 * Esta clase define un objeto que colisona con el resto de objetos del juego y que se mueve en una posición continua
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class Power1 {
    /**
     * Posición del objeto.
     */
    private Vector2 position;
    /**
     * Velocidad del objeto.
     */
    private Vector2 velocity;
    /**
     * Aceleración del objeto.
     */
    private Vector2 acceleration;
    /**
     * Radio del objeto.
     */
    private int rad;
    /**
     * Orientación del objeto.
     */
    private int rotation;
    /**
     * Circulo del objeto.
     */
    private Circle circle;
    /**
     * Rectangulo de las animaciones.
     */
    private Rectangle sRect;
    /**
     * Objeto caballero que lanza el objeto.
     */
    private Knight knigth;
    /**
     * Animaciónes del objeto que se lanza.
     */
    Animation volt, voltRight;

    /**
     * Constructor para Power1
     *
     * @param x         Posición x del objeto.
     * @param y         Posición y del objeto.
     * @param rad       Radio del objeto.
     * @param knigth    Objeto caballero que va a lanzar el objeto.
     * @param rotation  Orientación del objeto.
     * @param volt      Animación del objeto que se lanza.
     * @param voltRight Animación derecha del objeto que se lanza.
     */
    public Power1(float x, float y, int rad, Knight knigth, int rotation, Animation volt, Animation voltRight) {
        position = new Vector2(x, y);
        this.rad = rad;
        this.volt = volt;
        this.voltRight = voltRight;
        circle = new Circle(position.x, position.y, rad);
        sRect = new Rectangle(position.x - rad, position.y - rad * 2, rad * 4, rad * 4);
        this.knigth = knigth;
        this.rotation = rotation;
        if (rotation == 0) {
            velocity = new Vector2(-200 * Constant.density, 0);
            acceleration = new Vector2(-500 * Constant.density, 0);
            position.x -= rad;
        }
        if (rotation == 1) {
            velocity = new Vector2(200 * Constant.density, 0);
            acceleration = new Vector2(500 * Constant.density, 0);
            position.x += rad;
        }

    }

    /**
     * Metodo que gestiona los cambios de las variables y las actualiza.
     *
     * @param delta delta time
     */
    public void update(float delta) {
        if (position.x + rad > 0 - rad * 2 && position.x + rad < Gdx.graphics.getWidth() + rad * 2) {
            velocity.add(acceleration.cpy().scl(delta));
            position.add(velocity.cpy().scl(delta));
            circle.x = position.x;
            circle.y = position.y;
            if (rotation == 0) {
                sRect.x = position.x - rad;
            } else {
                sRect.x = position.x - rad * 3;
            }
            sRect.y = position.y - Gdx.graphics.getHeight() / 5;
        } else {
            knigth.deletePower();
        }
    }

    /**
     * Metodo que dibuja las animaciones y texturas.
     *
     * @param shapeRenderer Dibujador de figuras.
     * @param batch         Dibujador de animaciones.
     * @param frames        Delta time.
     */
    public void draw(ShapeRenderer shapeRenderer, SpriteBatch batch, float frames) {

       /* shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.circle(position.x, position.y, circle.radius);
        shapeRenderer.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.rect(sRect.x,sRect.y,sRect.width,sRect.height);
        shapeRenderer.end();*/
        batch.begin();
        if (rotation == 0) {
            batch.draw((TextureRegion) voltRight.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
            // batch.draw((TextureRegion) AssetLoader.fireVoltAnimationRight.getKeyFrame(frames), sRect.x,sRect.y, sRect.width/2,sRect.height/2,sRect.width,sRect.height, 1, 1, 90);
        } else {
            batch.draw((TextureRegion) volt.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
        }
        batch.end();
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
}
