package com.davidcarrion.game.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.davidcarrion.game.Helper.AssetLoader;
import com.davidcarrion.game.Helper.Constant;
import com.davidcarrion.game.Helper.ScrollHandler;
import com.davidcarrion.game.MyGame;
import com.davidcarrion.game.Objects.Background;
import com.davidcarrion.game.Objects.Coin;
import com.davidcarrion.game.Objects.Enemy;
import com.davidcarrion.game.Objects.Floor;
import com.davidcarrion.game.Objects.Hearth;
import com.davidcarrion.game.Objects.Knight;
import com.davidcarrion.game.Objects.PauseButton;
import com.davidcarrion.game.Screens.GameScreen;

import java.util.ArrayList;
import java.util.Random;

/**
 * Esta clase gestiona el render grafico del GameScreen
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class GameRender {
    /**
     * Objeto que gestiona todos los updates de las clases del juego.
     */
    private GameWorld myWorld;
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
     * Objetos floor del escenario 1.
     */
    private Floor frontFloor, backFloor;
    /**
     * Objetos floor del escenario 2.
     */
    private Floor frontFloorFabric, backFloorFabric;
    /**
     * Objetos Background del escenario 1.
     */
    private Background frontSky, backSky, frontMountains, frontFarClouds, frontFarMountains, frontNearClouds, backMountains, backFarClouds, backFarMountains, backNearClouds, frontTrees, backTrees;
    /**
     * Objetos Background del escenario 2.
     */
    private Background frontFabric1, frontFabric2, frontFabric3, frontFabric4, frontFabric5, backFabric1, backFabric2, backFabric3, backFabric4, backFabric5;
    /**
     * Fuente 1 con la que se escriben los textos.
     */
    BitmapFont font;
    /**
     * Objeto random para generar un numero aleatorio
     */
    private Random random = new Random();
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
     * Colección de monedas en pantalla.
     */
    private ArrayList<Coin> coins = new ArrayList<>();
    /**
     * Colección de corazones en pantalla.
     */
    private ArrayList<Hearth> hearths = new ArrayList<>();
    /**
     * Manejador de objetos que heredan de Scrollable.
     */
    private ScrollHandler scroller;
    /**
     * Fuente 2 con la que se escriben los textos.
     */
    BitmapFont font12;
    /**
     * Variable que indica que escenario se tiene que pintar.
     */
    private int selectBack;
    /**
     * Textura del suelo.
     */
    TextureRegion floorTexture;

    /**
     * Constructor para GameRender.
     *
     * @param world Objeto que gestiona todos los updates de las clases del juego.
     */
    public GameRender(GameWorld world) {
        myWorld = world;
        layout = new GlyphLayout();
        selectBack = random.nextInt(2);
        if (MyGame.prefs.getLanguage().equals("es")) {
            score = MyGame.myBundleEspaniol.get("puntuacion");
        } else {
            score = MyGame.myBundleIngles.get("puntuacion");
        }
        cam = new OrthographicCamera();
        cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
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
        if (selectBack == 0) {
            floorTexture = AssetLoader.floor1;
        }
        if (selectBack == 1) {
            floorTexture = AssetLoader.floorGround;
        }
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
        drawBackground();
        //DEBUG
        /*shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.line(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight(), Gdx.graphics.getWidth() / 2, 0);
        shapeRenderer.line(Gdx.graphics.getWidth(), Gdx.graphics.getHeight() / 2, 0, Gdx.graphics.getHeight() / 2);
        shapeRenderer.end();*/

        batch.begin();
        switch (knight.live) {
            case 5:
                batch.draw(AssetLoader.health5Texture, 50 * Constant.density, Gdx.graphics.getHeight() - 70 * Constant.density, Gdx.graphics.getWidth() / 20, Gdx.graphics.getWidth() / 20);
                break;
            case 4:
                batch.draw(AssetLoader.health4Texture, 50 * Constant.density, Gdx.graphics.getHeight() - 70 * Constant.density, Gdx.graphics.getWidth() / 20, Gdx.graphics.getWidth() / 20);
                break;
            case 3:
                batch.draw(AssetLoader.health3Texture, 50 * Constant.density, Gdx.graphics.getHeight() - 70 * Constant.density, Gdx.graphics.getWidth() / 20, Gdx.graphics.getWidth() / 20);
                break;
            case 2:
                batch.draw(AssetLoader.health2Texture, 50 * Constant.density, Gdx.graphics.getHeight() - 70 * Constant.density, Gdx.graphics.getWidth() / 20, Gdx.graphics.getWidth() / 20);
                break;
            case 1:
                batch.draw(AssetLoader.health1Texture, 50 * Constant.density, Gdx.graphics.getHeight() - 70 * Constant.density, Gdx.graphics.getWidth() / 20, Gdx.graphics.getWidth() / 20);
                break;
            default:
                batch.draw(AssetLoader.health1Texture, 50 * Constant.density, Gdx.graphics.getHeight() - 70 * Constant.density, Gdx.graphics.getWidth() / 20, Gdx.graphics.getWidth() / 20);
                break;
        }

        switch (knight.mana) {
            case 100:
                batch.draw(AssetLoader.mana100, 100 * Constant.density, Gdx.graphics.getHeight() - 70 * Constant.density, Gdx.graphics.getWidth() / 20, Gdx.graphics.getWidth() / 20);
                break;
            case 90:
            case 80:
            case 70:
            case 60:
            case 50:
                batch.draw(AssetLoader.mana50, 100 * Constant.density, Gdx.graphics.getHeight() - 70 * Constant.density, Gdx.graphics.getWidth() / 20, Gdx.graphics.getWidth() / 20);
                break;
            case 0:
                batch.draw(AssetLoader.mana0, 100 * Constant.density, Gdx.graphics.getHeight() - 70 * Constant.density, Gdx.graphics.getWidth() / 20, Gdx.graphics.getWidth() / 20);
                break;
            default:
                batch.draw(AssetLoader.mana0, 100 * Constant.density, Gdx.graphics.getHeight() - 70 * Constant.density, Gdx.graphics.getWidth() / 20, Gdx.graphics.getWidth() / 20);
                break;
        }

        batch.draw(AssetLoader.tCoin, 50 * Constant.density, Gdx.graphics.getHeight() - 130 * Constant.density, Gdx.graphics.getWidth() / 25, Gdx.graphics.getWidth() / 25);
        font12.draw(batch, "" + GameScreen.coins, 50 * Constant.density + Gdx.graphics.getWidth() / 20, Gdx.graphics.getHeight() - 100 * Constant.density);

        font12.draw(batch, score + GameScreen.score, Gdx.graphics.getWidth() / 2 - layout.width / 2, Gdx.graphics.getHeight() - 20 * Constant.density);

        batch.draw(floorTexture, floor.getX(), floor.getY(), floor.getWidth(), floor.getHeight());
        batch.end();
        knight.draw(shapeRenderer, batch, runtime);
        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).draw(shapeRenderer, batch, runtime);
        }
        for (int i = 0; i < coins.size(); i++) {
            coins.get(i).draw(batch, runtime);
        }
        for (int i = 0; i < hearths.size(); i++) {
            hearths.get(i).draw(batch, runtime);
        }
        drawFloor();
        pauseButton.Draw(batch);
    }

    /**
     * Método que dibuja los suelos.
     */
    private void drawFloor() {
        if (selectBack == 0) {
            frontFloorFabric.draw(batch, AssetLoader.fabric5);
            backFloorFabric.draw(batch, AssetLoader.fabric5);
        }
        if (selectBack == 1) {
            frontFloor.draw(batch, AssetLoader.floor);
            backFloor.draw(batch, AssetLoader.floor);
        }
    }

    /**
     * Método que dibuja los escenarios.
     */
    private void drawBackground() {
        if (selectBack == 0) {
            frontFabric1.draw(AssetLoader.fabric1, batch);
            backFabric1.draw(AssetLoader.fabric1no, batch);
            frontFabric2.draw(AssetLoader.fabric2, batch);
            backFabric2.draw(AssetLoader.fabric2, batch);
            frontFabric3.draw(AssetLoader.fabric3, batch);
            backFabric3.draw(AssetLoader.fabric3, batch);
            frontFabric4.draw(AssetLoader.fabric4, batch);
            backFabric4.draw(AssetLoader.fabric4, batch);
            frontFabric5.draw(AssetLoader.fabric5, batch);
            backFabric5.draw(AssetLoader.fabric5, batch);
        }
        if (selectBack == 1) {

            frontSky.draw(AssetLoader.skyMoon, batch);
            backSky.draw(AssetLoader.sky, batch);
            frontFarClouds.draw(AssetLoader.FarClouds, batch);
            backFarClouds.draw(AssetLoader.FarClouds, batch);
            frontNearClouds.draw(AssetLoader.NearClouds, batch);
            backNearClouds.draw(AssetLoader.NearClouds, batch);
            frontFarMountains.draw(AssetLoader.FarMountains, batch);
            backFarMountains.draw(AssetLoader.FarMountains, batch);
            frontMountains.draw(AssetLoader.Mountains, batch);
            backMountains.draw(AssetLoader.Mountains, batch);
            frontTrees.draw(AssetLoader.trees, batch);
            backTrees.draw(AssetLoader.trees, batch);
        }
    }

    /**
     * Método que inicializa todas las variables que comparte con el GameWorld.
     */
    private void initGamesObjects() {
        knight = myWorld.getKnigth();
        floor = myWorld.getFloor();
        scroller = myWorld.getScroller();
        if (selectBack == 0) {
            frontFloorFabric = scroller.getFrontFloorFabric();
            backFloorFabric = scroller.getBackFloorFabric();
        }
        if (selectBack == 1) {

            frontFloor = scroller.getFrontfloor();
            backFloor = scroller.getBackFloor();
        }
        enemies = myWorld.getEnemies();
        coins = myWorld.getCoins();
        hearths = myWorld.getHearths();
        pauseButton = myWorld.getPauseButton();
        if (selectBack == 0) {
            frontFabric1 = scroller.getFrontFabric1();
            frontFabric2 = scroller.getFrontFabric2();
            frontFabric3 = scroller.getFrontFabric3();
            frontFabric4 = scroller.getFrontFabric4();
            frontFabric5 = scroller.getFrontFabric5();
            backFabric1 = scroller.getBackFabric1();
            backFabric2 = scroller.getBackFabric2();
            backFabric3 = scroller.getBackFabric3();
            backFabric4 = scroller.getBackFabric4();
            backFabric5 = scroller.getBackFabric5();
        }
        if (selectBack == 1) {


            frontMountains = scroller.getFrontMountains();
            frontFarClouds = scroller.getFrontFarClouds();
            frontFarMountains = scroller.getFrontFarMountains();
            frontNearClouds = scroller.getFrontNearClouds();
            frontTrees = scroller.getFrontTrees();
            backMountains = scroller.getBackMountains();
            backFarClouds = scroller.getBackFarClouds();
            backFarMountains = scroller.getBackFarMountains();
            backNearClouds = scroller.getBackNearClouds();
            backTrees = scroller.getBackTrees();
            frontSky = scroller.getFrontSky();
            backSky = scroller.getBackSky();
        }

    }
}
