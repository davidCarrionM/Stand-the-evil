package com.davidcarrion.game.Helper;

import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.davidcarrion.game.Objects.Knight;
import com.davidcarrion.game.Screens.GameScreen;

/**
 * Esta clase gestiona todas las pulsaciones y deslizamientos por pantalla
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class GestureDetection implements GestureDetector.GestureListener {
    /**
     * Objeto caballero.
     */
    private Knight myKnight;

    /**
     * Constructor para GestureDetection.
     *
     * @param knight Caballero con el que se hacen todas las acciones.
     */
    public GestureDetection(Knight knight) {
        myKnight = knight;
    }

    /**
     * A mayores llama el metodo OnClick() del objeto knight.
     *
     * @param x
     * @param y
     * @param button
     * @return
     */
    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        myKnight.OnClick();
        return true;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        return false;
    }

    /**
     * A mayores llama el metodo shoot() del objeto knight si el juego no esta en pause.
     *
     * @param x
     * @param y
     * @return
     */
    @Override
    public boolean longPress(float x, float y) {
        if(myKnight.shoot){
        if (!GameScreen.pause) {
            myKnight.shoot();
            //pause = false;
        }
        }
        return true;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        return false;
    }

    /**
     * A mayores llama el metodo jump() del objeto knight.
     *
     * @param x
     * @param y
     * @param deltaX
     * @param deltaY
     * @return
     */
    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        myKnight.jump(deltaX, deltaY);
        return true;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }

    @Override
    public void pinchStop() {

    }
}
