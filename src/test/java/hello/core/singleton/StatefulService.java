package hello.core.singleton;

public class StatefulService {

//    private int price;

//    public void order(String name, int price) {
    public int order(String name, int price) {
        System.out.println("name = " + name + " / price = " + price);
//        this.price = price; //여기가 문제...!
        return price; // 필드에 값을 저장하지말고, 호출한 인스턴스의 지역변수로 값을 넘기자.
    }

//    public int getPrice() {
//        return price;
//    }
}
