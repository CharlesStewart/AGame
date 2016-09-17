package xyz.lexteam.agame.system;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import xyz.lexteam.agame.component.PositionComponent;
import xyz.lexteam.agame.component.VelocityComponent;

public class MovementSystem extends IteratingSystem{

    private ComponentMapper<PositionComponent> positionMap = ComponentMapper.getFor(PositionComponent.class);
    private ComponentMapper<VelocityComponent> velocityMap = ComponentMapper.getFor(VelocityComponent.class);


    public MovementSystem() {
        super(Family.all(PositionComponent.class, VelocityComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        positionMap.get(entity).setX(positionMap.get(entity).getX() + velocityMap.get(entity).getX());
        positionMap.get(entity).setY(positionMap.get(entity).getY() + velocityMap.get(entity).getY());
    }
}
