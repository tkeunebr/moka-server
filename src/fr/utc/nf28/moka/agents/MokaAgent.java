package fr.utc.nf28.moka.agents;

import fr.utc.nf28.moka.environment.MokaEnvironment;

/**
 * A generic Agent for Moka
 * Has a reference to its MokaEnvironment
 */
public class MokaAgent extends BaseAgent {
	protected MokaEnvironment mEnvironment;

	public void setup() {
		super.setup();
		final Object[] args = getArguments();
		mEnvironment = (MokaEnvironment) args[0];
	}

	public MokaEnvironment getEnvironment() {
		return mEnvironment;
	}

}
