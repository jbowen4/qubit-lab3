import java.math.BigDecimal;

public class DoubleQubit extends ParentQubit {

    float v1, v2;

    public DoubleQubit(float qubit1, float qubit2) {
        super(2);
        v1 = qubit1;
        v2 = qubit2;
    }

    ParentQubit mergeQubits(ParentQubit pq) {
        return null;
    }

    public String toBraKet() {
//        BigDecimal a = new BigDecimal(Math.sqrt(1 - this.v1)).stripTrailingZeros();
//        BigDecimal b = new BigDecimal(Math.sqrt(this.v1)).stripTrailingZeros();
//
//        BigDecimal c = new BigDecimal(Math.sqrt(1 - this.v2)).stripTrailingZeros();
//        BigDecimal d = new BigDecimal(Math.sqrt(this.v2)).stripTrailingZeros();
//
//        String s = (a*c) + "|00> + " + (a*d) + "|01> + " + (b*c) + "|10> + " + (b*d) + "|11>";

        return "";
    }

    public void applyNotGate() {

    }

    public void applyNotGate(int qb) {

    }

    public void applyHGate() {

    }

    public void applyHGate(int qb) {

    }

    public void applySwapGate(int qubit1, int qubit2) {

    }


}
