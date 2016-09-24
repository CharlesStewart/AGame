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

package xyz.lexteam.agame.client.entity.system;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import xyz.lexteam.agame.entity.component.PositionComponent;
import xyz.lexteam.agame.client.entity.component.TextureComponent;
import xyz.lexteam.agame.entity.system.MovementSystem;

/**
 * An {@link IteratingSystem} for rendering an texture at a position.
 */
public class RenderSystem extends IteratingSystem {

    /**
     * Allows access to any entity's {@link TextureComponent}.
     */
    private ComponentMapper<TextureComponent> textureMap = ComponentMapper.getFor(TextureComponent.class);

    /**
     * Allows access to any entity's {@link PositionComponent}.
     */
    private ComponentMapper<PositionComponent> positionMap = ComponentMapper.getFor(PositionComponent.class);

    /**
     * The object unto which the texture is drawn.
     */
    private SpriteBatch renderTarget;

    /**
     * Creates a new instance of {@link MovementSystem} with the correct family of components.
     *
     * @param renderTarget The object unto which the texture is drawn.
     */
    public RenderSystem(SpriteBatch renderTarget) {
        super(Family.all(TextureComponent.class, PositionComponent.class).get());
        this.renderTarget = renderTarget;
    }

    /**
     * Process all entity's affected by this system.
     *
     * @param entity the entity to be processed
     * @param deltaTime the time between this processing loop and the last
     */
    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        renderTarget.draw(textureMap.get(entity).getTexture(),
                positionMap.get(entity).getX(), positionMap.get(entity).getY());
    }

}
