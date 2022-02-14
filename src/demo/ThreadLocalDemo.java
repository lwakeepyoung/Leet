package demo;

public class ThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("test");
        String s = threadLocal.get();
        System.out.println(s);
    }
}
