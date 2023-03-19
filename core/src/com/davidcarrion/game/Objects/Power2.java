package com.davidcarrion.game.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.davidcarrion.game.Helper.Constant;

/**
 * Esta clase define un Array de objetos Meteor
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class Power2 {

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
     * Array de objetos Meteor.
     */
    private Meteor[] meteors;
    /**
     * Array de booleanas sobre si se elimina o no ese Meteor.
     */
    private Boolean[] boolMeteors;
    /**
     * Booleana que indica si se elimina o no el array de Meteors.
     */
    private boolean clearMeteor;
    /**
     * Objeto caballero que lanza el objeto.
     */
    private Knight knigth;
    /**
     * Animaciónes del objeto que se lanza.
     */
    Animation volt, voltRight;

    /**
     * Constructor para Power2
     * @param knigth Objeto caballero que lanza el objeto.
     * @param volt Animación del objeto que se lanza.
     * @param voltRight Animación derecha del objeto que se lanza.
     */
    public Power2(Knight knigth, Animation volt, Animation voltRight) {
        this.rad = Gdx.graphics.getWidth() / 16;
        position = new Vector2(Gdx.graphics.getWidth() / 16, Gdx.graphics.getHeight()+(rad*2));
        this.volt = volt;
        this.voltRight = voltRight;
        meteors = new Meteor[8];
        boolMeteors = new Boolean[8];
        for (int i = 0; i < 8; i++) {
            Meteor meteor = new Meteor(position.x, position.y, rad, this, i, volt, voltRight);
            Gdx.app.log("meteor", "OK");
            position.x += Gdx.graphics.getWidth() / 16 + Gdx.graphics.getWidth() / 16;
            meteors[i] = meteor;
        }
        for (int i = 0; i < 8; i++) {
            boolMeteors[i] = false;
        }
        clearMeteor = true;
        this.knigth = knigth;
        this.velocity = new Vector2(0, 200* Constant.density);
        this.acceleration = new Vector2(0, 400*Constant.density);
    }
    /**
     * Metodo que gestiona los cambios de las variables y las actualiza.
     *
     * @param delta delta time
     */
    public void update(float delta) {
        if (meteors != null) {
            for (int i = 0; i < meteors.length; i++) {
                meteors[i].update(delta);
            }
            clearMeteor = true;
            for (int i = 0; i < boolMeteors.length; i++) {

                if (!boolMeteors[i]) {
                    clearMeteor = false;
                }
            }
            if (clearMeteor) {
                meteors = null;
                knigth.state = Knight.State.IDLE;
            }
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
        if (meteors != null) {

            for (int i = 0; i < meteors.length; i++) {
                meteors[i].draw(shapeRenderer,batch,frames);
            }
        }

    }

    /**
     * Método para eliminar un Meteor determinado.
     * @param index Indice de BoolMeteors que se elimina.
     */
    public void deleteMeteor(int index) {
        boolMeteors[index] = true;
    }


    public Meteor[] getMeteors() {
        return meteors;
    }

    public Boolean[] getBoolMeteors() {
        return boolMeteors;
    }

}
