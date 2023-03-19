package com.davidcarrion.game.Helper;

import com.badlogic.gdx.Gdx;
import com.davidcarrion.game.Objects.Background;
import com.davidcarrion.game.Objects.Floor;

/**
 * Esta clase gestiona todos los objetos Scrollables del juego
 *
 * @author David Carrion Macenlle
 * @version 14/02/2023
 */
public class ScrollHandler {
    /**
     * Objetos floor del primer escenario.
     */
    private Floor frontfloor, backFloor;
    /**
     * Objetos del primer escenario.
     */
    private Background frontSky, frontMountains, frontFarClouds, frontFarMountains, frontNearClouds, frontTrees, backSky, backMountains, backFarClouds, backFarMountains, backNearClouds, backTrees;
    /**
     * Objetos floor del segundo escenario.
     */
    private Floor frontFloorFabric, backFloorFabric;
    /**
     * Objetos del segundo escenario.
     */
    private Background frontFabric1, frontFabric2, frontFabric3, frontFabric4, frontFabric5, backFabric1, backFabric2, backFabric3, backFabric4, backFabric5;
    /**
     * Constante que indica la velocidad de movimiento de los objetos.
     */
    public final float SCROLL_SPEED = -20 * Constant.density;

    /**
     * Constructor para ScrollHandler sin parametros.
     */
    public ScrollHandler() {
        frontfloor = new Floor(0, -Gdx.graphics.getHeight() / 4, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), SCROLL_SPEED * -1);
        backFloor = new Floor(-Gdx.graphics.getWidth(), -Gdx.graphics.getHeight() / 4, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), SCROLL_SPEED * -1);


        frontFarClouds = new Background(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), SCROLL_SPEED * 5);
        frontNearClouds = new Background(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), SCROLL_SPEED * 4);
        frontFarMountains = new Background(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), SCROLL_SPEED * 3);
        frontMountains = new Background(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), SCROLL_SPEED * 2);
        frontTrees = new Background(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), SCROLL_SPEED);
        frontSky = new Background(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), SCROLL_SPEED / 2);

        backFarClouds = new Background(Gdx.graphics.getWidth(), 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), SCROLL_SPEED * 5);
        backNearClouds = new Background(Gdx.graphics.getWidth(), 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), SCROLL_SPEED * 4);
        backFarMountains = new Background(Gdx.graphics.getWidth(), 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), SCROLL_SPEED * 3);
        backMountains = new Background(Gdx.graphics.getWidth(), 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), SCROLL_SPEED * 2);
        backTrees = new Background(Gdx.graphics.getWidth(), 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), SCROLL_SPEED);
        backSky = new Background(Gdx.graphics.getWidth(), 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), SCROLL_SPEED / 2);

        frontFloorFabric = new Floor(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), SCROLL_SPEED * -1);
        backFloorFabric = new Floor(-Gdx.graphics.getWidth(), 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), SCROLL_SPEED * -1);

        frontFabric1 = new Background(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), SCROLL_SPEED);
        frontFabric2 = new Background(0, Gdx.graphics.getHeight() / 8, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), SCROLL_SPEED * 1.5f);
        frontFabric3 = new Background(0, Gdx.graphics.getHeight() / 8, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), SCROLL_SPEED * 2);
        frontFabric4 = new Background(0, Gdx.graphics.getHeight() / 8, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), SCROLL_SPEED * 2.5f);
        frontFabric5 = new Background(0, Gdx.graphics.getHeight() / 8, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), SCROLL_SPEED * 3);

        backFabric1 = new Background(Gdx.graphics.getWidth(), 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), SCROLL_SPEED);
        backFabric2 = new Background(Gdx.graphics.getWidth(), Gdx.graphics.getHeight() / 8, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), SCROLL_SPEED * 1.5f);
        backFabric3 = new Background(Gdx.graphics.getWidth(), Gdx.graphics.getHeight() / 8, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), SCROLL_SPEED * 2);
        backFabric4 = new Background(Gdx.graphics.getWidth(), Gdx.graphics.getHeight() / 8, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), SCROLL_SPEED * 2.5f);
        backFabric5 = new Background(Gdx.graphics.getWidth(), Gdx.graphics.getHeight() / 8, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), SCROLL_SPEED * 3);
    }

    /**
     * Método que gestiona los cambios de las variables y las actualiza.
     *
     * @param delta delta time.
     */
    public void update(float delta) {
        frontfloor.update(delta);
        backFloor.update(delta);
        frontMountains.update(delta);
        frontFarClouds.update(delta);
        frontFarMountains.update(delta);
        frontNearClouds.update(delta);
        frontTrees.update(delta);
        frontSky.update(delta);
        backMountains.update(delta);
        backFarClouds.update(delta);
        backFarMountains.update(delta);
        backNearClouds.update(delta);
        backTrees.update(delta);
        backSky.update(delta);


        if (frontfloor.isScrolledRigth) {
            frontfloor.reset(-Gdx.graphics.getWidth());
        } else if (backFloor.isScrolledRigth) {
            backFloor.reset(-Gdx.graphics.getWidth());
        }

        if (frontMountains.isScrolledLeft) {
            frontMountains.reset(Gdx.graphics.getWidth());
        } else if (backMountains.isScrolledLeft) {
            backMountains.reset(Gdx.graphics.getWidth());
        }
        if (frontFarMountains.isScrolledLeft) {
            frontFarMountains.reset(Gdx.graphics.getWidth());
        } else if (backFarMountains.isScrolledLeft) {
            backFarMountains.reset(Gdx.graphics.getWidth());
        }
        if (frontFarClouds.isScrolledLeft) {
            frontFarClouds.reset(Gdx.graphics.getWidth());
        } else if (backFarClouds.isScrolledLeft) {
            backFarClouds.reset(Gdx.graphics.getWidth());
        }
        if (frontNearClouds.isScrolledLeft) {
            frontNearClouds.reset(Gdx.graphics.getWidth());
        } else if (backNearClouds.isScrolledLeft) {
            backNearClouds.reset(Gdx.graphics.getWidth());
        }
        if (frontTrees.isScrolledLeft) {
            frontTrees.reset(Gdx.graphics.getWidth());
        } else if (backTrees.isScrolledLeft) {
            backTrees.reset(Gdx.graphics.getWidth());
        }
        if (frontSky.isScrolledLeft) {
            frontSky.reset(Gdx.graphics.getWidth());
        } else if (backSky.isScrolledLeft) {
            backSky.reset(Gdx.graphics.getWidth());
        }
        frontFloorFabric.update(delta);
        backFloorFabric.update(delta);
        frontFabric1.update(delta);
        frontFabric2.update(delta);
        frontFabric3.update(delta);
        frontFabric4.update(delta);
        frontFabric5.update(delta);
        backFabric1.update(delta);
        backFabric2.update(delta);
        backFabric3.update(delta);
        backFabric4.update(delta);
        backFabric5.update(delta);

        if (frontFloorFabric.isScrolledLeft) {
            frontFloorFabric.reset(Gdx.graphics.getWidth());
        } else if (backFloorFabric.isScrolledLeft) {
            backFloorFabric.reset(Gdx.graphics.getWidth());
        }
        if (frontFabric1.isScrolledLeft) {
            frontFabric1.reset(Gdx.graphics.getWidth());
        } else if (backFabric1.isScrolledLeft) {
            backFabric1.reset(Gdx.graphics.getWidth());
        }

        if (frontFabric2.isScrolledLeft) {
            frontFabric2.reset(Gdx.graphics.getWidth());
        } else if (backFabric2.isScrolledLeft) {
            backFabric2.reset(Gdx.graphics.getWidth());
        }

        if (frontFabric3.isScrolledLeft) {
            frontFabric3.reset(Gdx.graphics.getWidth());
        } else if (backFabric3.isScrolledLeft) {
            backFabric3.reset(Gdx.graphics.getWidth());
        }

        if (frontFabric4.isScrolledLeft) {
            frontFabric4.reset(Gdx.graphics.getWidth());
        } else if (backFabric4.isScrolledLeft) {
            backFabric4.reset(Gdx.graphics.getWidth());
        }

        if (frontFabric5.isScrolledLeft) {
            frontFabric5.reset(Gdx.graphics.getWidth());
        } else if (backFabric5.isScrolledLeft) {
            backFabric5.reset(Gdx.graphics.getWidth());
        }
    }

    public Floor getFrontfloor() {
        return frontfloor;
    }

    public Floor getBackFloor() {
        return backFloor;
    }

    public Background getFrontMountains() {
        return frontMountains;
    }

    public Background getFrontFarClouds() {
        return frontFarClouds;
    }

    public Background getFrontFarMountains() {
        return frontFarMountains;
    }

    public Background getFrontNearClouds() {
        return frontNearClouds;
    }

    public Background getBackMountains() {
        return backMountains;
    }

    public Background getBackFarClouds() {
        return backFarClouds;
    }

    public Background getBackFarMountains() {
        return backFarMountains;
    }

    public Background getBackNearClouds() {
        return backNearClouds;
    }

    public Background getFrontTrees() {
        return frontTrees;
    }

    public Background getBackTrees() {
        return backTrees;
    }

    public Background getFrontSky() {
        return frontSky;
    }

    public Background getBackSky() {
        return backSky;
    }

    public Background getFrontFabric1() {
        return frontFabric1;
    }

    public Background getFrontFabric2() {
        return frontFabric2;
    }

    public Background getFrontFabric3() {
        return frontFabric3;
    }

    public Background getFrontFabric4() {
        return frontFabric4;
    }

    public Background getFrontFabric5() {
        return frontFabric5;
    }

    public Background getBackFabric1() {
        return backFabric1;
    }

    public Background getBackFabric2() {
        return backFabric2;
    }

    public Background getBackFabric3() {
        return backFabric3;
    }

    public Background getBackFabric4() {
        return backFabric4;
    }

    public Background getBackFabric5() {
        return backFabric5;
    }

    public Floor getFrontFloorFabric() {
        return frontFloorFabric;
    }

    public Floor getBackFloorFabric() {
        return backFloorFabric;
    }
}
