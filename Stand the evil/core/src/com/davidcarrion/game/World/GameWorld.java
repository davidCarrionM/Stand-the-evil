package com.davidcarrion.game.World;

import com.badlogic.gdx.Gdx;
import com.davidcarrion.game.Helper.ScrollHandler;
import com.davidcarrion.game.Helper.ShakeDetector;
import com.davidcarrion.game.Helper.SpawnEnemies;
import com.davidcarrion.game.MyGame;
import com.davidcarrion.game.Objects.Coin;
import com.davidcarrion.game.Objects.Enemy;
import com.davidcarrion.game.Objects.Floor;
import com.davidcarrion.game.Objects.Hearth;
import com.davidcarrion.game.Objects.Knight;
import com.davidcarrion.game.Objects.PauseButton;
import com.davidcarrion.game.Screens.GameScreen;

import java.util.ArrayList;

/**
 * Esta clase gestiona los objetos del GameScreen y su actualizacion frame a frame
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class GameWorld {
    /**
     * Objeto caballero.
     */
    private Knight knight;
    /**
     * Objeto enemigo.
     */
    private Enemy enemy;
    /**
     * Objeto suelo del escenario.
     */
    private Floor floor;
    /**
     * Objeto de botón de pause.
     */
    private PauseButton pauseButton;
    /**
     * Clase principal donde se gestionan las distintas Screens.
     */
    public MyGame game;
    /**
     * Colección de enemigos del juego.
     */
    private ArrayList<Enemy> enemies = new ArrayList<>();
    /**
     * Colección de monedas del juego.
     */
    public ArrayList<Coin> coins = new ArrayList<>();
    /**
     * Colección de corazones del juego.
     */
    public ArrayList<Hearth> hearths = new ArrayList<>();
    /**
     * Objeto que gestiona el spawn de los enemigos.
     */
    private SpawnEnemies spawnEnemies;
    /**
     * Objeto que gestiona la agitación de la pantalla.
     */
    private ShakeDetector shakeDetector;
    /**
     * Objeto que gestiona los objetos que heredan de Scrollable
     */
    private ScrollHandler scroller;


    /**
     * Constructor para GameWorld.
     *
     * @param game Clase principal donde se gestionan las distintas Screens.
     */
    public GameWorld(MyGame game) {
        this.game = game;
        knight = new Knight(Gdx.graphics.getWidth() / 2 - (Gdx.graphics.getWidth() / 8) / 2, Gdx.graphics.getHeight() / 8, Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 3, this, false);
        floor = new Floor(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() / 8, 0);
        shakeDetector = new ShakeDetector(knight);
        spawnEnemies = new SpawnEnemies(Gdx.graphics.getHeight() / 8, this);
        pauseButton = new PauseButton(game, 1);
        scroller = new ScrollHandler();
    }

    /**
     * Metodo que gestiona los cambios de las variables y las actualiza.
     *
     * @param delta delta time
     */
    public void update(float delta) {
        scroller.update(delta);
        knight.update(delta);
        Gdx.app.log("END", "END: " + GameScreen.end);
        if (!GameScreen.end) {
            if (enemies.size() > 0) {
                for (int i = 0; i < enemies.size(); i++) {
                    enemies.get(i).update(delta);
                }
            }
            if (coins.size() > 0) {
                for (int i = 0; i < coins.size(); i++) {
                    coins.get(i).update(delta);
                }
            }
            if (hearths.size() > 0) {
                for (int i = 0; i < hearths.size(); i++) {
                    hearths.get(i).update(delta);
                }
            }
            shakeDetector.update();
            spawnEnemies.update(delta, enemies);
        }
        pauseButton.render();
        Gdx.app.log("ENEMIES", "LENGTH: " + enemies.size());
    }

    /**
     * Método que elimina un enemigo indicado del juego.
     *
     * @param enemy Objeto enemigo que se elimina.
     */
    public void deleteEnemy(Enemy enemy) {
        Gdx.app.log("ENEMIES", "ELIMINAR: " + enemy.toString());
        if (enemies.contains(enemy)) {
            enemies.remove(enemy);
            if (knight.mana < 100) {
                knight.mana += 10;
            }
        }
    }

    /**
     * Método que elimina una moneda indicada del juego.
     *
     * @param coin Objeto moneda que se elimina.
     */
    public void deleteCoins(Coin coin) {
        if (coins.contains(coin)) {
            coins.remove(coin);
        }
    }

    /**
     * Método que elimina un corazón indicado del juego.
     *
     * @param hearth Objeto corazón que se elimina.
     */
    public void deleteHearths(Hearth hearth) {
        if (hearths.contains(hearth)) {
            hearths.remove(hearth);
        }
    }


    //Getters

    public Knight getKnigth() {
        return knight;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public Floor getFloor() {
        return floor;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public PauseButton getPauseButton() {
        return pauseButton;
    }

    public ScrollHandler getScroller() {
        return scroller;
    }

    public ArrayList<Coin> getCoins() {
        return coins;
    }

    public ArrayList<Hearth> getHearths() {
        return hearths;
    }
}
