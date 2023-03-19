package com.davidcarrion.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.davidcarrion.game.Helper.Constant;
import com.davidcarrion.game.Helper.SoundLoader;
import com.davidcarrion.game.MyGame;
import com.davidcarrion.game.Objects.PreferencesStan;

/**
 * Esta clase gestiona la pantalla de ajustes
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class PreferencesScreen implements Screen {

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
    public static Stage stage;
    /**
     * Botón que vuelve al menú.
     */
    ImageButton back;
    /**
     * Objeto PreferencesStan con las preferencias.
     */
    PreferencesStan stan1, stan2, stan3, stan4;
    /**
     * Botones de las preferencias.
     */
    ImageButton btn1, btn2, btn3, btn4;
    /**
     * Booleana que indica si la música está activa
     */
    boolean music;
    /**
     * Booleana que indica si el sonido está activo.
     */
    boolean sound;
    /**
     * Booleana que indica si la vibración está activa.
     */
    boolean vibration;
    /**
     * Variable que indica el idioma.
     */
    String idioma;
    /**
     * TexturaDrawable del boton activo.
     */
    TextureRegionDrawable btnActivo = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/accept.png"))));
    /**
     * TexturaDrawable del boton desActivo.
     */
    TextureRegionDrawable btnDesactivo = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/acceptPulsado.png"))));
    /**
     * TexturaDrawable del boton ingles.
     */
    TextureRegionDrawable english = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/espaniol.png"))));
    /**
     * TexturaDrawable del boton español.
     */
    TextureRegionDrawable spanish = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/ingles.png"))));
    /**
     * Sonido click de botón.
     */
    Sound soundClick;
    /**
     * Variables de los textos.
     */
    String musica, sonido, vibracion, idiomas;

    /**
     * Constructor para PreferencesScreen.
     *
     * @param myGame Clase principal donde se gestionan las distintas Screens.
     */
    public PreferencesScreen(MyGame myGame) {
        game = myGame;
        music = game.prefs.isMusic();
        sound = game.prefs.isSound();
        vibration = game.prefs.isVibration();
        idioma = game.prefs.getLanguage();
        soundClick = SoundLoader.clickSound;
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
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

        if (game.prefs.getLanguage().equals("es")) {
            musica = MyGame.myBundleEspaniol.get("musica");
            sonido = MyGame.myBundleEspaniol.get("sonido");
            vibracion = MyGame.myBundleEspaniol.get("vibracion");
            idiomas = MyGame.myBundleEspaniol.get("idioma");
        } else {
            musica = MyGame.myBundleIngles.get("musica");
            sonido = MyGame.myBundleIngles.get("sonido");
            vibracion = MyGame.myBundleIngles.get("vibracion");
            idiomas = MyGame.myBundleIngles.get("idioma");
        }

        stan1 = new PreferencesStan(Gdx.graphics.getWidth() / 8, (int) (Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 2.2f), this, musica);
        stan2 = new PreferencesStan(Gdx.graphics.getWidth() / 8, (int) (Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 1.4f), this, sonido);
        stan3 = new PreferencesStan((int) (Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 2.5f), (int) (Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 2.2f), this, vibracion);
        stan4 = new PreferencesStan((int) (Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 2.5f), (int) (Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 1.4f), this, idiomas);

        btn1 = new ImageButton(btnActivo, btnActivo, btnDesactivo);
        btn1.getImage().setFillParent(true);
        btn1.setSize(Gdx.graphics.getWidth() / 15, Gdx.graphics.getWidth() / 15);
        btn1.setPosition(Gdx.graphics.getWidth() / 3f, (Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 2.2f));
        stage.addActor(btn1);

        btn2 = new ImageButton(btnActivo, btnActivo, btnDesactivo);
        btn2.getImage().setFillParent(true);
        btn2.setSize(Gdx.graphics.getWidth() / 15, Gdx.graphics.getWidth() / 15);
        btn2.setPosition(Gdx.graphics.getWidth() / 3f, (Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 1.4f));
        stage.addActor(btn2);

        btn3 = new ImageButton(btnActivo, btnActivo, btnDesactivo);
        btn3.getImage().setFillParent(true);
        btn3.setSize(Gdx.graphics.getWidth() / 15, Gdx.graphics.getWidth() / 15);
        btn3.setPosition((Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 5f), (Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 2.2f));
        stage.addActor(btn3);

        btn4 = new ImageButton(spanish, spanish, english);
        btn4.getImage().setFillParent(true);
        btn4.setSize(Gdx.graphics.getWidth() / 15, Gdx.graphics.getWidth() / 15);
        btn4.setPosition((Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 5f), (Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 1.4f));
        stage.addActor(btn4);
        if (music) {
            btn1.setChecked(false);
        } else {
            btn1.setChecked(true);
        }
        if (sound) {
            btn2.setChecked(false);
        } else {
            btn2.setChecked(true);
        }
        if (vibration) {
            btn3.setChecked(false);
        } else {
            btn3.setChecked(true);
        }
        if (idioma.equals("es")) {
            btn4.setChecked(true);
        } else {
            btn4.setChecked(false);
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
        btn1.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (game.prefs.isSound()) {
                    soundClick.play();
                }
                music = !music;
                game.prefs.setMusic(!game.prefs.isMusic());
                if (music) {
                    btn1.setChecked(false);
                    game.returnMenuMusic();
                } else {
                    btn1.setChecked(true);
                    game.stopMusic();
                    Constant.menuMusic = true;
                }
            }
        });
        btn2.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (game.prefs.isSound()) {
                    soundClick.play();
                }
                sound = !sound;
                game.prefs.setSound(!game.prefs.isSound());
                if (sound) {
                    btn2.setChecked(false);
                } else {
                    btn2.setChecked(true);
                }
            }
        });
        btn3.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (game.prefs.isSound()) {
                    soundClick.play();
                }
                vibration = !vibration;
                game.prefs.setVibration(!game.prefs.isVibration());
                if (vibration) {
                    btn3.setChecked(false);
                } else {
                    btn3.setChecked(true);
                }
            }
        });

        btn4.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (game.prefs.isSound()) {
                    soundClick.play();
                }
                if (game.prefs.getLanguage().equals("es")) {
                    idioma = "en";
                    game.prefs.setLanguage("en");
                } else {
                    idioma = "es";
                    game.prefs.setLanguage("es");
                }
                cambiarIdioma();
                cambiarPropiaScreen(musica, sonido, vibracion, idiomas);

                if (idioma.equals("es")) {
                    btn4.setChecked(true);
                } else {
                    btn4.setChecked(false);
                }
            }
        });
    }

    /**
     * Método que cambia las variables de texto por el siguiente idioma.
     */
    public void cambiarIdioma() {
        if (game.prefs.getLanguage().equals("es")) {
            musica = MyGame.myBundleEspaniol.get("musica");
            sonido = MyGame.myBundleEspaniol.get("sonido");
            vibracion = MyGame.myBundleEspaniol.get("vibracion");
            idiomas = MyGame.myBundleEspaniol.get("idioma");
        } else {
            musica = MyGame.myBundleIngles.get("musica");
            sonido = MyGame.myBundleIngles.get("sonido");
            vibracion = MyGame.myBundleIngles.get("vibracion");
            idiomas = MyGame.myBundleIngles.get("idioma");
        }
    }

    /**
     * Método que cambia el texto de la screen por el indicado.
     *
     * @param string1 Primer texto.
     * @param string2 Segundo texto.
     * @param string3 Tercer texto.
     * @param string4 Cuarto texto.
     */
    public void cambiarPropiaScreen(String string1, String string2, String string3, String string4) {
        stan1.change(string1);
        stan2.change(string2);
        stan3.change(string3);
        stan4.change(string4);
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
