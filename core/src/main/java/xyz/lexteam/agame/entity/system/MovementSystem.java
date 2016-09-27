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

package xyz.lexteam.agame.entity.system;

import static xyz.lexteam.agame.entity.Mappers.*;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import xyz.lexteam.agame.entity.component.PositionComponent;
import xyz.lexteam.agame.entity.component.VelocityComponent;

/**
 * An {@link IteratingSystem} for changing an entity's position by a given velocity (movement).
 */
public class MovementSystem extends IteratingSystem {

    private final float entityDecelSpeed = 0.1f;

    /**
     * Creates a new instance of {@link MovementSystem} with the correct family of components.
     */
    public MovementSystem() {
        super(Family.all(PositionComponent.class, VelocityComponent.class).get());
    }

    /**
     * Process all entity's affected by this system.
     *
     * @param entity the entity to be processed
     * @param deltaTime the time between this processing loop and the last
     */
    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PositionComponent positionComponent = POSITION.get(entity);
        VelocityComponent velocityComponent = VELOCITY.get(entity);

        // TODO - find a way of making this more accurate / a more accurate method

        // Accurately comparing a float to 0 is not easy, apparently.
        float epsilon = 0.1f;
        if (Math.abs(velocityComponent.getX() - 0) < epsilon && Math.abs(velocityComponent.getY() - 0) < epsilon) {
            entity.remove(VelocityComponent.class);
        }


        // TODO: work out how much deceleration per loop. (Use deltaTime to make decel speed more accurate)

        if (velocityComponent.getX() != 0) {
            positionComponent.setX(positionComponent.getX() + velocityComponent.getX());
            if (velocityComponent.getX() > 0) {
                velocityComponent.setX(velocityComponent.getX() - entityDecelSpeed);
            } else if (velocityComponent.getX() < 0) {
                velocityComponent.setX(velocityComponent.getX() + entityDecelSpeed);
            }
        }

        if (velocityComponent.getY() != 0) {
            positionComponent.setY(positionComponent.getY() + velocityComponent.getY());
            if (velocityComponent.getY() > 0) {
                velocityComponent.setY(velocityComponent.getY() - entityDecelSpeed);
            } else if (velocityComponent.getY() < 0) {
                velocityComponent.setY(velocityComponent.getY() + entityDecelSpeed);
            }
        }
    }
}
