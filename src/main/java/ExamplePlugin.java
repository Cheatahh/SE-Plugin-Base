import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.AirportAgentSimulation;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.config.ConfigurationFormatException;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.plugin.Plugin;

public class ExamplePlugin implements Plugin {

    @Override
    public void activate() {
        System.out.println("[" + getClass().getSimpleName() + "] Hello World!");

        try {
            AirportAgentSimulation.registerEntity(this, ExampleAgent.TYPE_ID, ExampleAgent.class);
        } catch (ConfigurationFormatException exception) {
            exception.printStackTrace();
        }
    }
}
