/*
 * Copyright 2016 Lexteam
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package xyz.lexteam.agame.entity.component;

import com.badlogic.ashley.core.Component;

/**
 * A {@link Component} for position data.
 */
public class PositionComponent implements Component {

    private float x;
    private float y;

    public PositionComponent() {
        this(0, 0);
    }

    public PositionComponent(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the X coordinate of the entity.
     *
     * @return The X coord
     */
    public float getX() {
        return this.x;
    }

    /**
     * Gets the Y coordinate of the entity.
     *
     * @return The Y coord
     */
    public float getY() {
        return this.y;
    }

    /**
     * Sets the X coordinate of the entity.
     *
     * @param x The X coord
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Sets the Y coordinate of the entity.
     *
     * @param y The Y coord
     */
    public void setY(float y) {
        this.y = y;
    }

}
