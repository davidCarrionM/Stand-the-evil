package com.davidcarrion.game.Helper;

import com.badlogic.gdx.Gdx;
import com.davidcarrion.game.Objects.Knight;

/**
 * Esta clase detecta si el dispositivo se está agitando
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class ShakeDetector {
    /**
     * Aceleracion.
     */
    private float acceleration = 0f;
    /**
     * Velocidad actual.
     */
    private float currentAcceleration = 0f;
    /**
     * Velocidad pasada.
     */
    private float lastAcceleration = 0f;
    /**
     * Velocidad x del dispositivo.
     */
    float x = Gdx.input.getAccelerometerX();
    /**
     * Velocidad y del dispositivo.
     */
    float y = Gdx.input.getAccelerometerY();
    /**
     * Velocidad z del dispositivo.
     */
    float z = Gdx.input.getAccelerometerZ();
    /**
     * Objeto del que se va a lanzar la accion.
     */
    private Knight knight;

    /**
     * Constructor para ShakeDetector.
     *
     * @param knight objeto del que se va a lanzar la accion.
     */
    public ShakeDetector(Knight knight) {
        acceleration = 10f;
        this.knight = knight;
        x = Gdx.input.getAccelerometerX();
        y = Gdx.input.getAccelerometerY();
        z = Gdx.input.getAccelerometerZ();
        currentAcceleration = ((float) Math.sqrt((x * x + y * y + z * z)));
        lastAcceleration = ((float) Math.sqrt((x * x + y * y + z * z)));
    }

    /**
     * Método que gestiona los cambios de las variables y las actualiza.
     */
    public void update() {
        x = Gdx.input.getAccelerometerX();
        y = Gdx.input.getAccelerometerY();
        z = Gdx.input.getAccelerometerZ();
        lastAcceleration = currentAcceleration;
        currentAcceleration = ((float) Math.sqrt((x * x + y * y + z * z)));
        float delta = currentAcceleration - lastAcceleration;
        acceleration = acceleration * 0.9f + delta;

        if (acceleration > 12) {
            Gdx.app.log("SHAKE", "SHAKE TRUE");
            knight.shake();
        }
    }
}
