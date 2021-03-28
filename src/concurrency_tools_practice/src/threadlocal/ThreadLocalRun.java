package threadlocal;

import java.lang.ref.WeakReference;

/**
 * @description  验证是否会传递中丢失threadlocal中的key
 * @date 2021/3/24 19:47
 */
public class ThreadLocalRun {
//    private ThreadLocal<String> threadlocal = new ThreadLocal<String>();
//    private static ThreadLocal<String> threadlocal = new ThreadLocal<String>();
      private static ThreadLocal<St> stt1 = new ThreadLocal<St>();

    public static void main(String[] args) {

//        ThreadLocal<String> threadlocal = new ThreadLocalRun().threadlocal;
//        threadlocal.set("a");
////        threadlocal.remove();
//        // 1.添加gc操作
//        System.gc();
//        System.gc();
//        String s = threadlocal.get();
//        System.out.println("is ==>" + s);
//
//
//        WeakReference<String> weakReference = new WeakReference<String>("b");
//        System.gc();
//        System.out.println("is ===> "+weakReference.get());
//
//        //String的问题 特殊
//        WeakReference<St> st = new WeakReference<St>(new St(1));
//        System.gc();
//        System.out.println("is ===> "+st.get());


//        ThreadLocal<St> stt1 = new ThreadLocalRun().stt;
        stt1.set(new St(20));
//        stt1 = null; //断开本地强引用只剩threadlocal中的
        System.gc();
        //这里强引用了，为了营造 ‘只有弱引用的场景’ debug
//        System.out.println(stt1.get());
//        System.out.println(stt1);
        System.out.println("====");
        stt1 =null;
        System.out.println("====");
        //线程没结束，所以这里的还在 - 注释 ThreadLocal<St> stt1 = new ThreadLocalRun().stt;
//        new Thread((new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(3000);
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        })).start();

        System.out.println("===main end===");
    }
}

class St{
    int age ;

    public St(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "St{" +
                "age=" + age +
                '}';
    }
}
