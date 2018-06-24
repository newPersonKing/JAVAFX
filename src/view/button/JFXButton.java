/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package view.button;

import com.sun.javafx.css.converters.BooleanConverter;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.css.*;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Labeled;
import javafx.scene.control.Skin;
import javafx.scene.paint.Paint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JFXButton extends Button {

    public JFXButton() {

        initialize();
        // init in scene builder workaround ( TODO : remove when JFoenix is well integrated in scenebuilder by gluon )
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (int i = 0; i < stackTraceElements.length && i < 15; i++) {
            if (stackTraceElements[i].getClassName().toLowerCase().contains(".scenebuilder.kit.fxom.")) {
                this.setText("Button");
                break;
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    public JFXButton(String text) {
        super(text);
        initialize();
    }

    /**
     * {@inheritDoc}
     */
    public JFXButton(String text, Node graphic) {
        super(text, graphic);
        initialize();
    }
    /*这里是加载样式*/
    private void initialize() {
        this.getStyleClass().add(DEFAULT_STYLE_CLASS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Skin<?> createDefaultSkin() {
        return new JFXButtonSkin(this);
    }

  /*这里是加载样式文件*/
    @Override
    public String getUserAgentStylesheet() {
        return USER_AGENT_STYLESHEET;
    }


    /***************************************************************************
     *                                                                         *
     * Properties                                                              *
     *                                                                         *
     **************************************************************************/
    /**
     * the ripple color property of JFXButton.
     * 波纹颜色
     */
    private ObjectProperty<Paint> ripplerFill = new SimpleObjectProperty<>(null);

    public final ObjectProperty<Paint> ripplerFillProperty() {
        return this.ripplerFill;
    }


    public final Paint getRipplerFill() {
        return this.ripplerFillProperty().get();
    }

    public final void setRipplerFill(final Paint ripplerFill) {
        this.ripplerFillProperty().set(ripplerFill);
    }


    /***************************************************************************
     *                                                                         *
     * Stylesheet Handling                                                     *
     *                                                                         *
     **************************************************************************/

    /**
      初始化样式
     */
    private static final String DEFAULT_STYLE_CLASS = "jfx-button";

//    private static final String USER_AGENT_STYLESHEET = JFXButton.class.getResource("/css/controls/jfx-button.css").toExternalForm();
    private static final String USER_AGENT_STYLESHEET = ClassLoader.getSystemResource("")+"/resources/css/controls/jfx-button.css";
    public enum ButtonType {FLAT, RAISED}

    /**
     * according to material design the button has two types:
     * - flat : only shows the ripple effect upon clicking the button
     * - raised : shows the ripple effect and change in depth upon clicking the button
     * 自定义的两种button波纹的效果
     * 参数介绍 第一个CssMetadata 第二个View 也可以理解为对象  第三个 属性 第四个 属性默认值
     * buttonType 存储的是button的样式信息 只是存储 其实没啥特别的意思
     */
    private StyleableObjectProperty<ButtonType> buttonType = new SimpleStyleableObjectProperty<>(
        StyleableProperties.BUTTON_TYPE,
        JFXButton.this,
        "buttonType",
        ButtonType.FLAT);

    public ButtonType getButtonType() {
        return buttonType == null ? ButtonType.FLAT : buttonType.get();
    }

    public StyleableObjectProperty<ButtonType> buttonTypeProperty() {
        return this.buttonType;
    }

    public void setButtonType(ButtonType type) {
        this.buttonType.set(type);
    }

    /**
     * Disable the visual indicator for focus
     */
    private StyleableBooleanProperty disableVisualFocus = new SimpleStyleableBooleanProperty(StyleableProperties.DISABLE_VISUAL_FOCUS,
        JFXButton.this,
        "disableVisualFocus",
        false);


    public final StyleableBooleanProperty disableVisualFocusProperty() {
        return this.disableVisualFocus;
    }

    public final Boolean isDisableVisualFocus() {
        return disableVisualFocus != null && this.disableVisualFocusProperty().get();
    }

    public final void setDisableVisualFocus(final Boolean disabled) {
        this.disableVisualFocusProperty().set(disabled);
    }

    /*这个跟安卓中的自定义属性应该差不多*/
    private static class StyleableProperties {
        /*设置BUTTON_TYPE的值为样式中-jfx-button-type对应的值*/
        private static final CssMetaData<JFXButton, ButtonType> BUTTON_TYPE =
            new CssMetaData<JFXButton, ButtonType>("-jfx-button-type",
                ButtonTypeConverter.getInstance(), ButtonType.FLAT) {
                @Override
                public boolean isSettable(JFXButton control) {
                    /*检查给定节点上的相应的属性是否是可设置的  Bound界限，限制的*/
                    return control.buttonType == null || !control.buttonType.isBound();
                }

                @Override
                public StyleableProperty<ButtonType> getStyleableProperty(JFXButton control) {
                    return control.buttonTypeProperty();
                }
            };


        private static final CssMetaData<JFXButton, Boolean> DISABLE_VISUAL_FOCUS =
            new CssMetaData<JFXButton, Boolean>("-jfx-disable-visual-focus",
                BooleanConverter.getInstance(), false) {
                @Override
                public boolean isSettable(JFXButton control) {
                    return control.disableVisualFocus == null || !control.disableVisualFocus.isBound();
                }

                @Override
                public StyleableBooleanProperty getStyleableProperty(JFXButton control) {
                    return control.disableVisualFocusProperty();
                }
            };

        private static final List<CssMetaData<? extends Styleable, ?>> CHILD_STYLEABLES;

        static {
            final List<CssMetaData<? extends Styleable, ?>> styleables =
                new ArrayList<>(Control.getClassCssMetaData());
            Collections.addAll(styleables,
                BUTTON_TYPE,DISABLE_VISUAL_FOCUS
            );
            CHILD_STYLEABLES = Collections.unmodifiableList(styleables);
        }
    }

    // inherit the styleable properties from parent
    private List<CssMetaData<? extends Styleable, ?>> STYLEABLES;

    @Override
    public List<CssMetaData<? extends Styleable, ?>> getControlCssMetaData() {
        if (STYLEABLES == null) {
            final List<CssMetaData<? extends Styleable, ?>> styleables =
                new ArrayList<>(Control.getClassCssMetaData());
            styleables.addAll(getClassCssMetaData());
            styleables.addAll(Labeled.getClassCssMetaData());
            STYLEABLES = Collections.unmodifiableList(styleables);
        }
        return STYLEABLES;
    }

    public static List<CssMetaData<? extends Styleable, ?>> getClassCssMetaData() {
        return StyleableProperties.CHILD_STYLEABLES;
    }


}
