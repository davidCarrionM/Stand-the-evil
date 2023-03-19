package com.davidcarrion.game.Objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.davidcarrion.game.Helper.Scrollable;

/**
 * Esta clase define el objeto con el que colisionaran los personajes para no caer al vacio
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class Floor extends Scrollable {
    /**
     * Rectangulo del objeto.
     */
    private Rectangle rect;

    /**
     * Constructor para Floor.
     *
     * @param x           Posición x del objeto.
     * @param y           Posición y del objeto.
     * @param width       Ancho del objeto.
     * @param height      Alto del objeto.
     * @param scrollSpeed Velocidad de objeto.
     */
    public Floor(float x, float y, int width, int height, float scrollSpeed) {
        super(x, y, width, height, scrollSpeed);
        x = x;
        y = y;

        rect = new Rectangle(x, y, width, height);
    }

    /**
     * Metodo que gestiona los cambios de las variables y las actualiza.
     *
     * @param delta delta time
     */
    @Override
    public void update(float delta) {
        super.update(delta);
        rect.x = this.position.x;
        rect.y = this.position.y;
    }

    /**
     * Metodo que dibuja las animaciones y texturas.
     *
     * @param batch Dibujador de animaciones.
     * @param floor Textura del objeto.
     */
    public void draw(SpriteBatch batch, TextureRegion floor) {
        batch.begin();
        batch.draw(floor, rect.x, rect.y, rect.width, rect.height);
        batch.end();
    }

    public Rectangle getRect() {
        return rect;
    }
}
