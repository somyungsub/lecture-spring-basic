package egov.jdbc.template;

public abstract class CaffeineBeverage {

    // 템플릿메서드 패턴 -> 틀(알고리즘) 형태 제공
    final public void prepareRecipe() {
        boilWater();
        brew();             // 서브클래스에서 구현
        pourInCup();
        addCondiments();    // 서브클래스에서 구현
    }

    protected abstract void brew();
    protected abstract void addCondiments();

    private void boilWater() {
        System.out.println("물 끓이는 중!");
    }
    private void pourInCup() {
        System.out.println("컵에 따르는 중");
    }
}