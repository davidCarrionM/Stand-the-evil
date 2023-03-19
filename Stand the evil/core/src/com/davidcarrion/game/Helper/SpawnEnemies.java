package com.davidcarrion.game.Helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.davidcarrion.game.Objects.Enemy;
import com.davidcarrion.game.Objects.NormalEnemy;
import com.davidcarrion.game.Objects.SpecialEnemyA;
import com.davidcarrion.game.Objects.SpecialEnemyArrow;
import com.davidcarrion.game.Objects.SpecialEnemyB;
import com.davidcarrion.game.Objects.SpecialEnemyC;
import com.davidcarrion.game.Screens.GameScreen;
import com.davidcarrion.game.World.GameWorld;

import java.util.ArrayList;
import java.util.Random;

/**
 * Esta clase gestiona la aparicion de enemigos y de que tipo, al igual que el tiempo en el que aparecen
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class SpawnEnemies {
    /**
     * Posicion del enemigo para la parte izquierda.
     */
    private Vector2 spawnLeft;
    /**
     * Posicion del enemigo para la parte derecha.
     */
    private Vector2 spawnRigth;
    /**
     * Ancho del objeto enemigo.
     */
    private int widthEnemy;
    /**
     * Alto del objeto enemigo.
     */
    private int heigthEnemy;
    /**
     * Mundo donde se crea objeto enemigo.
     */
    private GameWorld world;
    /**
     * Objeto random para generar un numero aleatorio
     */
    private Random random = new Random();
    /**
     * Orientacion del objeto enemigo.
     */
    private int orientation;
    /**
     * Tipo de enemigo.
     */
    private int typeEnemy;
    /**
     * Tiempo mínimo que pasa entre spawn.
     */
    private float minTime = 0.5f;
    /**
     * Tiempo máximo que pasa entre spawn.
     */
    private float maxTime = 5f;
    /**
     * Booleana auxiliar para cambiar el periodo de spawn.
     */
    private boolean changePeriod = true;

    //Periodo random entre 3-5 luego entre 2-4, ...
    /**
     * Tiempo que pasa hasta llegar a period.
     */
    private float timeSeconds = 0f;
    /**
     * Tiempo entre spawn.
     */
    private float period = 5f;

    /**
     * Constructor para SpawnEnemies.
     *
     * @param y     posicion en y donde se genera el objeto enemigo.
     * @param world clase Screen donde se crea el objeto.
     */
    public SpawnEnemies(float y, GameWorld world) {
        this.world = world;
        widthEnemy = Gdx.graphics.getWidth() / 8;
        heigthEnemy = Gdx.graphics.getHeight() / 3;
        spawnLeft = new Vector2(0 - world.getKnigth().getWidth(), y);
        spawnRigth = new Vector2(Gdx.graphics.getWidth() + world.getKnigth().getWidth(), y);
        period = (float) (Math.random() * (maxTime - minTime)) + maxTime;
    }

    /**
     * Metodo que gestiona los cambios de las variables y las actualiza.
     *
     * @param delta delta time.
     */
    public void update(float delta, ArrayList<Enemy> enemies) {


        Gdx.app.log("RANDOM", "" + period);

        if (GameScreen.score != 0 && GameScreen.score % 50 == 0) {
            if (changePeriod) {
                if (maxTime > 0.5) {
                    maxTime -= 0.5;
                }
                changePeriod = false;
            }
        } else {
            changePeriod = true;
        }

        timeSeconds += Gdx.graphics.getDeltaTime();
        if (timeSeconds > period) {
            timeSeconds -= period;
            period = minTime + random.nextFloat() * (maxTime - minTime);
            orientation = random.nextInt(2);
            //orientation = 1;
            typeEnemy = random.nextInt(100) + 1;
            //typeEnemy =  91;
            if (typeEnemy > 0 && typeEnemy <= 60) {
                if (orientation == 0) {
                    enemies.add(new NormalEnemy(spawnLeft.x, spawnLeft.y, widthEnemy, heigthEnemy, world, orientation));
                } else {
                    enemies.add(new NormalEnemy(spawnRigth.x, spawnRigth.y, widthEnemy, heigthEnemy, world, orientation));
                }
            } else {
                if (typeEnemy > 60 && typeEnemy <= 70) {
                    if (orientation == 0) {
                        enemies.add(new SpecialEnemyArrow(spawnLeft.x, spawnLeft.y, widthEnemy, heigthEnemy, world, orientation));
                    } else {
                        enemies.add(new SpecialEnemyArrow(spawnRigth.x, spawnRigth.y, widthEnemy, heigthEnemy, world, orientation));
                    }
                } else {
                    if (typeEnemy > 70 && typeEnemy <= 80) {
                        if (orientation == 0) {
                            enemies.add(new SpecialEnemyA(spawnLeft.x, spawnLeft.y, widthEnemy, heigthEnemy, world, orientation));
                        } else {
                            enemies.add(new SpecialEnemyA(spawnRigth.x, spawnRigth.y, widthEnemy, heigthEnemy, world, orientation));
                        }
                    } else {
                        if (typeEnemy > 80 && typeEnemy <= 90) {
                            if (orientation == 0) {
                                enemies.add(new SpecialEnemyB(spawnLeft.x, spawnLeft.y, widthEnemy, heigthEnemy, world, orientation));
                            } else {
                                enemies.add(new SpecialEnemyB(spawnRigth.x, spawnRigth.y, widthEnemy, heigthEnemy, world, orientation));
                            }
                        } else {
                            if (orientation == 0) {
                                enemies.add(new SpecialEnemyC(spawnLeft.x, spawnLeft.y, widthEnemy, Gdx.graphics.getHeight() / 5, world, orientation));
                            } else {
                                enemies.add(new SpecialEnemyC(spawnRigth.x, spawnRigth.y, widthEnemy, Gdx.graphics.getHeight() / 5, world, orientation));
                            }
                        }
                    }
                }
            }
        }
    }
}

