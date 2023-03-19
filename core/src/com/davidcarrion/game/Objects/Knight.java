package com.davidcarrion.game.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.davidcarrion.game.Helper.AssetLoader;
import com.davidcarrion.game.Helper.Constant;
import com.davidcarrion.game.Helper.HitParticle;
import com.davidcarrion.game.Helper.SoundLoader;
import com.davidcarrion.game.MyGame;
import com.davidcarrion.game.Screens.GameScreen;
import com.davidcarrion.game.World.GameWorld;
import com.davidcarrion.game.World.TutorialWorld;

import java.util.ArrayList;

/**
 * Esta clase define el objeto del personaje principal del juego
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class Knight {
    /**
     * Estado del objeto.
     */
    State state;
    /**
     * Variable que indica los frames.
     */
    private float frames = 0f;

    /**
     * Enumerado con los estados del objeto.
     */
    public enum State {
        IDLE, CROUCH, JUMPING, DYING, HIT, HURT, FALLING, POWER, NULL
    }

    /**
     * Booleana que indica si esta saltando.
     */
    public boolean jumping = false;
    /**
     * Booleana que indica si esta agachado.
     */
    public boolean crouch = false;
    /**
     * Variable para saber si puede disparar.
     */
    public boolean shoot = true;
    /**
     * Booleana que indica si esta cayendo.
     */
    public boolean fall = true;
    /**
     * Booleana que indica si acabó la animación de morir.
     */
    public boolean endDeadAnimation = false;
    /**
     * Orientación del objeto.
     */
    public int orientation;
    /**
     * Vida del objeto.
     */
    public int live = 5;
    /**
     * Maná del objeto.
     */
    public int mana = 100;
    /**
     * Rectangulo del objeto.
     */
    private Rectangle rect;
    /**
     * Rectangulo de las animaciones.
     */
    private Rectangle sRect;
    /**
     * Rectangulo de la posición de movimientos del objeto.
     */
    private Rectangle allPositionRect;
    /**
     * Posición del obhjeto.
     */
    private Vector2 position;
    /**
     * Velocidad del objeto.
     */
    private Vector2 velocity;
    /**
     * Aceleración del objeto.
     */
    private Vector2 acceleration;
    /**
     * Array de objetos HitParticle del caballero.
     */
    public ArrayList<HitParticle> particles = new ArrayList<>();
    /**
     * Booleana que gestiona que el sonido de muerte solo suene una vez.
     */
    private boolean deadSound = true;
    /**
     * Ancho del objeto.
     */
    private int width;
    /**
     * Alto del objeto.
     */
    private int heigth;
    /**
     * Variable con el Ancho del objeto de pie.
     */
    private int normalHeigth;
    /**
     * Variable con el Alto del objeto de pie.
     */
    private int crouchHeigth;
    /**
     * Variable del sobrante entre el objeto floor y el caballero.
     */
    private float checkBugJump;
    /**
     * Clase donde se gestiona el objeto(En la pantalla de juego).
     */
    private GameWorld world;
    /**
     * Clase donde se gestiona el objeto(En el tutorial).
     */
    private TutorialWorld tutorialWorld = null;
    /**
     * Booleana que indica si estamos en el tutorial o no.
     */
    private boolean tutorialCharacter = false;
    /**
     * Sonido del poder del objeto.
     */
    Sound powerSound;
    /**
     * Objeto que se llama cada vez que se pulsa la pantalla y colisiona con el resto de objetos.
     */
    private Sword sword;
    /**
     * Objeto que se llama cada vez que se mantiene pulsada la pantalla y colisiona con el resto de objetos.
     */
    private Power1 power1;
    /**
     * Objeto que se llama cada vez que se agita el telefono y colisiona con el resto de objetos.
     */
    private Power2 power2;
    /**
     * Animaciones de orientación izquierda
     */
    Animation idleAnimation, crouchAnimation, hitAnimation, jumpAnimation, fallAnimation, powerAnimation, hurtAnimation, dieAnimation, volt;
    /**
     * Animaciones de orientacion derecha
     */
    Animation idleAnimationRight, crouchAnimationRight, hitAnimationRight, jumpAnimationRight, fallAnimationRight, powerAnimationRight, hurtAnimationRight, dieAnimationRight, voltRight;

    /**
     * Constructor para Knight
     *
     * @param x                 Posición en x del objeto.
     * @param y                 Posición en y del objeto.
     * @param width             Ancho del objeto.
     * @param heigth            Alto del objeto.
     * @param world             Clase donde se gestiona el objeto.
     * @param tutorialCharacter Booleana que indica si estamos en el tutorial o no.
     */
    public Knight(int x, int y, int width, int heigth, GameWorld world, boolean tutorialCharacter) {
        this.position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, -450 * Constant.density);

        if (tutorialWorld == null && !tutorialCharacter) {
            if (world.game.prefs.getKnightSelected() == 1) {
                idleAnimation = AssetLoader.IdleAnimationRed;
                idleAnimationRight = AssetLoader.IdleAnimationRightRed;
                crouchAnimation = AssetLoader.crouchAnimationRed;
                crouchAnimationRight = AssetLoader.crouchAnimationRightRed;
                hitAnimation = AssetLoader.attackAnimationRed;
                hitAnimationRight = AssetLoader.attackAnimationRightRed;
                jumpAnimation = AssetLoader.jumpAnimationRed;
                jumpAnimationRight = AssetLoader.jumpAnimationRightRed;
                fallAnimation = AssetLoader.fallAnimationRed;
                fallAnimationRight = AssetLoader.fallAnimationRightRed;
                powerAnimation = AssetLoader.powerAnimationRed;
                powerAnimationRight = AssetLoader.powerAnimationRightRed;
                hurtAnimation = AssetLoader.hurtAnimationRed;
                hurtAnimationRight = AssetLoader.hurtAnimationRightRed;
                dieAnimation = AssetLoader.deathAnimationRed;
                dieAnimationRight = AssetLoader.deathAnimationRightRed;
                volt = AssetLoader.fireVoltAnimation;
                voltRight = AssetLoader.fireVoltAnimationRight;
                powerSound = SoundLoader.fireShotSound;
            }
            if (world.game.prefs.getKnightSelected() == 2) {
                idleAnimation = AssetLoader.IdleAnimationBlue;
                idleAnimationRight = AssetLoader.IdleAnimationRightBlue;
                crouchAnimation = AssetLoader.crouchAnimationBlue;
                crouchAnimationRight = AssetLoader.crouchAnimationRightBlue;
                hitAnimation = AssetLoader.attackAnimationBlue;
                hitAnimationRight = AssetLoader.attackAnimationRightBlue;
                jumpAnimation = AssetLoader.jumpAnimationBlue;
                jumpAnimationRight = AssetLoader.jumpAnimationRightBlue;
                fallAnimation = AssetLoader.fallAnimationBlue;
                fallAnimationRight = AssetLoader.fallAnimationRightBlue;
                powerAnimation = AssetLoader.powerAnimationBlue;
                powerAnimationRight = AssetLoader.powerAnimationRightBlue;
                hurtAnimation = AssetLoader.hurtAnimationBlue;
                hurtAnimationRight = AssetLoader.hurtAnimationRightBlue;
                dieAnimation = AssetLoader.deathAnimationBlue;
                dieAnimationRight = AssetLoader.deathAnimationRightBlue;
                volt = AssetLoader.iceVoltAnimation;
                voltRight = AssetLoader.iceVoltAnimationRight;
                powerSound = SoundLoader.waterShotSound;
            }
            if (world.game.prefs.getKnightSelected() == 3) {
                idleAnimation = AssetLoader.IdleAnimationYellow;
                idleAnimationRight = AssetLoader.IdleAnimationRightYellow;
                crouchAnimation = AssetLoader.crouchAnimationYellow;
                crouchAnimationRight = AssetLoader.crouchAnimationRightYellow;
                hitAnimation = AssetLoader.attackAnimationYellow;
                hitAnimationRight = AssetLoader.attackAnimationRightYellow;
                jumpAnimation = AssetLoader.jumpAnimationYellow;
                jumpAnimationRight = AssetLoader.jumpAnimationRightYellow;
                fallAnimation = AssetLoader.fallAnimationYellow;
                fallAnimationRight = AssetLoader.fallAnimationRightYellow;
                powerAnimation = AssetLoader.powerAnimationYellow;
                powerAnimationRight = AssetLoader.powerAnimationRightYellow;
                hurtAnimation = AssetLoader.hurtAnimationYellow;
                hurtAnimationRight = AssetLoader.hurtAnimationRightYellow;
                dieAnimation = AssetLoader.deathAnimationYellow;
                dieAnimationRight = AssetLoader.deathAnimationRightYellow;
                volt = AssetLoader.thunderVoltAnimation;
                voltRight = AssetLoader.thunderVoltAnimationRight;
                powerSound = SoundLoader.thunderShotSound;
            }
            if (world.game.prefs.getKnightSelected() == 4) {
                idleAnimation = AssetLoader.IdleAnimationBrown;
                idleAnimationRight = AssetLoader.IdleAnimationRightBrown;
                crouchAnimation = AssetLoader.crouchAnimationBrown;
                crouchAnimationRight = AssetLoader.crouchAnimationRightBrown;
                hitAnimation = AssetLoader.attackAnimationBrown;
                hitAnimationRight = AssetLoader.attackAnimationRightBrown;
                jumpAnimation = AssetLoader.jumpAnimationBrown;
                jumpAnimationRight = AssetLoader.jumpAnimationRightBrown;
                fallAnimation = AssetLoader.fallAnimationBrown;
                fallAnimationRight = AssetLoader.fallAnimationRightBrown;
                powerAnimation = AssetLoader.powerAnimationBrown;
                powerAnimationRight = AssetLoader.powerAnimationRightBrown;
                hurtAnimation = AssetLoader.hurtAnimationBrown;
                hurtAnimationRight = AssetLoader.hurtAnimationRightBrown;
                dieAnimation = AssetLoader.deathAnimationBrown;
                dieAnimationRight = AssetLoader.deathAnimationRightBrown;
                volt = AssetLoader.dirtVoltAnimation;
                voltRight = AssetLoader.dirtVoltAnimationRight;
                powerSound = SoundLoader.dirtShotSound;

            }
        }

        this.heigth = heigth;
        this.width = width;
        rect = new Rectangle(x, y, width, heigth);
        sRect = new Rectangle(Gdx.graphics.getWidth() / 2 - Gdx.graphics.getWidth() / 8, y, Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 2.5f);
        allPositionRect = new Rectangle(x, 0, width, Gdx.graphics.getHeight());
        state = State.IDLE;

        crouchHeigth = heigth / 2;
        normalHeigth = heigth;
        this.world = world;
        checkBugJump = Gdx.graphics.getHeight() / 8;
        orientation = 0;
    }

    /**
     * @param x             Posición en x del objeto.
     * @param y             Posición en y del objeto.
     * @param width         Ancho del objeto.
     * @param heigth        Alto del objeto.
     * @param world         Clase donde se gestiona el objeto.
     * @param tutorialWorld Clase donde se gestiona el objeto del tutorial.
     */
    public Knight(int x, int y, int width, int heigth, GameWorld world, TutorialWorld tutorialWorld) {
        this(x, y, width, heigth, world, true);
        this.tutorialWorld = tutorialWorld;
        idleAnimation = AssetLoader.IdleAnimationRed;
        idleAnimationRight = AssetLoader.IdleAnimationRightRed;
        crouchAnimation = AssetLoader.crouchAnimationRed;
        crouchAnimationRight = AssetLoader.crouchAnimationRightRed;
        hitAnimation = AssetLoader.attackAnimationRed;
        hitAnimationRight = AssetLoader.attackAnimationRightRed;
        jumpAnimation = AssetLoader.jumpAnimationRed;
        jumpAnimationRight = AssetLoader.jumpAnimationRightRed;
        fallAnimation = AssetLoader.fallAnimationRed;
        fallAnimationRight = AssetLoader.fallAnimationRightRed;
        powerAnimation = AssetLoader.powerAnimationRed;
        powerAnimationRight = AssetLoader.powerAnimationRightRed;
        hurtAnimation = AssetLoader.hurtAnimationRed;
        hurtAnimationRight = AssetLoader.hurtAnimationRightRed;
        dieAnimation = AssetLoader.deathAnimationRed;
        dieAnimationRight = AssetLoader.deathAnimationRightRed;
        volt = AssetLoader.fireVoltAnimation;
        voltRight = AssetLoader.fireVoltAnimationRight;
        powerSound = SoundLoader.fireShotSound;
    }

    /**
     * Método que añade una particula de sangre al caballero.
     */
    public void addParticle() {
        HitParticle particle = new HitParticle(this, "blood");
        particles.add(particle);
    }

    /**
     * Metodo que elimina un HitParticle indicado.
     *
     * @param obj HitParticle que se elimina.
     */
    public void deleteParticle(HitParticle obj) {
        if (particles.contains(obj)) {
            particles.remove(obj);
        }
    }

    /**
     * Metodo que gestiona los cambios de las variables y las actualiza.
     *
     * @param delta delta time
     */
    public void update(float delta) {
        if (!state.equals(State.DYING)) {

            Gdx.app.log("DENSITY", "" + Constant.density);
            //Salto
            if (state.equals(State.JUMPING) || jumping) {
                velocity.add(acceleration.cpy().scl(delta));
                position.add(velocity.cpy().scl(delta));
                rect.x = position.x;
                rect.y = position.y;
                if (tutorialWorld == null) {
                    if (rect.overlaps(world.getFloor().getRect())) {
                        jumping = false;
                        fall = true;
                        if (position.y < checkBugJump) {
                            position.y += checkBugJump - position.y;
                            rect.y = position.y;
                        }
                        if (rect.height == crouchHeigth) {
                            state = State.CROUCH;
                            crouch = true;
                        } else {
                            state = State.IDLE;
                            crouch = false;
                        }
                    }
                } else {
                    if (rect.overlaps(tutorialWorld.getFloor().getRect())) {
                        jumping = false;
                        fall = true;
                        if (position.y < checkBugJump) {
                            position.y += checkBugJump - position.y;
                            rect.y = position.y;
                        }
                        if (rect.height == crouchHeigth) {
                            state = State.CROUCH;
                            crouch = true;
                        } else {
                            state = State.IDLE;
                            crouch = false;
                        }
                    }
                }
            }

            Gdx.app.log("PosicionY", "y:" + position.y);

            //Gestion del golpeo
            if (Gdx.input.justTouched()) {
                SoundLoader.soundSword.play(1.0f);
                if (Gdx.input.getX() <= Gdx.graphics.getWidth() / 2) {
                    orientation = 0;
                    sword = new Sword(getPosition().x - width / 2, getPosition().y, heigth);
                    HitParticle particle = new HitParticle(this, sword, "cut", 0);
                    particles.add(particle);
                } else {
                    orientation = 1;
                    sword = new Sword(getPosition().x + width, getPosition().y, heigth);
                    HitParticle particle = new HitParticle(this, sword, "cut", 1);
                    particles.add(particle);
                }
            } else {
                sword = null;
            }

            //Eliminar poderes
            if (power1 != null) {
                power1.update(delta);
            }

            if (power2 != null) {
                power2.update(delta);
            }

            if (live <= 0) {
                Gdx.app.log("KNIGTH DEATH", "TRUE");
                for (int i = 0; i < MyGame.musics.size(); i++) {
                    MyGame.musics.get(i).stop();
                }
                if (tutorialWorld == null) {
                    state = State.DYING;
                    if (deadSound) {
                        deadSound = false;
                        if (world.game.prefs.isSound()) {
                            SoundLoader.knightDieSound.play();
                        }
                    }
                    if (endDeadAnimation) {
                        world.game.prefs.setNewGames(world.game.prefs.getNewGames() + 1);
                        if (GameScreen.score > world.game.prefs.getMaxScore()) {
                            world.game.prefs.setMaxScore(GameScreen.score);
                        }
                        if (world.game.prefs.isMusic()) {
                            MyGame.musics.get(2).play();
                        }
                        Gdx.input.setInputProcessor(GameScreen.stageDead);
                        GameScreen.end = true;
                    }
                }
            }
            sRect.y = rect.y;
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
        frames += runtime;
        /*shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.MAGENTA);
        shapeRenderer.rect(sRect.x, sRect.y, sRect.width, sRect.height);
        shapeRenderer.setColor(Color.PINK);
        shapeRenderer.rect(allPositionRect.x, allPositionRect.y, allPositionRect.width, allPositionRect.height);
        shapeRenderer.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.MAGENTA);
        shapeRenderer.rect(rect.x, rect.y, rect.width, rect.height);
        if (sword != null) {
            shapeRenderer.rect(sword.getRect().x, sword.getRect().y, sword.getRect().width, sword.getRect().height);
        }
        shapeRenderer.end();*/

        if (power1 != null) {
            power1.draw(shapeRenderer, batch, frames);
        }

        if (power2 != null) {
            power2.draw(shapeRenderer, batch, frames);
        }

        batch.begin();
        if (state.equals(State.IDLE)) {
            if (orientation == 0) {
                batch.draw((TextureRegion) idleAnimationRight.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
            } else {
                batch.draw((TextureRegion) idleAnimation.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
            }
        }
        if (state.equals(State.CROUCH)) {
            if (frames > 2) {
                frames = runtime;
            }
            if (orientation == 0) {
                batch.draw((TextureRegion) crouchAnimationRight.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
            } else {
                batch.draw((TextureRegion) crouchAnimation.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
            }
        }
        if (state.equals(State.HIT)) {
            if (frames > 0.26) {
                frames = runtime;
            }
            if (orientation == 0) {
                batch.draw((TextureRegion) hitAnimationRight.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
                Gdx.app.log("KINGTH", "FRAMES: " + frames);
                if (hitAnimationRight.isAnimationFinished(frames)) {
                    Gdx.app.log("KINGTH", "FRAMES END: " + frames);
                    state = State.IDLE;
                    frames = runtime;
                }
            } else {
                batch.draw((TextureRegion) hitAnimation.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
                if (hitAnimation.isAnimationFinished(frames)) {
                    state = State.IDLE;
                    frames = runtime;
                }
            }
        }
        if (state.equals(State.JUMPING)) {
            if (frames > 3) {
                frames = runtime;
            }
            if (orientation == 0) {
                batch.draw((TextureRegion) jumpAnimationRight.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
            } else {
                batch.draw((TextureRegion) jumpAnimation.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
            }
        }
        if (state.equals(State.FALLING)) {
            if (orientation == 0) {
                batch.draw((TextureRegion) fallAnimationRight.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
            } else {
                batch.draw((TextureRegion) fallAnimation.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
            }
        }
        if (state.equals(State.POWER)) {
            if (frames > 2) {
                frames = runtime;
            }
            if (orientation == 0) {
                Gdx.app.log("KINGTH", "FRAMES: " + frames);
                batch.draw((TextureRegion) powerAnimationRight.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
                if (powerAnimationRight.isAnimationFinished(frames)) {
                    Gdx.app.log("KINGTH", "FRAMES END: " + frames);
                    state = State.IDLE;
                    frames = runtime;
                }
            } else {
                Gdx.app.log("KINGTH", "FRAMES: " + frames);
                batch.draw((TextureRegion) powerAnimation.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
                if (powerAnimation.isAnimationFinished(frames)) {
                    Gdx.app.log("KINGTH", "FRAMES END: " + frames);
                    state = State.IDLE;
                    frames = runtime;
                }
            }
        }
        if (state.equals(State.HURT)) {
            if (frames > 1) {
                frames = runtime;
            }
            Gdx.app.log("KINGTH", "FRAMES: " + frames);
            if (orientation == 0) {
                batch.draw((TextureRegion) hurtAnimationRight.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
                if (hurtAnimationRight.isAnimationFinished(frames)) {
                    Gdx.app.log("KINGTH", "FRAMES END: " + frames);
                    state = State.IDLE;
                    frames = runtime;
                }
            } else {
                batch.draw((TextureRegion) hurtAnimation.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
                if (hurtAnimation.isAnimationFinished(frames)) {
                    state = State.IDLE;
                    frames = runtime;
                }
            }
        }
        if (state.equals(State.DYING)) {
            if (orientation == 0) {
                batch.draw((TextureRegion) dieAnimationRight.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
                Gdx.app.log("DEAD", "FRAMES: " + frames);

                if (dieAnimationRight.isAnimationFinished(frames)) {
                    Gdx.app.log("DEAD", "FRAMES END: " + frames);
                    endDeadAnimation = true;
                    state = State.NULL;
                }
            } else {
                batch.draw((TextureRegion) dieAnimation.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
                if (dieAnimation.isAnimationFinished(frames)) {
                    endDeadAnimation = true;
                    state = State.NULL;

                }
            }
        }
        batch.end();
        for (int i = 0; i < particles.size(); i++) {
            particles.get(i).draw(shapeRenderer, batch, runtime);
        }
    }

    /**
     * Método que pone IDLE
     */
    public void OnClick() {
        shoot = true;
        if (!state.equals(State.DYING)) {
            if (state.equals(State.CROUCH) || crouch) {
                heigth = normalHeigth;
                rect.height = heigth;
                state = State.IDLE;
            }
            crouch = false;
            state = State.HIT;
        }
    }

    /**
     * Método que detecta si el objeto tiene que saltar, agacharse o caer.
     *
     * @param deltaX Posición inicial de la pulsación de la pantalla en x.
     * @param deltaY Posición inicial de la pulsación de la pantalla en y.
     */
    public void jump(float deltaX, float deltaY) {
        if (!state.equals(State.DYING)) {

            //Salto
            if (deltaY < -10 * Constant.density) {
                if (!state.equals(State.JUMPING) && !jumping) {
                    if (state.equals(State.CROUCH) || crouch) {
                        heigth = normalHeigth;
                        rect.height = heigth;
                        crouch = false;
                    }
                    velocity.y = 450 * Constant.density;
                    state = State.JUMPING;
                    jumping = true;
                    if (tutorialWorld == null) {
                        if (world.game.prefs.isSound()) {
                            SoundLoader.jumpSound.play();
                        }
                        world.game.prefs.setJumps(world.game.prefs.getJumps() + 1);
                    } else {
                        if (tutorialWorld.game.prefs.isSound()) {
                            SoundLoader.jumpSound.play();
                        }
                    }
                }
            }
            //Agacharse
            if (deltaY > 10 * Constant.density) {
                if ((!state.equals(State.JUMPING) || !jumping)) {
                    heigth = crouchHeigth;
                    rect.height = heigth;
                    state = State.CROUCH;
                    crouch = true;
                }
            }
            //Caer fuerte
            if (deltaY > 10 * Constant.density) {
                if (state.equals(State.JUMPING) || jumping) {
                    velocity.y = -700 * Constant.density;
                    if (tutorialWorld == null) {
                        if (world.game.prefs.isSound()) {
                            SoundLoader.fallSound.play();
                        }
                    } else {
                        if (tutorialWorld.game.prefs.isSound()) {
                            SoundLoader.fallSound.play();
                        }
                    }

                    state = State.FALLING;
                }
            }
        }
    }

    /**
     * Método que lanza el poder 1
     */
    public void shoot() {


        if (!state.equals(State.DYING)) {
            if (mana >= 50) {
                if (state.equals(State.CROUCH)) {
                    heigth = normalHeigth;
                    rect.height = heigth;
                }
                state = State.POWER;
                if (tutorialWorld == null) {
                    if (world.game.prefs.isSound()) {
                        powerSound.play();
                    }
                    if (world.game.prefs.isVibration()) {
                        Gdx.input.vibrate(200);
                    }
                } else {
                    if (tutorialWorld.game.prefs.isSound()) {
                        powerSound.play();
                    }
                    if (tutorialWorld.game.prefs.isVibration()) {
                        Gdx.input.vibrate(200);
                    }
                }

                int rotation;
                if (Gdx.input.getX() <= Gdx.graphics.getWidth() / 2) {
                    rotation = 0;
                } else {
                    rotation = 1;
                }
                mana -= 50;
                if (tutorialWorld == null) {
                    world.game.prefs.setPowers(world.game.prefs.getPowers() + 1);
                }
                power1 = new Power1(Gdx.graphics.getWidth() / 2, getPosition().y + heigth / 2, Gdx.graphics.getWidth() / 12, this, rotation, volt, voltRight);
            }

        }
    }

    /**
     * Método que lanza el poder 2
     */
    public void shake() {
        if (!state.equals(State.DYING)) {
            if (mana == 100) {
                if (state.equals(State.CROUCH)) {
                    heigth = normalHeigth;
                    rect.height = heigth;
                }
                state = State.POWER;
                if (tutorialWorld == null) {
                    if (world.game.prefs.isSound()) {
                        powerSound.play();
                    }
                    if (world.game.prefs.isVibration()) {
                        Gdx.input.vibrate(500);
                    }
                } else {
                    if (tutorialWorld.game.prefs.isSound()) {
                        powerSound.play();
                    }
                    if (tutorialWorld.game.prefs.isVibration()) {
                        Gdx.input.vibrate(500);
                    }
                }

                mana -= 100;
                if (tutorialWorld == null) {
                    world.game.prefs.setPowers(world.game.prefs.getPowers() + 1);
                }
                power2 = new Power2(this, volt, voltRight);
            }
        }
    }

    /**
     * Método que elimina el poder 1.
     */
    public void deletePower() {
        power1 = null;
    }


    //Getters

    public Vector2 getPosition() {
        return position;
    }

    public int getWidth() {
        return width;
    }

    public int getHeigth() {
        return heigth;
    }

    public Rectangle getRect() {
        return rect;
    }

    public Sword getSword() {
        return sword;
    }

    public Power1 getPower1() {
        return power1;
    }

    public Power2 getPower2() {
        return power2;
    }

    public Rectangle getAllPositionRect() {
        return allPositionRect;
    }
}
