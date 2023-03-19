package com.davidcarrion.game.Helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

/**
 * Esta clase es una clase padre del que heredaran los objetos que se muevan continuo hacia un lado, como el parallax
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class Scrollable {
    /**
     * Posición del objeto.
     */
    protected Vector2 position;
    /**
     * Velocidad del objeto.
     */
    protected Vector2 velocity;
    /**
     * Ancho del objeto.
     */
    protected int width;
    /**
     * Alto del objeto.
     */
    protected int height;
    /**
     * Booleana que indica si se mueve hacia la izquierda.
     */
    protected boolean isScrolledLeft;

    /**
     * Booleana que indica si se mueve hacia la derecha.
     */
    protected boolean isScrolledRigth;

    /**
     * Constructor para la clase Scrollable.
     *
     * @param x           posicion en x del objeto.
     * @param y           posicion en y del objeto.
     * @param width       ancho del objeto.
     * @param height      alto del objeto.
     * @param scrollSpeed velocidad de movimiento del objeto.
     */
    public Scrollable(float x, float y, int width, int height, float scrollSpeed) {
        position = new Vector2(x, y);
        velocity = new Vector2(scrollSpeed, 0);
        this.width = width;
        this.height = height;
        isScrolledLeft = false;
        isScrolledRigth = false;
    }

    /**
     * Método que gestiona los cambios de las variables y las actualiza.
     *
     * @param delta delta time.
     */
    public void update(float delta) {
        position.add(velocity.cpy().scl(delta));

        if (position.x + width < 0) {
            isScrolledLeft = true;
        }

        if (position.x > Gdx.graphics.getWidth()) {
            isScrolledRigth = true;
        }
    }

    /**
     * Método que cambia la posicion de x del objeto a la indicada.
     *
     * @param newX nueva posicion en x del objeto.
     */
    public void reset(float newX) {
        position.x = newX;
        isScrolledLeft = false;
        isScrolledRigth = false;
    }

    public boolean isScrolledLeft() {
        return isScrolledLeft;
    }

    public boolean isScrolledRigth() {
        return isScrolledRigth;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
