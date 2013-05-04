package fr.utc.nf28.moka.agents;

import fr.utc.nf28.moka.environment.UmlClass;
import fr.utc.nf28.moka.util.JSONParserUtils;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import java.io.IOException;

public class ItemCreationBehaviour extends CyclicBehaviour {
    @Override
    public void action() {
        final ACLMessage message = myAgent.receive(MessageTemplate.MatchPerformative(ACLMessage.REQUEST));
        if (message != null) {
            final String itemJson = message.getContent();
            try {
                UmlClass item = JSONParserUtils.deserializeUmlClass(itemJson);
                System.out.println(item.toString());
                ((ConnectionAgent)myAgent).getEnvironment().addItem(item);
            } catch (IOException e) {
                System.out.println("Item creation request syntax is wrong");
            }


        }
    }
}
