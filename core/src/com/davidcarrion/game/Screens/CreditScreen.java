package com.davidcarrion.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.davidcarrion.game.Helper.Constant;
import com.davidcarrion.game.Helper.SoundLoader;
import com.davidcarrion.game.MyGame;

/**
 * Esta clase gestiona la pantalla de creditos
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class CreditScreen implements Screen {
    /**
     * Imagen de fondo donde se situarán los creditos.
     */
    Image image;
    /**
     * Imagen de fondo de pantalla.
     */
    Image background;
    /**
     * Clase principal donde se gestionan las distintas Screens.
     */
    MyGame game;
    /**
     * Clase que usan todos los actores de la pantalla para poder gestionarlos.
     */
    private Stage stage;
    /**
     * Dibujador de animaciones y texturas.
     */
    SpriteBatch batch;
    /**
     * Botón con imagen para volver a la pantalla principal.
     */
    ImageButton back;
    /**
     * Fuente con la que se escriben los textos.
     */
    private BitmapFont font12;
    /**
     * Sonido de click de botón.
     */
    Sound soundClick;
    /**
     * Variable del texto que se va a escribir en pantalla
     */
    String texto1, texto2, texto3, texto4, texto5, texto6, texto7, texto8, texto9, texto10;
    /**
     * Rectangulo que coge la mitad izquierda de la imagen.
     */
    Rectangle rectLeft;
    /**
     * Rectangulo que coge la mitad derecha de la imagen.
     */
    Rectangle rectRight;
    /**
     * Dibujador de figuras.
     */
    ShapeRenderer shapeRenderer;

    /**
     * Constructor para CreditScreen.
     *
     * @param myGame Clase principal donde se gestionan las distintas Screens.
     */
    public CreditScreen(final MyGame myGame) {
        game = myGame;
        batch = new SpriteBatch();
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        soundClick = SoundLoader.clickSound;
        shapeRenderer = new ShapeRenderer();

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("ui/dpcomic.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = (int) (23 * Constant.density);
        parameter.color = Color.BLACK;
        font12 = generator.generateFont(parameter); // font size 12 pixels
        generator.dispose();

        background = new Image(new Texture(Gdx.files.internal("ui/fondoShop.png")));
        background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        background.setPosition(0, 0);
        stage.addActor(background);

        image = new Image(new Texture(Gdx.files.internal("ui/libro.png")));
        image.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        image.setPosition(0, 0);
        stage.addActor(image);

        back = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/back.png")))), new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/backPulsado.png")))));
        back.setSize(40 * Constant.density, 40 * Constant.density);
        back.setPosition(70 * Constant.density, Gdx.graphics.getHeight() - 90 * Constant.density);
        back.getImage().setFillParent(true);
        stage.addActor(back);
        back.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (game.prefs.isSound()) {
                    SoundLoader.clickSound.play();
                }
                game.musics.get(1).setVolume(0.7f);
                Constant.menuMusic = true;
                game.setMenu();
            }
        });
        if (game.prefs.getLanguage().equals("es")) {
            texto1 = MyGame.myBundleEspaniol.get("creador");
            texto2 = MyGame.myBundleEspaniol.get("creditsMusica");
            texto3 = MyGame.myBundleEspaniol.get("creditsSonido");
            texto4 = MyGame.myBundleEspaniol.get("creditsAssets");
            texto5 = MyGame.myBundleEspaniol.get("creditsGui");
            texto6 = MyGame.myBundleEspaniol.get("creditsFondos");
            texto7 = MyGame.myBundleEspaniol.get("creditsCaballero");
            texto8 = MyGame.myBundleEspaniol.get("creditsEnemigos");
            texto9 = MyGame.myBundleEspaniol.get("creditsEfectos");
            texto10 = MyGame.myBundleEspaniol.get("creditsBotones");
        } else {
            texto1 = MyGame.myBundleIngles.get("creador");
            texto2 = MyGame.myBundleIngles.get("creditsMusica");
            texto3 = MyGame.myBundleIngles.get("creditsSonido");
            texto4 = MyGame.myBundleIngles.get("creditsAssets");
            texto5 = MyGame.myBundleIngles.get("creditsGui");
            texto6 = MyGame.myBundleIngles.get("creditsFondos");
            texto7 = MyGame.myBundleIngles.get("creditsCaballero");
            texto8 = MyGame.myBundleIngles.get("creditsEnemigos");
            texto9 = MyGame.myBundleIngles.get("creditsEfectos");
            texto10 = MyGame.myBundleIngles.get("creditsBotones");
        }
        rectLeft = new Rectangle(Gdx.graphics.getWidth() / 10, Gdx.graphics.getWidth() / 10, Gdx.graphics.getWidth() / 3, Gdx.graphics.getHeight() / 1.5f);
        rectRight = new Rectangle(Gdx.graphics.getWidth() / 1.75f, Gdx.graphics.getWidth() / 10, Gdx.graphics.getWidth() / 3, Gdx.graphics.getHeight() / 1.5f);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1f, 0f, 0f, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();

        batch.begin();
        font12.draw(batch, texto1, rectLeft.x, rectLeft.y + rectLeft.height - rectLeft.height / 10);
        font12.draw(batch, texto2, rectLeft.x, rectLeft.y + rectLeft.height - rectLeft.height / 10 * 3);
        font12.draw(batch, texto3, rectLeft.x, rectLeft.y + rectLeft.height - rectLeft.height / 10 * 5);
        font12.draw(batch, texto4, rectLeft.x, rectLeft.y + rectLeft.height - rectLeft.height / 10 * 7);
        font12.draw(batch, texto5, rectLeft.x, rectLeft.y + rectLeft.height - rectLeft.height / 10 * 9);

        font12.draw(batch, texto6, rectRight.x, rectLeft.y + rectLeft.height - rectLeft.height / 10);
        font12.draw(batch, texto7, rectRight.x, rectLeft.y + rectLeft.height - rectLeft.height / 10 * 3);
        font12.draw(batch, texto8, rectRight.x, rectLeft.y + rectLeft.height - rectLeft.height / 10 * 5);
        font12.draw(batch, texto9, rectRight.x, rectLeft.y + rectLeft.height - rectLeft.height / 10 * 7);
        font12.draw(batch, texto10, rectRight.x, rectLeft.y + rectLeft.height - rectLeft.height / 10 * 9);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
