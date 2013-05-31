/**
 * 
 */
package com.github.gwtd3.api.svg;

import com.github.gwtd3.api.IsFunction;
import com.github.gwtd3.api.functions.DatumFunction;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author <a href="mailto:schiochetanthoni@gmail.com">Anthony Schiochet</a>
 * 
 */
public class Line extends JavaScriptObject implements IsFunction {

    protected Line() {
        super();
    }

    public static enum InterpolationMode {
        /**
         * piecewise linear segments, as in a polyline.
         */
        LINEAR("linear"),

        /**
         * close the linear segments to form a polygon.
         */
        LINEAR_CLOSED("linear-closed"),

        /**
         * alternate between vertical and horizontal segments, as in a step
         * function.
         */
        STEP_BEFORE("step-before"),

        /**
         * alternate between horizontal and vertical segments, as in a step
         * function
         */
        STEP_AFTER("step-after"),

        /**
         * a B-spline, with control point duplication on the ends.
         */
        BASIS("basis"),
        /**
         * an open B-spline; may not intersect the start or end.
         */
        BASIS_OPEN("basis-open"),
        /**
         * a closed B-spline, as in a loop.
         */
        BASIS_CLOSED("basis-closed"),
        /**
         * equivalent to basis, except the tension parameter is used to
         * straighten the spline.
         */
        BUNDLE("bundle"),
        /**
         * a Cardinal spline, with control point duplication on the ends.
         */
        CARDINAL("cardinal"),
        /**
         * an open Cardinal spline; may not intersect the start or end, but will
         * intersect other control points.
         */
        CARDINAL_OPEN("cardinal-open"),
        /**
         * a closed Cardinal spline, as in a loop.
         */
        CARDINAL_CLOSED("cardinal-closed"),
        /**
         * cubic interpolation that preserves monotonicity in y.
         */
        MONOTONE("monotone");

        private final String value;

        private InterpolationMode(final String value) {
            this.value = value;
        }

        /**
         * @return the value
         */
        public String getValue() {
            return value;
        }

        public static InterpolationMode fromValue(final String value) {
            return valueOf(value.toUpperCase().replace('-', '_'));
        }
    }

    /**
     * Returns the current interpolation mode.
     * 
     * @return the current interpolation mode.
     */
    public final native InterpolationMode interpolate() /*-{
		return @com.github.gwtd3.api.svg.Line.InterpolationMode::fromValue(Ljava/lang/String;)(this.interpolate());
    }-*/;

    /**
     * Set the current interpolation mode.
     * 
     * @param i
     *            the interpolation mode
     * @return the current line
     */
    public final native Line interpolate(final InterpolationMode i) /*-{
		return this.interpolate(i.@com.github.gwtd3.api.svg.Line.InterpolationMode::getValue()());
    }-*/;

    /**
     * Set the x coordinates of points generated by this generator.
     * 
     * @param d
     * @return
     */
    public final native Line x(double d) /*-{
		return this.x(d);
    }-*/;

    /**
     * Set the function used to compute x coordinates of points generated by
     * this line generator. The function is invoked for each element in the data
     * array passed to the line generator.
     * <p>
     * The default accessor assumes that each input element is a two-element array of numbers.
     * 
     * @param datumFunction
     * @return
     */
    public final native Line x(final DatumFunction<Double> callback)/*-{
		return this.x(function(d, i) {
			return callback.@com.github.gwtd3.api.functions.DatumFunction::apply(Lcom/google/gwt/dom/client/Element;Lcom/github/gwtd3/api/core/Datum;I)(this,{datum:d},i);
		});
    }-*/;

    // should create a JSO impl of DatumFunction calling himself
    // public final native DatumFunction<Double> x()/*-{
    // return this.x();
    // }-*/;

    /**
     * Set the y coordinates of points generated by this generator.
     * 
     * @param d
     * @return
     */
    public final native Line y(double d) /*-{
		return this.y(d);
    }-*/;

    /**
     * See {@link #x(DatumFunction)}.
     * <p>
     * Note that, like most other graphics libraries, SVG uses the top-left corner as the origin and thus higher values
     * of y are lower on the screen. For visualization we often want the origin in the bottom-left corner instead; one
     * easy way to accomplish this is to invert the range of the y-scale by using range([h, 0]) instead of range([0,
     * h]).
     * 
     * @param callback
     * @return
     */
    public final native Line y(final DatumFunction<Double> callback) /*-{
		return this.y(function(d, i) {
			return callback.@com.github.gwtd3.api.functions.DatumFunction::apply(Lcom/google/gwt/dom/client/Element;Lcom/github/gwtd3/api/core/Datum;I)(this,{datum:d},i);
		});
    }-*/;

    /**
     * Sets the function used to controls where the line is defined.
     * <p>
     * The defined accessor can be used to define where the line is defined and undefined, which is typically useful in
     * conjunction with missing data; the generated path data will automatically be broken into multiple distinct
     * subpaths, skipping undefined data.
     * <p>
     * 
     * @param callback
     * @return
     */
    public final native Line defined(final DatumFunction<Boolean> callback) /*-{
		return this.defined(function(d) {
			var result = callback.@com.github.gwtd3.api.functions.DatumFunction::apply(Lcom/google/gwt/dom/client/Element;Lcom/github/gwtd3/api/core/Datum;I)(null,{datum:d}, 0);
			if (result == null) {
				return false;
			} else {
				return result.@java.lang.Boolean::booleanValue()();
			}
		});
    }-*/;

    /**
     * Generate a piecewise linear curve, as in a line chart.
     * <p>
     * Data must be an array-like structure. the type of the array elements depends on the x and y functions. the
     * default x and y functions assumes that each input element is a two-element array of numbers.
     * 
     * @return
     */
    public final native <T> String apply(T data)/*-{
		return this(data);
    }-*/;

    /**
     * Generate a piecewise linear curve, as in a line chart.
     * <p>
     * Data must be an array-like structure. the type of the array elements depends on the x and y functions. the
     * default x and y functions assumes that each input element is a two-element array of numbers.
     * <p>
     * The index will be passed through to the line's accessor functions.
     * <p>
     * 
     * @param data
     * @param index
     * @return
     */
    public final native <T> String apply(T data, int index)/*-{
		return this(data, index);
    }-*/;
}