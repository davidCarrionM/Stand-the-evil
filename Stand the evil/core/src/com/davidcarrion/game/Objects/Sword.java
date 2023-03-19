package com.davidcarrion.game.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

/**
 * Esta clase define un objeto con un rectangulo que colisionará con el resto de objetos
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class Sword {
    /**
     * Rectangulo del objeto.
     */
    Rectangle rect;

    /**
     * Constructor para Sword.
     *
     * @param x      Posición x del objeto.
     * @param y      Posición y del objeto.
     * @param heigth Altura del objeto.
     */
    public Sword(float x, float y, int heigth) {
        rect = new Rectangle(x, y, Gdx.graphics.getWidth() / 16, heigth);
    }

    public Rectangle getRect() {
        return rect;
    }
}
