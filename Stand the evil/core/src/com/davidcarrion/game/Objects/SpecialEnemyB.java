package com.davidcarrion.game.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.davidcarrion.game.Helper.AssetLoader;
import com.davidcarrion.game.Helper.Constant;
import com.davidcarrion.game.Helper.HitParticle;
import com.davidcarrion.game.Helper.SoundLoader;
import com.davidcarrion.game.Screens.GameScreen;
import com.davidcarrion.game.World.GameWorld;

/**
 * Esta clase define un objeto que hereda de enemigo y se comportará como un enemigo que se mueve hacia atras cuando lo golpean
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class SpecialEnemyB extends Enemy {
    /**
     * Booleana que indica si el enemigo puede cambiar de lado.
     */
    private boolean change;
    /**
     * Rectangulo para las animaciones.
     */
    private Rectangle sRect;
    /**
     * Variable que indica los frames.
     */
    private float frames = 0f;

    /**
     * Constructor para SpecialEnemyB
     *
     * @param x           Posición x del objeto.
     * @param y           Posición y del objeto.
     * @param width       Ancho del objeto.
     * @param heigth      Alto del objeto.
     * @param world       Clase donde se gestiona el objeto.
     * @param orientation Orientación del objeto.
     */
    public SpecialEnemyB(float x, float y, int width, int heigth, GameWorld world, int orientation) {
        super(x, y, width, heigth, world, orientation);
        setColor(Color.ORANGE);
        if (orientation == 0) {
            sRect = new Rectangle(x, y, width + width / 2, heigth + width / 2);
        } else {
            sRect = new Rectangle(x - width / 2, y, width + width / 2, heigth + width / 2);
        }
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
        frames += runtime;
        batch.begin();
        if (getOrientation() == 0) {
            if (state.equals(State.RUNNING)) {
                batch.draw((TextureRegion) AssetLoader.specialEnemyBRunAnimation.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
            }
            if (state.equals(State.HIT)) {
                if (frames > 2) {
                    frames = runtime;
                }
                batch.draw((TextureRegion) AssetLoader.specialEnemyBAttackAnimation.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
                if (AssetLoader.specialEnemyBAttackAnimation.isAnimationFinished(frames)) {
                    frames = runtime;
                }
            }
            /*if(state.equals(State.DAMAGE)){
                batch.draw((TextureRegion) AssetLoader.normalEnemyDamageAnimation.getKeyFrame(runtime), sRect.x, sRect.y, sRect.width, sRect.height);
            }*/
            if (state.equals(State.DYING)) {
                if (frames > 2) {
                    frames = runtime;
                }
                batch.draw((TextureRegion) AssetLoader.specialEnemyBDeathAnimation.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
                if (AssetLoader.specialEnemyBDeathAnimation.isAnimationFinished(frames)) {
                    this.endAnimacion = true;
                    dead = true;
                    frames = runtime;
                    state = State.NULL;
                }
            }
        } else {
            if (state.equals(State.RUNNING)) {
                batch.draw((TextureRegion) AssetLoader.specialEnemyBRunAnimationRight.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
            }
            if (state.equals(State.HIT)) {
                if (frames > 2) {
                    frames = runtime;
                }
                batch.draw((TextureRegion) AssetLoader.specialEnemyBAttackAnimationRight.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
                if (AssetLoader.specialEnemyBAttackAnimationRight.isAnimationFinished(frames)) {
                    frames = runtime;
                }
            }
            /*if(state.equals(State.DAMAGE)){
                batch.draw((TextureRegion) AssetLoader.normalEnemyDamageAnimationRight.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
            }*/
            if (state.equals(State.DYING)) {
                if (frames > 2 * Constant.density) {
                    frames = runtime;
                }
                batch.draw((TextureRegion) AssetLoader.specialEnemyBDeathAnimationRight.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
                if (AssetLoader.specialEnemyBDeathAnimationRight.isAnimationFinished(frames)) {
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
            if (!change) {
                if (getKnight().getSword().getRect().overlaps(getRect())) {
                    HitParticle particle = new HitParticle(this, "smoke");
                    getKnight().particles.add(particle);
                    if (getWorld().game.prefs.isSound()) {
                        SoundLoader.dashSound.play();
                    }
                    change = true;
                    if (getOrientation() == 0) {
                        setPosition(new Vector2(getPosition().x - getWidth() / 2, getPosition().y));
                    } else {
                        setPosition(new Vector2(getPosition().x + getWidth() / 2, getPosition().y));
                    }
                    setRect(getPosition().x, getPosition().y);
                    Gdx.app.log("Hit Enemy", "1");
                }
            } else {
                if (getKnight().getSword().getRect().overlaps(getRect())) {
                    Gdx.app.log("ELIMINAR ENEMIGO", "SWORD");
                    GameScreen.score += 10;
                    HitParticle particle = new HitParticle(this, "blood");
                    getKnight().particles.add(particle);
                    live -= 3;
                }
            }
        }
        if (!getKnight().getAllPositionRect().overlaps(getRect())) {
            getPosition().add(getVelocity().cpy().scl(delta));

        } else {
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
        }
    }
}
