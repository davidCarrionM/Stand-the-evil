package com.davidcarrion.game.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.davidcarrion.game.Helper.AssetLoader;
import com.davidcarrion.game.Helper.Constant;
import com.davidcarrion.game.MyGame;

/**
 * Esta clase define un objeto con una animacion y un texto que irá en la Screen Record
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class StanRecord {
    /**
     * Rectangulo del objeto.
     */
    Rectangle rect;
    /**
     * Rectangulo donde va la animación del objeto.
     */
    Rectangle rectCharacter;
    /**
     * Rectangulo donde va el texto.
     */
    Rectangle rectCharacterS;
    /**
     * Dibujador de figuras.
     */
    ShapeRenderer shapeRenderer;
    /**
     * Dibujador de animaciones y texturas.
     */
    SpriteBatch batch;
    /**
     * Animación del objeto.
     */
    Animation character;
    /**
     * Espacio a mayores en x para el rectangulo.
     */
    float ofsetX = 0f;
    /**
     * Espacio a mayores en y para el rectangulo.
     */
    float ofsetY = 0f;

    /**
     * Variable que indica los frames.
     */
    float frames;
    /**
     * Fuentes con la que se escriben los textos.
     */
    private BitmapFont font, font12;

    Color coloor;
    /**
     * Texto que se escribe.
     */
    String texto;
    /**
     * Tipo de Record.
     */
    String type;
    /**
     * Variable para gestionar el tamaño del texto.
     */
    GlyphLayout layout;
    /**
     * Texto para el type "score".
     */
    String highScore;

    /**
     * Constructor para StanRecord.
     *
     * @param x         Posición x del objeto.
     * @param y         Posición y del objeto.
     * @param character Animación del record.
     * @param texto     Texto que se escribe.
     * @param color     (Debug) Color del rectangulo.
     * @param type      Tipo de Record.
     */
    public StanRecord(int x, int y, Animation character, String texto, Color color, String type) {
        shapeRenderer = new ShapeRenderer();
        batch = new SpriteBatch();
        this.texto = texto;
        this.type = type;
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("ui/dpcomic.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = (int) (20 * Constant.density);
        parameter.color = Color.BLACK;
        font12 = generator.generateFont(parameter); // font size 12 pixels
        parameter.size = (int) (30 * Constant.density);
        font = generator.generateFont(parameter);
        generator.dispose();
        if (MyGame.prefs.getLanguage().equals("es")) {
            highScore = MyGame.myBundleEspaniol.get("maxPuntuacion");
        } else {
            highScore = MyGame.myBundleIngles.get("maxPuntuacion");
        }
        this.character = character;
        rect = new Rectangle(x, y, Gdx.graphics.getWidth() / 6f, Gdx.graphics.getHeight() / 4.5f);
        if (type.equals("rect")) {
            rectCharacter = new Rectangle(x, y, Gdx.graphics.getWidth() / 10f, Gdx.graphics.getHeight() / 4.5f);
        }
        if (type.equals("rectArrow")) {
            rectCharacter = new Rectangle(x, y, Gdx.graphics.getWidth() / 10f, Gdx.graphics.getHeight() / 4.5f);
            ofsetX = Gdx.graphics.getWidth() / 38f;
        }
        if (type.equals("rectLanza")) {
            rectCharacter = new Rectangle(x, y, Gdx.graphics.getWidth() / 10f, Gdx.graphics.getHeight() / 4.5f);
            ofsetX = Gdx.graphics.getWidth() / 38f;
        }
        if (type.equals("rectShield")) {
            rectCharacter = new Rectangle(x, y, Gdx.graphics.getWidth() / 10f, Gdx.graphics.getHeight() / 4.5f);
            ofsetX = Gdx.graphics.getWidth() / 40f;
        }
        if (type.equals("rectFly")) {
            rectCharacter = new Rectangle(x, y, Gdx.graphics.getWidth() / 10f, Gdx.graphics.getHeight() / 4.5f);
            ofsetX = Gdx.graphics.getWidth() / 25f;
            ofsetY = Gdx.graphics.getWidth() / 30f;
        }
        if (type.equals("square")) {
            rectCharacter = new Rectangle(x, y, Gdx.graphics.getWidth() / 10f, Gdx.graphics.getHeight() / 4.5f);
            rectCharacterS = new Rectangle(x, y + ((Gdx.graphics.getHeight() / 4.5f) - (Gdx.graphics.getWidth() / 10f)) / 2, Gdx.graphics.getWidth() / 10f, Gdx.graphics.getWidth() / 10f);
        }
        if (type.equals("knight")) {
            rectCharacter = new Rectangle(x, y, Gdx.graphics.getWidth() / 10f, Gdx.graphics.getHeight() / 5f);
            ofsetX = Gdx.graphics.getWidth() / 25f;
        }
        layout = new GlyphLayout();
        layout.setText(font12, highScore);
        if (type.equals("score")) {
            rect = new Rectangle(x, y, Gdx.graphics.getWidth() / 3f, Gdx.graphics.getHeight() / 4.5f);
            rectCharacter = new Rectangle(x + Gdx.graphics.getWidth() / 26, y, Gdx.graphics.getWidth() / 5f, layout.width);
        }
        this.coloor = color;
    }

    /**
     * Metodo que dibuja las animaciones y texturas.
     *
     * @param runtime Delta time.
     */
    public void draw(float runtime) {
        frames += runtime;
        /*shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(coloor);
        shapeRenderer.rect(rect.x, rect.y, rect.width, rect.height);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rect(rectCharacter.x, rectCharacter.y, rectCharacter.width,rectCharacter.height);
        shapeRenderer.end();
*/
        batch.begin();
        if (type.equals("square")) {
            batch.draw((TextureRegion) AssetLoader.normalEnemyhit.getKeyFrame(frames), rectCharacter.x - ofsetX, rectCharacter.y - ofsetY, rectCharacter.width * 2f, rectCharacter.height * 1.5f);
            batch.draw((TextureRegion) character.getKeyFrame(frames), rectCharacterS.x - ofsetX, rectCharacterS.y - ofsetY, rectCharacterS.width, rectCharacterS.height);
        } else {
            if (type.equals("score")) {
                font.draw(batch, highScore, rectCharacter.x + (15 * Constant.density), rect.y + rect.height / 2);
            } else {
                batch.draw((TextureRegion) character.getKeyFrame(frames), rectCharacter.x - ofsetX, rectCharacter.y - ofsetY, rectCharacter.width * 2f, rectCharacter.height * 1.5f);
            }
        }
        font12.draw(batch, texto, rectCharacter.x + rectCharacter.width + 10 * Constant.density, rectCharacter.y + rectCharacter.height / 2);
        batch.end();
    }
}
