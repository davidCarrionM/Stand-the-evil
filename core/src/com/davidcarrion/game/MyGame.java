package com.davidcarrion.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.I18NBundle;
import com.davidcarrion.game.Helper.AssetLoader;
import com.davidcarrion.game.Helper.AssetLoaderMenu;
import com.davidcarrion.game.Helper.Constant;
import com.davidcarrion.game.Helper.Prefs;
import com.davidcarrion.game.Helper.SoundLoader;
import com.davidcarrion.game.Screens.AnimationScreen;
import com.davidcarrion.game.Screens.CreditScreen;
import com.davidcarrion.game.Screens.GameScreen;
import com.davidcarrion.game.Screens.MenuScreen;

import com.davidcarrion.game.Screens.PreferencesScreen;
import com.davidcarrion.game.Screens.RecordsScreen;
import com.davidcarrion.game.Screens.ShopScreen;
import com.davidcarrion.game.Screens.TutorialScreen;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Esta clase es la clase principal donde se gestionará el cambio de pantallas y se cargaran los sonidos e imagenes
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class MyGame extends Game {
    /**
     * Clase con los datos guardados.
     */
    public static Prefs prefs;
    /**
     * Pantalla de menú.
     */
    MenuScreen menu;
    /**
     * Pantalla de juego.
     */
    GameScreen game;
    /**
     * Pantalla de tienda.
     */
    ShopScreen shop;
    /**
     * Pantalla de ajustes.
     */
    PreferencesScreen preferences;
    /**
     * Pantalla de records.
     */
    RecordsScreen records;
    /**
     * Pantalla de tutorial.
     */
    TutorialScreen tutorial;
    /**
     * Pantalla de creditos.
     */
    CreditScreen credits;
    /**
     * Pantalla de animación.
     */
    AnimationScreen animationScreen;
    /**
     * Colección con la música.
     */
    public static ArrayList<Music> musics;
    /**
     * Archivo de textos en español.
     */
    public static I18NBundle myBundleEspaniol;
    /**
     * Archivo de textos en ingles.
     */
    public static I18NBundle myBundleIngles;

    @Override
    public void create() {
        prefs = new Prefs();
        musics = new ArrayList<>();

        animationScreen = new AnimationScreen(this);
        FileHandle baseFileHandle = Gdx.files.internal("i18n/MyStrings");

        Locale locale = new Locale("es");
        myBundleEspaniol = I18NBundle.createBundle(baseFileHandle, locale);

        locale = new Locale("en");
        myBundleIngles = I18NBundle.createBundle(baseFileHandle, locale);

        AssetLoader.load();
        AssetLoaderMenu.load();
        SoundLoader.load();

        Music music = Gdx.audio.newMusic(Gdx.files.internal("music/menuMusic.mp3"));
        music.setVolume(0.7f);
        music.setLooping(true);
        musics.add(music);

        music = Gdx.audio.newMusic(Gdx.files.internal("music/battle.mp3"));
        music.setVolume(0.7f);
        music.setLooping(true);
        musics.add(music);

        music = Gdx.audio.newMusic(Gdx.files.internal("music/deadMusic.mp3"));
        music.setVolume(0.7f);
        music.setLooping(true);
        musics.add(music);

        music = Gdx.audio.newMusic(Gdx.files.internal("music/tutorialMusic.mp3"));
        music.setVolume(0.7f);
        music.setLooping(true);
        musics.add(music);

        music = Gdx.audio.newMusic(Gdx.files.internal("music/creditsMusic.mp3"));
        music.setVolume(0.7f);
        music.setLooping(true);
        musics.add(music);

       music = Gdx.audio.newMusic(Gdx.files.internal("music/animaciones.mp3"));
        music.setVolume(0.7f);
        music.setLooping(true);
        musics.add(music);

        setAnimation();
    }

    /**
     * Método que para toda la música.
     */
    public void stopMusic() {
        for (int i = 0; i < musics.size(); i++) {
            musics.get(i).stop();
        }
    }

    /**
     * Método que hace que vuelva a sonar la música del menú.
     */
    public void returnMenuMusic() {
        musics.get(0).play();
        Constant.menuMusic = false;
    }

    /**
     * Método que cambia la pantalla al menú.
     */
    public void setMenu() {

        if (MyGame.prefs.isMusic()) {
            if (Constant.menuMusic) {
                stopMusic();
                musics.get(0).play();
                Constant.menuMusic = false;
            }
        }
        menu = new MenuScreen(this);
        setScreen(menu);
    }
    /**
     * Método que cambia la pantalla al juego.
     */
    public void setNewGame() {
        if (prefs.isVibration()) {
            Gdx.input.vibrate(1000);
        }
        game = new GameScreen(this);
        if (MyGame.prefs.isMusic()) {
           stopMusic();
            musics.get(1).play();
        }
        setScreen(game);
        GameScreen.pause = false;
        GameScreen.end = false;
    }
    /**
     * Método que cambia la pantalla a la tienda.
     */
    public void setShop() {
        shop = new ShopScreen(this);
        setScreen(shop);
    }
    /**
     * Método que cambia la pantalla a los ajustes.
     */
    public void setPreferences() {
        preferences = new PreferencesScreen(this);
        setScreen(preferences);
    }
    /**
     * Método que cambia la pantalla a los records.
     */
    public void setRecords() {
        records = new RecordsScreen(this);
        setScreen(records);
    }
    /**
     * Método que cambia la pantalla al tutorial.
     */
    public void setTutorial() {
        if (MyGame.prefs.isMusic()) {
            stopMusic();
            musics.get(3).play();
        }
        tutorial = new TutorialScreen(this);
        setScreen(tutorial);
        TutorialScreen.pauseBoton = true;
    }
    /**
     * Método que cambia la pantalla a los creditos.
     */
    public void setCredit() {
        if (MyGame.prefs.isMusic()) {
           stopMusic();
            musics.get(4).play();
        }
        credits = new CreditScreen(this);
        setScreen(credits);
    }
    /**
     * Método que cambia la pantalla a las animaciones.
     */
    public void setAnimation() {
        if (prefs.isMusic()) {
            musics.get(5).play();
        }
        animationScreen = new AnimationScreen(this);
        setScreen(animationScreen);
    }
    /**
     * Método que libera recursos.
     */
    @Override
    public void dispose() {
        super.dispose();
        SoundLoader.dispose();
        AssetLoader.dispose();

    }
}
