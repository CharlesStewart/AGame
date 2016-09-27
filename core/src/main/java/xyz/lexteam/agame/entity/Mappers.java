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

package xyz.lexteam.agame.entity;

import static com.badlogic.ashley.core.ComponentMapper.getFor;

import com.badlogic.ashley.core.ComponentMapper;
import xyz.lexteam.agame.entity.component.HealthComponent;
import xyz.lexteam.agame.entity.component.PositionComponent;
import xyz.lexteam.agame.entity.component.VelocityComponent;

/**
 * A pseudo-enum for all the {@link ComponentMapper}s in AGame.
 */
public final class Mappers {

    public static final ComponentMapper<HealthComponent> HEALTH = getFor(HealthComponent.class);

    public static final ComponentMapper<PositionComponent> POSITION = getFor(PositionComponent.class);

    public static final ComponentMapper<VelocityComponent> VELOCITY = getFor(VelocityComponent.class);

}
