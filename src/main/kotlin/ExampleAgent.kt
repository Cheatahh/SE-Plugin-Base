import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.geometry.Point
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.simulation.entity.Agent
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.simulation.entity.Entity
import kotlin.math.min

//carries an explosive to kill nearby entities
class ExampleAgent(x: Int, y: Int, w: Int, h: Int) : Agent() {

    private val explosionRadius = min(world.width, world.height) * .1
    private var explosionTriggered = false

    init {
        position = Point(x, y)
        width = w
        height = h
        speed = .0
    }

    override fun pluginUpdate() {

        if(!explosionTriggered) {
            val entitiesInRadius = world.entities.filter {
                position .. it.position < explosionRadius
            }

            //explosion is triggered if at least 10% of all entities are in the explosion radius
            if(entitiesInRadius.count() < world.entities.count() / 10) return
            explosionTriggered = true

            entitiesInRadius.forEach(Entity::kill)

        }

    }

    companion object {
        const val TYPE_ID = "ExampleAgent"
    }
}