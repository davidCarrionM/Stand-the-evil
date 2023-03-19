package com.davidcarrion.game.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.davidcarrion.game.Helper.AssetLoader;
import com.davidcarrion.game.Helper.HitParticle;
import com.davidcarrion.game.Screens.GameScreen;
import com.davidcarrion.game.World.GameWorld;

/**
 * Esta clase define un objeto que hereda de enemigo y se comportará como un enemigo normal pero con una posicion Y mas alta
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class SpecialEnemyC extends Enemy {
    /**
     * Booleana que indica si puede pegar su único golpe.
     */
    private boolean onlyHit;
    /**
     * Rectangulo para las animaciones.
     */
    private Rectangle sRect;
    /**
     * Variable que indica los frames.
     */
    private float frames = 0f;

    /**
     * Constructor para SpecialEnemyC
     *
     * @param x           Posición x del objeto.
     * @param y           Posición y del objeto.
     * @param width       Ancho del objeto.
     * @param heigth      Alto del objeto.
     * @param world       Clase donde se gestiona el objeto.
     * @param orientation Orientación del objeto.
     */
    public SpecialEnemyC(float x, float y, int width, int heigth, GameWorld world, int orientation) {
        super(x, Gdx.graphics.getHeight() - heigth * 2, heigth, width, world, orientation);
        onlyHit = true;
        sRect = new Rectangle(getRect().x - getRect().width / 2.5f, getRect().y / 2, getRect().width + getRect().width * 1.5f, getRect().height + getRect().width);
        setColor(Color.GOLD);
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
                batch.draw((TextureRegion) AssetLoader.specialEnemyCRunAnimation.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
            }
            if (state.equals(State.DYING)) {
                if (frames > 2) {
                    frames = runtime;
                }
                batch.draw((TextureRegion) AssetLoader.specialEnemyCDeathAnimation.getKeyFrame(frames), sRect.x, sRect.y, sRect.width / 2, sRect.height / 2, sRect.width, sRect.height, 1, 1, 270);
                if (AssetLoader.specialEnemyCDeathAnimation.isAnimationFinished(frames)) {
                    this.endAnimacion = true;
                    dead = true;
                    frames = runtime;
                    state = State.NULL;
                }
            }
            if (state.equals(State.HIT)) {
                if (frames > 2) {
                    frames = runtime;
                }
                batch.draw((TextureRegion) AssetLoader.specialEnemyCHitAnimation.getKeyFrame(frames), sRect.x, sRect.y, sRect.width / 2, sRect.height / 2, sRect.width, sRect.height, 1, 1, 270);
                if (AssetLoader.specialEnemyCHitAnimation.isAnimationFinished(frames)) {
                    state = State.RUNNING;
                    frames = runtime;
                }
            }

        } else {
            if (state.equals(State.RUNNING)) {
                batch.draw((TextureRegion) AssetLoader.specialEnemyCRunAnimationRight.getKeyFrame(frames), sRect.x, sRect.y, sRect.width, sRect.height);
            }
            if (state.equals(State.DYING)) {
                if (frames > 2) {
                    frames = runtime;
                }
                batch.draw((TextureRegion) AssetLoader.specialEnemyCDeathAnimationRight.getKeyFrame(frames), sRect.x, sRect.y, sRect.width / 2, sRect.height / 2, sRect.width, sRect.height, 1, 1, 90);
                if (AssetLoader.specialEnemyCDeathAnimationRight.isAnimationFinished(frames)) {
                    this.endAnimacion = true;
                    dead = true;
                    state = State.NULL;
                    frames = runtime;
                }
            }
            if (state.equals(State.HIT)) {
                if (frames > 2) {
                    frames = runtime;
                }
                batch.draw((TextureRegion) AssetLoader.specialEnemyCHitAnimationRight.getKeyFrame(frames), sRect.x, sRect.y, sRect.width / 2, sRect.height / 2, sRect.width, sRect.height, 1, 1, 90);
                if (AssetLoader.specialEnemyCHitAnimationRight.isAnimationFinished(frames)) {
                    state = State.RUNNING;
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
                sRect.x = getRect().x - getRect().width;
            } else {
                sRect.x = getRect().x - getRect().width / 2;

            }
            sRect.y = getPosition().y - getRect().getHeight() / 2;
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
                live -= 3;
            }
        }
        if (getRect().overlaps(getKnight().getRect())) {
            if (onlyHit) {
                state = State.HIT;
                getKnight().live -= 1;
                getKnight().state = Knight.State.HURT;
                getKnight().addParticle();
                onlyHit = false;
            }
        }
        getPosition().add(getVelocity().cpy().scl(delta));
    }


}
