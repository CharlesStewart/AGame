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

package xyz.lexteam.agame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class AGame extends ApplicationAdapter {
	SpriteBatch batch;
	Sprite sprite;

    public void move(int key, boolean moving){

    }


	@Override
	public void create () {
		batch = new SpriteBatch();
		sprite = new Sprite(new Texture("player.png"));
        Gdx.input.setInputProcessor(new InputAdapter(){

            @Override
            public boolean keyDown(int key) {
                switch(key){
                    case Input.Keys.W:
                        sprite.setPosition(sprite.getX(), sprite.getY() + 1);
                        break;
                    case Input.Keys.S:
                        sprite.setPosition(sprite.getX(), sprite.getY() - 1);
                        break;
                    case Input.Keys.A:
                        sprite.setPosition(sprite.getX() - 1, sprite.getY());
                        break;
                    case Input.Keys.D:
                        sprite.setPosition(sprite.getX() + 1, sprite.getY());
                        break;
                }
                return super.keyDown(key);
            }
        });
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		sprite.draw(batch);
		batch.end();
	}
}
