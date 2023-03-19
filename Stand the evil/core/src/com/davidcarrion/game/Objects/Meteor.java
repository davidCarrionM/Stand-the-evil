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
 * Esta clase define un objeto que cae desde arriba de la pantalla y colisiona con los otros objetos
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class Meteor {
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
     * Radio de los objetos que se crean.
     */
    private int rad;
    /**
     * Circulo del objeto.
     */
    private Circle circle;
    /**
     * Rectangulo de las animaciones.
     */
    private Rectangle sRect;
    /**
     * Objeto de power2 que gestiona este objeto.
     */
    private Power2 power2;
    /**
     * Numero de objeto que se añade.
     */
    private int index;
    /**
     * Animaciónes del objeto que se lanza.
     */
    Animation volt, voltRight;

    /**
     * Constructor para Meteor.
     *
     * @param x         Posición en x del objeto.
     * @param y         Posición en y del objeto.
     * @param rad       Radio de los circulos.
     * @param power2    Objeto de power2 que gestiona este objeto.
     * @param index     Numero de objeto que se añade
     * @param volt      Animación del objeto que se lanza.
     * @param voltRight Animación derecha del objeto que se lanza.
     */
    public Meteor(float x, float y, int rad, Power2 power2, int index, Animation volt, Animation voltRight) {
        position = new Vector2(x, y);
        this.rad = rad;
        this.volt = volt;
        this.voltRight = voltRight;
        circle = new Circle(position.x, position.y, rad);
        sRect = new Rectangle(position.x - rad * 2, position.y - rad, rad * 4, rad * 4);
        this.power2 = power2;
        velocity = new Vector2(0, -50 * Constant.density);
        acceleration = new Vector2(0, -500 * Constant.density);
        this.index = index;
    }

    /**
     * Metodo que gestiona los cambios de las variables y las actualiza.
     *
     * @param delta delta time
     */
    public void update(float delta) {
        velocity.add(acceleration.cpy().scl(delta));
        position.add(velocity.cpy().scl(delta));
        circle.x = position.x;
        circle.y = position.y;
        sRect.x = position.x - Gdx.graphics.getHeight() / 4;
        sRect.y = position.y - Gdx.graphics.getHeight() / 5;
        if (position.y < 0 - rad * 2) {
            power2.deleteMeteor(index);
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
        /*shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.circle(circle.x,circle.y,rad);
        shapeRenderer.end();*/
        batch.begin();
        //batch.draw((TextureRegion) AssetLoader.fireVoltAnimationRight.getKeyFrame(frames), sRect.x,sRect.y,sRect.width,sRect.height);
        batch.draw((TextureRegion) voltRight.getKeyFrame(frames), sRect.x, sRect.y, sRect.width / 2, sRect.height / 2, sRect.width, sRect.height, 1, 1, 90);
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

    public int getIndex() {
        return index;
    }

}
