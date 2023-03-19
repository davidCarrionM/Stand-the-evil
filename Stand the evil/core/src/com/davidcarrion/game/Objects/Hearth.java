package com.davidcarrion.game.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.davidcarrion.game.Helper.AssetLoader;
import com.davidcarrion.game.Helper.Constant;
import com.davidcarrion.game.World.GameWorld;

/**
 * Esta clase define un objeto con una animacion de corazon que se moverá en y hasta que desaparezca
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class Hearth {
    /**
     * Rectangulo del objeto.
     */
    private Rectangle rect;
    /**
     * Velocidad del objeto.
     */
    private Vector2 velocity;
    /**
     * Posición del objeto.
     */
    private Vector2 position;
    /**
     * Clase donde se va a gestionar el objeto
     */
    private GameWorld world;
    /**
     * Variable que indica los frames.
     */
    private float frame = 0f;
    /**
     * Objeto enemigo de donde va a salir el objeto.
     */
    private Enemy enemy;

    /**
     * Constructor para Hearth
     *
     * @param enemy Objeto enemigo de donde va a salir el objeto.
     * @param world Clase donde se gestiona el objeto.
     */
    public Hearth(Enemy enemy, GameWorld world) {
        this.enemy = enemy;
        this.world = world;
        position = new Vector2(enemy.getRect().x + enemy.getRect().width / 2 - enemy.getRect().width / 4, enemy.getRect().y + enemy.getRect().height);
        rect = new Rectangle(enemy.getRect().x + enemy.getRect().width / 2 - enemy.getRect().width / 4, enemy.getRect().y + enemy.getRect().height, enemy.getRect().width / 4, enemy.getRect().width / 4);
        velocity = new Vector2(0, 200 * Constant.density);
    }

    /**
     * Metodo que gestiona los cambios de las variables y las actualiza.
     *
     * @param delta delta time
     */
    public void update(float delta) {
        position.add(velocity.cpy().scl(delta));
        rect.x = position.x;
        rect.y = position.y;
        if (rect.y > Gdx.graphics.getHeight()) {
            world.deleteHearths(this);
        }
    }

    /**
     * Metodo que dibuja las animaciones y texturas.
     *
     * @param batch   Dibujador de animaciones.
     * @param runtime Delta time.
     */
    public void draw(SpriteBatch batch, float runtime) {
        frame += runtime;
        batch.begin();
        batch.draw((TextureRegion) AssetLoader.hearthAnimation.getKeyFrame(frame), rect.x, rect.y, rect.width, rect.height);
        batch.end();
    }
}
