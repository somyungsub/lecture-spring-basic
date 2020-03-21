package egov.jdbc.template;

public class Tea extends CaffeineBeverage {
    @Override
    public void brew() {
        System.out.println("차를 우려내는 중");
    }

    @Override
    public void addCondiments() {
        System.out.println("레몬추출을 추가 하는중 ");
    }

}
