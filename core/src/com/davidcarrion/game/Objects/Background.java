package com.davidcarrion.game.Objects;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.davidcarrion.game.Helper.Scrollable;
/**
 * Esta clase define el objeto que se usará como fondo de pantalla que hereda de Scrollable
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class Background extends Scrollable {

    /**
     * Constructor para Background.
     * @param x Posición x del objeto.
     * @param y Posición y del objeto.
     * @param width Ancho del objeto.
     * @param height Alto del objeto.
     * @param scrollSpeed Velocidad de movimiento del objeto.
     */
    public Background(float x, float y, int width, int height, float scrollSpeed) {
        super(x, y, width, height, scrollSpeed);
    }

    /**
     * Metodo que dibuja las animaciones y texturas.
     *
     * @param batch         Dibujador de animaciones.
     */
    public void draw(TextureRegion textureRegion, SpriteBatch batch){
        batch.begin();
        batch.draw(textureRegion,getX(),getY(),getWidth(),getHeight());
        batch.end();
    }
}
