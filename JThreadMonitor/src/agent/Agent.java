package agent;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

/**
 * Agent for installing monitoring instruments to classes
 * 
 * @author jianghao
 * 
 */
public class Agent {

	public static void premain(final String agentArgs,
			final Instrumentation inst) {
		inst.addTransformer(new ConstructorCounter(), true);
		for (Class<?> clazz : inst.getAllLoadedClasses())
			if (inst.isModifiableClass(clazz))
				try {
					inst.retransformClasses(clazz);
				} catch (UnmodifiableClassException e) {
					e.printStackTrace();
				}
	}
}
