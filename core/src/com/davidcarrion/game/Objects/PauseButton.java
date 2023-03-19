package com.davidcarrion.game.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.davidcarrion.game.Helper.AssetLoader;
import com.davidcarrion.game.Helper.Constant;
import com.davidcarrion.game.Helper.SoundLoader;
import com.davidcarrion.game.MyGame;
import com.davidcarrion.game.Screens.GameScreen;
import com.davidcarrion.game.Screens.TutorialScreen;

/**
 * Esta clase define un objeto que pausa la pantalla de juego y muestra el stage para continuar o ir al menu
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class PauseButton {
    /**
     * Rectangulo del objeto.
     */
    private Rectangle rect;
    /**
     * Clase principal que gestiona las screens.
     */
    MyGame game;
    /**
     * Número de la pantalla que se va a utilizar (0=game,1=tutorial).
     */
    int screen;
    /**
     * Textura para el boton de home.
     */
    TextureRegion home = new TextureRegion(new Texture(Gdx.files.internal("ui/home.png")));

    /**
     * Constructor para PauseButton.
     *
     * @param game   Clase principal que gestiona las screens.
     * @param screen Número de la pantalla que se va a utilizar (0=game,1=tutorial).
     */
    public PauseButton(MyGame game, int screen) {
        this.game = game;
        this.screen = screen;
        rect = new Rectangle(Gdx.graphics.getWidth() - (Gdx.graphics.getWidth() / 12), Gdx.graphics.getHeight() - (Gdx.graphics.getWidth() / 12), Gdx.graphics.getWidth() / 17, Gdx.graphics.getWidth() / 17);
    }

    /**
     * Metodo que gestiona los cambios de las variables y las actualiza.
     */
    public void render() {
        if (Gdx.input.justTouched()) {
            if (rect.contains(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY())) {
                if (game.prefs.isSound()) {
                    SoundLoader.clickSound.play();
                }
                if (screen == 1) {
                    Gdx.input.setInputProcessor(GameScreen.stage);
                    MyGame.musics.get(1).setVolume(0.2f);
                    GameScreen.pause = true;
                } else {
                    TutorialScreen.world.getKnigth().shoot = false;
                    TutorialScreen.pause = true;
                    Constant.menuMusic = true;
                    game.setMenu();
                }
            }
        }
    }

    /**
     * Metodo que dibuja las animaciones y texturas.
     *
     * @param batch Dibujador de animaciones.
     */
    public void Draw(SpriteBatch batch) {
        batch.begin();
        if (screen == 1) {
            batch.draw(AssetLoader.pauseButton, rect.x, rect.y, rect.width, rect.height);
        } else {
            batch.draw(home, rect.x, rect.y, rect.width, rect.height);
        }
        batch.end();
        //shapeRenderer.rect(rect.x,rect.y,rect.width, rect.height);
    }
}
