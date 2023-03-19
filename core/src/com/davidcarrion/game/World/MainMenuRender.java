package com.davidcarrion.game.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.davidcarrion.game.Helper.AssetLoaderMenu;
import com.davidcarrion.game.Helper.ScrollHandlerMenu;
import com.davidcarrion.game.Objects.Background;

/**
 * Esta clase gestiona el render grafico del MenuScreen
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class MainMenuRender {
    /**
     * Objeto que gestiona todos los updates de las clases del menú.
     */
    private MainMenuWorld menuWorld;
    /**
     * Camara Orthografica.
     */
    private OrthographicCamera cam;
    /**
     * Dibujador de animaciones y texturas.
     */
    private SpriteBatch batch;
    /**
     * Objetos Background con las partes de los escenarios.
     */
    private Background frontFarTrees, frontMidTrees, frontNearTrees, backFarTrees, backMidTrees, backNearTrees;
    /**
     * Manejador de objetos que heredan de Scrollable.
     */
    private ScrollHandlerMenu scroller;

    /**
     * Constructor para MainMenuRender.
     *
     * @param menuWorld Objeto que gestiona todos los updates de las clases del menú.
     */
    public MainMenuRender(MainMenuWorld menuWorld) {
        this.menuWorld = menuWorld;
        cam = new OrthographicCamera();
        cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch = new SpriteBatch();
        batch.setProjectionMatrix(cam.combined);
        initGamesObjects();
    }

    /**
     * Metodo que dibuja las animaciones y texturas.
     *
     * @param runtime Delta time.
     */
    public void render(float runtime) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        drawBackground();
    }

    /**
     * Método que dibuja los escenarios.
     */
    private void drawBackground() {
        frontFarTrees.draw(AssetLoaderMenu.frontFarTrees, batch);
        backFarTrees.draw(AssetLoaderMenu.backFarTrees, batch);
        frontMidTrees.draw(AssetLoaderMenu.frontMidTrees, batch);
        backMidTrees.draw(AssetLoaderMenu.backMidTrees, batch);
        frontNearTrees.draw(AssetLoaderMenu.frontNearTrees, batch);
        backNearTrees.draw(AssetLoaderMenu.backNearTrees, batch);
    }

    /**
     * Método que inicializa todas las variables que comparte con el GameWorld.
     */
    private void initGamesObjects() {

        scroller = menuWorld.getScroller();
        frontFarTrees = scroller.getFrontFarTrees();
        frontMidTrees = scroller.getFrontMidTrees();
        frontNearTrees = scroller.getFrontNearTrees();
        backFarTrees = scroller.getBackFarTrees();
        backMidTrees = scroller.getBackMidTrees();
        backNearTrees = scroller.getBackNearTrees();

    }
}
