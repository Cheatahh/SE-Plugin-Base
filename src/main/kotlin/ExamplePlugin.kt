import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.AirportAgentSimulation
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.config.ConfigurationFormatException
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.plugin.Plugin

class ExamplePlugin : Plugin {

    override fun activate() {
        println("[${javaClass.simpleName}] Hello World!")

        try {
            AirportAgentSimulation.registerEntity(this, ExampleAgent.TYPE_ID, ExampleAgent::class.java)
        } catch (exception: ConfigurationFormatException) {
            exception.printStackTrace()
        }
    }

}