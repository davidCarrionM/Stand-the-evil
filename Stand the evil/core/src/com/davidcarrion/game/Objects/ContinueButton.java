package com.davidcarrion.game.Objects;

import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class ContinueButton extends ImageButton {
    public ContinueButton(Skin skin) {
        super(skin);
    }

    public ContinueButton(Skin skin, String styleName) {
        super(skin, styleName);
    }

    public ContinueButton(ImageButtonStyle style) {
        super(style);
    }

    public ContinueButton(Drawable imageUp) {
        super(imageUp);
    }

    public ContinueButton(Drawable imageUp, Drawable imageDown) {
        super(imageUp, imageDown);
    }

    public ContinueButton(Drawable imageUp, Drawable imageDown, Drawable imageChecked) {
        super(imageUp, imageDown, imageChecked);
    }
}
