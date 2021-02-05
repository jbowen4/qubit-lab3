public class TestQubits {

    public static void main(String[] args) {
        SingleQubit qubit = new SingleQubit();
        System.out.println("Probability of white: " + qubit.getValue(0) + ". Probability of black: " + qubit.getValue(1));
        qubit.applyNotGate();
        System.out.println("after NOT gate");
        System.out.println("Probability of white: " + qubit.getValue(0) + ". Probability of black: " + qubit.getValue(1));
        qubit.applyHGate();
        System.out.println("after H gate");
        System.out.println("Probability of white: " + qubit.getValue(0) + ". Probability of black: " + qubit.getValue(1));
        System.out.println("Braket Notation: " + qubit.toBraKet());

        System.out.println();
        System.out.println();

        SingleQubit second = new SingleQubit();
        DoubleQubit dq = (DoubleQubit)qubit.mergeQubits(second);
        System.out.println("new Double Qubit merged from 2 single qubits");
        System.out.println("prob of 00: " + dq.getValue(0) + ". prob of 01: " + dq.getValue(1) + ". prob of 10: " + dq.getValue(2) + ". prob of 11: " + dq.getValue(3));
        dq.applyNotGate();  //
        System.out.println("after NOT gate");
        System.out.println("prob of 00: " + dq.getValue(0) + ". prob of 01: " + dq.getValue(1) + ". prob of 10: " + dq.getValue(2) + ". prob of 11: " + dq.getValue(3));
        dq.applyNotGate(1); //
        System.out.println("after NOT gate to the 2nd qubit only");
        System.out.println("prob of 00: " + dq.getValue(0) + ". prob of 01: " + dq.getValue(1) + ". prob of 10: " + dq.getValue(2) + ". prob of 11: " + dq.getValue(3));
        dq.applyHGate(0); //
        System.out.println("after H gate to the first qubit only");
        System.out.println("prob of 00: " + dq.getValue(0) + ". prob of 01: " + dq.getValue(1) + ". prob of 10: " + dq.getValue(2) + ". prob of 11: " + dq.getValue(3));
        System.out.println("Braket Notation: " + dq.toBraKet());

    }
}
