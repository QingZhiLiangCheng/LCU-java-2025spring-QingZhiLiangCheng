package cn.edu.lcu.cs.design_pattern.singleton;

public class SingletonClient {
    public static void main(String[] args) {
//        commontTest();
        multithreadTest();
    }

    private static void commontTest() {
        int count = 10;
        for (int i = 0; i < count; i++) {
            System.out.println(LazySingleton.getInstance());
            System.out.println(EagerSingleton.getInstance());
        }
    }

    private static void multithreadTest() {
        for (int i = 0; i < 10; i++) {
            new Thread() {
                @Override
                public void run() {
                    System.out.println(LazySingleton.getInstance());
                }
            }.start();
        }
    }
}
