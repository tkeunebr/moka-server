package fr.utc.nf28.moka.agents.connection;

import fr.utc.nf28.moka.BuildConfig;
import fr.utc.nf28.moka.agents.A2ATransaction;
import fr.utc.nf28.moka.util.JSONParserUtils;
import fr.utc.nf28.moka.util.JadeUtils;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import java.io.IOException;
import java.util.HashMap;

/**
 * A behaviour that handles connections and disconnections.
 */
public class ConnectionHandlingBehaviour extends CyclicBehaviour {
	@Override
	public void action() {
		final ACLMessage message = myAgent.receive(MessageTemplate.MatchPerformative(ACLMessage.REQUEST));
		if (message != null) {
			final String connectionRequestString = message.getContent();
			try {
				final A2ATransaction request = JSONParserUtils.deserializeA2ATransaction(connectionRequestString);
				final String type = request.getType();
				if (type.equals(JadeUtils.TRANSACTION_TYPE_CONNECTION)) {
					((ConnectionAgent) myAgent).connection((HashMap<String, String>) request.getContent(), message.getSender());
				} else if (type.equals(JadeUtils.TRANSACTION_TYPE_LOGOUT)) {
                    ((ConnectionAgent) myAgent).disconnection(message.getSender());
				}
			} catch (IOException e) {
				e.printStackTrace();
				if (BuildConfig.DEBUG) System.out.println("Connection/disconnection request syntax is wrong");
			}

		} else {
			block();
		}
	}
}
