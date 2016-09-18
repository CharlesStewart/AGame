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

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.TimeUtils;
import xyz.lexteam.agame.client.AGame;

/**
 * The splash screen.
 */
public class SplashScreen implements Screen {

    private final AGame game;
    private final Texture splashTexture;
    private long startTime;

    public SplashScreen(AGame game) {
        this.game = game;
        this.splashTexture = new Texture("splash.png");
    }

    @Override
    public void show() {
        this.startTime = TimeUtils.millis();
    }

    @Override
    public void render(float delta) {
        if (this.startTime + 3000 < TimeUtils.millis()) {
            this.game.setScreen(new GameScreen(this.game));
        } else {
            this.game.getBatch().begin();
            this.game.getBatch().draw(this.splashTexture, 0, 0);
            this.game.getBatch().end();
        }
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
        this.splashTexture.dispose();
    }

}
