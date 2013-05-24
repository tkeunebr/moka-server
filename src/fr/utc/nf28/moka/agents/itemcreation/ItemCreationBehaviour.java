package fr.utc.nf28.moka.agents.itemcreation;

import fr.utc.nf28.moka.agents.A2ATransaction;
import fr.utc.nf28.moka.agents.MokaAgent;
import fr.utc.nf28.moka.util.JSONParserUtils;
import fr.utc.nf28.moka.util.JadeUtils;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import java.io.IOException;

/**
 * A behaviour that handles item creation.
 */
public class ItemCreationBehaviour extends CyclicBehaviour {
	@Override
	public void action() {
		final ACLMessage message = myAgent.receive(MessageTemplate.MatchPerformative(ACLMessage.REQUEST));
		if (message != null) {
			final String requestString = message.getContent();
			try {
				final A2ATransaction request = JSONParserUtils.deserializeA2ATransaction(requestString);
				final String type = request.getType();
				if (type.equals(JadeUtils.TYPE_ADD_ITEM_TO_ITEM_CREATION_AGENT)) {
					((ItemCreationAgent)myAgent).create((String)request.getContent());
				} else if (type.equals("destruction")) {
					//TODO implement destruction
				} else {
					throw new IOException();
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Item creation/destruction request syntax is wrong");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void destroy(String idString) {
		((MokaAgent) myAgent).getEnvironment().removeItem(Integer.valueOf(idString));
	}

}
