package com.davidcarrion.game.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.davidcarrion.game.Helper.AssetLoader;
import com.davidcarrion.game.Helper.HitParticle;
import com.davidcarrion.game.Helper.SoundLoader;
import com.davidcarrion.game.Screens.GameScreen;
import com.davidcarrion.game.World.GameWorld;
import com.davidcarrion.game.World.TutorialWorld;

/**
 * Esta clase define un objeto que hereda de enemigo y se comportará como un enemigo normal que lanza una vez un objeto Arrow
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class SpecialEnemyArrow extends Enemy {
    /**
     * Booleana que indica si se realizo el disparo.
     */
    private boolean onlyShoot;
    /**
     * Objeto Arrow que lanza el objeto.
     */
    private Arrow arrow;
    /**
     * Booleana que indica si esta en la posición correcta para disparar
     */
    private boolean comprobation;
    /**
     * Booleana que indica si puede caminar al acabar de disparar.
     */
    private boolean runAgain;
    /**
     * Variable que indica los frames.
     */
    float frames = 0f;
    /**
     * Rectangulo para las animaciones.
     */
    Rectangle sRect;
    /**
     * Clase donde se gestiona el objeto(En el tutorial).
     */
    TutorialWorld tutorialWorld;
    /**
     * Clase donde se gestiona el objeto(En el juego).
     */
    private GameWorld world;

    /**
     * Constructor para SpecialEnemyArrow con parametro GameWorld
     *
     * @param x           Posición de x del objeto.
     * @param y           Posición de y del objeto.
     * @param width       Ancho del objeto.
     * @param heigth      Alto del objeto.
     * @param world       Clase donde se gestiona el objeto.
     * @param orientation Orientación del objeto.
     */
    public SpecialEnemyArrow(float x, float y, int width, int heigth, GameWorld world, int orientation) {
        super(x, y, width, heigth, world, orientation);
        this.world = world;
        onlyShoot = true;
        runAgain = false;
        if (orientation == 0) {
            sRect = new Rectangle(x, y, width + width / 2, heigth + width / 2);
        } else {
            sRect = new Rectangle(x - width / 2, y, width + width / 2, heigth + width / 2);
        }
    }

    /**
     * Constructor para SpecialEnemyArrow con parametro TutorialWorld
     *
     * @param x             Posición de x del objeto.
     * @param y             Posición de y del objeto.
     * @param width         Ancho del objeto.
     * @param heigth        Alto del objeto.
     * @param world         Clase donde se gestiona el objeto.
     * @param tutorialWorld Clase tutorial donde se gestiona el objeto.
     * @param orientation   Orientación del objeto.
     */
    public SpecialEnemyArrow(float x, float y, int width, int heigth, GameWorld world, TutorialWorld tutorialWorld, int orientation) {
        super(x, y, width, heigth, tutorialWorld, orientation);
        this.world = world;
        onlyShoot = true;
        runAgain = false;
        if (orientation == 0) {
            sRect = new Rectangle(x, y, width + width / 2, heigth + width / 2);
        } else {
            sRect = new Rectangle(x - width / 2, y, width + width / 2, heigth + width / 2);
        }
        this.tutorialWorld = tutorialWorld;
    }

    /**
     * Metodo que dibuja las animaciones y texturas.
     *
     * @param shapeRenderer Dibujador de figuras.
     * @param batch         Dibujador de animaciones.
     * @param runtime       Delta time.
     */
    @Override
    public void draw(ShapeRenderer shapeRenderer, SpriteBatch batch, float runtime) {
        super.draw(shapeRenderer, batch, runtime);
        if (arrow != null) {
            arrow.draw(shapeRenderer, batch, runtime);
        }
        frames += runtime;
        batch.begin();
        if (getOrientation() == 0) {
            if (state.equals(State.IDLE)) {
                batch.draw((TextureRegion) AssetLoader.specialEnemyArrowIdleAnimation.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
            }
            if (state.equals(State.RUNNING)) {
                batch.draw((TextureRegion) AssetLoader.specialEnemyArrowRunAnimation.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
            }
            if (state.equals(State.HIT)) {
                if (frames > 2) {
                    frames = runtime;
                }
                batch.draw((TextureRegion) AssetLoader.specialEnemyArrowAttackAnimation.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
                if (AssetLoader.specialEnemyArrowAttackAnimation.isAnimationFinished(frames)) {
                    frames = runtime;
                    state = State.IDLE;
                }
            }
            /*if(state.equals(State.DAMAGE)){
                batch.draw((TextureRegion) AssetLoader.normalEnemyDamageAnimation.getKeyFrame(runtime), sRect.x, sRect.y, sRect.width, sRect.height);
            }*/
            if (state.equals(State.DYING)) {
                if (frames > 2) {
                    frames = runtime;
                }
                batch.draw((TextureRegion) AssetLoader.specialEnemyArrowDeathAnimation.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
                if (AssetLoader.specialEnemyArrowDeathAnimation.isAnimationFinished(frames)) {
                    this.endAnimacion = true;
                    dead = true;
                    frames = runtime;
                    state = State.NULL;
                }
            }
        } else {
            if (state.equals(State.IDLE)) {
                batch.draw((TextureRegion) AssetLoader.specialEnemyArrowIdleAnimationRight.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
            }
            if (state.equals(State.RUNNING)) {
                Gdx.app.log("ENEMY A", "ENTRA FRAMES" + frames);
                batch.draw((TextureRegion) AssetLoader.specialEnemyArrowRunAnimationRight.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
            }
            if (state.equals(State.HIT)) {
                if (frames > 2) {
                    frames = runtime;
                }
                batch.draw((TextureRegion) AssetLoader.specialEnemyArrowAttackAnimationRight.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
                if (AssetLoader.specialEnemyAAttackAnimationRight.isAnimationFinished(frames)) {
                    frames = runtime;
                    state = State.IDLE;
                }
            }
            /*if(state.equals(State.DAMAGE)){
                batch.draw((TextureRegion) AssetLoader.normalEnemyDamageAnimationRight.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
            }*/
            if (state.equals(State.DYING)) {
                if (frames > 2) {
                    frames = runtime;
                }
                batch.draw((TextureRegion) AssetLoader.specialEnemyArrowDeathAnimationRight.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
                if (AssetLoader.specialEnemyArrowDeathAnimationRight.isAnimationFinished(frames)) {
                    Gdx.app.log("ENEMY A", "ENTRA");
                    this.endAnimacion = true;
                    dead = true;
                    frames = runtime;
                    state = State.NULL;
                }
            }
        }
        batch.end();
        /*shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.rect(sRect.x, sRect.y, sRect.width, sRect.height);
        shapeRenderer.end();*/
    }

    /**
     * Metodo que gestiona los cambios de las variables y las actualiza.
     *
     * @param delta delta time
     */
    @Override
    public void update(float delta) {
        super.update(delta);
        if (!dead) {
            if (arrow != null) {
                arrow.update(delta);
            }
            if (getOrientation() == 0) {
                sRect.x = getPosition().x;
            } else {
                sRect.x = getPosition().x - getWidth() / 2;

            }
            sRect.y = getPosition().y;
        }
    }

    /**
     * Metodo que comprueba y gestiona las colisiones.
     *
     * @param delta Delta time.
     */
    @Override
    public void colider(float delta) {
        super.colider(delta);

        if (getKnight().getSword() != null) {
            if (getKnight().getSword().getRect().overlaps(getRect())) {
                Gdx.app.log("ELIMINAR ENEMIGO", "SWORD");
                GameScreen.score += 10;
                HitParticle particle = new HitParticle(this, "blood");
                getKnight().particles.add(particle);
                live -= 3;
            }
        }


        if (getOrientation() == 0) {
            if (onlyShoot && getPosition().x >= 0 + getWidth()) {
                comprobation = true;
            } else {
                comprobation = false;
            }
        } else {
            if (onlyShoot && getPosition().x + getWidth() <= Gdx.graphics.getWidth() - getWidth()) {
                comprobation = true;
            } else {
                comprobation = false;
            }
        }

        if (comprobation) {
            state = State.HIT;
            setTimeSeconds(getTimeSeconds() + Gdx.graphics.getDeltaTime());
            if (getTimeSeconds() > getPeriod() / 2) {
                setTimeSeconds(getTimeSeconds() - getPeriod());
                if (tutorialWorld == null) {
                    if (getWorld().game.prefs.isSound()) {
                        SoundLoader.arrowSound.play();
                    }
                } else {
                    if (tutorialWorld.game.prefs.isSound()) {
                        SoundLoader.arrowSound.play();
                    }
                }

                if (tutorialWorld == null) {
                    arrow = new Arrow(getPosition().x + getWidth() / 2, getPosition().y + getHeigth() - Gdx.graphics.getHeight() / 16, Gdx.graphics.getHeight() / 16, this, world.getKnigth(), getOrientation());
                } else {
                    arrow = new Arrow(getPosition().x + getWidth() / 2, getPosition().y + getHeigth() - Gdx.graphics.getHeight() / 16, Gdx.graphics.getHeight() / 16, this, tutorialWorld.getKnigth(), getOrientation());
                }
                onlyShoot = false;
            }
        } else {
            if (onlyShoot) {
                getPosition().add(getVelocity().cpy().scl(delta));
            } else {
                if (!runAgain) {
                    setTimeSeconds(getTimeSeconds() + Gdx.graphics.getDeltaTime());
                    if (getTimeSeconds() > getPeriod()) {
                        setTimeSeconds(getTimeSeconds() - getPeriod());
                        runAgain = true;
                        state = State.RUNNING;
                    }
                } else {
                    if (getKnight().getAllPositionRect().overlaps(getRect())) {
                        state = State.HIT;
                        setTimeSeconds(getTimeSeconds() + Gdx.graphics.getDeltaTime());
                        if (getTimeSeconds() > getPeriod() / 2) {
                            setTimeSeconds(getTimeSeconds() - getPeriod());
                            if (getSword() == null) {
                                if (getOrientation() == 0) {
                                    setSword(new Sword(getPosition().x + getWidth(), getPosition().y, getHeigth()));
                                } else {
                                    setSword(new Sword(getPosition().x - getWidth() / 2, getPosition().y, getHeigth()));
                                }
                            }
                        }
                    } else {
                        getPosition().add(getVelocity().cpy().scl(delta));
                    }
                }
            }
        }

    }

    /**
     * Método que elimina el Arrow.
     */
    public void deleteArrow() {
        arrow = null;
    }

    public boolean isOnlyShoot() {
        return onlyShoot;
    }

    public Arrow getArrow() {
        return arrow;
    }
}
