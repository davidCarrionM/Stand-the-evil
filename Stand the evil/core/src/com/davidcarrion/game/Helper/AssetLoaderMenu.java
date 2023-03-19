package com.davidcarrion.game.Helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
/**
 * Esta clase carga todas las animaciones solamente del menu una vez que se inicia el juego
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class AssetLoaderMenu {
    /**
     * Texturas de los objetos del escenario.
     */
    public static TextureRegion frontFarTrees,frontMidTrees,frontNearTrees,backFarTrees,backMidTrees,backNearTrees;

    /**
     * Constructor para AssetLoaderMenu.
     */
    public AssetLoaderMenu() {}

    /**
     * Método que carga todas las animaciones.
     */
    public static void load(){
        frontFarTrees = new TextureRegion(new Texture(Gdx.files.internal("main_menu/background/background_layer_1.png")));
        frontMidTrees = new TextureRegion(new Texture(Gdx.files.internal("main_menu/background/background_layer_2.png")));
        frontNearTrees = new TextureRegion(new Texture(Gdx.files.internal("main_menu/background/background_layer_3.png")));
        backFarTrees = new TextureRegion(new Texture(Gdx.files.internal("main_menu/background/background_layer_1.png")));
        backMidTrees = new TextureRegion(new Texture(Gdx.files.internal("main_menu/background/background_layer_2.png")));
        backNearTrees = new TextureRegion(new Texture(Gdx.files.internal("main_menu/background/background_layer_3.png")));
    }

    /**
     * Método que hace dispose de las texturas.
     */
    public static void dispose(){

    }

}
