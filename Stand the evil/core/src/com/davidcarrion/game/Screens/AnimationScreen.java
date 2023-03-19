package com.davidcarrion.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.davidcarrion.game.Helper.Constant;
import com.davidcarrion.game.Helper.SoundLoader;
import com.davidcarrion.game.MyGame;

import java.util.ArrayList;

/**
 * Esta clase gestiona la pantalla de Animación de principio de juego
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class AnimationScreen implements Screen {
    /**
     * Clase que usan todos los actores de la pantalla para poder gestionarlos.
     */
    private Stage stage;
    /**
     * Clase principal donde se gestionan las distintas Screens.
     */
    private MyGame game;
    /**
     * Colección de las imagenes de la animación.
     */
    ArrayList<Texture> images = new ArrayList<>();
    /**
     * Indica el numero de imagen que se esta mostrando.
     */
    int cont = 0;
    /**
     * Botón para salir de la animación e ir al menú principal.
     */
    ImageButton back;
    /**
     * Botón para ir a la siguiente animación.
     */
    ImageButton next;
    /**
     * Botón para ir a la animación anterior.
     */
    ImageButton exit;

    /**
     * Constructor para AnimationScreen.
     *
     * @param game Clase principal donde se gestionan las distintas Screens.
     */
    public AnimationScreen(final MyGame game) {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        this.game = game;

        images.add((new Texture(Gdx.files.internal("background/animacion1.png"))));
        images.add((new Texture(Gdx.files.internal("background/animacion2.png"))));
        images.add((new Texture(Gdx.files.internal("background/animacion3.png"))));
        images.add((new Texture(Gdx.files.internal("background/city1.png"))));
        images.add((new Texture(Gdx.files.internal("background/city2.png"))));
        images.add((new Texture(Gdx.files.internal("background/mountain0.png"))));
        images.add((new Texture(Gdx.files.internal("background/mountain1.png"))));
        images.add((new Texture(Gdx.files.internal("background/mountain2.png"))));
        images.add((new Texture(Gdx.files.internal("background/zfinal.png"))));

        final Image image = new Image(images.get(0));
        image.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        image.setPosition(0, 0);
        stage.addActor(image);

        back = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/left.png")))), new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/leftPulsado.png")))));
        back.getImage().setFillParent(true);
        back.setSize(Gdx.graphics.getWidth() / 15, Gdx.graphics.getWidth() / 15);
        back.setPosition(Gdx.graphics.getWidth() / 50, Gdx.graphics.getHeight() / 100);
        stage.addActor(back);
        back.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (game.prefs.isSound()) {
                    SoundLoader.paperSound.play();
                }
                if (cont > 0) {
                    cont--;
                    image.setDrawable(new SpriteDrawable(new Sprite(images.get(cont))));
                }
            }
        });

        next = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/right.png")))), new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/rightPulsado.png")))));
        next.getImage().setFillParent(true);
        next.setSize(Gdx.graphics.getWidth() / 15, Gdx.graphics.getWidth() / 15);
        next.setPosition(Gdx.graphics.getWidth() - next.getWidth() * 1.8f, Gdx.graphics.getHeight() / 100);
        stage.addActor(next);
        next.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (game.prefs.isSound()) {
                    SoundLoader.paperSound.play();
                }
                if (cont < images.size() - 1) {
                    cont++;
                    image.setDrawable(new SpriteDrawable(new Sprite(images.get(cont))));
                }
            }
        });

        exit = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/salir.png")))), new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/salirPulsado.png")))));
        exit.getImage().setFillParent(true);
        exit.setSize(Gdx.graphics.getWidth() / 15, Gdx.graphics.getWidth() / 15);
        exit.setPosition(Gdx.graphics.getWidth() / 2 - exit.getWidth() / 2, Gdx.graphics.getHeight() / 100);
        stage.addActor(exit);
        exit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (game.prefs.isSound()) {
                    SoundLoader.clickSound.play();
                }
                Constant.menuMusic = true;
                game.setMenu();
            }
        });
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
        if (cont == 0) {
            back.setVisible(false);
        } else {
            back.setVisible(true);
        }
        if (cont >= images.size() - 1) {
            next.setVisible(false);
        } else {
            next.setVisible(true);
        }
    }

    @Override
    public void resize(int i, int i1) {

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
