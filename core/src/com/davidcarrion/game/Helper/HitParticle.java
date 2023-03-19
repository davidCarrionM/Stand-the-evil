package com.davidcarrion.game.Helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.davidcarrion.game.Objects.Enemy;
import com.davidcarrion.game.Objects.Knight;
import com.davidcarrion.game.Objects.Sword;

/**
 * Esta clase crea una animacion de efecto en el enemigo o en le personaje dependiendo de la acción
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class HitParticle {
    /**
     * Rectangulo del objeto.
     */
    Rectangle rect;
    /**
     * Animacion del objeto.
     */
    Animation animation;
    /**
     * Sonido que hace el objeto.
     */
    Sound hitSound;
    /**
     * Orientacion del objeto.
     */
    int orientation;
    /**
     * Objeto caballero donde se crea el objeto
     */
    private Knight knight;
    /**
     * Objeto enemigo donde se crea el objeto.
     */
    private Enemy enemy;
    /**
     * Tipo de objeto que se va a crear(Que animación usa).
     */
    private String type;
    /**
     * Booleana para saber si la particula tiene una orientacion de 90º o 270º.
     */
    private boolean up = false;
    /**
     * Delta time.
     */
    float frame;

    /**
     * Constructor para HitParticle con el atributo knight.
     *
     * @param knight objeto donde se crean los objetos.
     * @param type   tipo de objeto que se crea.
     */
    public HitParticle(Knight knight, String type) {
        this.knight = knight;
        this.type = type;
        orientation = knight.orientation;
        switch (type) {
            case "blood":
                float x;
                if (knight.orientation == 0) {
                    animation = AssetLoader.bloodAnimation;
                    x = knight.getRect().x + knight.getRect().width / 2;
                } else {
                    animation = AssetLoader.bloodAnimationRight;
                    x = knight.getRect().x - knight.getRect().width / 8;
                }
                rect = new Rectangle(x, knight.getRect().y + knight.getRect().getWidth() / 4, Gdx.graphics.getWidth() / 12, Gdx.graphics.getWidth() / 12);
                break;
        }
    }

    /**
     * Constructor para HitParticle con el atributo enemy.
     *
     * @param enemy objeto donde se crean los objetos.
     * @param type  tipo de objeto que se crea.
     */
    public HitParticle(Enemy enemy, String type) {
        this.enemy = enemy;
        this.knight = enemy.getKnight();
        this.type = type;
        orientation = enemy.getOrientation();
        switch (type) {
            case "blood":
                float x;
                if (enemy.getOrientation() == 0) {
                    animation = AssetLoader.bloodAnimation;
                    x = enemy.getRect().x + enemy.getRect().width / 2;
                } else {
                    animation = AssetLoader.bloodAnimationRight;
                    x = enemy.getRect().x - enemy.getRect().width / 8;
                }
                rect = new Rectangle(x, enemy.getRect().y + enemy.getRect().getWidth() / 4, Gdx.graphics.getWidth() / 12, Gdx.graphics.getWidth() / 12);
                break;
            case "epower":
                if (enemy.getOrientation() == 0) {
                    animation = AssetLoader.enemyVoltHitAnimationRight;
                    x = enemy.getRect().x + Gdx.graphics.getWidth() / 12;
                } else {
                    animation = AssetLoader.enemyVoltHitAnimation;
                    x = enemy.getRect().x;
                }
                if (enemy.tutorialWorld == null) {
                    if (enemy.getWorld().game.prefs.isSound()) {
                        SoundLoader.voltHitSound.play();
                    }
                } else {
                    if (enemy.tutorialWorld.game.prefs.isSound()) {
                        SoundLoader.voltHitSound.play();
                    }
                }
                rect = new Rectangle(x, enemy.getRect().y + enemy.getRect().getWidth() - (20 * Constant.density), Gdx.graphics.getWidth() / 12, Gdx.graphics.getWidth() / 12);
                break;
            case "epowerKnight":
                if (knight.orientation == 0) {
                    animation = AssetLoader.enemyVoltHitAnimationRight;
                    x = knight.getRect().x;
                } else {
                    animation = AssetLoader.enemyVoltHitAnimation;
                    x = knight.getRect().x + Gdx.graphics.getWidth() / 12;
                }
                if (enemy.tutorialWorld == null) {
                    if (enemy.getWorld().game.prefs.isSound()) {
                        SoundLoader.voltHitSound.play();
                    }
                } else {
                    if (enemy.tutorialWorld.game.prefs.isSound()) {
                        SoundLoader.voltHitSound.play();
                    }
                }
                rect = new Rectangle(x, knight.getRect().y + knight.getRect().getWidth() - (20 * Constant.density), Gdx.graphics.getWidth() / 12, Gdx.graphics.getWidth() / 12);
                break;
            case "kpower":
                if (enemy.tutorialWorld == null) {

                    if (enemy.getOrientation() == 0) {
                        if (enemy.getWorld().game.prefs.getKnightSelected() == 1) {
                            animation = AssetLoader.voltHitAnimationRightRed;
                            hitSound = SoundLoader.fireHitSound;
                        }
                        if (enemy.getWorld().game.prefs.getKnightSelected() == 2) {
                            animation = AssetLoader.voltHitAnimationRightBlue;
                            hitSound = SoundLoader.waterHitSound;
                        }
                        if (enemy.getWorld().game.prefs.getKnightSelected() == 3) {
                            animation = AssetLoader.voltHitAnimationYellow;
                            hitSound = SoundLoader.thunderHitSound;
                        }
                        if (enemy.getWorld().game.prefs.getKnightSelected() == 4) {
                            animation = AssetLoader.voltHitAnimationBrown;
                            hitSound = SoundLoader.dirtHitSound;
                        }

                        x = enemy.getRect().x + Gdx.graphics.getWidth() / 12;
                    } else {
                        if (enemy.getWorld().game.prefs.getKnightSelected() == 1) {
                            animation = AssetLoader.voltHitAnimationRed;
                            hitSound = SoundLoader.fireHitSound;
                        }
                        if (enemy.getWorld().game.prefs.getKnightSelected() == 2) {
                            animation = AssetLoader.voltHitAnimationBlue;
                            hitSound = SoundLoader.waterHitSound;
                        }
                        if (enemy.getWorld().game.prefs.getKnightSelected() == 3) {
                            animation = AssetLoader.voltHitAnimationRightYellow;
                            hitSound = SoundLoader.thunderHitSound;
                        }
                        if (enemy.getWorld().game.prefs.getKnightSelected() == 4) {
                            animation = AssetLoader.voltHitAnimationRightBrown;
                            hitSound = SoundLoader.dirtHitSound;
                        }
                    }
                    if (enemy.getWorld().game.prefs.isSound()) {
                        hitSound.play();
                    }
                } else {
                    if (enemy.getOrientation() == 0) {
                        animation = AssetLoader.voltHitAnimationRed;
                        x = enemy.getRect().x + Gdx.graphics.getWidth() / 12;
                    } else {
                        animation = AssetLoader.voltHitAnimationRightRed;
                    }
                    hitSound = SoundLoader.fireHitSound;
                    if (enemy.tutorialWorld.game.prefs.isSound()) {
                        hitSound.play();
                    }
                }
                x = enemy.getRect().x;
                rect = new Rectangle(x, enemy.getRect().y + enemy.getRect().getWidth() - (20 * Constant.density), Gdx.graphics.getWidth() / 12, Gdx.graphics.getWidth() / 12);

                break;
            case "up":
                up = true;
                if (enemy.tutorialWorld == null) {

                    if (enemy.getWorld().game.prefs.getKnightSelected() == 1) {
                        animation = AssetLoader.voltHitAnimationRed;
                        hitSound = SoundLoader.fireHitSound;
                    }
                    if (enemy.getWorld().game.prefs.getKnightSelected() == 2) {
                        animation = AssetLoader.voltHitAnimationRightBlue;
                        hitSound = SoundLoader.waterHitSound;
                    }
                    if (enemy.getWorld().game.prefs.getKnightSelected() == 3) {
                        animation = AssetLoader.voltHitAnimationYellow;
                        hitSound = SoundLoader.thunderHitSound;
                    }
                    if (enemy.getWorld().game.prefs.getKnightSelected() == 4) {
                        animation = AssetLoader.voltHitAnimationBrown;
                        hitSound = SoundLoader.dirtHitSound;
                    }

                    if (enemy.getWorld().game.prefs.isSound()) {
                        hitSound.play();
                    }
                } else {
                    animation = AssetLoader.voltHitAnimationRed;
                    hitSound = SoundLoader.fireHitSound;
                    if (enemy.tutorialWorld.game.prefs.isSound()) {
                        hitSound.play();
                    }
                }
                rect = new Rectangle(enemy.getRect().x, enemy.getRect().y, enemy.getWidth(), enemy.getHeigth());
                break;
            case "smoke":
                animation = AssetLoader.smokeAnimation;
                rect = new Rectangle(enemy.getRect().x, enemy.getRect().y, enemy.getWidth(), enemy.getWidth());
                break;
        }
    }

    /**
     * Constructor para HitParticle con cuatro atributos.
     *
     * @param knight      objeto donde se va a crear el objeto.
     * @param sword       posicion del objeto donde se va a crear.
     * @param type        tipo de objeto que se va a crear.
     * @param orientation orientacion del objeto que se va a crear.
     */
    public HitParticle(Knight knight, Sword sword, String type, int orientation) {
        this.knight = knight;
        this.type = type;
        this.orientation = orientation;
        switch (type) {
            case "cut":
                float x;
                if (orientation == 0) {
                    animation = AssetLoader.cutSwordAnimation;
                } else {
                    animation = AssetLoader.cutSwordAnimationRight;
                }
                rect = new Rectangle(sword.getRect().x, sword.getRect().y, sword.getRect().width, sword.getRect().height);
                break;
        }
    }

    /**
     * Método que dibuja las animaciones y texturas.
     *
     * @param shapeRenderer Dibujador de figuras.
     * @param batch         Dibujador de animaciones.
     * @param runtime       delta time.
     */
    public void draw(ShapeRenderer shapeRenderer, SpriteBatch batch, float runtime) {
        frame += runtime;
        batch.begin();
        if (!up) {
            batch.draw((TextureRegion) animation.getKeyFrame(frame), rect.x, rect.y, rect.width, rect.height);
        } else {
            batch.draw((TextureRegion) animation.getKeyFrame(frame), rect.x, rect.y, rect.width / 2, rect.height / 2, rect.width, rect.height, 1, 1, 270);
        }
        if (animation.isAnimationFinished(frame)) {
            knight.deleteParticle(this);
        }
        batch.end();
    }

}
