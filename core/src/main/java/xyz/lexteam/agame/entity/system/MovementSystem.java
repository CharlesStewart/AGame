package xyz.lexteam.agame.entity.system;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import xyz.lexteam.agame.entity.component.PositionComponent;
import xyz.lexteam.agame.entity.component.VelocityComponent;

/**
 * An {@link IteratingSystem} for changing an entity's position by a given velocity (movement).
 */
public class MovementSystem extends IteratingSystem {


    private final float entityDeaccelSpeed = 0.5f;

    /**
     * Allows access to any entity's {@link PositionComponent}.
     */
    private ComponentMapper<PositionComponent> positionMap = ComponentMapper.getFor(PositionComponent.class);

    /**
     * Allows access to any entity's {@link VelocityComponent}.
     */
    private ComponentMapper<VelocityComponent> velocityMap = ComponentMapper.getFor(VelocityComponent.class);

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
