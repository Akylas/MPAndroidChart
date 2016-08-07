
package com.github.mikephil.charting.components;

import com.github.mikephil.charting.utils.Utils;

/**
 * Class representing the x-axis labels settings. Only use the setter methods to
 * modify it. Do not access public variables directly. Be aware that not all
 * features the XLabels class provides are suitable for the RadarChart.
 *
 * @author Philipp Jahoda
 */
public class XAxis extends AxisBase {

    /**
     * width of the x-axis labels in pixels - this is automatically
     * calculated by the computeSize() methods in the renderers
     */
    public int mLabelWidth = 1;

    /**
     * height of the x-axis labels in pixels - this is automatically
     * calculated by the computeSize() methods in the renderers
     */
    public int mLabelHeight = 1;

    /**
     * width of the (rotated) x-axis labels in pixels - this is automatically
     * calculated by the computeSize() methods in the renderers
     */
    public int mLabelRotatedWidth = 1;

    /**
     * height of the (rotated) x-axis labels in pixels - this is automatically
     * calculated by the computeSize() methods in the renderers
     */
    public int mLabelRotatedHeight = 1;

    /**
     * This is the angle for drawing the X axis labels (in degrees)
     */
    protected float mLabelRotationAngle = 0f;

    /**
     * if set to true, the chart will avoid that the first and last label entry
     * in the chart "clip" off the edge of the chart
     */
    private boolean mAvoidFirstLastClipping = false;

    /**
     * the position of the x-labels relative to the chart
     */
    private XAxisPosition mPosition = XAxisPosition.TOP;

    /**
     * the space that should be left out (in characters) between the x-axis labels This only applies if the number of labels that will be skipped in between drawn axis labels is not custom set.
     */
    public int mSpaceBeetweenLabels = 4;
    
    /**
     * the modulus that indicates if a value at a specified index in an array(list) for the x-axis-labels is drawn or not. Draw when `(index % modulus) == 0`.
     */
    public int mAxisLabelModulus = 1;
    
    /**
     * Is axisLabelModulus a custom value or auto calculated? If false, then it's auto, if true, then custom.
     */
    private boolean mIsAxisLabelModulusCustom = false;

    /**
     * enum for the position of the x-labels relative to the chart
     */
    public enum XAxisPosition {
        TOP, BOTTOM, BOTH_SIDED, TOP_INSIDE, BOTTOM_INSIDE
    }

    public XAxis() {
        super();

        mYOffset = Utils.convertDpToPixel(4.f); // -3
    }

    /**
     * returns the position of the x-labels
     */
    public XAxisPosition getPosition() {
        return mPosition;
    }

    /**
     * sets the position of the x-labels
     *
     * @param pos
     */
    public void setPosition(XAxisPosition pos) {
        mPosition = pos;
    }

    /**
     * returns the angle for drawing the X axis labels (in degrees)
     */
    public float getLabelRotationAngle() {
        return mLabelRotationAngle;
    }

    /**
     * sets the angle for drawing the X axis labels (in degrees)
     *
     * @param angle the angle in degrees
     */
    public void setLabelRotationAngle(float angle) {
        mLabelRotationAngle = angle;
    }

    /**
     * if set to true, the chart will avoid that the first and last label entry
     * in the chart "clip" off the edge of the chart or the screen
     *
     * @param enabled
     */
    public void setAvoidFirstLastClipping(boolean enabled) {
        mAvoidFirstLastClipping = enabled;
    }

    /**
     * returns true if avoid-first-lastclipping is enabled, false if not
     *
     * @return
     */
    public boolean isAvoidFirstLastClippingEnabled() {
        return mAvoidFirstLastClipping;
    }
    
    
    public void setLabelsToSkip(int count)
    {
        mIsAxisLabelModulusCustom = true;

        if (count < 0)
        {
            mAxisLabelModulus = 1;
        }
        else
        {
            mAxisLabelModulus = count + 1;
        }
    }
    
    /**
     * Calling this will disable a custom number of labels to be skipped (set by `setLabelsToSkip(...)`) while drawing the x-axis. Instead, the number of values to skip will again be calculated automatically.
     *
     * @return
     */
    public void resetLabelsToSkip()
    {
        mIsAxisLabelModulusCustom = false;
    }
    
    /**
     * returns: true if a custom axis-modulus has been set that determines the number of labels to skip when drawing.
     *
     * @return
     */
    public boolean isAxisModulusCustom()
    {
        return mIsAxisLabelModulusCustom;
    }
}
