//DATA STRUCTURE WHICH WILL HELP TO WITH ASSIGN userID WITH password AND user as a object
public class Pair<A, B> {
    private A firstValue;
    private B secondValue;

    public Pair(A firstValue, B secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    public A getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(A temp){
        this.firstValue = temp;
    }

    public B getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(B temp){
        this.secondValue = temp;
    }
}
