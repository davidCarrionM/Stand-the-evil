package com.davidcarrion.game.World;

import com.davidcarrion.game.Helper.ScrollHandlerMenu;
/**
 * Esta clase gestiona los objetos del MenuScreen y su actualizacion frame a frame
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class MainMenuWorld {
    /**
     * Manejador de objetos que heredan de Scrollable.
     */
    private ScrollHandlerMenu scroller;

    /**
     * Constructor para MainMenuWorld.
     */
    public MainMenuWorld() {
        scroller = new ScrollHandlerMenu();
    }
    /**
     * Método que gestiona los cambios de las variables y las actualiza.
     *
     * @param delta delta time.
     */
    public void update(float delta) {
        scroller.update(delta);
    }

    public ScrollHandlerMenu getScroller() {
        return scroller;
    }
}
