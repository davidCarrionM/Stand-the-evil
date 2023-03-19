package com.davidcarrion.game.Helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.davidcarrion.game.MyGame;
import com.davidcarrion.game.Screens.TutorialScreen;
/**
 * Esta clase muestra un texto y reanuda el tutorial cuando se pulsa la pantalla
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class Stopper {
    /**
     * Fuente con la que se escriben los textos.
     */
    private BitmapFont font12;
    /**
     * Dibujador de animaciones y texturas.
     */
    private SpriteBatch batch;
    /**
     * pantalla de texto que se va a mostrar.
     */
    String text;
    /**
     * Variable para gestionar el tamaño del texto.
     */
    GlyphLayout layout;
    /**
     * Lineas de texto de la pantalla comienzo.
     */
    String comienzo1,comienzo2,comienzo3,comienzo4;
    /**
     * Lineas de texto de la pantalla interfaz.
     */
    String interfaz1, interfaz2, interfaz3, interfaz4;
    /**
     * Lineas de texto de la pantalla movimiento.
     */
    String movimiento1, movimiento2, movimiento3, movimiento4;
    /**
     * Lineas de texto de la pantalla enemigoNormal.
     */
    String enemigoNormal1, enemigoNormal2, enemigoNormal3, enemigoNormal4;
    /**
     * Lineas de texto de la pantalla enemigoArrow.
     */
    String enemigoArrow1, enemigoArrow2, enemigoArrow3, enemigoArrow4;
    /**
     * Lineas de texto de la pantalla poderes.
     */
    String poderes1, poderes2, poderes3, poderes4;
    /**
     * Lineas de texto de la pantalla final.
     */
    String final1, final2, final3, final4;

    /**
     * Constructor para Stopper.
     * @param text pantalla que se va a mostrar.
     */
    public Stopper(String text) {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("ui/dpcomic.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = (int) (Gdx.graphics.getHeight()/13);
        parameter.color = Color.BLACK;
        font12 = generator.generateFont(parameter);
        generator.dispose();
        batch = new SpriteBatch();
        this.text = text;
        if(MyGame.prefs.getLanguage().equals("es")){
            comienzo1 = MyGame.myBundleEspaniol.get("comienzo1");
            comienzo2 = MyGame.myBundleEspaniol.get("comienzo2");
            comienzo3 = MyGame.myBundleEspaniol.get("comienzo3");
            comienzo4 = MyGame.myBundleEspaniol.get("comienzo4");
            interfaz1 = MyGame.myBundleEspaniol.get("interfaz1");
            interfaz2 = MyGame.myBundleEspaniol.get("interfaz2");
            interfaz3 = MyGame.myBundleEspaniol.get("interfaz3");
            interfaz4 = MyGame.myBundleEspaniol.get("interfaz4");
            movimiento1 = MyGame.myBundleEspaniol.get("movimiento1");
            movimiento2 = MyGame.myBundleEspaniol.get("movimiento2");
            movimiento3 = MyGame.myBundleEspaniol.get("movimiento3");
            movimiento4 = MyGame.myBundleEspaniol.get("movimiento4");
            enemigoNormal1 = MyGame.myBundleEspaniol.get("enemigoNormal1");
            enemigoNormal2 = MyGame.myBundleEspaniol.get("enemigoNormal2");
            enemigoNormal3 = MyGame.myBundleEspaniol.get("enemigoNormal3");
            enemigoNormal4 = MyGame.myBundleEspaniol.get("enemigoNormal4");
            enemigoArrow1 = MyGame.myBundleEspaniol.get("enemigoArrow1");
            enemigoArrow2 = MyGame.myBundleEspaniol.get("enemigoArrow2");
            enemigoArrow3 = MyGame.myBundleEspaniol.get("enemigoArrow3");
            enemigoArrow4 = MyGame.myBundleEspaniol.get("enemigoArrow4");
            poderes1 = MyGame.myBundleEspaniol.get("poderes1");
            poderes2 = MyGame.myBundleEspaniol.get("poderes2");
            poderes3 = MyGame.myBundleEspaniol.get("poderes3");
            poderes4 = MyGame.myBundleEspaniol.get("poderes4");
            final1 = MyGame.myBundleEspaniol.get("final1");
            final2 = MyGame.myBundleEspaniol.get("final2");
            final3 = MyGame.myBundleEspaniol.get("final3");
            final4 = MyGame.myBundleEspaniol.get("final4");
        }else{
            comienzo1 = MyGame.myBundleIngles.get("comienzo1");
            comienzo2 = MyGame.myBundleIngles.get("comienzo2");
            comienzo3 = MyGame.myBundleIngles.get("comienzo3");
            comienzo4 = MyGame.myBundleIngles.get("comienzo4");
            interfaz1 = MyGame.myBundleIngles.get("interfaz1");
            interfaz2 = MyGame.myBundleIngles.get("interfaz2");
            interfaz3 = MyGame.myBundleIngles.get("interfaz3");
            interfaz4 = MyGame.myBundleIngles.get("interfaz4");
            movimiento1 = MyGame.myBundleIngles.get("movimiento1");
            movimiento2 = MyGame.myBundleIngles.get("movimiento2");
            movimiento3 = MyGame.myBundleIngles.get("movimiento3");
            movimiento4 = MyGame.myBundleIngles.get("movimiento4");
            enemigoNormal1 = MyGame.myBundleIngles.get("enemigoNormal1");
            enemigoNormal2 = MyGame.myBundleIngles.get("enemigoNormal2");
            enemigoNormal3 = MyGame.myBundleIngles.get("enemigoNormal3");
            enemigoNormal4 = MyGame.myBundleIngles.get("enemigoNormal4");
            enemigoArrow1 = MyGame.myBundleIngles.get("enemigoArrow1");
            enemigoArrow2 = MyGame.myBundleIngles.get("enemigoArrow2");
            enemigoArrow3 = MyGame.myBundleIngles.get("enemigoArrow3");
            enemigoArrow4 = MyGame.myBundleIngles.get("enemigoArrow4");
            poderes1 = MyGame.myBundleIngles.get("poderes1");
            poderes2 = MyGame.myBundleIngles.get("poderes2");
            poderes3 = MyGame.myBundleIngles.get("poderes3");
            poderes4 = MyGame.myBundleIngles.get("poderes4");
            final1 = MyGame.myBundleIngles.get("final1");
            final2 = MyGame.myBundleIngles.get("final2");
            final3 = MyGame.myBundleIngles.get("final3");
            final4 = MyGame.myBundleIngles.get("final4");
        }
        layout = new GlyphLayout();
    }

    /**
     * Metodo que gestiona los cambios de las variables y las actualiza.
     */
    public void render(){
        batch.begin();
        if(text.equals("comienzo")){
           escribir(comienzo1,comienzo2,comienzo3,comienzo4);
        }
        if(text.equals("interfaz")){
            escribir(interfaz1,interfaz2,interfaz3,interfaz4);
        }
        if(text.equals("movimiento")){
           escribir(movimiento1,movimiento2,movimiento3,movimiento4);
        }
        if(text.equals("enemigoNormal")){
            escribir(enemigoNormal1,enemigoNormal2,enemigoNormal3,enemigoNormal4);
        }
        if(text.equals("enemigoFlecha")){
            escribir(enemigoArrow1,enemigoArrow2,enemigoArrow3,enemigoArrow4);
        }
        if(text.equals("poderes")){
            escribir(poderes1,poderes2,poderes3,poderes4);
        }
        if(text.equals("final")){
            escribir(final1,final2,final3,final4);
        }
        batch.end();
        if (Gdx.input.isTouched()){
            TutorialScreen.pause = false;
        }
    }

    /**
     * Método para escribir 4 textos en pantalla .
     * @param texto1 Primer texto.
     * @param texto2 Segundo texto.
     * @param texto3 Tercer texto.
     * @param texto4 Cuarto texto.
     */
    public void escribir(String texto1,String texto2,String texto3,String texto4){
        layout.setText(font12,texto1);
        font12.draw(batch, texto1, Gdx.graphics.getWidth()/2- layout.width/2,Gdx.graphics.getHeight()- Gdx.graphics.getHeight()/7);
        layout.setText(font12,texto2);
        font12.draw(batch, texto2, Gdx.graphics.getWidth()/2- layout.width/2,Gdx.graphics.getHeight()- Gdx.graphics.getHeight()/4.5f);
        layout.setText(font12,texto3);
        font12.draw(batch, texto3, Gdx.graphics.getWidth()/2- layout.width/2,Gdx.graphics.getHeight()- Gdx.graphics.getHeight()/3.5f);
        layout.setText(font12,texto4);
        font12.draw(batch, texto4, Gdx.graphics.getWidth()/2- layout.width/2,Gdx.graphics.getHeight()- Gdx.graphics.getHeight()/2.9f);
    }

}
