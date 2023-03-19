package com.davidcarrion.game.Helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * Esta clase gestiona toda la persistencia de datos que necesitara el juego
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class Prefs {
    /**
     * Objeto que gestiona la persistencia de datos
     */
    private Preferences pref;
    /**
     * Indica si la musica esta activa o no.
     */
    private boolean music;
    /**
     * Indica si el sonido esta activo o no.
     */
    private boolean sound;
    /**
     * Indica si la vibración esta activa o no.
     */
    private boolean vibration;
    /**
     * Indica si el personaje azul esta desbloqueado o no.
     */
    private boolean blueUnlock;
    /**
     * Indica si el personaje amarillo esta desbloqueado o no.
     */
    private boolean yellowUnlock;
    /**
     * Indica si el personaje marron esta desbloqueado o no.
     */
    private boolean brownUnlock;
    /**
     * Indica que personaje esta seleccionado.
     */
    private int knightSelected;
    /**
     * Indica cuantos enemigos normales se han matado.
     */
    private int normalEnemies;
    /**
     * Indica cuantos enemigos especiales A se han matado.
     */
    private int specialEnemiesA;
    /**
     * Indica cuantos enemigos especiales B se han matado.
     */
    private int specialEnemiesB;
    /**
     * Indica cuantos enemigos especiales C se han matado.
     */
    private int specialEnemiesC;
    /**
     * Indica cuantos enemigos especiales Arrow se han matado.
     */
    private int specialEnemiesArrow;
    /**
     * Indica cuantos enemigos se han matado con los poderes.
     */
    private int voltDies;
    /**
     * Indica cuantos saltos se han realizado.
     */
    private int jumps;
    /**
     * Indica cuantos golpes se han recibido.
     */
    private int hits;
    /**
     * Indica cuantas veces se han usado los poderes.
     */
    private int powers;
    /**
     * Indica cuantas veces se han muerto.
     */
    private int newGames;
    /**
     * Indica la maxima puntuacion conseguida.
     */
    private int maxScore;
    /**
     * Indica la cantidad de monedas que se tiene.
     */
    private int coins;
    /**
     * Indica que lenguaje se esta usando.
     */
    private String language;

    /**
     * Constructor para la clase Prefs sin parametros
     */
    public Prefs() {
        pref = Gdx.app.getPreferences("My Preferences");

        music = pref.getBoolean("music", true);
        sound = pref.getBoolean("sound", true);
        vibration = pref.getBoolean("vibration", true);
        blueUnlock = pref.getBoolean("blue", false);
        yellowUnlock = pref.getBoolean("yellow", false);
        brownUnlock = pref.getBoolean("brown", false);
        knightSelected = pref.getInteger("selected", 1);
        normalEnemies = pref.getInteger("normalEnemies", 0);
        specialEnemiesA = pref.getInteger("specialEnemiesA", 0);
        specialEnemiesB = pref.getInteger("specialEnemiesB", 0);
        specialEnemiesC = pref.getInteger("specialEnemiesC", 0);
        specialEnemiesArrow = pref.getInteger("specialEnemiesArrow", 0);
        voltDies = pref.getInteger("voltDies", 0);
        jumps = pref.getInteger("jumps", 0);
        hits = pref.getInteger("hits", 0);
        powers = pref.getInteger("powers", 0);
        newGames = pref.getInteger("newGames", 0);
        maxScore = pref.getInteger("maxScore", 0);
        coins = pref.getInteger("coins", 0);
        language = pref.getString("language", "es");
    }

    public boolean isMusic() {
        return music;
    }

    public void setMusic(boolean music) {
        this.music = music;
        pref.putBoolean("music", music);
        pref.flush();
    }

    public boolean isSound() {
        return sound;
    }

    public void setSound(boolean sound) {
        this.sound = sound;
        pref.putBoolean("sound", sound);
        pref.flush();
    }

    public boolean isVibration() {
        return vibration;
    }

    public void setVibration(boolean vibration) {
        this.vibration = vibration;
        pref.putBoolean("vibration", vibration);
        pref.flush();
    }

    public boolean isBlueUnlock() {
        return blueUnlock;
    }

    public void setBlueUnlock(boolean blueUnlock) {
        this.blueUnlock = blueUnlock;
        pref.putBoolean("blue", blueUnlock);
        pref.flush();
    }

    public boolean isYellowUnlock() {
        return yellowUnlock;
    }

    public void setYellowUnlock(boolean yellowUnlock) {
        this.yellowUnlock = yellowUnlock;
        pref.putBoolean("yellow", yellowUnlock);
        pref.flush();
    }

    public boolean isBrownUnlock() {
        return brownUnlock;
    }

    public void setBrownUnlock(boolean brownUnlock) {
        this.brownUnlock = brownUnlock;
        pref.putBoolean("brown", brownUnlock);
        pref.flush();
    }

    public int getKnightSelected() {
        return knightSelected;
    }

    public void setKnightSelected(int knightSelected) {
        this.knightSelected = knightSelected;
        pref.putInteger("selected", knightSelected);
        pref.flush();
    }

    public int getNormalEnemies() {
        return normalEnemies;
    }

    public void setNormalEnemies(int normalEnemies) {
        this.normalEnemies = normalEnemies;
        pref.putInteger("normalEnemies", normalEnemies);
        pref.flush();
    }

    public int getSpecialEnemiesA() {
        return specialEnemiesA;
    }

    public void setSpecialEnemiesA(int specialEnemiesA) {
        this.specialEnemiesA = specialEnemiesA;
        pref.putInteger("specialEnemiesA", specialEnemiesA);
        pref.flush();
    }

    public int getSpecialEnemiesB() {
        return specialEnemiesB;
    }

    public void setSpecialEnemiesB(int specialEnemiesB) {
        this.specialEnemiesB = specialEnemiesB;
        pref.putInteger("specialEnemiesB", specialEnemiesB);
        pref.flush();
    }

    public int getSpecialEnemiesC() {
        return specialEnemiesC;
    }

    public void setSpecialEnemiesC(int specialEnemiesC) {
        this.specialEnemiesC = specialEnemiesC;
        pref.putInteger("specialEnemiesC", specialEnemiesC);
        pref.flush();
    }

    public int getSpecialEnemiesArrow() {
        return specialEnemiesArrow;
    }

    public void setSpecialEnemiesArrow(int specialEnemiesArrow) {
        this.specialEnemiesArrow = specialEnemiesArrow;
        pref.putInteger("specialEnemiesArrow", specialEnemiesArrow);
        pref.flush();
    }

    public int getVoltDies() {
        return voltDies;
    }

    public void setVoltDies(int voltDies) {
        this.voltDies = voltDies;
        pref.putInteger("voltDies", voltDies);
        pref.flush();
    }

    public int getJumps() {
        return jumps;
    }

    public void setJumps(int jumps) {
        this.jumps = jumps;
        pref.putInteger("jumps", jumps);
        pref.flush();
    }

    public int getNewGames() {
        return newGames;
    }

    public void setNewGames(int newGames) {
        this.newGames = newGames;
        pref.putInteger("newGames", newGames);
        pref.flush();
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
        pref.putInteger("hits", hits);
        pref.flush();
    }

    public int getPowers() {
        return powers;
    }

    public void setPowers(int powers) {
        this.powers = powers;
        pref.putInteger("powers", powers);
        pref.flush();
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
        pref.putInteger("maxScore", maxScore);
        pref.flush();
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
        pref.putInteger("coins", coins);
        pref.flush();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
        pref.putString("language", language);
        pref.flush();
    }
}
