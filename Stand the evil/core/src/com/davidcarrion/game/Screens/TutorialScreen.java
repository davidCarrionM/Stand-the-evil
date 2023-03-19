package com.davidcarrion.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.input.GestureDetector;
import com.davidcarrion.game.Helper.GestureDetection;
import com.davidcarrion.game.Helper.Stopper;
import com.davidcarrion.game.MyGame;
import com.davidcarrion.game.World.TutorialRender;
import com.davidcarrion.game.World.TutorialWorld;

/**
 * Esta clase gestiona la pantalla de tutorial
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class TutorialScreen implements Screen {
    /**
     * Variable estática con la puntuación del juego.
     */
    public static int score;
    /**
     * Booleana estática que indica si el juego está parado.
     */
    public static boolean pause = false;
    /**
     * Booleana estática que indica si el juego está parado para poder pulsarse.
     */
    public static boolean pauseBoton = false;
    /**
     * Booleana estática que indica si el juego ha finalizado.
     */
    public static boolean end = false;
    /**
     * Clase que gestiona todos los updates de las clases del tutorial.
     */
    public static  TutorialWorld world;
    /**
     * Clase que gestiona todos los draws de las clases del tutorial.
     */
    private TutorialRender renderer;
    /**
     * Clase principal donde se gestionan las distintas Screens.
     */
    private MyGame parent;
    /**
     * Delta time
     */
    float auxDelta = 0f;
    /**
     * Objeto que muestra un texto y pausa el tutorial.
     */
    public static Stopper stopper;

    /**
     * Constructor para TutorialScreen.
     *
     * @param parent Clase principal donde se gestionan las distintas Screens.
     */
    public TutorialScreen(final MyGame parent) {
        score = 0;
        world = new TutorialWorld(parent, this);
        renderer = new TutorialRender(world);
        this.parent = parent;
        Gdx.input.setInputProcessor(new GestureDetector(new GestureDetection(world.getKnigth())));
        stopper = new Stopper("comienzo");
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        if (!pause) {
            auxDelta = delta;
        } else {
            auxDelta = 0;
        }
        renderer.render(auxDelta);
        if (!pause) {
            world.update(delta);
        } else {
            stopper.render();
        }
    }

    /**
     * Méodo que cambia la pantalla a la del menú
     */
    public void setMenu() {
        parent.setMenu();
    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
    }
}
