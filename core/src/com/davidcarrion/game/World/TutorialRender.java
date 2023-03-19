package com.davidcarrion.game.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.davidcarrion.game.Helper.AssetLoader;
import com.davidcarrion.game.Helper.Constant;
import com.davidcarrion.game.MyGame;
import com.davidcarrion.game.Objects.Enemy;
import com.davidcarrion.game.Objects.Floor;
import com.davidcarrion.game.Objects.Knight;
import com.davidcarrion.game.Objects.PauseButton;
import com.davidcarrion.game.Screens.GameScreen;

import java.util.ArrayList;

/**
 * Esta clase gestiona el render grafico del TutorialScreen
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class TutorialRender {
    /**
     * Objeto que gestiona todos los updates de las clases del tutorial.
     */
    private TutorialWorld myWorld;
    /**
     * Objeto floor del escenario.
     */
    private Floor floor;
    /**
     * Camara Orthografica.
     */
    private OrthographicCamera cam;
    /**
     * Dibujador de figuras.
     */
    private ShapeRenderer shapeRenderer;
    /**
     * Dibujador de animaciones y texturas.
     */
    private SpriteBatch batch;
    /**
     * Objeto pauseButton
     */
    private PauseButton pauseButton;
    /**
     * Fuente 1 con la que se escriben los textos.
     */
    BitmapFont font;
    /**
     * Variable para gestionar el tamaño del texto.
     */
    GlyphLayout layout;
    /**
     * Puntuación de la partida.
     */
    String score;
    /**
     * Objeto caballero.
     */
    private Knight knight;
    /**
     * Colección de enemigos en pantalla.
     */
    private ArrayList<Enemy> enemies = new ArrayList<>();
    /**
     * Fuente 2 con la que se escriben los textos.
     */
    BitmapFont font12;

    /**
     * Constructor para TutorialRender.
     *
     * @param world Objeto que gestiona todos los updates de las clases del tutorial.
     */
    public TutorialRender(TutorialWorld world) {
        myWorld = world;

        cam = new OrthographicCamera();
        cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        layout = new GlyphLayout();
        if (MyGame.prefs.getLanguage().equals("es")) {
            score = MyGame.myBundleEspaniol.get("puntuacion");
        } else {
            score = MyGame.myBundleIngles.get("puntuacion");
        }
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);

        batch = new SpriteBatch();
        batch.setProjectionMatrix(cam.combined);
        font = new BitmapFont();
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("ui/dpcomic.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = (int) (40 * Constant.density);
        font12 = generator.generateFont(parameter); // font size 12 pixels
        generator.dispose();
        initGamesObjects();
        layout.setText(font12, score);
    }

    /**
     * Metodo que dibuja las animaciones y texturas.
     *
     * @param runtime Delta time.
     */
    public void render(float runtime) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
       /* shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.BLACK);
        shapeRenderer.rect(floor.getX(), floor.getY(), floor.getWidth(),floor.getHeight());
        shapeRenderer.end();*/
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(200 / 255f, 200 / 255f, 200 / 255f, 1);
        shapeRenderer.rect(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        shapeRenderer.setColor(165 / 255f, 165 / 255f, 165 / 255f, 1);
        shapeRenderer.rect(0, 0, floor.getWidth(), floor.getHeight() + floor.getHeight() / 2);
        shapeRenderer.end();
        //DEBUG
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.line(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight(), Gdx.graphics.getWidth() / 2, 0);
        shapeRenderer.line(Gdx.graphics.getWidth(), Gdx.graphics.getHeight() / 2, 0, Gdx.graphics.getHeight() / 2);
        shapeRenderer.end();

        batch.begin();
        batch.draw(AssetLoader.health5Texture, 50 * Constant.density, Gdx.graphics.getHeight() - 70 * Constant.density, Gdx.graphics.getWidth() / 20, Gdx.graphics.getWidth() / 20);
        batch.draw(AssetLoader.mana100, 100 * Constant.density, Gdx.graphics.getHeight() - 70 * Constant.density, Gdx.graphics.getWidth() / 20, Gdx.graphics.getWidth() / 20);

        batch.draw(AssetLoader.tCoin, 50 * Constant.density, Gdx.graphics.getHeight() - 130 * Constant.density, Gdx.graphics.getWidth() / 25, Gdx.graphics.getWidth() / 25);
        font12.draw(batch, "" + GameScreen.coins, 50 * Constant.density + Gdx.graphics.getWidth() / 20, Gdx.graphics.getHeight() - 100 * Constant.density);
        font12.draw(batch, score + GameScreen.score, Gdx.graphics.getWidth() / 2 - layout.width / 2, Gdx.graphics.getHeight() - 20 * Constant.density);

        /*batch.draw(AssetLoader.floorGround, floor.getX(), floor.getY(), floor.getWidth(), floor.getHeight());*/
        batch.end();
        knight.draw(shapeRenderer, batch, runtime);
        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).draw(shapeRenderer, batch, runtime);
        }
        pauseButton.Draw(batch);
    }

    /**
     * Método que inicializa todas las variables que comparte con el GameWorld.
     */
    private void initGamesObjects() {
        knight = myWorld.getKnigth();
        floor = myWorld.getFloor();
        enemies = myWorld.getEnemies();
        pauseButton = myWorld.getPauseButton();
    }
}
