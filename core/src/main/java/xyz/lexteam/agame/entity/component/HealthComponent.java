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
 * A {@link Component} for health data.
 */
public class HealthComponent implements Component {

    private float health;

    /**
     * Creates a health component with the default health (100.0f).
     */
    public HealthComponent() {
        this.health = 100.0f;
    }

    /**
     * Creates a health component with the given health.
     *
     * @param health The health
     */
    public HealthComponent(float health) {
        this.health = health;
    }

    /**
     * Gets the health of the entity.
     *
     * @return The health
     */
    public float getHealth() {
        return this.health;
    }

    /**
     * Sets the health of the entity.
     *
     * @param health The health
     */
    public void setHealth(float health) {
        this.health = health;
    }

}
