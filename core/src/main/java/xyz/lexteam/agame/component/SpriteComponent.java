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

package xyz.lexteam.agame.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * The {@link Component} for sprite data.
 */
public class SpriteComponent implements Component {

    private Sprite sprite;

    /**
     * Gets the {@link Sprite} of the entity.
     *
     * @return The sprite
     */
    public Sprite getSprite() {
        return this.sprite;
    }

    /**
     * Sets the {@link Sprite} of the entity.
     *
     * @param sprite The sprite
     */
    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

}
