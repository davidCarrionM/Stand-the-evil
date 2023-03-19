package com.davidcarrion.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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
import com.davidcarrion.game.Helper.AssetLoader;
import com.davidcarrion.game.Helper.Constant;
import com.davidcarrion.game.Helper.SoundLoader;
import com.davidcarrion.game.MyGame;
import com.davidcarrion.game.Objects.ShopCharacter;

/**
 * Esta clase gestiona la pantalla de tienda
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class ShopScreen implements Screen {
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
     * Botón con imagen para volver a la pantalla principal.
     */
    ImageButton back;
    /**
     * Variable de monedas que tiene el jugador.
     */
    int coins;
    /**
     * Botones de compra.
     */
    ImageButton button1, button2, button3, button4;
    /**
     * Objetos ShopCharacter que tienen los personajes de compra.
     */
    ShopCharacter stan1, stan2, stan3, stan4;
    /**
     * Fuente con la que se escriben los textos.
     */
    private BitmapFont font12;
    /**
     * Sonido click de botón.
     */
    Sound soundClick;

    /**
     * Constructor para ShopScreen.
     *
     * @param myGame Clase principal donde se gestionan las distintas Screens.
     */
    public ShopScreen(final MyGame myGame) {
        game = myGame;
        coins = game.prefs.getCoins();
        batch = new SpriteBatch();
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        soundClick = SoundLoader.clickSound;

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("ui/dpcomic.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = (int) (35 * Constant.density);
        parameter.color = Color.BLACK;
        font12 = generator.generateFont(parameter); // font size 12 pixels
        generator.dispose();

        background = new Image(new Texture(Gdx.files.internal("ui/fondoShop.png")));
        background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        background.setPosition(0, 0);
        stage.addActor(background);

        image = new Image(new Texture(Gdx.files.internal("ui/libro.png")));
        image.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        image.setPosition(0, 0);
        stage.addActor(image);

        back = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/back.png")))), new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/backPulsado.png")))));
        back.setSize(40 * Constant.density, 40 * Constant.density);
        back.setPosition(70 * Constant.density, Gdx.graphics.getHeight() - 90 * Constant.density);
        back.getImage().setFillParent(true);
        stage.addActor(back);

        button1 = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/transparentButton.png")))), new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/transparentButton.png")))));
        button1.setSize(Gdx.graphics.getWidth() / 3.5f, Gdx.graphics.getHeight() / 3.5f);
        button1.setPosition(Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 2);
        button1.getImage().setFillParent(true);
        stage.addActor(button1);

        button2 = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/transparentButton.png")))), new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/transparentButton.png")))));
        button2.setSize(Gdx.graphics.getWidth() / 3.5f, Gdx.graphics.getHeight() / 3.5f);
        button2.setPosition(Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 5);
        button2.getImage().setFillParent(true);
        stage.addActor(button2);

        button3 = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/transparentButton.png")))), new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/transparentButton.png")))));
        button3.setSize(Gdx.graphics.getWidth() / 3.5f, Gdx.graphics.getHeight() / 3.5f);
        button3.setPosition((int) (Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 2.5f), Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 2);
        button3.getImage().setFillParent(true);
        stage.addActor(button3);

        button4 = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/transparentButton.png")))), new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/transparentButton.png")))));
        button4.setSize(Gdx.graphics.getWidth() / 3.5f, Gdx.graphics.getHeight() / 3.5f);
        button4.setPosition((int) (Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 2.5f), Gdx.graphics.getHeight() / 5);
        button4.getImage().setFillParent(true);
        stage.addActor(button4);

        stan1 = new ShopCharacter(Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 2, AssetLoader.IdleAnimationRed, AssetLoader.fireVoltAnimation, true, "red");
        stan2 = new ShopCharacter(Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 5, AssetLoader.IdleAnimationBlue, AssetLoader.iceVoltAnimation, game.prefs.isBlueUnlock(), "blue");
        stan3 = new ShopCharacter((int) (Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 2.5f), Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 2, AssetLoader.IdleAnimationYellow, AssetLoader.thunderVoltAnimation, game.prefs.isYellowUnlock(), "yellow");
        stan4 = new ShopCharacter((int) (Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 2.5f), Gdx.graphics.getHeight() / 5, AssetLoader.IdleAnimationBrown, AssetLoader.dirtVoltAnimation, game.prefs.isBrownUnlock(), "brown");

        if (game.prefs.getKnightSelected() == 1) {
            stan1.check(true);
            stan2.check(false);
            stan3.check(false);
            stan4.check(false);
        }
        if (game.prefs.getKnightSelected() == 2) {
            stan1.check(false);
            stan2.check(true);
            stan3.check(false);
            stan4.check(false);
        }
        if (game.prefs.getKnightSelected() == 3) {
            stan1.check(false);
            stan2.check(false);
            stan3.check(true);
            stan4.check(false);
        }
        if (game.prefs.getKnightSelected() == 4) {
            stan1.check(false);
            stan2.check(false);
            stan3.check(false);
            stan4.check(true);
        }
        back.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (game.prefs.isSound()) {
                    soundClick.play();
                }
                game.setMenu();
            }
        });
        button1.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (myGame.prefs.isSound()) {
                    SoundLoader.fireShopSound.play();
                }
                stan1.check(true);
                stan2.check(false);
                stan3.check(false);
                stan4.check(false);
                game.prefs.setKnightSelected(1);
            }
        });
        button2.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (stan2.unlock) {
                    if (myGame.prefs.isSound()) {
                        SoundLoader.waterShopSound.play();
                    }
                    stan1.check(false);
                    stan2.check(true);
                    stan3.check(false);
                    stan4.check(false);
                    game.prefs.setKnightSelected(2);
                } else {
                    if (coins >= 50) {
                        if (myGame.prefs.isSound()) {
                            SoundLoader.buySound.play();
                        }
                        coins -= 50;
                        stan2.unlock = true;
                        game.prefs.setCoins(game.prefs.getCoins() - 50);
                        game.prefs.setBlueUnlock(true);
                    } else {
                        if (myGame.prefs.isSound()) {
                            SoundLoader.lockSound.play();
                        }
                    }
                }
            }
        });
        button3.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (stan3.unlock) {
                    if (myGame.prefs.isSound()) {
                        SoundLoader.thunderShopSound.play();
                    }
                    stan1.check(false);
                    stan2.check(false);
                    stan3.check(true);
                    stan4.check(false);
                    game.prefs.setKnightSelected(3);
                } else {
                    if (coins >= 50) {
                        if (myGame.prefs.isSound()) {
                            SoundLoader.buySound.play();
                        }
                        coins -= 50;
                        game.prefs.setCoins(game.prefs.getCoins() - 50);
                        stan3.unlock = true;
                        game.prefs.setYellowUnlock(true);
                    } else {
                        if (myGame.prefs.isSound()) {
                            SoundLoader.lockSound.play();
                        }
                    }
                }
            }
        });
        button4.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (stan4.unlock) {
                    if (myGame.prefs.isSound()) {
                        SoundLoader.dirtShopSound.play(0.6f);
                    }
                    stan1.check(false);
                    stan2.check(false);
                    stan3.check(false);
                    stan4.check(true);
                    game.prefs.setKnightSelected(4);
                } else {
                    if (coins >= 50) {
                        if (myGame.prefs.isSound()) {
                            SoundLoader.buySound.play();
                        }
                        coins -= 50;
                        game.prefs.setCoins(game.prefs.getCoins() - 50);
                        stan4.unlock = true;
                        game.prefs.setBrownUnlock(true);
                    } else {
                        if (myGame.prefs.isSound()) {
                            SoundLoader.lockSound.play();
                        }
                    }
                }
            }
        });
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
        stan1.draw(delta);
        stan2.draw(delta);
        stan3.draw(delta);
        stan4.draw(delta);
        batch.begin();
        batch.draw(AssetLoader.tCoin, Gdx.graphics.getWidth() / 4.5f, Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 7, 25 * Constant.density, 25 * Constant.density);
        font12.draw(batch, coins + "", Gdx.graphics.getWidth() / 3.8f, Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 11);

        batch.end();
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
