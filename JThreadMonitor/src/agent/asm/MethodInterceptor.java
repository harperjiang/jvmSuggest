package agent.asm;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class MethodInterceptor extends MethodVisitor {

	public MethodInterceptor(MethodVisitor mv) {
		super(Opcodes.ASM4, mv);
	}

	@Override
	public void visitCode() {
		mv.visitCode();
		// 0 getstatic java.lang.System.out : java.io.PrintStream [31]
		// 3 ldc <String "Visit"> [37]
		// 5 invokevirtual java.io.PrintStream.println(java.lang.String) : void
		// [39]
		mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out",
				"Ljava/io/PrintStream;");
		mv.visitLdcInsn("Visit");
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream",
				"println", "(Ljava/lang/String;)V");
	}

	
	@Override
	public void visitEnd() {
		// TODO Auto-generated method stub
		super.visitEnd();
	}
	public void visitMaxs(int maxStack, int maxLocals) {
		mv.visitMaxs(maxStack + 2, maxLocals);
	}
}
