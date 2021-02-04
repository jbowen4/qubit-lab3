public class TestQubits {

    public static void main(String[] args) {
        SingleQubit qubit = new SingleQubit();
        qubit.getValue(0);
        qubit.setValue(0, 1);
        qubit.getValue(0);
    }
}
