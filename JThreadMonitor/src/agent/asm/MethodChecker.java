package agent.asm;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class MethodChecker extends MethodVisitor {

	public MethodChecker(MethodVisitor mv) {
		super(Opcodes.ASM4, mv);
	}
	@Override
	public void visitFrame(int type, int nLocal, Object[] local, int nStack,
			Object[] stack) {
		System.out.println("Visit Frame");
		super.visitFrame(type, nLocal, local, nStack, stack);
	}

	@Override
	public void visitCode() {
		mv.visitCode();
		// 0 getstatic java.lang.System.out : java.io.PrintStream [31]
		// 3 ldc <String "Visit"> [37]
		// 5 invokevirtual java.io.PrintStream.println(java.lang.String) : void
		// [39]
		// mv.visitFieldInsn(Opcodes.GETSTATIC, "Java.lang.System", "out",
		// "java.io.PrintStream");
		// mv.visitLdcInsn("Visit");
		// mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream",
		// "println", "(Ljava/lang/String;)V");
	}
	
	@Override
	public void visitFieldInsn(int opcode, String owner, String name,
			String desc) {
		System.out.println(opcode);
		System.out.println(owner);
		System.out.println(name);
		System.out.println(desc);
		super.visitFieldInsn(opcode, owner, name, desc);
	}
	
	@Override
	public void visitLdcInsn(Object cst) {
		System.out.println(cst);
		super.visitLdcInsn(cst);
	}

	@Override
	public void visitMethodInsn(int opcode, String owner, String name,
			String desc) {
		System.out.println(opcode);
		System.out.println(owner);
		System.out.println(name);
		System.out.println(desc);
		super.visitMethodInsn(opcode, owner, name, desc);
	}
	
	public void visitMaxs(int maxStack, int maxLocals) {
		System.out.println(maxStack);
		System.out.println(maxLocals);
		mv.visitMaxs(maxStack, maxLocals);
	}
}
