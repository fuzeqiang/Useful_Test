package classtest.asm;

import org.objectweb.asm.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by fuzeqiang(100918) on 2016/7/20 0020.
 */
public class AsmDemo extends ClassLoader{
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException, InvocationTargetException {
        for (int n = 0; n < 20; n++) {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                changeMethod();
            }
            System.out.print((System.currentTimeMillis() - start) + ",");
        }
//        AsmDemo loader=new AsmDemo();
//        Class<?> appClass=loader.defineClass(null, code, 0,code.length);
//        appClass.getMethods()[0].invoke(appClass.newInstance(), new Object[]{});
    }

    public static void changeMethod() throws IOException{
        ClassReader classReader = new ClassReader("classtest.asm.HelloWorld");
        ClassWriter cw=new ClassWriter(ClassWriter.COMPUTE_MAXS);
        CustomVisitor myv=new CustomVisitor(Opcodes.ASM4,cw);
        classReader.accept(myv, 0);
        byte[] code=cw.toByteArray();
    }

}

class CustomVisitor extends ClassVisitor implements Opcodes {

    public CustomVisitor(int api, ClassVisitor cv) {
        super(api, cv);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if (name.equals("sayHello")) {
            mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn("HelloWorld!");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");
        }
        return mv;
    }
}
