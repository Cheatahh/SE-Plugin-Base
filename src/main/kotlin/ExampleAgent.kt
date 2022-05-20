import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.simulation.entity.Agent
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.simulation.entity.Entity
import kotlin.math.min

//carries an explosive to kill nearby entities
class ExampleAgent : Agent() {

    private val explosionRange = min(world.width, world.height) * .1
    private var explosionTriggered = false

    init {
        //waiting in the center of our world
        spawn(world, world.width / 2, world.height / 2, 1, 1)
        speed = .0
    }

    override fun pluginUpdate() {

        if(!explosionTriggered) {
            val entitiesInRadius = world.entities.filter {
                position .. it.position < explosionRange
            }

            //explosion is triggered if 10% of all entities in radius
            if(entitiesInRadius.count() < world.entities.count() / 10) return
            explosionTriggered = true

            entitiesInRadius.forEach(Entity::kill)
        }

    }

    companion object {
        const val TYPE_ID = "ExampleAgent"
    }
}