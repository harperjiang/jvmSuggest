package agent;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import agent.asm.MethodInterceptor;

public class ConstructorCounter implements ClassFileTransformer {

	@Override
	public byte[] transform(ClassLoader loader, String className,
			Class<?> classBeingRedefined, ProtectionDomain protectionDomain,
			byte[] classfileBuffer) throws IllegalClassFormatException {
		System.out.println(className);
		if (!("java/lang/Object".equals(className))) {
			return classfileBuffer;
		}
		try {
			ClassReader reader = new ClassReader(classfileBuffer);
			ClassWriter writer = new ClassWriter(0);
			ClassVisitor visitor = new ClassVisitor(Opcodes.ASM4, writer) {
				@Override
				public MethodVisitor visitMethod(int access, String name,
						String desc, String signature, String[] exceptions) {
					MethodVisitor mv = super.visitMethod(access, name, desc,
							signature, exceptions);
					if (name.equals("<init>")) {
						return new MethodInterceptor(mv);
					}
					return mv;
				}
			};
			reader.accept(visitor, 0);
			return writer.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
			return classfileBuffer;
		}
	}

}
