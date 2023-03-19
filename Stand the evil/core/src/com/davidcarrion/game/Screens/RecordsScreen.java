package com.davidcarrion.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.davidcarrion.game.Helper.AssetLoader;
import com.davidcarrion.game.Helper.Constant;
import com.davidcarrion.game.Helper.SoundLoader;
import com.davidcarrion.game.MyGame;
import com.davidcarrion.game.Objects.StanRecord;

/**
 * Esta clase gestiona la pantalla de records
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class RecordsScreen implements Screen {
    /**
     * Imagen de fondo donde se situarán los creditos.
     */
    Image image;
    /**
     * Imagen de fondo de pantalla.
     */
    Image background;
    /**
     * Clase principal donde se gestionan las distintas Screens.
     */
    MyGame game;
    /**
     * Clase que usan todos los actores de la pantalla para poder gestionarlos.
     */
    private Stage stage;
    /**
     * Dibujador de animaciones y texturas.
     */
    SpriteBatch batch;
    /**
     * Objetos StanRecord que tienen los datos del record
     */
    StanRecord stanRecord1, stanRecord2, stanRecord3, stanRecord4, stanRecord5, stanRecord6, stanRecord7, stanRecord8, stanRecord9, stanRecord10, stanRecord11;
    /**
     * Sonido click de botón.
     */
    Sound soundClick;
    /**
     * Botón con imagen para volver a la pantalla principal.
     */
    ImageButton back;

    /**
     * Constructor para RecordsScreen.
     *
     * @param myGame Clase principal donde se gestionan las distintas Screens.
     */
    public RecordsScreen(MyGame myGame) {
        game = myGame;
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        background = new Image(new Texture(Gdx.files.internal("ui/fondoShop.png")));
        background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        background.setPosition(0, 0);
        stage.addActor(background);
        soundClick = SoundLoader.clickSound;
        image = new Image(new Texture(Gdx.files.internal("ui/libro.png")));
        image.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        image.setPosition(0, 0);
        stage.addActor(image);

        back = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/back.png")))), new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/backPulsado.png")))));
        back.setSize(40 * Constant.density, 40 * Constant.density);
        back.setPosition(70 * Constant.density, Gdx.graphics.getHeight() - 90 * Constant.density);
        back.getImage().setFillParent(true);
        stage.addActor(back);

        back.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (game.prefs.isSound()) {
                    soundClick.play();
                }
                game.setMenu();
            }
        });

        stanRecord1 = new StanRecord((int) (Gdx.graphics.getWidth() / 11f), (int) (Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 2.6f), AssetLoader.normalEnemyRunAnimation, game.prefs.getNormalEnemies() + "", Color.RED, "rect");
        stanRecord2 = new StanRecord((int) (Gdx.graphics.getWidth() / 3.8f), (int) (Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 2.6f), AssetLoader.specialEnemyARunAnimation, game.prefs.getSpecialEnemiesA() + "", Color.BLUE, "rectLanza");
        stanRecord3 = new StanRecord((int) (Gdx.graphics.getWidth() / 11f), (int) (Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 1.63f), AssetLoader.specialEnemyBRunAnimation, game.prefs.getSpecialEnemiesB() + "", Color.GREEN, "rectShield");
        stanRecord4 = new StanRecord((int) (Gdx.graphics.getWidth() / 3.8f), (int) (Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 1.63f), AssetLoader.specialEnemyCRunAnimationUp, game.prefs.getSpecialEnemiesC() + "", Color.YELLOW, "rectFly");
        stanRecord5 = new StanRecord((int) (Gdx.graphics.getWidth() / 11f), (int) (Gdx.graphics.getHeight() / 6.4f), AssetLoader.specialEnemyArrowRunAnimation, game.prefs.getSpecialEnemiesArrow() + "", Color.BROWN, "rectArrow");
        stanRecord6 = new StanRecord((int) (Gdx.graphics.getWidth() / 3.8f), (int) (Gdx.graphics.getHeight() / 6.4f), AssetLoader.voltHit, game.prefs.getVoltDies() + "", Color.PINK, "square");

        stanRecord7 = new StanRecord((int) (Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 2.3f), (int) (Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 2.6f), AssetLoader.knightJump, game.prefs.getJumps() + "", Color.PINK, "knight");
        stanRecord9 = new StanRecord((int) (Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 3.8f), (int) (Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 2.6f), AssetLoader.knightVolt, game.prefs.getPowers() + "", Color.PINK, "knight");
        stanRecord8 = new StanRecord((int) (Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 2.3f), (int) (Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 1.63f), AssetLoader.knightHit, game.prefs.getHits() + "", Color.PINK, "knight");
        stanRecord10 = new StanRecord((int) (Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 3.8f), (int) (Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 1.63f), AssetLoader.knightDeath, game.prefs.getNewGames() + "", Color.PINK, "knight");
        stanRecord11 = new StanRecord((int) (Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 2.3f), (int) (Gdx.graphics.getHeight() / 6.4f), null, game.prefs.getMaxScore() + "", Color.PINK, "score");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1f, 0f, 0f, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
        stanRecord2.draw(delta);
        stanRecord1.draw(delta);
        stanRecord3.draw(delta);
        stanRecord4.draw(delta);
        stanRecord5.draw(delta);
        stanRecord6.draw(delta);
        stanRecord7.draw(delta);
        stanRecord8.draw(delta);
        stanRecord9.draw(delta);
        stanRecord10.draw(delta);
        stanRecord11.draw(delta);
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
