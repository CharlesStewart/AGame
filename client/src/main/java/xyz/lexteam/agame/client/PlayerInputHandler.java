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

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import xyz.lexteam.agame.entity.component.VelocityComponent;

import java.util.ArrayList;

/**
 * A {@link InputAdapter} specifically for handling player-related input
 */
public class PlayerInputHandler extends InputAdapter {

    /**
     * The {@link Entity} that represents the player
     *
     * TODO - Create an EntityPool and get player through that?
     */
    private Entity player;

    /**
     * Holds a list of all keys currently pressed
     */
    private ArrayList<Integer> keysPressed = new ArrayList<>();

    /**
     * Creates a new {@link PlayerInputHandler} instance
     * @param player The {@link Entity} that represents the player
     */
    public PlayerInputHandler(Entity player) {
        this.player = player;
    }

    /**
     * Updates the Player based off of input.
     *
     * This should be called in the game loop
     */
    public void update() {
        if (keysPressed.size() != 0) {
            if (player.getComponent(VelocityComponent.class) == null) {
                player.add(new VelocityComponent());
            }

            if (keysPressed.contains(Input.Keys.LEFT)) {
                player.getComponent(VelocityComponent.class).setX(-5);
            }

            if (keysPressed.contains(Input.Keys.RIGHT)) {
                player.getComponent(VelocityComponent.class).setX(5);
            }

            if (keysPressed.contains(Input.Keys.UP)) {
                player.getComponent(VelocityComponent.class).setY(5);
            }

            if (keysPressed.contains(Input.Keys.DOWN)) {
                player.getComponent(VelocityComponent.class).setY(-5);
            }
        }
    }

    @Override
    public boolean keyDown(int keycode) {
        keysPressed.add(keycode);
        return super.keyDown(keycode);
    }

    @Override
    public boolean keyUp(int keycode) {
        keysPressed.remove(keysPressed.indexOf(keycode));
        return super.keyUp(keycode);
    }
}
