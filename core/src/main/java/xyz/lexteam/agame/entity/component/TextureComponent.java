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
import com.badlogic.gdx.graphics.g2d.Texture;

/**
 * The {@link Component} for Texture data.
 */
public class TextureComponent implements Component {

    private Texture texture;

    /**
     * Gets the {@link Texture} of the entity.
     *
     * @return The Texture
     */
    public Texture getTexture() {
        return this.Texture;
    }

    /**
     * Sets the {@link Texture} of the entity.
     *
     * @param Texture The Texture
     */
    public void setTexture(Texture Texture) {
        this.Texture = Texture;
    }

}
