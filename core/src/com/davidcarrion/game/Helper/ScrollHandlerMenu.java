package com.davidcarrion.game.Helper;

import com.badlogic.gdx.Gdx;
import com.davidcarrion.game.Objects.Background;

/**
 * Esta clase gestiona todos los objetos Scrollables del menu
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class ScrollHandlerMenu {
    /**
     * Objetos del escenario del menu.
     */
    private Background frontFarTrees, frontMidTrees, frontNearTrees, backFarTrees, backMidTrees, backNearTrees;

    /**
     * Constante que indica la velocidad de movimiento de los objetos.
     */
    public final float SCROLL_SPEED = -20 * Constant.density;

    /**
     * Constructor para ScrollHandler sin parametros.
     */
    public ScrollHandlerMenu() {
        frontFarTrees = new Background(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), SCROLL_SPEED);
        frontMidTrees = new Background(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), SCROLL_SPEED * 2);
        frontNearTrees = new Background(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), SCROLL_SPEED * 3);
        backFarTrees = new Background(Gdx.graphics.getWidth(), 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), SCROLL_SPEED);
        backMidTrees = new Background(Gdx.graphics.getWidth(), 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), SCROLL_SPEED * 2);
        backNearTrees = new Background(Gdx.graphics.getWidth(), 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), SCROLL_SPEED * 3);

    }

    /**
     * Método que gestiona los cambios de las variables y las actualiza.
     *
     * @param delta delta time.
     */
    public void update(float delta) {
        frontFarTrees.update(delta);
        frontMidTrees.update(delta);
        frontNearTrees.update(delta);
        backFarTrees.update(delta);
        backMidTrees.update(delta);
        backNearTrees.update(delta);

        if (frontFarTrees.isScrolledLeft) {
            frontFarTrees.reset(Gdx.graphics.getWidth());
        } else if (backFarTrees.isScrolledLeft) {
            backFarTrees.reset(Gdx.graphics.getWidth());
        }
        if (frontMidTrees.isScrolledLeft) {
            frontMidTrees.reset(Gdx.graphics.getWidth());
        } else if (backMidTrees.isScrolledLeft) {
            backMidTrees.reset(Gdx.graphics.getWidth());
        }
        if (frontNearTrees.isScrolledLeft) {
            frontNearTrees.reset(Gdx.graphics.getWidth());
        } else if (backNearTrees.isScrolledLeft) {
            backNearTrees.reset(Gdx.graphics.getWidth());
        }
    }

    public Background getFrontFarTrees() {
        return frontFarTrees;
    }

    public Background getFrontMidTrees() {
        return frontMidTrees;
    }

    public Background getFrontNearTrees() {
        return frontNearTrees;
    }

    public Background getBackFarTrees() {
        return backFarTrees;
    }

    public Background getBackMidTrees() {
        return backMidTrees;
    }

    public Background getBackNearTrees() {
        return backNearTrees;
    }

}
