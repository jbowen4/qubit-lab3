import java.math.BigDecimal;

public class SingleQubit extends ParentQubit{
    public SingleQubit(){
        super(1);
    }

    ParentQubit mergeQubits(ParentQubit pq){
        if (pq.getNumQubits() != 1) {
            return null;
        }

        DoubleQubit doubleQubit = new DoubleQubit();

        float prob00 = this.getValue(0) * pq.getValue(0);
        float prob01 = this.getValue(0) * pq.getValue(1);
        float prob10 = this.getValue(1) * pq.getValue(0);
        float prob11 = this.getValue(1) * pq.getValue(1);

        float[] probs = {prob00, prob01, prob10, prob11};

        doubleQubit.setValues(probs);

        return doubleQubit;
    }

    public String toBraKet(){

        if (qubits[0] == 1) { return "|0>"; }
        if (qubits[1] == 1) { return "|1>"; }

            String blackAmp = String.format( "%.2f", Math.sqrt(Math.abs(qubits[0])));
            String whiteAmp = String.format( "%.2f", Math.sqrt(Math.abs(qubits[1])));
            char sign = (qubits[1] == Math.abs(qubits[0])) ? '+' : '-';

            String s = whiteAmp + "|0> " + sign + " " + blackAmp + "|1>";

            return s;


//        else { return "There was an error with your qubit value. Please try again."; }
    }

    public void applyNotGate(){
        int notOperator[][] = {{0, 1},
                               {1, 0}};

        int a = notOperator[0][0];
        int b = notOperator[0][1];
        int c = notOperator[1][0];
        int d = notOperator[1][1];

        float initialVector[] = {(float)Math.sqrt(qubits[0]), (float)Math.sqrt(qubits[1])};

        float x = initialVector[0];
        float y = initialVector[1];

        float resultVector[] = {((a*x)+(b*y)), ((c*x)+(d*y))};

        qubits[0] = (float)Math.pow(resultVector[0], 2);
        qubits[1] = (float)Math.pow(resultVector[1], 2);
    }

    public void applyNotGate(int qb){
        if (qb != 0) {
            return;
        }

        applyNotGate();
    }

    public void applyHGate(){
        double hOperator[][] = {{1/Math.sqrt(2), 1/Math.sqrt(2)},
                                {1/Math.sqrt(2), -1/Math.sqrt(2)}};

        double a = hOperator[0][0];
        double b = hOperator[0][1];
        double c = hOperator[1][0];
        double d = hOperator[1][1];

        float initialVector[] = {(float)Math.sqrt(qubits[0]), (float)Math.sqrt(qubits[1])};

        float x = initialVector[0];
        float y = initialVector[1];

        double resultVector[] = {((a*x)+(b*y)), ((c*x)+(d*y))};

        qubits[0] = (float)Math.pow(resultVector[0], 2);
        qubits[1] = (float)Math.pow(resultVector[1], 2) * ((Math.abs(resultVector[1]) != resultVector[1]) ? -1 : 1);
    }

    public void applyHGate(int qb){
        if (qb != 0) {
            return;
        }

        applyHGate();
    }

    public void applySwapGate(int qubit1, int qubit2){
        return;
    }

}
