package com.davidcarrion.game.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.davidcarrion.game.Helper.AssetLoader;
import com.davidcarrion.game.Helper.HitParticle;
import com.davidcarrion.game.Screens.GameScreen;
import com.davidcarrion.game.World.GameWorld;
import com.davidcarrion.game.World.TutorialWorld;

/**
 * Esta clase define un objeto que hereda de enemigo y se comportará como un enemigo normal
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class NormalEnemy extends Enemy {
    /**
     * Rectangulo de las animaciones del objeto.
     */
    private Rectangle sRect;
    /**
     * Clase donde se gestiona el objeto(En el tutorial).
     */
    TutorialWorld tutorialWorld;
    /**
     * Variable que indica los frames.
     */
    private float frames = 0f;

    /**
     * Constructor para NormalEnemy con parametro GameWorld
     *
     * @param x           Posición de x del objeto.
     * @param y           Posición de y del objeto.
     * @param width       Ancho del objeto.
     * @param heigth      Alto del objeto.
     * @param world       Clase donde se gestiona el objeto.
     * @param orientation Orientación del objeto.
     */
    public NormalEnemy(float x, float y, int width, int heigth, GameWorld world, int orientation) {
        super(x, y, width, heigth, world, orientation);
        if (orientation == 0) {
            sRect = new Rectangle(x + width / 4, y, width + width / 2, heigth + width / 2);
        } else {
            sRect = new Rectangle(x - width, y, width + width / 2, heigth + width / 2);
        }
    }

    /**
     * Constructor para NormalEnemy con parametro TutorialWorld
     *
     * @param x             Posición de x del objeto.
     * @param y             Posición de y del objeto.
     * @param width         Ancho del objeto.
     * @param heigth        Alto del objeto.
     * @param world         Clase donde se gestiona el objeto.
     * @param tutorialWorld Clase tutorial donde se gestiona el objeto.
     * @param orientation   Orientación del objeto.
     */
    public NormalEnemy(float x, float y, int width, int heigth, GameWorld world, TutorialWorld tutorialWorld, int orientation) {
        super(x, y, width, heigth, tutorialWorld, orientation);
        if (orientation == 0) {
            sRect = new Rectangle(x + width / 4, y, width + width / 2, heigth + width / 2);
        } else {
            sRect = new Rectangle(x - width, y, width + width / 2, heigth + width / 2);
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
        frames += runtime;
        batch.begin();
        if (getOrientation() == 0) {
            if (state.equals(State.RUNNING)) {
                Gdx.app.log("NORMALENEMY", "frames izquierda: " + frames);
                batch.draw((TextureRegion) AssetLoader.normalEnemyRunAnimation.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
            }
            if (state.equals(State.HIT)) {
                if (frames > 2) {
                    frames = runtime;
                }
                batch.draw((TextureRegion) AssetLoader.normalEnemyHitAnimation.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
                if (AssetLoader.normalEnemyHitAnimation.isAnimationFinished(frames)) {
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
                batch.draw((TextureRegion) AssetLoader.normalEnemyDeathAnimation.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
                if (AssetLoader.normalEnemyDeathAnimation.isAnimationFinished(frames)) {
                    this.endAnimacion = true;
                    dead = true;
                    frames = runtime;
                    state = State.NULL;
                }
            }
        } else {
            if (state.equals(State.RUNNING)) {
                Gdx.app.log("NORMALENEMY", "frames derecha: " + frames);
                batch.draw((TextureRegion) AssetLoader.normalEnemyRunAnimationRigth.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
            }
            if (state.equals(State.HIT)) {
                if (frames > 2) {
                    frames = runtime;
                }
                batch.draw((TextureRegion) AssetLoader.normalEnemyHitAnimationRigth.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
                if (AssetLoader.normalEnemyHitAnimationRigth.isAnimationFinished(frames)) {
                    frames = runtime;
                }
            }
            /*if(state.equals(State.DAMAGE)){
                batch.draw((TextureRegion) AssetLoader.normalEnemyDamageAnimationRight.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
            }*/
            if (state.equals(State.DYING)) {
                if (frames > 2) {
                    frames = runtime;
                }
                batch.draw((TextureRegion) AssetLoader.normalEnemyDeathAnimationRight.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
                if (AssetLoader.normalEnemyDeathAnimationRight.isAnimationFinished(frames)) {
                    this.endAnimacion = true;
                    dead = true;
                    frames = runtime;
                    state = State.NULL;
                }
            }
        }
        batch.end();
       /* shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
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
                sRect.x = getPosition().x + getWidth() / 4;
            } else {
                sRect.x = getPosition().x - getWidth() + sRect.width / 6;

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
        if (!getKnight().getAllPositionRect().overlaps(getRect())) {
            getPosition().add(getVelocity().cpy().scl(delta));

        } else {
            if (!state.equals(State.DYING)) {
                state = State.HIT;
                setTimeSeconds(getTimeSeconds() + Gdx.graphics.getDeltaTime());
                if (getTimeSeconds() > getPeriod() / 4) {
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
}
