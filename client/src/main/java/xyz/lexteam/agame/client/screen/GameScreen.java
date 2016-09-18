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

package xyz.lexteam.agame.client.screen;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import xyz.lexteam.agame.client.AGame;
import xyz.lexteam.agame.client.entity.component.TextureComponent;
import xyz.lexteam.agame.client.entity.system.RenderSystem;
import xyz.lexteam.agame.entity.component.PositionComponent;
import xyz.lexteam.agame.entity.system.MovementSystem;

/**
 * The game screen.
 */
public class GameScreen implements Screen {

    private final AGame game;
    private final Engine engine;

    public GameScreen(AGame game) {
        this.game = game;
        this.engine = new Engine();

        this.engine.addSystem(new RenderSystem(this.game.getBatch()));
        this.engine.addSystem(new MovementSystem());

        Entity player = new Entity();
        player.add(new PositionComponent());
        player.add(new TextureComponent(new Texture("player.png")));
        this.engine.addEntity(player);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.game.getBatch().begin();
        engine.update(Gdx.graphics.getDeltaTime());
        this.game.getBatch().end();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
    }

}
