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

package xyz.lexteam.agame.client;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import xyz.lexteam.agame.entity.component.PositionComponent;
import xyz.lexteam.agame.client.entity.component.TextureComponent;
import xyz.lexteam.agame.entity.system.MovementSystem;
import xyz.lexteam.agame.client.entity.system.RenderSystem;

public class AGame extends ApplicationAdapter {

    private SpriteBatch batch;
    private Engine engine;

    @Override
    public void create() {
        batch = new SpriteBatch();

        engine = new Engine();

        engine.addSystem(new RenderSystem(batch));
        engine.addSystem(new MovementSystem());

        Entity player = new Entity();
        player.add(new PositionComponent());
        player.add(new TextureComponent(new Texture("player.png")));

        engine.addEntity(player);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        engine.update(Gdx.graphics.getDeltaTime());
        batch.end();
    }

}
