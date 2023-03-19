package com.davidcarrion.game.Helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Esta clase carga todas las animaciones una vez que se inicia el juego
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class AssetLoader {
    /**
     * Variable auxiliar para crear las animaciones en sprites.
     */
    public static Texture texture;
    /**
     * Array auxiliar para crear las animaciones en imagenes distintas.
     */
    public static TextureRegion[] textureRegions;

    //KNIGHT
    /**
     * Animaciones del caballero rojo.
     */
    public static Animation deathAnimationRed, deathAnimationRightRed, hurtAnimationRed, hurtAnimationRightRed, powerAnimationRed, powerAnimationRightRed, fallAnimationRed, fallAnimationRightRed, IdleAnimationRed, IdleAnimationRightRed, crouchAnimationRed, crouchAnimationRightRed, jumpAnimationRed, jumpAnimationRightRed, attackAnimationRed, attackAnimationRightRed;
    /**
     * Animaciones del caballero azul.
     */
    public static Animation deathAnimationBlue, deathAnimationRightBlue, hurtAnimationBlue, hurtAnimationRightBlue, powerAnimationBlue, powerAnimationRightBlue, fallAnimationBlue, fallAnimationRightBlue, IdleAnimationBlue, IdleAnimationRightBlue, crouchAnimationBlue, crouchAnimationRightBlue, jumpAnimationBlue, jumpAnimationRightBlue, attackAnimationBlue, attackAnimationRightBlue;
    /**
     * Animaciones del caballero amarillo.
     */
    public static Animation deathAnimationYellow, deathAnimationRightYellow, hurtAnimationYellow, hurtAnimationRightYellow, powerAnimationYellow, powerAnimationRightYellow, fallAnimationYellow, fallAnimationRightYellow, IdleAnimationYellow, IdleAnimationRightYellow, crouchAnimationYellow, crouchAnimationRightYellow, jumpAnimationYellow, jumpAnimationRightYellow, attackAnimationYellow, attackAnimationRightYellow;
    /**
     * Animaciones del caballero marron.
     */
    public static Animation deathAnimationBrown, deathAnimationRightBrown, hurtAnimationBrown, hurtAnimationRightBrown, powerAnimationBrown, powerAnimationRightBrown, fallAnimationBrown, fallAnimationRightBrown, IdleAnimationBrown, IdleAnimationRightBrown, crouchAnimationBrown, crouchAnimationRightBrown, jumpAnimationBrown, jumpAnimationRightBrown, attackAnimationBrown, attackAnimationRightBrown;

    //ENEMIES
    /**
     * Animaciones del enemigo normal.
     */
    public static Animation normalEnemyDamageAnimation, normalEnemyDamageAnimationRight, normalEnemyDeathAnimation, normalEnemyDeathAnimationRight, normalEnemyRunAnimation, normalEnemyHitAnimation, normalEnemyRunAnimationRigth, normalEnemyHitAnimationRigth;
    /**
     * Animaciones del enemigo especial C (Volador).
     */
    public static Animation specialEnemyCHitAnimation, specialEnemyCHitAnimationRight, specialEnemyCDeathAnimation, specialEnemyCDeathAnimationRight, specialEnemyCRunAnimation, specialEnemyCRunAnimationRight, specialEnemyCRunAnimationUp;
    /**
     * Animaciones del enemigo especial A (Cambia de lado).
     */
    public static Animation specialEnemyADeathAnimation, specialEnemyADeathAnimationRight, specialEnemyAAttackAnimation, specialEnemyAAttackAnimationRight, specialEnemyARunAnimation, specialEnemyARunAnimationRight;
    /**
     * Animaciones del enemigo especial B (Se mueve para atras).
     */
    public static Animation specialEnemyBDeathAnimation, specialEnemyBDeathAnimationRight, specialEnemyBAttackAnimation, specialEnemyBAttackAnimationRight, specialEnemyBRunAnimation, specialEnemyBRunAnimationRight;
    /**
     * Animaciones del enemigo especial Arrow (Dispara Arrow).
     */
    public static Animation specialEnemyArrowIdleAnimation, specialEnemyArrowIdleAnimationRight, specialEnemyArrowDeathAnimation, specialEnemyArrowDeathAnimationRight, specialEnemyArrowAttackAnimation, specialEnemyArrowAttackAnimationRight, specialEnemyArrowRunAnimation, specialEnemyArrowRunAnimationRight, specialEnemyArrowArrowAnimation, specialEnemyArrowArrowAnimationRight;

    //EFFECTS
    /**
     * Animaciones del poder de fuego.
     */
    public static Animation fireVoltAnimation, fireVoltAnimationRight;
    /**
     * Animaciones del poder de hielo.
     */
    public static Animation iceVoltAnimation, iceVoltAnimationRight;
    /**
     * Animaciones del poder de rayo.
     */
    public static Animation thunderVoltAnimation, thunderVoltAnimationRight;
    /**
     * Animaciones del poder de tierra.
     */
    public static Animation dirtVoltAnimation, dirtVoltAnimationRight;
    /**
     * Animaciones sangre.
     */
    public static Animation bloodAnimation, bloodAnimationRight;
    /**
     * Animaciones del golpeo del Arrow.
     */
    public static Animation enemyVoltHitAnimation, enemyVoltHitAnimationRight;
    /**
     * Animaciones del golpeo del poder de fuego, agua, rayo y tierra.
     */
    public static Animation voltHitAnimationRed, voltHitAnimationRightRed, voltHitAnimationBlue, voltHitAnimationRightBlue, voltHitAnimationYellow, voltHitAnimationRightYellow, voltHitAnimationBrown, voltHitAnimationRightBrown;
    /**
     * Animaciones del movimiento de los enemigos especiales.
     */
    public static Animation smokeAnimation;
    /**
     * Animaciones del golpeo del caballero.
     */
    public static Animation cutSwordAnimation, cutSwordAnimationRight;
    /**
     * Animaciones en loop para los records del caballero.
     */
    public static Animation knightJump, knightHit, knightVolt, knightDeath, voltHit, normalEnemyhit;

    //BACKGROUND
    /**
     * Texturas de los suelos del escenario.
     */
    public static TextureRegion floor, floorGround, floor1;
    /**
     * Texturas de los objetos del escenario.
     */
    public static TextureRegion Mountains, FarClouds, FarMountains, NearClouds, trees;
    /**
     * Texturas de los cielos del escenario.
     */
    public static TextureRegion sky, skyMoon;
    /**
     * Texturas de los objetos del 2ºescenario.
     */
    public static TextureRegion fabric1, fabric1no, fabric2, fabric3, fabric4, fabric5;

    //UI
    /**
     * Texturas de los objetos de la interfaz de usuario.
     */
    public static TextureRegion mana100, mana50, mana0, health5Texture, health4Texture, health3Texture, health2Texture, health1Texture;
    /**
     * Textura de la moneda de compra.
     */
    public static TextureRegion tCoin;
    /**
     * Textura del boton de pause.
     */
    public static TextureRegion pauseButton;
    /**
     * Animacion de la moneda que sube.
     */
    public static Animation coin;
    /**
     * Animacion del corazon que sube.
     */
    public static Animation hearthAnimation;

    /**
     * Constructor para AssetLoader sin parametros.
     */
    public AssetLoader() {
    }

    /**
     * Método que carga todas las animaciones.
     */
    public static void load() {
        background();
        knigth("Red");
        knigth("Blue");
        knigth("Yellow");
        knigth("Brown");
        powers();
        UI();

        normalEnemy();
        specialEnemyA();
        specialEnemyB();
        specialEnemyC();
        specialEnemyArrow();
    }

    /**
     * Método que define las animaciones del caballero.
     *
     * @param color dependiendo del string define las animaciones del caballero de un color o otro.
     */
    public static void knigth(String color) {
        texture = new Texture(Gdx.files.internal("knigth/Idle" + color + ".png"));
        TextureRegion[][] temp = TextureRegion.split(texture, 128, 64);
        textureRegions = new TextureRegion[8];
        int index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                textureRegions[index] = temp[i][j];
                index++;
            }
        }
        if (color.equals("Red")) {
            IdleAnimationRed = new Animation(0.1f, textureRegions);
            IdleAnimationRed.setPlayMode(Animation.PlayMode.LOOP);
        }
        if (color.equals("Blue")) {
            IdleAnimationBlue = new Animation(0.1f, textureRegions);
            IdleAnimationBlue.setPlayMode(Animation.PlayMode.LOOP);
        }
        if (color.equals("Yellow")) {
            IdleAnimationYellow = new Animation(0.1f, textureRegions);
            IdleAnimationYellow.setPlayMode(Animation.PlayMode.LOOP);
        }
        if (color.equals("Brown")) {
            IdleAnimationBrown = new Animation(0.1f, textureRegions);
            IdleAnimationBrown.setPlayMode(Animation.PlayMode.LOOP);
        }


        texture = new Texture(Gdx.files.internal("knigth/Idle" + color + ".png"));
        temp = TextureRegion.split(texture, 128, 64);
        textureRegions = new TextureRegion[8];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                textureRegions[index] = temp[i][j];
                textureRegions[index].flip(true, false);
                index++;
            }
        }
        if (color.equals("Red")) {
            IdleAnimationRightRed = new Animation(0.1f, textureRegions);
            IdleAnimationRightRed.setPlayMode(Animation.PlayMode.LOOP);
        }
        if (color.equals("Blue")) {
            IdleAnimationRightBlue = new Animation(0.1f, textureRegions);
            IdleAnimationRightBlue.setPlayMode(Animation.PlayMode.LOOP);
        }
        if (color.equals("Yellow")) {
            IdleAnimationRightYellow = new Animation(0.1f, textureRegions);
            IdleAnimationRightYellow.setPlayMode(Animation.PlayMode.LOOP);
        }
        if (color.equals("Brown")) {
            IdleAnimationRightBrown = new Animation(0.1f, textureRegions);
            IdleAnimationRightBrown.setPlayMode(Animation.PlayMode.LOOP);
        }


        texture = new Texture(Gdx.files.internal("knigth/crouch_idle" + color + ".png"));
        temp = TextureRegion.split(texture, 128, 64);
        textureRegions = new TextureRegion[8];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                textureRegions[index] = temp[i][j];
                index++;
            }
        }
        if (color.equals("Red")) {
            crouchAnimationRed = new Animation(0.1f, textureRegions);
            crouchAnimationRed.setPlayMode(Animation.PlayMode.LOOP);
        }
        if (color.equals("Blue")) {
            crouchAnimationBlue = new Animation(0.1f, textureRegions);
            crouchAnimationBlue.setPlayMode(Animation.PlayMode.LOOP);
        }
        if (color.equals("Yellow")) {
            crouchAnimationYellow = new Animation(0.1f, textureRegions);
            crouchAnimationYellow.setPlayMode(Animation.PlayMode.LOOP);
        }
        if (color.equals("Brown")) {
            crouchAnimationBrown = new Animation(0.1f, textureRegions);
            crouchAnimationBrown.setPlayMode(Animation.PlayMode.LOOP);
        }


        texture = new Texture(Gdx.files.internal("knigth/crouch_idle" + color + ".png"));
        temp = TextureRegion.split(texture, 128, 64);
        textureRegions = new TextureRegion[8];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                textureRegions[index] = temp[i][j];
                textureRegions[index].flip(true, false);
                index++;
            }
        }
        if (color.equals("Red")) {
            crouchAnimationRightRed = new Animation(0.1f, textureRegions);
            crouchAnimationRightRed.setPlayMode(Animation.PlayMode.LOOP);
        }
        if (color.equals("Blue")) {
            crouchAnimationRightBlue = new Animation(0.1f, textureRegions);
            crouchAnimationRightBlue.setPlayMode(Animation.PlayMode.LOOP);
        }
        if (color.equals("Yellow")) {
            crouchAnimationRightYellow = new Animation(0.1f, textureRegions);
            crouchAnimationRightYellow.setPlayMode(Animation.PlayMode.LOOP);
        }
        if (color.equals("Brown")) {
            crouchAnimationRightBrown = new Animation(0.1f, textureRegions);
            crouchAnimationRightBrown.setPlayMode(Animation.PlayMode.LOOP);
        }


        texture = new Texture(Gdx.files.internal("knigth/Jump" + color + ".png"));
        temp = TextureRegion.split(texture, 128, 64);
        textureRegions = new TextureRegion[8];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                textureRegions[index] = temp[i][j];
                index++;
            }
        }
        if (color.equals("Red")) {
            jumpAnimationRed = new Animation(0.2f, textureRegions);
            jumpAnimationRed.setPlayMode(Animation.PlayMode.NORMAL);
        }
        if (color.equals("Blue")) {
            jumpAnimationBlue = new Animation(0.2f, textureRegions);
            jumpAnimationBlue.setPlayMode(Animation.PlayMode.NORMAL);
        }
        if (color.equals("Yellow")) {
            jumpAnimationYellow = new Animation(0.2f, textureRegions);
            jumpAnimationYellow.setPlayMode(Animation.PlayMode.NORMAL);
        }
        if (color.equals("Brown")) {
            jumpAnimationBrown = new Animation(0.2f, textureRegions);
            jumpAnimationBrown.setPlayMode(Animation.PlayMode.NORMAL);
        }


        texture = new Texture(Gdx.files.internal("knigth/Jump" + color + ".png"));
        temp = TextureRegion.split(texture, 128, 64);
        textureRegions = new TextureRegion[8];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                textureRegions[index] = temp[i][j];
                textureRegions[index].flip(true, false);
                index++;
            }
        }
        if (color.equals("Red")) {
            jumpAnimationRightRed = new Animation(0.2f, textureRegions);
            jumpAnimationRightRed.setPlayMode(Animation.PlayMode.NORMAL);
        }
        if (color.equals("Blue")) {
            jumpAnimationRightBlue = new Animation(0.2f, textureRegions);
            jumpAnimationRightBlue.setPlayMode(Animation.PlayMode.NORMAL);
        }
        if (color.equals("Yellow")) {
            jumpAnimationRightYellow = new Animation(0.2f, textureRegions);
            jumpAnimationRightYellow.setPlayMode(Animation.PlayMode.NORMAL);
        }
        if (color.equals("Brown")) {
            jumpAnimationRightBrown = new Animation(0.2f, textureRegions);
            jumpAnimationRightBrown.setPlayMode(Animation.PlayMode.NORMAL);
        }


        texture = new Texture(Gdx.files.internal("knigth/Attacks" + color + ".png"));
        temp = TextureRegion.split(texture, 128, 64);
        textureRegions = new TextureRegion[3];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                if (j > 4) {
                    if (index < 3) {
                        textureRegions[index] = temp[i][j];
                        index++;
                    }
                }
            }
        }
        if (color.equals("Red")) {
            attackAnimationRed = new Animation(0.08f, textureRegions);
            attackAnimationRed.setPlayMode(Animation.PlayMode.NORMAL);
        }
        if (color.equals("Blue")) {
            attackAnimationBlue = new Animation(0.08f, textureRegions);
            attackAnimationBlue.setPlayMode(Animation.PlayMode.NORMAL);
        }
        if (color.equals("Yellow")) {
            attackAnimationYellow = new Animation(0.08f, textureRegions);
            attackAnimationYellow.setPlayMode(Animation.PlayMode.NORMAL);
        }
        if (color.equals("Brown")) {
            attackAnimationBrown = new Animation(0.08f, textureRegions);
            attackAnimationBrown.setPlayMode(Animation.PlayMode.NORMAL);
        }


        texture = new Texture(Gdx.files.internal("knigth/Attacks" + color + ".png"));
        temp = TextureRegion.split(texture, 128, 64);
        textureRegions = new TextureRegion[3];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                if (j > 4) {
                    if (index < 3) {
                        textureRegions[index] = temp[i][j];
                        textureRegions[index].flip(true, false);
                        index++;
                    }
                }
            }
        }
        if (color.equals("Red")) {
            attackAnimationRightRed = new Animation(0.08f, textureRegions);
            attackAnimationRightRed.setPlayMode(Animation.PlayMode.NORMAL);
        }
        if (color.equals("Blue")) {
            attackAnimationRightBlue = new Animation(0.08f, textureRegions);
            attackAnimationRightBlue.setPlayMode(Animation.PlayMode.NORMAL);
        }
        if (color.equals("Yellow")) {
            attackAnimationRightYellow = new Animation(0.08f, textureRegions);
            attackAnimationRightYellow.setPlayMode(Animation.PlayMode.NORMAL);
        }
        if (color.equals("Brown")) {
            attackAnimationRightBrown = new Animation(0.08f, textureRegions);
            attackAnimationRightBrown.setPlayMode(Animation.PlayMode.NORMAL);
        }


        texture = new Texture(Gdx.files.internal("knigth/attack_from_air" + color + ".png"));
        temp = TextureRegion.split(texture, 128, 64);
        textureRegions = new TextureRegion[3];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                if (index < 3) {
                    textureRegions[index] = temp[i][j];
                    index++;
                }
            }
        }
        if (color.equals("Red")) {
            fallAnimationRed = new Animation(0.2f, textureRegions);
            fallAnimationRed.setPlayMode(Animation.PlayMode.LOOP);
        }
        if (color.equals("Blue")) {
            fallAnimationBlue = new Animation(0.2f, textureRegions);
            fallAnimationBlue.setPlayMode(Animation.PlayMode.LOOP);
        }
        if (color.equals("Yellow")) {
            fallAnimationYellow = new Animation(0.2f, textureRegions);
            fallAnimationYellow.setPlayMode(Animation.PlayMode.LOOP);
        }
        if (color.equals("Brown")) {
            fallAnimationBrown = new Animation(0.2f, textureRegions);
            fallAnimationBrown.setPlayMode(Animation.PlayMode.LOOP);
        }


        texture = new Texture(Gdx.files.internal("knigth/attack_from_air" + color + ".png"));
        temp = TextureRegion.split(texture, 128, 64);
        textureRegions = new TextureRegion[3];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                if (index < 3) {
                    textureRegions[index] = temp[i][j];
                    textureRegions[index].flip(true, false);
                    index++;
                }
            }
        }
        if (color.equals("Red")) {
            fallAnimationRightRed = new Animation(0.2f, textureRegions);
            fallAnimationRightRed.setPlayMode(Animation.PlayMode.LOOP);
        }
        if (color.equals("Blue")) {
            fallAnimationRightBlue = new Animation(0.2f, textureRegions);
            fallAnimationRightBlue.setPlayMode(Animation.PlayMode.LOOP);
        }
        if (color.equals("Yellow")) {
            fallAnimationRightYellow = new Animation(0.2f, textureRegions);
            fallAnimationRightYellow.setPlayMode(Animation.PlayMode.LOOP);
        }
        if (color.equals("Brown")) {
            fallAnimationRightBrown = new Animation(0.2f, textureRegions);
            fallAnimationRightBrown.setPlayMode(Animation.PlayMode.LOOP);
        }


        texture = new Texture(Gdx.files.internal("knigth/Hanging" + color + ".png"));
        temp = TextureRegion.split(texture, 128, 64);
        textureRegions = new TextureRegion[8];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                textureRegions[index] = temp[i][j];
                index++;
            }
        }
        if (color.equals("Red")) {
            powerAnimationRed = new Animation(0.2f, textureRegions);
            powerAnimationRed.setPlayMode(Animation.PlayMode.NORMAL);
        }
        if (color.equals("Blue")) {
            powerAnimationBlue = new Animation(0.2f, textureRegions);
            powerAnimationBlue.setPlayMode(Animation.PlayMode.NORMAL);
        }
        if (color.equals("Yellow")) {
            powerAnimationYellow = new Animation(0.2f, textureRegions);
            powerAnimationYellow.setPlayMode(Animation.PlayMode.NORMAL);
        }
        if (color.equals("Brown")) {
            powerAnimationBrown = new Animation(0.2f, textureRegions);
            powerAnimationBrown.setPlayMode(Animation.PlayMode.NORMAL);
        }


        texture = new Texture(Gdx.files.internal("knigth/Hanging" + color + ".png"));
        temp = TextureRegion.split(texture, 128, 64);
        textureRegions = new TextureRegion[8];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                textureRegions[index] = temp[i][j];
                textureRegions[index].flip(true, false);
                index++;
            }
        }
        if (color.equals("Red")) {
            powerAnimationRightRed = new Animation(0.2f, textureRegions);
            powerAnimationRightRed.setPlayMode(Animation.PlayMode.NORMAL);
        }
        if (color.equals("Blue")) {
            powerAnimationRightBlue = new Animation(0.2f, textureRegions);
            powerAnimationRightBlue.setPlayMode(Animation.PlayMode.NORMAL);
        }
        if (color.equals("Yellow")) {
            powerAnimationRightYellow = new Animation(0.2f, textureRegions);
            powerAnimationRightYellow.setPlayMode(Animation.PlayMode.NORMAL);
        }
        if (color.equals("Brown")) {
            powerAnimationRightBrown = new Animation(0.2f, textureRegions);
            powerAnimationRightBrown.setPlayMode(Animation.PlayMode.NORMAL);
        }


        texture = new Texture(Gdx.files.internal("knigth/Hurt" + color + ".png"));
        temp = TextureRegion.split(texture, 128, 64);
        textureRegions = new TextureRegion[3];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                if (index < 3) {
                    textureRegions[index] = temp[i][j];
                    index++;
                }
            }
        }
        if (color.equals("Red")) {
            hurtAnimationRed = new Animation(0.3f, textureRegions);
            hurtAnimationRed.setPlayMode(Animation.PlayMode.NORMAL);
        }
        if (color.equals("Blue")) {
            hurtAnimationBlue = new Animation(0.3f, textureRegions);
            hurtAnimationBlue.setPlayMode(Animation.PlayMode.NORMAL);
        }
        if (color.equals("Yellow")) {
            hurtAnimationYellow = new Animation(0.3f, textureRegions);
            hurtAnimationYellow.setPlayMode(Animation.PlayMode.NORMAL);
        }
        if (color.equals("Brown")) {
            hurtAnimationBrown = new Animation(0.3f, textureRegions);
            hurtAnimationBrown.setPlayMode(Animation.PlayMode.NORMAL);
        }


        texture = new Texture(Gdx.files.internal("knigth/Hurt" + color + ".png"));
        temp = TextureRegion.split(texture, 128, 64);
        textureRegions = new TextureRegion[3];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                if (index < 3) {
                    textureRegions[index] = temp[i][j];
                    textureRegions[index].flip(true, false);
                    index++;
                }
            }
        }
        if (color.equals("Red")) {
            hurtAnimationRightRed = new Animation(0.3f, textureRegions);
            hurtAnimationRightRed.setPlayMode(Animation.PlayMode.NORMAL);
        }
        if (color.equals("Blue")) {
            hurtAnimationRightBlue = new Animation(0.3f, textureRegions);
            hurtAnimationRightBlue.setPlayMode(Animation.PlayMode.NORMAL);
        }
        if (color.equals("Yellow")) {
            hurtAnimationRightYellow = new Animation(0.3f, textureRegions);
            hurtAnimationRightYellow.setPlayMode(Animation.PlayMode.NORMAL);
        }
        if (color.equals("Brown")) {
            hurtAnimationRightBrown = new Animation(0.3f, textureRegions);
            hurtAnimationRightBrown.setPlayMode(Animation.PlayMode.NORMAL);
        }


        texture = new Texture(Gdx.files.internal("knigth/Death" + color + ".png"));
        temp = TextureRegion.split(texture, 128, 64);
        textureRegions = new TextureRegion[4];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                textureRegions[index] = temp[i][j];
                index++;
            }
        }
        if (color.equals("Red")) {
            deathAnimationRed = new Animation(0.3f, textureRegions);
            deathAnimationRed.setPlayMode(Animation.PlayMode.NORMAL);
        }
        if (color.equals("Blue")) {
            deathAnimationBlue = new Animation(0.3f, textureRegions);
            deathAnimationBlue.setPlayMode(Animation.PlayMode.NORMAL);
        }
        if (color.equals("Yellow")) {
            deathAnimationYellow = new Animation(0.3f, textureRegions);
            deathAnimationYellow.setPlayMode(Animation.PlayMode.NORMAL);
        }
        if (color.equals("Brown")) {
            deathAnimationBrown = new Animation(0.3f, textureRegions);
            deathAnimationBrown.setPlayMode(Animation.PlayMode.NORMAL);
        }


        texture = new Texture(Gdx.files.internal("knigth/Death" + color + ".png"));
        temp = TextureRegion.split(texture, 128, 64);
        textureRegions = new TextureRegion[4];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                textureRegions[index] = temp[i][j];
                textureRegions[index].flip(true, false);
                index++;
            }
        }
        if (color.equals("Red")) {
            deathAnimationRightRed = new Animation(0.3f, textureRegions);
            deathAnimationRightRed.setPlayMode(Animation.PlayMode.NORMAL);
        }
        if (color.equals("Blue")) {
            deathAnimationRightBlue = new Animation(0.3f, textureRegions);
            deathAnimationRightBlue.setPlayMode(Animation.PlayMode.NORMAL);
        }
        if (color.equals("Yellow")) {
            deathAnimationRightYellow = new Animation(0.3f, textureRegions);
            deathAnimationRightYellow.setPlayMode(Animation.PlayMode.NORMAL);
        }
        if (color.equals("Brown")) {
            deathAnimationRightBrown = new Animation(0.3f, textureRegions);
            deathAnimationRightBrown.setPlayMode(Animation.PlayMode.NORMAL);
        }


        texture = new Texture(Gdx.files.internal("hits/blood.png"));
        temp = TextureRegion.split(texture, 42, 38);
        textureRegions = new TextureRegion[7];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                textureRegions[index] = temp[i][j];
                index++;
            }
        }
        bloodAnimation = new Animation(0.1f, textureRegions);
        bloodAnimation.setPlayMode(Animation.PlayMode.NORMAL);

        texture = new Texture(Gdx.files.internal("hits/blood.png"));
        temp = TextureRegion.split(texture, 42, 38);
        textureRegions = new TextureRegion[7];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                textureRegions[index] = temp[i][j];
                textureRegions[index].flip(true, false);
                index++;
            }
        }
        bloodAnimationRight = new Animation(0.1f, textureRegions);
        bloodAnimationRight.setPlayMode(Animation.PlayMode.NORMAL);
    }

    /**
     * Método que define las animaciones del escenario.
     */
    public static void background() {
        floor = new TextureRegion(new Texture(Gdx.files.internal("background/trees.png")));
        floorGround = new TextureRegion(new Texture(Gdx.files.internal("background/floor.png")));
        floor1 = new TextureRegion(new Texture(Gdx.files.internal("background/floor1.png")));
        Mountains = new TextureRegion(new Texture(Gdx.files.internal("background/mountains.png")));
        FarMountains = new TextureRegion(new Texture(Gdx.files.internal("background/far-mountains.png")));
        FarClouds = new TextureRegion(new Texture(Gdx.files.internal("background/far-clouds.png")));
        NearClouds = new TextureRegion(new Texture(Gdx.files.internal("background/near-clouds.png")));
        trees = new TextureRegion(new Texture(Gdx.files.internal("background/trees.png")));
        sky = new TextureRegion(new Texture(Gdx.files.internal("background/sky.png")));
        skyMoon = new TextureRegion(new Texture(Gdx.files.internal("background/sky-moon.png")));

        fabric1 = new TextureRegion(new Texture(Gdx.files.internal("background/fabric1.png")));
        fabric1no = new TextureRegion(new Texture(Gdx.files.internal("background/fabric1no.png")));
        fabric2 = new TextureRegion(new Texture(Gdx.files.internal("background/fabric2.png")));
        fabric3 = new TextureRegion(new Texture(Gdx.files.internal("background/fabric3.png")));
        fabric4 = new TextureRegion(new Texture(Gdx.files.internal("background/fabric4.png")));
        fabric5 = new TextureRegion(new Texture(Gdx.files.internal("background/fabric5.png")));
    }

    /**
     * Método que define las animaciones del enemigo normal.
     */
    public static void normalEnemy() {
        TextureRegion[] aux = new TextureRegion[6];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = new TextureRegion(new Texture(Gdx.files.internal("enemy/normal/walk-" + (i + 1) + ".png")));
        }
        normalEnemyRunAnimation = new Animation(0.15f, aux);
        normalEnemyRunAnimation.setPlayMode(Animation.PlayMode.LOOP);

        aux = new TextureRegion[6];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = new TextureRegion(new Texture(Gdx.files.internal("enemy/normal/walk-" + (i + 1) + ".png")));
            aux[i].flip(true, false);
        }
        normalEnemyRunAnimationRigth = new Animation(0.15f, aux);
        normalEnemyRunAnimationRigth.setPlayMode(Animation.PlayMode.LOOP);

        aux = new TextureRegion[8];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = new TextureRegion(new Texture(Gdx.files.internal("enemy/normal/attack-A" + (i + 1) + ".png")));
        }
        normalEnemyHitAnimation = new Animation(0.13f, aux);
        normalEnemyHitAnimation.setPlayMode(Animation.PlayMode.NORMAL);

        aux = new TextureRegion[8];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = new TextureRegion(new Texture(Gdx.files.internal("enemy/normal/attack-A" + (i + 1) + ".png")));
            aux[i].flip(true, false);
        }
        normalEnemyHitAnimationRigth = new Animation(0.13f, aux);
        normalEnemyHitAnimationRigth.setPlayMode(Animation.PlayMode.NORMAL);

        aux = new TextureRegion[4];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = new TextureRegion(new Texture(Gdx.files.internal("enemy/normal/dead-" + (i + 1) + ".png")));
        }
        normalEnemyDeathAnimation = new Animation(0.18f, aux);
        normalEnemyDeathAnimation.setPlayMode(Animation.PlayMode.NORMAL);

        aux = new TextureRegion[4];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = new TextureRegion(new Texture(Gdx.files.internal("enemy/normal/dead-" + (i + 1) + ".png")));
            aux[i].flip(true, false);
        }
        normalEnemyDeathAnimationRight = new Animation(0.18f, aux);
        normalEnemyDeathAnimationRight.setPlayMode(Animation.PlayMode.NORMAL);

        aux = new TextureRegion[3];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = new TextureRegion(new Texture(Gdx.files.internal("enemy/normal/hit-" + (i + 1) + ".png")));
        }
        normalEnemyDamageAnimation = new Animation(0.3f, aux);
        normalEnemyDamageAnimation.setPlayMode(Animation.PlayMode.LOOP);

        aux = new TextureRegion[3];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = new TextureRegion(new Texture(Gdx.files.internal("enemy/normal/hit-" + (i + 1) + ".png")));
            aux[i].flip(true, false);
        }
        normalEnemyDamageAnimationRight = new Animation(0.3f, aux);
        normalEnemyDamageAnimationRight.setPlayMode(Animation.PlayMode.LOOP);
    }

    /**
     * Método que define las animaciones del enemigo especial C (volador).
     */
    public static void specialEnemyC() {
        texture = new Texture(Gdx.files.internal("enemy/especialC/idle2.png"));
        TextureRegion[][] temp = TextureRegion.split(texture, 100, 100);
        textureRegions = new TextureRegion[8];
        int index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                textureRegions[index] = temp[i][j];
                index++;
            }
        }
        specialEnemyCRunAnimation = new Animation(0.1f, textureRegions);
        specialEnemyCRunAnimation.setPlayMode(Animation.PlayMode.LOOP);

        texture = new Texture(Gdx.files.internal("enemy/especialC/idle2.png"));
        temp = TextureRegion.split(texture, 100, 100);
        textureRegions = new TextureRegion[8];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                textureRegions[index] = temp[i][j];
                textureRegions[index].flip(true, false);
                index++;
            }
        }
        specialEnemyCRunAnimationRight = new Animation(0.1f, textureRegions);
        specialEnemyCRunAnimationRight.setPlayMode(Animation.PlayMode.LOOP);

        texture = new Texture(Gdx.files.internal("enemy/especialC/idle2Up.png"));
        temp = TextureRegion.split(texture, 100, 100);
        textureRegions = new TextureRegion[8];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                textureRegions[index] = temp[i][j];
                index++;
            }
        }
        specialEnemyCRunAnimationUp = new Animation(0.1f, textureRegions);
        specialEnemyCRunAnimationUp.setPlayMode(Animation.PlayMode.LOOP);

        texture = new Texture(Gdx.files.internal("enemy/especialC/death.png"));
        temp = TextureRegion.split(texture, 100, 100);
        textureRegions = new TextureRegion[20];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                textureRegions[index] = temp[i][j];
                index++;
            }
        }
        specialEnemyCDeathAnimation = new Animation(0.08f, textureRegions);
        specialEnemyCDeathAnimation.setPlayMode(Animation.PlayMode.NORMAL);

        texture = new Texture(Gdx.files.internal("enemy/especialC/death.png"));
        temp = TextureRegion.split(texture, 100, 100);
        textureRegions = new TextureRegion[20];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                textureRegions[index] = temp[i][j];
                textureRegions[index].flip(true, false);
                index++;
            }
        }
        specialEnemyCDeathAnimationRight = new Animation(0.08f, textureRegions);
        specialEnemyCDeathAnimationRight.setPlayMode(Animation.PlayMode.NORMAL);

        texture = new Texture(Gdx.files.internal("enemy/especialC/attacking.png"));
        temp = TextureRegion.split(texture, 100, 100);
        textureRegions = new TextureRegion[7];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                if (index < 7) {
                    textureRegions[index] = temp[i][j];
                    index++;
                }
            }
        }
        specialEnemyCHitAnimation = new Animation(0.1f, textureRegions);
        specialEnemyCHitAnimation.setPlayMode(Animation.PlayMode.NORMAL);

        texture = new Texture(Gdx.files.internal("enemy/especialC/attacking.png"));
        temp = TextureRegion.split(texture, 100, 100);
        textureRegions = new TextureRegion[7];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                if (index < 7) {
                    textureRegions[index] = temp[i][j];
                    textureRegions[index].flip(true, false);
                    index++;
                }
            }
        }
        specialEnemyCHitAnimationRight = new Animation(0.1f, textureRegions);
        specialEnemyCHitAnimationRight.setPlayMode(Animation.PlayMode.NORMAL);

        texture = new Texture(Gdx.files.internal("enemy/especialC/attacking.png"));
        temp = TextureRegion.split(texture, 100, 100);
        textureRegions = new TextureRegion[7];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                if (index < 7) {
                    textureRegions[index] = temp[i][j];
                    index++;
                }
            }
        }
        specialEnemyCHitAnimation = new Animation(0.1f, textureRegions);
        specialEnemyCHitAnimation.setPlayMode(Animation.PlayMode.NORMAL);

        texture = new Texture(Gdx.files.internal("enemy/especialC/attacking.png"));
        temp = TextureRegion.split(texture, 100, 100);
        textureRegions = new TextureRegion[7];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                if (index < 7) {
                    textureRegions[index] = temp[i][j];
                    textureRegions[index].flip(true, false);
                    index++;
                }
            }
        }
        specialEnemyCHitAnimationRight = new Animation(0.1f, textureRegions);
        specialEnemyCHitAnimationRight.setPlayMode(Animation.PlayMode.NORMAL);

    }

    /**
     * Método que define las animaciones del enemigo especial A (Cambia de lado).
     */
    public static void specialEnemyA() {
        TextureRegion[] aux;
        aux = new TextureRegion[6];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = new TextureRegion(new Texture(Gdx.files.internal("enemy/especialA/walk-" + (i + 1) + ".png")));
        }
        specialEnemyARunAnimation = new Animation(0.1f, aux);
        specialEnemyARunAnimation.setPlayMode(Animation.PlayMode.LOOP);

        aux = new TextureRegion[6];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = new TextureRegion(new Texture(Gdx.files.internal("enemy/especialA/walk-" + (i + 1) + ".png")));
            aux[i].flip(true, false);
        }
        specialEnemyARunAnimationRight = new Animation(0.1f, aux);
        specialEnemyARunAnimationRight.setPlayMode(Animation.PlayMode.LOOP);

        aux = new TextureRegion[6];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = new TextureRegion(new Texture(Gdx.files.internal("enemy/especialA/attack-A" + (i + 1) + ".png")));
        }
        specialEnemyAAttackAnimation = new Animation(0.18f, aux);
        specialEnemyAAttackAnimation.setPlayMode(Animation.PlayMode.NORMAL);

        aux = new TextureRegion[6];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = new TextureRegion(new Texture(Gdx.files.internal("enemy/especialA/attack-A" + (i + 1) + ".png")));
            aux[i].flip(true, false);
        }
        specialEnemyAAttackAnimationRight = new Animation(0.18f, aux);
        specialEnemyAAttackAnimationRight.setPlayMode(Animation.PlayMode.NORMAL);

        aux = new TextureRegion[4];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = new TextureRegion(new Texture(Gdx.files.internal("enemy/especialA/dead-" + (i + 1) + ".png")));
        }
        specialEnemyADeathAnimation = new Animation(0.18f, aux);
        specialEnemyADeathAnimation.setPlayMode(Animation.PlayMode.NORMAL);

        aux = new TextureRegion[4];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = new TextureRegion(new Texture(Gdx.files.internal("enemy/especialA/dead-" + (i + 1) + ".png")));
            aux[i].flip(true, false);
        }
        specialEnemyADeathAnimationRight = new Animation(0.18f, aux);
        specialEnemyADeathAnimationRight.setPlayMode(Animation.PlayMode.NORMAL);
    }

    /**
     * Método que define las animaciones del enemigo especial B (Se mueve hacia atras).
     */
    public static void specialEnemyB() {
        TextureRegion[] aux;
        aux = new TextureRegion[6];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = new TextureRegion(new Texture(Gdx.files.internal("enemy/especialB/walk-" + (i + 1) + ".png")));
        }
        specialEnemyBRunAnimation = new Animation(0.1f, aux);
        specialEnemyBRunAnimation.setPlayMode(Animation.PlayMode.LOOP);

        aux = new TextureRegion[6];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = new TextureRegion(new Texture(Gdx.files.internal("enemy/especialB/walk-" + (i + 1) + ".png")));
            aux[i].flip(true, false);
        }
        specialEnemyBRunAnimationRight = new Animation(0.1f, aux);
        specialEnemyBRunAnimationRight.setPlayMode(Animation.PlayMode.LOOP);

        aux = new TextureRegion[6];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = new TextureRegion(new Texture(Gdx.files.internal("enemy/especialB/attack-A" + (i + 1) + ".png")));
        }
        specialEnemyBAttackAnimation = new Animation(0.18f, aux);
        specialEnemyBAttackAnimation.setPlayMode(Animation.PlayMode.NORMAL);

        aux = new TextureRegion[6];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = new TextureRegion(new Texture(Gdx.files.internal("enemy/especialB/attack-A" + (i + 1) + ".png")));
            aux[i].flip(true, false);
        }
        specialEnemyBAttackAnimationRight = new Animation(0.18f, aux);
        specialEnemyBAttackAnimationRight.setPlayMode(Animation.PlayMode.NORMAL);

        aux = new TextureRegion[4];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = new TextureRegion(new Texture(Gdx.files.internal("enemy/especialB/dead-" + (i + 1) + ".png")));
        }
        specialEnemyBDeathAnimation = new Animation(0.18f, aux);
        specialEnemyBDeathAnimation.setPlayMode(Animation.PlayMode.NORMAL);

        aux = new TextureRegion[4];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = new TextureRegion(new Texture(Gdx.files.internal("enemy/especialB/dead-" + (i + 1) + ".png")));
            aux[i].flip(true, false);
        }
        specialEnemyBDeathAnimationRight = new Animation(0.18f, aux);
        specialEnemyBDeathAnimationRight.setPlayMode(Animation.PlayMode.NORMAL);
    }

    /**
     * Método que define las animaciones del enemigo especial Arrow (Lanza Arrow).
     */
    public static void specialEnemyArrow() {
        TextureRegion[] aux;
        aux = new TextureRegion[4];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = new TextureRegion(new Texture(Gdx.files.internal("enemy/especialArrow/arrow/bolt" + (i + 1) + ".png")));
        }
        specialEnemyArrowArrowAnimation = new Animation(0.1f, aux);
        specialEnemyArrowArrowAnimation.setPlayMode(Animation.PlayMode.LOOP);

        aux = new TextureRegion[4];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = new TextureRegion(new Texture(Gdx.files.internal("enemy/especialArrow/arrow/bolt" + (i + 1) + ".png")));
            aux[i].flip(true, false);
        }
        specialEnemyArrowArrowAnimationRight = new Animation(0.1f, aux);
        specialEnemyArrowArrowAnimationRight.setPlayMode(Animation.PlayMode.LOOP);

        aux = new TextureRegion[12];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = new TextureRegion(new Texture(Gdx.files.internal("enemy/especialArrow/run-" + (i + 1) + ".png")));
        }
        specialEnemyArrowRunAnimation = new Animation(0.1f, aux);
        specialEnemyArrowRunAnimation.setPlayMode(Animation.PlayMode.LOOP);

        aux = new TextureRegion[12];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = new TextureRegion(new Texture(Gdx.files.internal("enemy/especialArrow/run-" + (i + 1) + ".png")));
            aux[i].flip(true, false);
        }
        specialEnemyArrowRunAnimationRight = new Animation(0.1f, aux);
        specialEnemyArrowRunAnimationRight.setPlayMode(Animation.PlayMode.LOOP);

        aux = new TextureRegion[6];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = new TextureRegion(new Texture(Gdx.files.internal("enemy/especialArrow/attack-A" + (i + 1) + ".png")));
        }
        specialEnemyArrowAttackAnimation = new Animation(0.17f, aux);
        specialEnemyArrowAttackAnimation.setPlayMode(Animation.PlayMode.NORMAL);

        aux = new TextureRegion[6];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = new TextureRegion(new Texture(Gdx.files.internal("enemy/especialArrow/attack-A" + (i + 1) + ".png")));
            aux[i].flip(true, false);
        }
        specialEnemyArrowAttackAnimationRight = new Animation(0.17f, aux);
        specialEnemyArrowAttackAnimationRight.setPlayMode(Animation.PlayMode.NORMAL);

        aux = new TextureRegion[4];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = new TextureRegion(new Texture(Gdx.files.internal("enemy/especialArrow/dead-" + (i + 1) + ".png")));
        }
        specialEnemyArrowDeathAnimation = new Animation(0.18f, aux);
        specialEnemyArrowDeathAnimation.setPlayMode(Animation.PlayMode.NORMAL);

        aux = new TextureRegion[4];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = new TextureRegion(new Texture(Gdx.files.internal("enemy/especialArrow/dead-" + (i + 1) + ".png")));
            aux[i].flip(true, false);
        }
        specialEnemyArrowDeathAnimationRight = new Animation(0.18f, aux);
        specialEnemyArrowDeathAnimationRight.setPlayMode(Animation.PlayMode.NORMAL);

        aux = new TextureRegion[2];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = new TextureRegion(new Texture(Gdx.files.internal("enemy/especialArrow/idle-" + (i + 1) + ".png")));
        }
        specialEnemyArrowIdleAnimation = new Animation(0.18f, aux);
        specialEnemyArrowIdleAnimation.setPlayMode(Animation.PlayMode.LOOP);

        aux = new TextureRegion[2];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = new TextureRegion(new Texture(Gdx.files.internal("enemy/especialArrow/idle-" + (i + 1) + ".png")));
            aux[i].flip(true, false);
        }
        specialEnemyArrowIdleAnimationRight = new Animation(0.18f, aux);
        specialEnemyArrowIdleAnimationRight.setPlayMode(Animation.PlayMode.LOOP);
    }

    /**
     * Método que define las animaciones de los efectos y poderes.
     */
    public static void powers() {
        texture = new Texture(Gdx.files.internal("knigth/powers/Firebolt.png"));
        TextureRegion[][] temp = TextureRegion.split(texture, 48, 48);
        textureRegions = new TextureRegion[4];
        int index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                if (index < 4) {
                    textureRegions[index] = temp[i][j];
                    index++;
                }
            }
        }
        fireVoltAnimation = new Animation(0.1f, textureRegions);
        fireVoltAnimation.setPlayMode(Animation.PlayMode.LOOP);

        texture = new Texture(Gdx.files.internal("knigth/powers/Firebolt.png"));
        temp = TextureRegion.split(texture, 48, 48);
        textureRegions = new TextureRegion[4];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                if (index < 4) {
                    textureRegions[index] = temp[i][j];
                    textureRegions[index].flip(true, false);
                    index++;
                }
            }
        }
        fireVoltAnimationRight = new Animation(0.1f, textureRegions);
        fireVoltAnimationRight.setPlayMode(Animation.PlayMode.LOOP);

        TextureRegion[] aux = new TextureRegion[5];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = new TextureRegion(new Texture(Gdx.files.internal("hits/hits-3-" + (i + 1) + ".png")));
        }
        enemyVoltHitAnimation = new Animation(0.15f, aux);
        enemyVoltHitAnimation.setPlayMode(Animation.PlayMode.NORMAL);

        aux = new TextureRegion[5];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = new TextureRegion(new Texture(Gdx.files.internal("hits/hits-3-" + (i + 1) + ".png")));
            aux[i].flip(true, false);
        }
        enemyVoltHitAnimationRight = new Animation(0.15f, aux);
        enemyVoltHitAnimationRight.setPlayMode(Animation.PlayMode.NORMAL);

        texture = new Texture(Gdx.files.internal("knigth/powers/Firebolt.png"));
        temp = TextureRegion.split(texture, 48, 48);
        textureRegions = new TextureRegion[6];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                if (j > 4) {
                    textureRegions[index] = temp[i][j];
                    index++;
                }
            }
        }
        voltHitAnimationRed = new Animation(0.15f, textureRegions);
        voltHitAnimationRed.setPlayMode(Animation.PlayMode.NORMAL);

        texture = new Texture(Gdx.files.internal("knigth/powers/Firebolt.png"));
        temp = TextureRegion.split(texture, 48, 48);
        textureRegions = new TextureRegion[6];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                if (j > 4) {
                    textureRegions[index] = temp[i][j];
                    textureRegions[index].flip(true, false);
                    index++;
                }
            }
        }
        voltHitAnimationRightRed = new Animation(0.15f, textureRegions);
        voltHitAnimationRightRed.setPlayMode(Animation.PlayMode.NORMAL);

        texture = new Texture(Gdx.files.internal("hits/smoke.png"));
        temp = TextureRegion.split(texture, 32, 32);
        textureRegions = new TextureRegion[7];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                textureRegions[index] = temp[i][j];
                index++;
            }
        }
        smokeAnimation = new Animation(0.1f, textureRegions);
        smokeAnimation.setPlayMode(Animation.PlayMode.NORMAL);

        aux = new TextureRegion[5];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = new TextureRegion(new Texture(Gdx.files.internal("hits/sword" + (i + 1) + ".png")));
        }
        cutSwordAnimation = new Animation(0.05f, aux);
        cutSwordAnimation.setPlayMode(Animation.PlayMode.NORMAL);

        aux = new TextureRegion[5];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = new TextureRegion(new Texture(Gdx.files.internal("hits/sword" + (i + 1) + ".png")));
            aux[i].flip(true, false);
        }
        cutSwordAnimationRight = new Animation(0.05f, aux);
        cutSwordAnimationRight.setPlayMode(Animation.PlayMode.NORMAL);

        texture = new Texture(Gdx.files.internal("hits/waterHit.png"));
        temp = TextureRegion.split(texture, 64, 64);
        textureRegions = new TextureRegion[16];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                textureRegions[index] = temp[i][j];
                index++;
            }
        }
        voltHitAnimationBlue = new Animation(0.05f, textureRegions);
        voltHitAnimationBlue.setPlayMode(Animation.PlayMode.NORMAL);

        texture = new Texture(Gdx.files.internal("hits/waterHit.png"));
        temp = TextureRegion.split(texture, 64, 64);
        textureRegions = new TextureRegion[16];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                textureRegions[index] = temp[i][j];
                textureRegions[index].flip(true, false);
                index++;
            }
        }
        voltHitAnimationRightBlue = new Animation(0.05f, textureRegions);
        voltHitAnimationRightBlue.setPlayMode(Animation.PlayMode.NORMAL);

        texture = new Texture(Gdx.files.internal("hits/thunderhit.png"));
        temp = TextureRegion.split(texture, 32, 32);
        textureRegions = new TextureRegion[6];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                textureRegions[index] = temp[i][j];
                index++;
            }
        }
        voltHitAnimationYellow = new Animation(0.15f, textureRegions);
        voltHitAnimationYellow.setPlayMode(Animation.PlayMode.NORMAL);

        texture = new Texture(Gdx.files.internal("hits/thunderhit.png"));
        temp = TextureRegion.split(texture, 32, 32);
        textureRegions = new TextureRegion[6];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                textureRegions[index] = temp[i][j];
                textureRegions[index].flip(true, false);
                index++;
            }
        }
        voltHitAnimationRightYellow = new Animation(0.15f, textureRegions);
        voltHitAnimationRightYellow.setPlayMode(Animation.PlayMode.NORMAL);

        texture = new Texture(Gdx.files.internal("hits/dirtHit.png"));
        temp = TextureRegion.split(texture, 48, 48);
        textureRegions = new TextureRegion[6];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                if (i > 0) {
                    textureRegions[index] = temp[i][j];
                    index++;
                }
            }
        }
        voltHitAnimationBrown = new Animation(0.15f, textureRegions);
        voltHitAnimationBrown.setPlayMode(Animation.PlayMode.NORMAL);

        texture = new Texture(Gdx.files.internal("hits/dirtHit.png"));
        temp = TextureRegion.split(texture, 48, 48);
        textureRegions = new TextureRegion[6];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                if (i > 0) {
                    textureRegions[index] = temp[i][j];
                    textureRegions[index].flip(true, false);
                    index++;
                }
            }
        }
        voltHitAnimationRightBrown = new Animation(0.15f, textureRegions);
        voltHitAnimationRightBrown.setPlayMode(Animation.PlayMode.NORMAL);

        texture = new Texture(Gdx.files.internal("knigth/powers/WaterBall.png"));
        temp = TextureRegion.split(texture, 64, 64);
        textureRegions = new TextureRegion[16];
        index = 0;
        int cont = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                if (cont > 4) {
                    if (index < 16) {
                        textureRegions[index] = temp[i][j];
                        index++;
                    }
                }
                cont++;
            }
        }
        iceVoltAnimation = new Animation(0.1f, textureRegions);
        iceVoltAnimation.setPlayMode(Animation.PlayMode.LOOP);

        texture = new Texture(Gdx.files.internal("knigth/powers/WaterBall.png"));
        temp = TextureRegion.split(texture, 64, 64);
        textureRegions = new TextureRegion[16];
        index = 0;
        cont = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                if (cont > 4) {
                    if (index < 16) {
                        textureRegions[index] = temp[i][j];
                        textureRegions[index].flip(true, false);
                        index++;
                    }
                }
                cont++;
            }
        }
        iceVoltAnimationRight = new Animation(0.1f, textureRegions);
        iceVoltAnimationRight.setPlayMode(Animation.PlayMode.LOOP);

        texture = new Texture(Gdx.files.internal("knigth/powers/thunderVolt.png"));
        temp = TextureRegion.split(texture, 32, 32);
        textureRegions = new TextureRegion[5];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                textureRegions[index] = temp[i][j];
                index++;
            }
        }
        thunderVoltAnimation = new Animation(0.1f, textureRegions);
        thunderVoltAnimation.setPlayMode(Animation.PlayMode.LOOP);

        texture = new Texture(Gdx.files.internal("knigth/powers/thunderVolt.png"));
        temp = TextureRegion.split(texture, 32, 32);
        textureRegions = new TextureRegion[5];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                textureRegions[index] = temp[i][j];
                textureRegions[index].flip(true, false);
                index++;
            }
        }
        thunderVoltAnimationRight = new Animation(0.1f, textureRegions);
        thunderVoltAnimationRight.setPlayMode(Animation.PlayMode.LOOP);

        texture = new Texture(Gdx.files.internal("knigth/powers/dirtVolt.png"));
        temp = TextureRegion.split(texture, 48, 32);
        textureRegions = new TextureRegion[6];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                if (index < 6) {
                    textureRegions[index] = temp[i][j];
                    index++;
                }
            }
        }
        dirtVoltAnimation = new Animation(0.1f, textureRegions);
        dirtVoltAnimation.setPlayMode(Animation.PlayMode.LOOP);

        texture = new Texture(Gdx.files.internal("knigth/powers/dirtVolt.png"));
        temp = TextureRegion.split(texture, 48, 32);
        textureRegions = new TextureRegion[6];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                if (index < 6) {
                    textureRegions[index] = temp[i][j];
                    textureRegions[index].flip(true, false);
                    index++;
                }
            }
        }
        dirtVoltAnimationRight = new Animation(0.1f, textureRegions);
        dirtVoltAnimationRight.setPlayMode(Animation.PlayMode.LOOP);

    }

    /**
     * Método que define las animaciones y texturas de la interfaz de usuario.
     */
    public static void UI() {
        texture = new Texture(Gdx.files.internal("ui/heart.png"));
        TextureRegion[][] temp = TextureRegion.split(texture, 17, 17);
        textureRegions = new TextureRegion[5];
        int index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                textureRegions[index] = temp[i][j];
                index++;
            }
        }

        health5Texture = textureRegions[0];
        health4Texture = textureRegions[1];
        health3Texture = textureRegions[2];
        health2Texture = textureRegions[3];
        health1Texture = textureRegions[4];

        mana100 = new TextureRegion(new Texture(Gdx.files.internal("ui/maxMana.png")));
        mana50 = new TextureRegion(new Texture(Gdx.files.internal("ui/halfMana.png")));
        mana0 = new TextureRegion(new Texture(Gdx.files.internal("ui/emptyMana.png")));

        texture = new Texture(Gdx.files.internal("ui/coin.png"));
        temp = TextureRegion.split(texture, 256, 256);
        textureRegions = new TextureRegion[5];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                if (index < 5) {
                    textureRegions[index] = temp[i][j];
                    index++;
                }
            }
        }
        tCoin = textureRegions[0];
        coin = new Animation(0.15f, textureRegions);
        coin.setPlayMode(Animation.PlayMode.LOOP);

        texture = new Texture(Gdx.files.internal("hits/waterHit.png"));
        temp = TextureRegion.split(texture, 64, 64);
        textureRegions = new TextureRegion[16];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                textureRegions[index] = temp[i][j];
                index++;
            }
        }
        voltHit = new Animation(0.1f, textureRegions);
        voltHit.setPlayMode(Animation.PlayMode.LOOP);

        texture = new Texture(Gdx.files.internal("knigth/JumpRed.png"));
        temp = TextureRegion.split(texture, 128, 64);
        textureRegions = new TextureRegion[8];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                textureRegions[index] = temp[i][j];
                index++;
            }
        }
        knightJump = new Animation(0.15f, textureRegions);
        knightJump.setPlayMode(Animation.PlayMode.LOOP);

        texture = new Texture(Gdx.files.internal("knigth/HangingRed.png"));
        temp = TextureRegion.split(texture, 128, 64);
        textureRegions = new TextureRegion[8];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                textureRegions[index] = temp[i][j];
                index++;
            }
        }
        knightVolt = new Animation(0.1f, textureRegions);
        knightVolt.setPlayMode(Animation.PlayMode.LOOP);

        texture = new Texture(Gdx.files.internal("knigth/HurtRed.png"));
        temp = TextureRegion.split(texture, 128, 64);
        textureRegions = new TextureRegion[3];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                if (index < 3) {
                    textureRegions[index] = temp[i][j];
                    index++;
                }
            }
        }
        knightHit = new Animation(0.2f, textureRegions);
        knightHit.setPlayMode(Animation.PlayMode.LOOP);

        texture = new Texture(Gdx.files.internal("knigth/DeathRed.png"));
        temp = TextureRegion.split(texture, 128, 64);
        textureRegions = new TextureRegion[4];
        index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                textureRegions[index] = temp[i][j];
                index++;
            }
        }
        knightDeath = new Animation(0.2f, textureRegions);
        knightDeath.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        TextureRegion[] aux = new TextureRegion[3];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = new TextureRegion(new Texture(Gdx.files.internal("enemy/normal/hit-" + (i + 1) + ".png")));
        }
        normalEnemyhit = new Animation(0.3f, aux);
        normalEnemyhit.setPlayMode(Animation.PlayMode.LOOP);

        aux = new TextureRegion[4];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = new TextureRegion(new Texture(Gdx.files.internal("ui/hearth" + (i + 1) + ".png")));
        }
        hearthAnimation = new Animation(0.3f, aux);
        hearthAnimation.setPlayMode(Animation.PlayMode.LOOP);

        pauseButton = new TextureRegion(new Texture(Gdx.files.internal("ui/pause.png")));
    }

    /**
     * Método que libera recursos de las texturas.
     */
    public static void dispose() {
        texture.dispose();
    }
}
