package com.davidcarrion.game.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Timer;
import com.davidcarrion.game.Helper.Constant;
import com.davidcarrion.game.Helper.ScrollHandler;
import com.davidcarrion.game.Helper.ShakeDetector;
import com.davidcarrion.game.Helper.Stopper;
import com.davidcarrion.game.MyGame;
import com.davidcarrion.game.Objects.Enemy;
import com.davidcarrion.game.Objects.Floor;
import com.davidcarrion.game.Objects.Knight;
import com.davidcarrion.game.Objects.NormalEnemy;
import com.davidcarrion.game.Objects.PauseButton;
import com.davidcarrion.game.Objects.SpecialEnemyArrow;
import com.davidcarrion.game.Screens.TutorialScreen;

import java.util.ArrayList;
/**
 * Esta clase gestiona los objetos del TutorialWorld y su actualizacion frame a frame
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class TutorialWorld {
    /**
     * Objeto caballero.
     */
    private Knight knight;
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
     * Objeto que gestiona la agitación de la pantalla.
     */
    private ShakeDetector shakeDetector;
    /**
     * Objeto que gestiona los objetos que heredan de Scrollable
     */
    private ScrollHandler scroller;
    /**
     * Screen del tutorial.
     */
    TutorialScreen screen;
    /**
     * Booleana que indica si se puede mostrar el texto de comienzo.
     */
    boolean comienzo = true;
    /**
     * Booleana que indica si se puede mostrar el texto de movimiento.
     */
    boolean movimiento = false;
    /**
     * Booleana que indica si se puede mostrar el texto de interfaz.
     */
    boolean gui = false;
    /**
     * Booleana que indica si se puede mostrar el texto de aparece enemigo.
     */
    boolean apareceEnemigo = false;
    /**
     * Booleana que indica si se puede mostrar el texto de aparece enemigo arrow.
     */
    boolean apareceArrow = false;
    /**
     * Booleana que indica si se puede mostrar el texto de poderes.
     */
    boolean aparecePoderes = false;
    /**
     * Booleana que indica si se puede mostrar el texto de final.
     */
    boolean finalTutorial = false;
    /**
     * Booleana auxiliar del texto comienzo.
     */
    boolean auxComienzo = true;
    /**
     * Booleana auxiliar del texto movimiento.
     */
    boolean auxMovimiento = false;
    /**
     * Booleana auxiliar del texto enemigo.
     */
    boolean auxApareceEnemigo = false;
    /**
     * Booleana auxiliar del texto arrow.
     */
    boolean auxApareceArrow = false;
    /**
     * Booleana auxiliar del texto poderes.
     */
    boolean auxAparecePoderes = false;
    /**
     * Booleana auxiliar del texto final.
     */
    boolean auxFinalTutorial = false;
    /**
     * Booleana auxiliar del texto final para salir.
     */
    boolean auxFinal = false;
    /**
     * Objeto que gestiona todos los updates de las clases del menú.
     */
    TutorialWorld world = this;


    /**
     *
     * @param game Clase principal donde se gestionan las distintas Screens.
     * @param screen Screen del tutorial.
     */
    public TutorialWorld(MyGame game, TutorialScreen screen) {
        this.game = game;
        this.screen = screen;
        knight = new Knight(Gdx.graphics.getWidth() / 2 - (Gdx.graphics.getWidth() / 8) / 2, Gdx.graphics.getHeight() / 8, Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 3, null, this);
        floor = new Floor(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() / 8, 0);
        shakeDetector = new ShakeDetector(knight);
        pauseButton = new PauseButton(game,2);
        scroller = new ScrollHandler();
    }

    /**
     * Metodo que gestiona los cambios de las variables y las actualiza.
     *
     * @param delta delta time
     */
    public void update(float delta) {
        knight.mana = 100;
        knight.live = 5;
        pauseButton.render();
        Gdx.app.log("Coleccion", "Tamaño coleccion: " + enemies.size());
        scroller.update(delta);
        knight.update(delta);
        if (enemies.size() > 0) {
            for (int i = 0; i < enemies.size(); i++) {
                Gdx.app.log("Coleccion", "Corre el enemigo" + i);
                enemies.get(i).update(delta);
            }
        }
        shakeDetector.update();
        if (comienzo) {
            TutorialScreen.pause = true;
            comienzo = false;
        } else {
            if (auxComienzo) {
                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        TutorialScreen.pause = false;
                        movimiento = true;
                        auxComienzo = false;
                    }
                }, 1f);
            }
        }

        if (movimiento) {
            TutorialScreen.pause = true;
            TutorialScreen.stopper = new Stopper("interfaz");
            movimiento = false;
            auxMovimiento = true;
        } else {
            if (auxMovimiento) {
                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        TutorialScreen.pause = false;
                        gui = true;
                        auxMovimiento = false;
                    }
                }, 1f);
            }
        }

        if (gui) {
            TutorialScreen.pause = true;
            TutorialScreen.stopper = new Stopper("movimiento");
            gui = false;
            auxApareceEnemigo = true;
        } else {
            if (auxApareceEnemigo) {
                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        if (enemies.size() == 0) {
                            apareceEnemigo = true;
                            auxApareceEnemigo = false;
                        }
                    }
                }, 1f);

            }
        }

        if (apareceEnemigo) {
            TutorialScreen.pause = true;
            TutorialScreen.stopper = new Stopper("enemigoNormal");
            enemies.add(new NormalEnemy(0 - knight.getWidth(), Gdx.graphics.getHeight() / 8, Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 3, null, world, 0));
            apareceEnemigo = false;
            auxApareceArrow = true;
        } else {
            if (auxApareceArrow) {
                TutorialScreen.pause = false;
                if (Gdx.input.isTouched()) {
                    Timer.schedule(new Timer.Task() {
                        @Override
                        public void run() {
                            if (enemies.size() == 0) {
                                apareceArrow = true;
                                auxApareceArrow = false;
                            }
                        }
                    }, 1f);
                }

            }
        }
        if (apareceArrow) {
            TutorialScreen.pause = true;
            TutorialScreen.stopper = new Stopper("enemigoFlecha");
            enemies.add(new SpecialEnemyArrow(0 - knight.getWidth(), Gdx.graphics.getHeight() / 8, Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 3, null, world, 0));
            apareceArrow = false;
            auxAparecePoderes = true;
        } else {
            if (auxAparecePoderes) {
                if (Gdx.input.isTouched()) {
                    Timer.schedule(new Timer.Task() {
                        @Override
                        public void run() {
                            if (enemies.size() == 0) {
                                aparecePoderes = true;
                                auxAparecePoderes = false;
                            }
                        }
                    }, 1f);
                }
            }
        }

        if (aparecePoderes) {
            TutorialScreen.pause = true;
            TutorialScreen.stopper = new Stopper("poderes");
            enemies.add(new NormalEnemy(Gdx.graphics.getWidth() + world.getKnigth().getWidth(), Gdx.graphics.getHeight() / 8, Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 3, null, world, 1));
            enemies.add(new NormalEnemy(Gdx.graphics.getWidth() + world.getKnigth().getWidth() + 10 * Constant.density, Gdx.graphics.getHeight() / 8, Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 3, null, world, 1));
            enemies.add(new NormalEnemy(Gdx.graphics.getWidth() + world.getKnigth().getWidth() + 30 * Constant.density, Gdx.graphics.getHeight() / 8, Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 3, null, world, 1));
            enemies.add(new NormalEnemy(Gdx.graphics.getWidth() + world.getKnigth().getWidth() + 50 * Constant.density, Gdx.graphics.getHeight() / 8, Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 3, null, world, 1));
            enemies.add(new NormalEnemy(Gdx.graphics.getWidth() + world.getKnigth().getWidth() + 70 * Constant.density, Gdx.graphics.getHeight() / 8, Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 3, null, world, 1));
            aparecePoderes = false;
            auxFinalTutorial = true;
        } else {
            if (auxFinalTutorial) {
                if (Gdx.input.isTouched()) {
                    Timer.schedule(new Timer.Task() {
                        @Override
                        public void run() {
                            if (enemies.size() == 0) {
                                finalTutorial = true;
                                auxFinalTutorial = false;
                            }
                        }
                    }, 2f);
                }
            }

        }
        if (finalTutorial) {
            TutorialScreen.pause = true;
            TutorialScreen.stopper = new Stopper("final");
            finalTutorial = false;
            auxFinal = true;
        } else {
            if (auxFinal) {
                if (Gdx.input.isTouched()) {
                    knight.shoot = false;
                    TutorialScreen.pause = false;
                    auxFinal = false;
                    Constant.menuMusic = true;
                    screen.setMenu();
                }
            }
        }
    }
    /**
     * Método que elimina un enemigo indicado del juego.
     *
     * @param enemy Objeto enemigo que se elimina.
     */
    public void deleteEnemy(Enemy enemy) {
        if (enemies.contains(enemy)) {
            enemies.remove(enemy);
            if (knight.mana < 100) {
                knight.mana += 10;
            }
        }
    }

    //Getters

    public Knight getKnigth() {
        return knight;
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
}
