package xyz.lexteam.agame.entity.system;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import xyz.lexteam.agame.entity.component.PositionComponent;
import xyz.lexteam.agame.entity.component.VelocityComponent;

public class MovementSystem extends IteratingSystem{

    private final float entityDeaccelSpeed = 0.5f;

    private ComponentMapper<PositionComponent> positionMap = ComponentMapper.getFor(PositionComponent.class);
    private ComponentMapper<VelocityComponent> velocityMap = ComponentMapper.getFor(VelocityComponent.class);


    public MovementSystem() {
        super(Family.all(PositionComponent.class, VelocityComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        positionMap.get(entity).setX(positionMap.get(entity).getX() + velocityMap.get(entity).getX());
        positionMap.get(entity).setY(positionMap.get(entity).getY() + velocityMap.get(entity).getY());

        //TODO: work out how much deacelleration per a loop.
        velocityMap.get(entity).setX(positionMap.get(entity).getX() - 0.1f);
        velocityMap.get(entity).setY(positionMap.get(entity).getY() - 0.1f);

        if(velocityMap.get(entity).getX() == 0 & velocityMap.get(entity).getY() == 0){
            entity.remove(VelocityComponent.class);
        }
    }
}
