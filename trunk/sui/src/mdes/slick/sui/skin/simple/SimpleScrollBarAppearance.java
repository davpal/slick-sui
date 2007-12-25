/*
 * SimpleScrollBarAppearance.java
 *
 * Created on November 12, 2007, 2:58 PM
 */

package mdes.slick.sui.skin.simple;

import mdes.slick.sui.skin.simple.SimpleArrowButton;
import mdes.slick.sui.SuiButton;
import mdes.slick.sui.SuiComponent;
import mdes.slick.sui.SuiScrollBar;
import mdes.slick.sui.SuiSlider;
import mdes.slick.sui.SuiTheme;
import mdes.slick.sui.skin.ScrollBarAppearance;
import mdes.slick.sui.skin.SkinUtil;
import mdes.slick.sui.SuiSkin;

/**
 * 
 * @author davedes
 */
public class SimpleScrollBarAppearance extends SimpleContainerAppearance implements ScrollBarAppearance {
    
    public void install(SuiComponent comp, SuiSkin skin, SuiTheme theme) {
        SkinUtil.installFont(comp, ((SimpleSkin)skin).getFont());    
        SkinUtil.installColors(comp, theme.getPrimary1(), theme.getForeground());
    }
    
    public SuiButton createScrollButton(SuiScrollBar bar, int direction) {
        SuiButton btn = createSimpleScrollButton(bar, direction);
        return btn;
    }
    
    public SuiSlider createSlider(SuiScrollBar bar, int orientation) {
        SuiSlider slider = new SuiSlider(orientation);
        return slider;
    }
    
    /**
     * A utility method to create a scroll button based on the given
     * scroll bar's orientation, size and direction. This will set the
     * button's dimensions to the width or height (based on orientation)
     * of the given scroll bar.
     * 
     * 
     * @param bar the scroll bar parent
     * @param direction the direction the bar will scroll, either 
     *      SuiScrollBar.INCREMENT or SuiScrollBar.DECREMENT.
     * @return a new SimpleArrowButton based on the given parameters
     */
    protected SuiButton createSimpleScrollButton(SuiScrollBar bar, int direction) {
        float angle = SimpleArrowButton.getScrollButtonAngle(bar, direction);
        int orientation = bar.getOrientation();
        float size = 0f;
        if (orientation==SuiScrollBar.HORIZONTAL) {
            size = bar.getHeight();
        } else
            size = bar.getWidth();
        SuiButton btn = new SimpleArrowButton(angle);
        btn.setSize(size, size);
        return btn;
    }
}