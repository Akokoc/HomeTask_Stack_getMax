public class Main {
    public static void main(String[] args) {
        IMaxElementStack<Integer> maxElementStack = new NaiveMaxElementStack<>();//структура данных

        maxElementStack.addLast(1);//array [1]
        System.out.println(maxElementStack.getMax());//return 1
        maxElementStack.addLast(10);//array [1,10]
        System.out.println(maxElementStack.getMax());//return 10
        maxElementStack.addLast(-10); //array [1,10,-10]
        System.out.println(maxElementStack.getMax());//return 10
        maxElementStack.addLast(20);//array [1,10,-10,20]
        System.out.println(maxElementStack.getMax());//return 20
        maxElementStack.removeLast();//array [1,10,-10]
        System.out.println(maxElementStack.getMax());//return 10


    }
}
