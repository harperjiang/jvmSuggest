package agent.asm;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class MethodInterceptor extends MethodVisitor {

	public MethodInterceptor() {
		super(Opcodes.ASM4);
	}

}
