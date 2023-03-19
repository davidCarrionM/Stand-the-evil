package com.davidcarrion.game.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.davidcarrion.game.Helper.Constant;
import com.davidcarrion.game.Helper.HitParticle;
import com.davidcarrion.game.Helper.SoundLoader;
import com.davidcarrion.game.Screens.GameScreen;
import com.davidcarrion.game.World.GameWorld;
import com.davidcarrion.game.World.TutorialWorld;

import java.util.ArrayList;
import java.util.Random;

/**
 * Esta clase define el objeto enemigo que se mueve hacia el enemigo y lo golpea
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class Enemy {
    /**
     * Estado del objeto
     */
    State state;
    /**
     * Vidas del objeto
     */
    public int live = 3;
    /**
     * Booleana que indica si acabo la animación de muerte del objeto
     */
    public boolean endAnimacion = false;
    /**
     * Enumerado con los estados del objeto
     */
    public enum State {
        RUNNING, DYING, HIT, DAMAGE, NULL, IDLE
    }
    /**
     * Color del rectangulo en el debug.
     */
    private Color color;
    /**
     * Rectangulo del objeto.
     */
    private Rectangle rect;
    /**
     * Posición del objeto.
     */
    private Vector2 position;
    /**
     * Velocidad del objeto.
     */
    private Vector2 velocity;
    /**
     * Booleana que indica si el enemigo esta muerto.
     */
    protected boolean dead = false;
    /**
     * Ancho del objeto.
     */
    private int width;
    /**
     * Alto del objeto.
     */
    private int heigth;
    /**
     * Booleana que gestiona que el sonido de muerte solo suene una vez.
     */
    private boolean deadSound = true;
    /**
     * Orientación del objeto.
     */
    private int orientation;
    /**
     * Tiempo que va pasando.
     */
    private float timeSeconds = 0f;
    /**
     * Tiempo limite.
     */
    private float period = 1f;
    /**
     * Clase donde se gestiona el objeto(En la pantalla de juego)
     */
    private GameWorld world;
    /**
     * Objeto caballero que interactua con el objeto
     */
    private Knight knight;
    /**
     * Clase donde se gestiona el objeto(En el tutorial)
     */
    public TutorialWorld tutorialWorld;
    /**
     * Objeto espada que colisiona con el objeto.
     */
    private Sword sword;

    /**
     * Constructor para Enemy con el GameWorld.
     *
     * @param x           Posición x del objeto
     * @param y           Posición y del objeto.
     * @param width       Ancho del objeto.
     * @param heigth      Alto del objeto.
     * @param world       Clase donde se gestiona el objeto.
     * @param orientation Orientación del objeto.
     */
    public Enemy(float x, float y, int width, int heigth, GameWorld world, int orientation) {

        this.orientation = orientation;
        if (orientation == 0) {
            this.position = new Vector2(x, y);
            velocity = new Vector2(100 * Constant.density, 0);
        } else {
            this.position = new Vector2(x, y);
            velocity = new Vector2(-100 * Constant.density, 0);
        }
        this.heigth = heigth;
        this.width = width;
        rect = new Rectangle(x, y, width, heigth);

        state = State.RUNNING;

        this.world = world;
        this.tutorialWorld = null;
        knight = world.getKnigth();

        color = Color.RED;
    }

    /**
     * Constructor para Enemy con el TutorialWorld.
     *
     * @param x             Posición x del objeto
     * @param y             Posición y del objeto.
     * @param width         Ancho del objeto.
     * @param heigth        Alto del objeto.
     * @param tutorialWorld Clase donde se gestiona el objeto.
     * @param orientation   Orientación del objeto.
     */
    public Enemy(float x, float y, int width, int heigth, TutorialWorld tutorialWorld, int orientation) {
        this.orientation = orientation;
        if (orientation == 0) {
            this.position = new Vector2(x, y);
            velocity = new Vector2(100 * Constant.density, 0);
        } else {
            this.position = new Vector2(x, y);
            velocity = new Vector2(-100 * Constant.density, 0);
        }
        this.heigth = heigth;
        this.width = width;
        rect = new Rectangle(x, y, width, heigth);

        state = State.RUNNING;

        this.tutorialWorld = tutorialWorld;
        knight = tutorialWorld.getKnigth();

        color = Color.RED;
    }

    /**
     * Metodo que gestiona los cambios de las variables y las actualiza.
     *
     * @param delta delta time
     */
    public void update(float delta) {
        delete(this);
        Gdx.app.log("ENDANIMATION", "ENTRA UPDATE " + endAnimacion);
        if (!dead) {
            colider(delta);
            rect.x = position.x;
            rect.y = position.y;
            if (orientation == 0) {
                if (position.x + width > Gdx.graphics.getWidth() + width * 2) {
                    if (tutorialWorld == null) {
                        world.deleteEnemy(this);
                    } else {
                        tutorialWorld.deleteEnemy(this);
                    }
                }
            }
            if (orientation == 1) {
                if (position.x + width < 0 - width * 2) {
                    if (tutorialWorld == null) {
                        world.deleteEnemy(this);
                    } else {
                        tutorialWorld.deleteEnemy(this);
                    }
                }
            }
            Gdx.app.log("Position Enemigo", "" + position.x + " " + rect.x);
        }
    }

    /**
     * Metodo que dibuja las animaciones y texturas.
     *
     * @param shapeRenderer Dibujador de figuras.
     * @param batch         Dibujador de animaciones.
     * @param runtime       Delta time.
     */
    public void draw(ShapeRenderer shapeRenderer, SpriteBatch batch, float runtime) {
        /*shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(color);
        shapeRenderer.rect(rect.x, rect.y, width, heigth);
        Gdx.app.log("Position Enemigo RENDER", "" + position.x + " " + rect.x);
        if (sword != null) {
            shapeRenderer.rect(sword.rect.x, sword.rect.y, sword.rect.width, sword.rect.height);
        }
        shapeRenderer.end();*/
    }

    /**
     * Metodo que comprueba y gestiona las colisiones.
     *
     * @param delta Delta time.
     */
    public void colider(float delta) {
        ArrayList<Enemy> enemies;
        if (tutorialWorld == null) {
            enemies = world.getEnemies();
        } else {
            enemies = tutorialWorld.getEnemies();
        }
        for (int i = 0; i < enemies.size(); i++) {
            if (enemies.get(i) instanceof SpecialEnemyArrow) {
                if (((SpecialEnemyArrow) enemies.get(i)).getArrow() != null && ((SpecialEnemyArrow) enemies.get(i)).getArrow().isHitEnemy()) {
                    if (Intersector.overlaps(((SpecialEnemyArrow) enemies.get(i)).getArrow().getCircle(), rect)) {
                        Gdx.app.log("ELIMINAR ENEMIGO", "ENEMY BALL");
                        GameScreen.score += 10;
                        ((SpecialEnemyArrow) enemies.get(i)).deleteArrow();
                        HitParticle particle = new HitParticle(this, "epower");
                        knight.particles.add(particle);
                        live -= 3;
                    }
                }
            }
        }
        if (knight.getPower1() != null) {
            if (tutorialWorld == null) {
                if (Intersector.overlaps(world.getKnigth().getPower1().getCircle(), rect)) {
                    Gdx.app.log("ELIMINAR ENEMIGO", "POWER 1");
                    GameScreen.score += 10;
                    world.game.prefs.setVoltDies(world.game.prefs.getVoltDies() + 1);
                    HitParticle particle = new HitParticle(this, "kpower");
                    knight.particles.add(particle);
                    live -= 3;
                }
            } else {
                if (Intersector.overlaps(tutorialWorld.getKnigth().getPower1().getCircle(), rect)) {
                    Gdx.app.log("ELIMINAR ENEMIGO", "POWER 1");
                    HitParticle particle = new HitParticle(this, "kpower");
                    knight.particles.add(particle);
                    live -= 3;
                }
            }

        }

        if (knight.getPower2() != null && knight.getPower2().getMeteors() != null) {
            Meteor[] meteors = knight.getPower2().getMeteors();
            for (int i = 0; i < meteors.length; i++) {
                if (Intersector.overlaps(meteors[i].getCircle(), rect)) {
                    Gdx.app.log("ELIMINAR ENEMIGO", "POWER 2, BALL:" + meteors[i].getIndex());
                    GameScreen.score += 10;
                    if (tutorialWorld == null) {
                        world.game.prefs.setVoltDies(world.game.prefs.getVoltDies() + 1);
                    }
                    HitParticle particle = new HitParticle(this, "up");
                    knight.particles.add(particle);
                    live -= 3;
                }
            }
        }

        if (sword != null) {
            if (sword.rect.overlaps(knight.getRect())) {
                Gdx.app.log("KNIGTH HIT", "TRUE");
                sword = null;
                if (!getKnight().state.equals(Knight.State.DYING)) {
                    getKnight().state = Knight.State.HURT;
                    if (tutorialWorld == null) {
                        if (world.game.prefs.isVibration()) {
                            Gdx.input.vibrate(100);
                        }
                        if (world.game.prefs.isSound()) {
                            SoundLoader.knightDamageSound.play();
                        }
                    } else {
                        if (tutorialWorld.game.prefs.isVibration()) {
                            Gdx.input.vibrate(100);
                        }
                        if (tutorialWorld.game.prefs.isSound()) {
                            SoundLoader.knightDamageSound.play();
                        }
                    }
                    knight.live -= 1;
                    if (tutorialWorld == null) {
                        world.game.prefs.setHits(world.game.prefs.getHits() + 1);
                    }
                    knight.addParticle();
                }
            } else {
                if (sword.rect.overlaps(knight.getAllPositionRect())) {
                    Gdx.app.log("KNIGTH HIT", "FALSE");
                    sword = null;
                }
            }

        }
    }

    /**
     * Metodo que elimina del World el enemigo indicado.
     *
     * @param enemy Objeto enemigo que se elimina.
     */
    public void delete(final Enemy enemy) {
        Gdx.app.log("ENDANIMATION5", "Lives: " + live + "  " + endAnimacion);
        if (live <= 0) {
            Gdx.app.log("ENDANIMATION2", "" + endAnimacion);
            if (deadSound) {
                deadSound = false;
                if (tutorialWorld == null) {
                    if (world.game.prefs.isSound()) {
                        SoundLoader.EnemyDieSound.play();
                    }
                } else {
                    if (tutorialWorld.game.prefs.isSound()) {
                        SoundLoader.EnemyDieSound.play();
                    }
                }
            }
            if (endAnimacion) {
                if (tutorialWorld == null) {
                    world.deleteEnemy(enemy);
                } else {
                    tutorialWorld.deleteEnemy(enemy);
                }
            }
            if (!state.equals(State.NULL) && !state.equals(State.DYING)) {
                if (tutorialWorld == null) {
                    Random random = new Random();
                    if (random.nextInt(4) == 0) {
                        if (world.game.prefs.isSound()) {
                            SoundLoader.coinSound.play();
                        }
                        Coin coin = new Coin(this, world);
                        world.coins.add(coin);
                        GameScreen.coins++;
                        world.game.prefs.setCoins(world.game.prefs.getCoins() + 1);
                    } else {

                        if (random.nextInt(20) == 0) {
                            if (world.game.prefs.isSound()) {
                                SoundLoader.heartSound.play();
                            }
                            Hearth hearth = new Hearth(this, world);
                            world.hearths.add(hearth);
                            if (knight.live < 5) {
                                knight.live++;
                            }
                        }
                    }
                    if (enemy.getClass().equals(NormalEnemy.class)) {
                        world.game.prefs.setNormalEnemies(world.game.prefs.getNormalEnemies() + 1);
                    } else {
                        if (enemy.getClass().equals(SpecialEnemyA.class)) {
                            world.game.prefs.setSpecialEnemiesA(world.game.prefs.getSpecialEnemiesA() + 1);
                        } else {
                            if (enemy.getClass().equals(SpecialEnemyB.class)) {
                                world.game.prefs.setSpecialEnemiesB(world.game.prefs.getSpecialEnemiesB() + 1);
                            } else {
                                if (enemy.getClass().equals(SpecialEnemyC.class)) {
                                    world.game.prefs.setSpecialEnemiesC(world.game.prefs.getSpecialEnemiesC() + 1);
                                } else {
                                    world.game.prefs.setSpecialEnemiesArrow(world.game.prefs.getSpecialEnemiesArrow() + 1);
                                }
                            }
                        }
                    }
                }
                state = State.DYING;
                dead = true;
            }
        }
    }

    /*public void hit(final Enemy enemy, int damager) {

        float delay = 0.5f;
        dead = true;
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                dead = false;
            }
        }, delay);
    }*/

    public int getOrientation() {
        return orientation;
    }

    public Rectangle getRect() {
        return rect;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public int getWidth() {
        return width;
    }

    public int getHeigth() {
        return heigth;
    }

    public GameWorld getWorld() {
        return world;
    }

    public Sword getSword() {
        return sword;
    }

    public void setSword(Sword sword) {
        this.sword = sword;
    }

    public Knight getKnight() {
        return knight;
    }

    public void setRect(float x, float y) {
        this.rect.x = x;
        this.rect.y = y;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public float getTimeSeconds() {
        return timeSeconds;
    }

    public void setTimeSeconds(float timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public float getPeriod() {
        return period;
    }

    public void setPeriod(float period) {
        this.period = period;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
