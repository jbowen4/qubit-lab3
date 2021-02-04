import java.math.BigDecimal;

public class SingleQubit extends ParentQubit{
    float value;

    public SingleQubit(){
        super(1);
        value = 0;
    }

    ParentQubit mergeQubits(ParentQubit pq){
        if (pq.getNumQubits() > 1) {
            return null;
        }

        DoubleQubit doubleQubit = new DoubleQubit(this.value, pq.qubits[0]);

        return doubleQubit;
    }

    public String toBraKet(){
        if (this.value > 0 && this.value < 1) {

            String blackAmp = String.format( "%.2f", new BigDecimal(Math.sqrt(this.value)).stripTrailingZeros());
            String whiteAmp = String.format( "%.2f", new BigDecimal(Math.sqrt(1 - this.value)).stripTrailingZeros());
            char sign = (this.value == Math.abs(this.value)) ? '+' : '-';

            String s = whiteAmp + "|0> " + sign + " " + blackAmp + "|1>";

            return s;
        }
        else if (this.value == 0) { return "|0>"; }
        else if (this.value == 1) { return "|1>"; }
        else { return "There was an error with your qubit value. Please try again."; }
    }

    public void applyNotGate(){
        int notOperator[][] = {{0, 1},
                               {1, 0}};

        int a = notOperator[0][0];
        int b = notOperator[0][1];
        int c = notOperator[1][0];
        int d = notOperator[1][1];

        float initialVector[] = {Math.abs(1-this.value), this.value};

        float x = initialVector[0];
        float y = initialVector[1];

        float resultVector[] = {((a*x)+(b*y)), ((c*x)+(d*y))};

        this.value = resultVector[1];
    }

    public void applyNotGate(int qb){
        if (qb != 0) {
            return;
        }

        int notOperator[][] = {{0, 1},
                                {1, 0}};

        int a = notOperator[0][0];
        int b = notOperator[0][1];
        int c = notOperator[1][0];
        int d = notOperator[1][1];

        float qbVal = qubits[qb];

        float initialVector[] = {Math.abs(1-qbVal), qbVal};

        float x = initialVector[0];
        float y = initialVector[1];

        float resultVector[] = {((a*x)+(b*y)), ((c*x)+(d*y))};

        qubits[qb] = resultVector[1];
    }

    public void applyHGate(){
        double hOperator[][] = {{1/Math.sqrt(2), 1/Math.sqrt(2)},
                                {1/Math.sqrt(2), -1/Math.sqrt(2)}};

        double a = hOperator[0][0];
        double b = hOperator[0][1];
        double c = hOperator[1][0];
        double d = hOperator[1][1];

        float initialVector[] = {Math.abs(1-this.value), this.value};

        float x = initialVector[0];
        float y = initialVector[1];

        double resultVector[] = {((a*x)+(b*y)), ((c*x)+(d*y))};

        this.value = (float)resultVector[1];
    }

    public void applyHGate(int qb){
        if (qb != 0) {
            return;
        }

        double hOperator[][] = {{1/Math.sqrt(2), 1/Math.sqrt(2)},
                {1/Math.sqrt(2), -1/Math.sqrt(2)}};

        double a = hOperator[0][0];
        double b = hOperator[0][1];
        double c = hOperator[1][0];
        double d = hOperator[1][1];

        float qbVal = qubits[qb];

        float initialVector[] = {Math.abs(1-qbVal), qbVal};

        float x = initialVector[0];
        float y = initialVector[1];

        double resultVector[] = {((a*x)+(b*y)), ((c*x)+(d*y))};

        this.value = (float)resultVector[1];
    }

    public void applySwapGate(int qubit1, int qubit2){

    }

}
