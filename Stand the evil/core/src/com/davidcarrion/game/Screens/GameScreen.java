package com.davidcarrion.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.davidcarrion.game.Helper.Constant;
import com.davidcarrion.game.Helper.GestureDetection;
import com.davidcarrion.game.Helper.SoundLoader;
import com.davidcarrion.game.MyGame;
import com.davidcarrion.game.World.GameRender;
import com.davidcarrion.game.World.GameWorld;

/**
 * Esta clase gestiona la pantalla del juego
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class GameScreen implements Screen {
    /**
     * Variable estática con la puntuación del juego.
     */
    public static int score;
    /**
     * Booleana estática que indica si el juego está parado.
     */
    public static boolean pause = false;
    /**
     * Booleana estática que indica si el juego ha finalizado.
     */
    public static boolean end = false;
    /**
     * Variable estática con el número de monedas del juego.
     */
    public static int coins;
    /**
     * Clase que gestiona todos los updates de las clases del juego.
     */
    private GameWorld world;
    /**
     * Clase que gestiona todos los draws de las clases del juego.
     */
    private GameRender renderer;
    /**
     * Clase que usan todos los actores de la pantalla para poder gestionarlos mientras esta el juego activo.
     */
    public static Stage stage;
    /**
     * Clase que usan todos los actores de la pantalla para poder gestionarlos cuando el juego acabó.
     */
    public static Stage stageDead;
    /**
     * Clase principal donde se gestionan las distintas Screens.
     */
    private MyGame parent;
    /**
     * Fuente con la que se escriben los textos.
     */
    private BitmapFont font12;
    /**
     * Dibujador de animaciones y texturas.
     */
    private SpriteBatch batch;
    /**
     * Botón que reanuda el juego cuando está pausado.
     */
    ImageButton resume;
    /**
     * Botón que vuelve al menú.
     */
    ImageButton menu;
    /**
     * Botón que vuelve a empezar la partida.
     */
    ImageButton retry;
    /**
     * Botón que vuelve al menú.
     */
    ImageButton menuDead;
    /**
     * Variable para gestionar el tamaño del texto.
     */
    GlyphLayout layout;

    /**
     * Constructor para GameScreen.
     *
     * @param parent Clase principal donde se gestionan las distintas Screens.
     */
    public GameScreen(final MyGame parent) {
        score = 0;
        world = new GameWorld(parent);
        renderer = new GameRender(world);
        this.parent = parent;
        Gdx.input.setInputProcessor(new GestureDetector(new GestureDetection(world.getKnigth())));

        layout = new GlyphLayout();
        stage = new Stage(new ScreenViewport());
        stageDead = new Stage(new ScreenViewport());
        coins = 0;
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("ui/dpcomic.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = (int) (30 * Constant.density);
        parameter.color = Color.BLACK;
        font12 = generator.generateFont(parameter); // font size 12 pixels
        generator.dispose();
        batch = new SpriteBatch();

        Image image = new Image(new Texture(Gdx.files.internal("ui/panel.png")));
        image.setSize(Gdx.graphics.getWidth() / 4, Gdx.graphics.getWidth() / 4);
        image.setPosition(Gdx.graphics.getWidth() / 2 - image.getWidth() / 2, Gdx.graphics.getHeight() / 2 - image.getHeight() / 2);
        stage.addActor(image);

        resume = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/continue.png")))), new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/continuePulsado.png")))));
        resume.getImage().setFillParent(true);
        resume.setSize(Gdx.graphics.getWidth() / 14, Gdx.graphics.getWidth() / 14);
        resume.setPosition(Gdx.graphics.getWidth() / 2 - resume.getWidth() / 1.25f, Gdx.graphics.getHeight() / 2.2f);
        stage.addActor(resume);

        menu = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/home.png")))), new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/homePulsado.png")))));
        menu.getImage().setFillParent(true);
        menu.setSize(Gdx.graphics.getWidth() / 14, Gdx.graphics.getWidth() / 14);
        menu.setPosition(Gdx.graphics.getWidth() / 2 - resume.getWidth() / 1.25f, Gdx.graphics.getHeight() / 2.2f - menu.getHeight());
        stage.addActor(menu);

        resume.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.input.setInputProcessor(new GestureDetector(new GestureDetection(world.getKnigth())));
                if (parent.prefs.isSound()) {
                    SoundLoader.clickSound.play();
                }
                parent.musics.get(1).setVolume(0.7f);
                GameScreen.pause = false;
                world.getKnigth().shoot = false;
            }
        });
        menu.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (parent.prefs.isSound()) {
                    SoundLoader.clickSound.play();
                }
                parent.musics.get(1).setVolume(0.7f);
                Constant.menuMusic = true;
                parent.setMenu();
            }
        });

        Image image1 = new Image(new Texture(Gdx.files.internal("ui/panel.png")));
        image1.setSize(Gdx.graphics.getWidth() / 4, Gdx.graphics.getWidth() / 4);
        image1.setPosition(Gdx.graphics.getWidth() / 2 - image.getWidth() / 2, Gdx.graphics.getHeight() / 2 - image.getHeight() / 2);
        stageDead.addActor(image1);

        retry = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/restart.png")))), new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/restartPulsado.png")))));
        //resume.setSize(resume.getWidth()* Constant.density,resume.getHeight()*Constant.density);
        retry.getImage().setFillParent(true);
        retry.setSize(Gdx.graphics.getWidth() / 14, Gdx.graphics.getWidth() / 14);
        retry.setPosition(Gdx.graphics.getWidth() / 2 - resume.getWidth() / 1.25f, Gdx.graphics.getHeight() / 2.2f);
        stageDead.addActor(retry);


        menuDead = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/home.png")))), new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/homePulsado.png")))));
        menuDead.getImage().setFillParent(true);
        menuDead.setSize(Gdx.graphics.getWidth() / 14, Gdx.graphics.getWidth() / 14);
        menuDead.setPosition(Gdx.graphics.getWidth() / 2 - resume.getWidth() / 1.25f, Gdx.graphics.getHeight() / 2.2f - menu.getHeight());
        stageDead.addActor(menuDead);

        retry.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (parent.prefs.isSound()) {
                    SoundLoader.clickSound.play();
                }
                parent.musics.get(1).setVolume(0.7f);
                parent.setNewGame();
            }
        });

        menuDead.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (parent.prefs.isSound()) {
                    SoundLoader.clickSound.play();
                }
                parent.musics.get(1).setVolume(0.7f);
                Constant.menuMusic = true;
                parent.setMenu();
            }
        });
    }

    @Override
    public void render(float delta) {
        if (!end) {
            if (!pause) {
                renderer.render(delta);
                world.update(delta);
            } else {
                world.getKnigth().shoot = false;
                renderer.render(0);
                stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
                stage.draw();
            }
        } else {
            renderer.render(0);
            stageDead.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
            stageDead.draw();
        }
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
        stage.dispose();
        stageDead.dispose();
    }
}
