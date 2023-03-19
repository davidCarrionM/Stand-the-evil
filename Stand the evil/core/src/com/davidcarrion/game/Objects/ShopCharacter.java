package com.davidcarrion.game.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.davidcarrion.game.Helper.AssetLoader;
import com.davidcarrion.game.Helper.Constant;

/**
 * Esta clase define un objeto con dos animaciones que irá en la Screen Shop
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class ShopCharacter {
    /**
     * Rectangulo del objeto.
     */
    Rectangle rect;
    /**
     * Booleana que indica si el objeto está desbloqueado.
     */
    public boolean unlock = false;
    /**
     * Booleana que indica si el objeto está seleccionado.
     */
    boolean chose = false;
    /**
     * Rectangulo para la animación del caballero.
     */
    Rectangle rectCharacter;
    /**
     * Rectangulo para la animación del poder.
     */
    Rectangle rectPower;
    /**
     * Dibujador de figuras.
     */
    ShapeRenderer shapeRenderer;
    /**
     * Dibujador de animaciones y texturas.
     */
    SpriteBatch batch;
    /**
     * Animación del caballero.
     */
    Animation character;
    /**
     * Animación del poder.
     */
    Animation power;
    /**
     * (Debug) Color del rectangulo.
     */
    String color;
    /**
     * Variable que indica los frames.
     */
    float frames;
    /**
     * Textura de bloqueado.
     */
    TextureRegion lock = new TextureRegion(new Texture(Gdx.files.internal("ui/lock.png")));
    /**
     * Textura para el objeto seleccionado.
     */
    TextureRegion check = new TextureRegion(new Texture(Gdx.files.internal("ui/chose.png")));
    /**
     * Textura para el objeto no seleccionado.
     */
    TextureRegion checkBack = new TextureRegion(new Texture(Gdx.files.internal("ui/choseTransparent.png")));
    /**
     * Textura para el fondo del objeto cuando esta bloqueado.
     */
    TextureRegion lockColor;
    /**
     * Textura de moneda.
     */
    TextureRegion coin = new TextureRegion(AssetLoader.tCoin);
    /**
     * Fuente con la que se escribe el texto.
     */
    private BitmapFont font, font12;

    /**
     * Constructor para ShopCharacter.
     *
     * @param x         Posición x para el objeto.
     * @param y         Posición y para el objeto.
     * @param character Animación del caballero que se le pone al rectCharacter.
     * @param power     Animación del poder que se le pone al rectPower.
     * @param unlock    Valor que indica si el objeto esta desbloqueado o no.
     * @param color     (Debug) Color del rectangulo.
     */
    public ShopCharacter(int x, int y, Animation character, Animation power, boolean unlock, String color) {
        shapeRenderer = new ShapeRenderer();
        batch = new SpriteBatch();
        this.character = character;
        this.power = power;
        this.unlock = unlock;
        this.color = color;
        rect = new Rectangle(x, y, Gdx.graphics.getWidth() / 3.5f, Gdx.graphics.getHeight() / 3.5f);
        Gdx.app.log("compra", "" + Gdx.graphics.getWidth() / 3.5f + " " + Gdx.graphics.getHeight() / 3.5f);
        rectCharacter = new Rectangle(x - 40 * Constant.density, y + 10 * Constant.density, Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 3f);
        rectPower = new Rectangle(x + 110 * Constant.density, y + 30 * Constant.density, Gdx.graphics.getWidth() / 8, Gdx.graphics.getWidth() / 8);
        if (color.equals("red")) {

        }
        if (color.equals("blue")) {
            lockColor = new TextureRegion(new Texture(Gdx.files.internal("ui/blueTransparent.png")));
        }
        if (color.equals("yellow")) {
            lockColor = new TextureRegion(new Texture(Gdx.files.internal("ui/yellowTransparent.png")));
        }
        if (color.equals("brown")) {
            lockColor = new TextureRegion(new Texture(Gdx.files.internal("ui/brownTransparent.png")));
        }
        font = new BitmapFont();
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("ui/dpcomic.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = (int) (40 * Constant.density);
        parameter.color = Color.BLACK;
        font12 = generator.generateFont(parameter); // font size 12 pixels
        generator.dispose();
    }

    /**
     * Método que dibuja las animaciones y texturas.
     *
     * @param runtime Delta time.
     */
    public void draw(float runtime) {
        frames += runtime;
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        //shapeRenderer.setColor(Color.WHITE);
        //shapeRenderer.rect(rect.x, rect.y, rect.width, rect.height);
        //shapeRenderer.setColor(Color.BLUE);
        //shapeRenderer.rect(rectCharacter.x, rectCharacter.y, rectCharacter.width,rectCharacter.height);
        //shapeRenderer.rect(rectPower.x, rectPower.y, rectPower.width,rectPower.height);
        shapeRenderer.end();

        batch.begin();
        if (unlock) {
            if (chose) {
                batch.draw(checkBack, rect.x, rect.y, rect.width, rect.height);
                batch.draw(check, rect.x, rect.y, rect.width, rect.height);
            }
            batch.draw((TextureRegion) character.getKeyFrame(frames), rectCharacter.x, rectCharacter.y, rectCharacter.width, rectCharacter.height);
            batch.draw((TextureRegion) power.getKeyFrame(frames), rectPower.x, rectPower.y, rectPower.width, rectPower.height);
        } else {
            batch.draw((TextureRegion) character.getKeyFrame(0), rectCharacter.x, rectCharacter.y, rectCharacter.width, rectCharacter.height);
            batch.draw((TextureRegion) power.getKeyFrame(0), rectPower.x, rectPower.y, rectPower.width, rectPower.height);
            batch.draw(lockColor, rect.x, rect.y, rect.width, rect.height);
            batch.draw(lock, rect.x + rect.width / 2 - (50 * Constant.density / 2), rect.y + rect.height / 2 - (25 * Constant.density / 2), 50 * Constant.density, 50 * Constant.density);
            batch.draw(coin, rect.x + rect.width / 2 - (75 * Constant.density / 2), rect.y + rect.height / 2 - (100 * Constant.density / 2), 25 * Constant.density, 25 * Constant.density);
            font12.draw(batch, "50", rect.x + rect.width / 2 - (10 * Constant.density / 2), rect.y + rect.height / 2 - (50 * Constant.density / 2));
        }
        batch.end();
    }

    /**
     * Cambia la booleana chose.
     *
     * @param flag Valor por el que se cambia la booleana.
     */
    public void check(boolean flag) {
        chose = flag;
    }
}
