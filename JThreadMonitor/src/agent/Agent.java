package agent;

import java.lang.instrument.Instrumentation;

/**
 * Agent for installing monitoring instruments to classes
 * 
 * @author jianghao
 * 
 */
public class Agent {

	public static void premain(final String agentArgs,
			final Instrumentation inst) {
		inst.addTransformer(new ConstructorCounter(), false);
	}
}
