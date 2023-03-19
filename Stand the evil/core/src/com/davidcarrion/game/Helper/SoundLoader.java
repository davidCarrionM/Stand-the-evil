package com.davidcarrion.game.Helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

/**
 * Esta clase carga todos los audio antes de que inicie el juego
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class SoundLoader {
    /**
     * Sonido de la espada.
     */
    public static Sound soundSword;
    /**
     * Sonido del salto.
     */
    public static Sound jumpSound;
    /**
     * Sonido de la caida fuerte.
     */
    public static Sound fallSound;
    /**
     * Sonido del click del boton.
     */
    public static Sound clickSound;
    /**
     * Sonido al comprar.
     */
    public static Sound buySound;
    /**
     * Sonido de compra bloqueada.
     */
    public static Sound lockSound;
    /**
     * Sonido de la tienda del personaje de fuego.
     */
    public static Sound fireShopSound;
    /**
     * Sonido de la tienda del personaje de agua.
     */
    public static Sound waterShopSound;
    /**
     * Sonido de la tienda del personaje de rayo.
     */
    public static Sound thunderShopSound;
    /**
     * Sonido de la tienda del personaje de tierra.
     */
    public static Sound dirtShopSound;
    /**
     * Sonido de daño del caballero.
     */
    public static Sound knightDamageSound;
    /**
     * Sonido de muerte del caballero.
     */
    public static Sound knightDieSound;
    /**
     * Sonido de muerte del enemigo.
     */
    public static Sound EnemyDieSound;
    /**
     * Sonido de aparicion del corazon.
     */
    public static Sound heartSound;
    /**
     * Sonido de aparicion de la moneda.
     */
    public static Sound coinSound;
    /**
     * Sonido de teletransporte de los enemigos especiales.
     */
    public static Sound dashSound;
    /**
     * Sonido de aparicion de la flecha.
     */
    public static Sound arrowSound;
    /**
     * Sonido del poder de fuego.
     */
    public static Sound fireShotSound;
    /**
     * Sonido del golpe de fuego.
     */
    public static Sound fireHitSound;
    /**
     * Sonido de poder de agua.
     */
    public static Sound waterShotSound;
    /**
     * Sonido del golpe de agua.
     */
    public static Sound waterHitSound;
    /**
     * Sonido de poder de rayo.
     */
    public static Sound thunderShotSound;
    /**
     * Sonido del golpe de rayo.
     */
    public static Sound thunderHitSound;
    /**
     * Sonido de poder de tierra.
     */
    public static Sound dirtShotSound;
    /**
     * Sonido del golpe de tierra.
     */
    public static Sound dirtHitSound;
    /**
     * Sonido golpe de arrow.
     */
    public static Sound voltHitSound;
    /**
     * Sonido pasar animacion.
     */
    public static Sound paperSound;

    /**
     * Constructor para SoundLoader sin parametros.
     */
    public SoundLoader() {

    }

    /**
     * Carga todos los sonidos
     */
    public static void load() {
        soundSword = Gdx.audio.newSound(Gdx.files.internal("music/sword.wav"));
        jumpSound = Gdx.audio.newSound(Gdx.files.internal("music/jump.wav"));
        fallSound = Gdx.audio.newSound(Gdx.files.internal("music/fall.wav"));
        voltHitSound = Gdx.audio.newSound(Gdx.files.internal("music/enemyVolt.wav"));
        clickSound = Gdx.audio.newSound(Gdx.files.internal("music/click.wav"));
        buySound = Gdx.audio.newSound(Gdx.files.internal("music/buy.wav"));
        lockSound = Gdx.audio.newSound(Gdx.files.internal("music/lock.wav"));
        coinSound = Gdx.audio.newSound(Gdx.files.internal("music/coin.wav"));
        heartSound = Gdx.audio.newSound(Gdx.files.internal("music/hearth.wav"));
        dashSound = Gdx.audio.newSound(Gdx.files.internal("music/dash.wav"));
        arrowSound = Gdx.audio.newSound(Gdx.files.internal("music/arrow.wav"));

        EnemyDieSound = Gdx.audio.newSound(Gdx.files.internal("music/enemyDead.wav"));
        knightDamageSound = Gdx.audio.newSound(Gdx.files.internal("music/knightHit.ogg"));
        knightDieSound = Gdx.audio.newSound(Gdx.files.internal("music/knightDead.wav"));
        fireShopSound = Gdx.audio.newSound(Gdx.files.internal("music/fireShop.ogg"));
        waterShopSound = Gdx.audio.newSound(Gdx.files.internal("music/waterShop.wav"));
        thunderShopSound = Gdx.audio.newSound(Gdx.files.internal("music/thunderShop.wav"));
        dirtShopSound = Gdx.audio.newSound(Gdx.files.internal("music/dirtShop.wav"));
        paperSound = Gdx.audio.newSound(Gdx.files.internal("music/paper.wav"));

        fireShotSound = Gdx.audio.newSound(Gdx.files.internal("music/powers/fireShot.wav"));
        fireHitSound = Gdx.audio.newSound(Gdx.files.internal("music/powers/fireHit.wav"));
        waterShotSound = Gdx.audio.newSound(Gdx.files.internal("music/powers/waterShot.wav"));
        waterHitSound = Gdx.audio.newSound(Gdx.files.internal("music/powers/waterHit.wav"));
        thunderShotSound = Gdx.audio.newSound(Gdx.files.internal("music/powers/electricShot.wav"));
        thunderHitSound = Gdx.audio.newSound(Gdx.files.internal("music/powers/electricHit.wav"));
        dirtShotSound = Gdx.audio.newSound(Gdx.files.internal("music/powers/dirtShot.wav"));
        dirtHitSound = Gdx.audio.newSound(Gdx.files.internal("music/powers/dirtHit.wav"));

    }

    /**
     * Libera recursos de los sonidos
     */
    public static void dispose() {
        soundSword.dispose();
        jumpSound.dispose();
        fallSound.dispose();
        voltHitSound.dispose();
        clickSound.dispose();
        buySound.dispose();
        lockSound.dispose();
        coinSound.dispose();
        heartSound.dispose();
        dashSound.dispose();
        arrowSound.dispose();
        paperSound.dispose();
        EnemyDieSound.dispose();
        knightDamageSound.dispose();
        knightDieSound.dispose();
        fireShopSound.dispose();
        waterShopSound.dispose();
        thunderShopSound.dispose();
        dirtShopSound.dispose();

        fireShotSound.dispose();
        fireHitSound.dispose();
        waterShotSound.dispose();
        waterHitSound.dispose();
        thunderShotSound.dispose();
        thunderHitSound.dispose();
        dirtShotSound.dispose();
        dirtHitSound.dispose();
    }
}
