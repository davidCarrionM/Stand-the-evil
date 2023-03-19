package com.davidcarrion.game.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.davidcarrion.game.Helper.Constant;
import com.davidcarrion.game.Screens.PreferencesScreen;

/**
 * Esta clase define un objeto con un texto que ira en la Screen Preferences
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class PreferencesStan {
    /**
     * Rectangulo del objeto
     */
    Rectangle rect;
    /**
     * Dibujador de figuras.
     */
    ShapeRenderer shapeRenderer;
    /**
     * Dibujador de animaciones y texturas.
     */
    SpriteBatch batch;
    /**
     * Variable que indica los frames.
     */
    float frames;
    /**
     * Fuente con la que se escriben los textos.
     */
    private BitmapFont font12;
    /**
     * Screen donde se gestiona el objeto.
     */
    PreferencesScreen preferencesScreen;
    /**
     * Texto que se escribe.
     */
    String text;

    /**
     * Constructor para PreferencesStan
     *
     * @param x                 Posición x del objeto.
     * @param y                 Posición y del objeto.
     * @param preferencesScreen Screen donde se gestiona el objeto.
     * @param text              Texto que se escribe.
     */
    public PreferencesStan(int x, int y, PreferencesScreen preferencesScreen, String text) {
        shapeRenderer = new ShapeRenderer();
        batch = new SpriteBatch();
        this.text = text;
        this.preferencesScreen = preferencesScreen;
        rect = new Rectangle(x, y, Gdx.graphics.getWidth() / 4.5f, Gdx.graphics.getHeight() / 4.5f);

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
        /*shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rect(rect.x, rect.y, rect.width, rect.height);
        shapeRenderer.end();*/

        batch.begin();
        font12.draw(batch, text, rect.x, rect.y + rect.height / 2);
        batch.end();
    }

    /**
     * Método que cambia la variable texto.
     * @param textChange Texto por el que se cambia la variable.
     */
    public void change(String textChange) {
        text = textChange;
    }
}
