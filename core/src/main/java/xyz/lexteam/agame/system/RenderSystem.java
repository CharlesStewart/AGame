package xyz.lexteam.agame.system;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import xyz.lexteam.agame.component.PositionComponent;
import xyz.lexteam.agame.component.TextureComponent;

public class RenderSystem extends IteratingSystem {

    private ComponentMapper<TextureComponent> textureMap = ComponentMapper.getFor(TextureComponent.class);
    private ComponentMapper<PositionComponent> positionMap = ComponentMapper.getFor(PositionComponent.class);
    private SpriteBatch renderTarget;

    public RenderSystem(SpriteBatch renderTarget) {
        super(Family.all(TextureComponent.class, PositionComponent.class).get());
        this.renderTarget = renderTarget;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        renderTarget.draw(textureMap.get(entity).getTexture()
                , positionMap.get(entity).getX(), positionMap.get(entity).getY());
    }



}
