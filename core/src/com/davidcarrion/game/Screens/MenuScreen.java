package com.davidcarrion.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.davidcarrion.game.Helper.SoundLoader;
import com.davidcarrion.game.MyGame;
import com.davidcarrion.game.World.MainMenuRender;
import com.davidcarrion.game.World.MainMenuWorld;

/**
 * Esta clase gestiona la pantalla del menu
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class MenuScreen implements Screen {
    /**
     * Clase que usan todos los actores de la pantalla para poder gestionarlos.
     */
    private Stage stage;
    /**
     * Clase principal donde se gestionan las distintas Screens.
     */
    private MyGame game;
    /**
     * Clase que gestiona todos los updates de las clases del menú.
     */
    private MainMenuWorld world;
    /**
     * Clase que gestiona todos los draws de las clases del menú.
     */
    private MainMenuRender renderer;
    /**
     * Variable que indica los frames.
     */
    private float runTime;
    /**
     * Sonido de click de botón.
     */
    Sound soundClick;
    /**
     * Fuente con la que se escriben los textos.
     */
    private BitmapFont font12;
    /**
     * Dibujador de animaciones y texturas.
     */
    private SpriteBatch batch;
    /**
     * Tamaño de los botones de la Screen.
     */
    float tamanioBoton = Gdx.graphics.getWidth() / 15;
    /**
     * Variable para gestionar el tamaño del texto.
     */
    GlyphLayout layout;

    /**
     * Constructor para MenuScreen.
     *
     * @param myGame Clase principal donde se gestionan las distintas Screens.
     */
    public MenuScreen(MyGame myGame) {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        this.game = myGame;
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("ui/alagard.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = Gdx.graphics.getHeight() / 8;
        parameter.color = Color.BLACK;
        font12 = generator.generateFont(parameter);
        batch = new SpriteBatch();
        generator.dispose();
        world = new MainMenuWorld();
        renderer = new MainMenuRender(world);
        soundClick = SoundLoader.clickSound;
        layout = new GlyphLayout();
        layout.setText(font12, "Stand the Evil");

        Image image = new Image(new Texture(Gdx.files.internal("main_menu/menu.png")));
        image.setSize(Gdx.graphics.getWidth() / 1.5f, Gdx.graphics.getHeight() / 1.5f);
        image.setPosition(Gdx.graphics.getWidth() / 2 - image.getWidth() / 2, Gdx.graphics.getHeight() / 2 - image.getHeight() / 1.5f);
        stage.addActor(image);

        ImageButton newGame = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/continue.png")))), new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/continuePulsado.png")))));
        newGame.getImage().setFillParent(true);
        newGame.setSize(tamanioBoton, tamanioBoton);
        newGame.setPosition(image.getX() + image.getWidth() / 2 - newGame.getWidth() / 1.5f, image.getY() + image.getHeight() - newGame.getHeight() * 2.5f);
        stage.addActor(newGame);
        newGame.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (game.prefs.isSound()) {
                    soundClick.play();
                }

                game.setNewGame();
            }
        });

        ImageButton preferences = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/settings.png")))), new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/settingsPulsado.png")))));
        preferences.getImage().setFillParent(true);
        preferences.setSize(tamanioBoton, tamanioBoton);
        preferences.setPosition(image.getX() + image.getWidth() / 2 - preferences.getWidth() / 1.5f, newGame.getY() - Gdx.graphics.getHeight() / 40 - preferences.getHeight());
        stage.addActor(preferences);
        preferences.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (game.prefs.isSound()) {
                    soundClick.play();
                }

                game.setPreferences();
            }
        });

        ImageButton exit = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/salir.png")))), new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/salirPulsado.png")))));
        exit.getImage().setFillParent(true);
        exit.setSize(tamanioBoton, tamanioBoton);
        exit.setPosition(image.getX() + image.getWidth() / 2 - exit.getWidth() / 1.5f, preferences.getY() - Gdx.graphics.getWidth() / 60 - exit.getHeight());
        stage.addActor(exit);
        exit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (game.prefs.isSound()) {
                    soundClick.play();
                }
                Gdx.app.exit();
            }
        });

        ImageButton shop = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/shop.png")))), new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/shopPulsado.png")))));
        shop.getImage().setFillParent(true);
        shop.setSize(tamanioBoton, tamanioBoton);
        shop.setPosition(newGame.getX() - shop.getHeight() - Gdx.graphics.getHeight() / 6, image.getY() + image.getHeight() - newGame.getHeight() * 2.5f);
        stage.addActor(shop);
        shop.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (game.prefs.isSound()) {
                    soundClick.play();
                }
                game.setShop();
            }
        });

        ImageButton record = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/record.png")))), new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/recordPulsado.png")))));
        record.getImage().setFillParent(true);
        record.setSize(tamanioBoton, tamanioBoton);
        record.setPosition(newGame.getX() - shop.getHeight() - Gdx.graphics.getHeight() / 6, preferences.getY() - Gdx.graphics.getWidth() / 60 - exit.getHeight());
        stage.addActor(record);
        record.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (game.prefs.isSound()) {
                    soundClick.play();
                }
                game.setRecords();
            }
        });

        ImageButton tutorial = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/tutorial.png")))), new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/tutorialPulsado.png")))));
        tutorial.getImage().setFillParent(true);
        tutorial.setSize(tamanioBoton, tamanioBoton);
        tutorial.setPosition(newGame.getX() + shop.getHeight() + Gdx.graphics.getHeight() / 6, image.getY() + image.getHeight() - newGame.getHeight() * 2.5f);
        stage.addActor(tutorial);
        tutorial.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (game.prefs.isSound()) {
                    soundClick.play();
                }
                game.setTutorial();
            }
        });

        ImageButton credits = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/credits.png")))), new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/creditsPulsado.png")))));
        credits.getImage().setFillParent(true);
        credits.setSize(tamanioBoton, tamanioBoton);
        credits.setPosition(newGame.getX() + shop.getHeight() + Gdx.graphics.getHeight() / 6, preferences.getY() - Gdx.graphics.getWidth() / 60 - exit.getHeight());
        stage.addActor(credits);
        credits.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (game.prefs.isSound()) {
                    soundClick.play();
                }
                game.setCredit();
            }
        });
    }

    @Override
    public void show() {


    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        runTime += delta;
        renderer.render(runTime);
        world.update(delta);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
        batch.begin();
        font12.draw(batch, "Stand the Evil", Gdx.graphics.getWidth() / 2 - layout.width / 2, Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 9);
        batch.end();
        Gdx.app.log("Music","value "+MyGame.prefs.isMusic());
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
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
    }
}
