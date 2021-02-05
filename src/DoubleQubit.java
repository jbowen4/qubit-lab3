import java.math.BigDecimal;

public class DoubleQubit extends ParentQubit {

    float c = (float) ( 1/ Math.sqrt(2));

    public DoubleQubit() {
        super(2);
    }

    ParentQubit mergeQubits(ParentQubit pq) {
        return null;
    }

    public float[] vectorMult(float[][] gate) {
        float[] array = {0, 0, 0, 0};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                array[i] += (gate[i][j] * Math.sqrt(Math.abs(qubits[j])));    // will not work for more than 2 qubits bc only 0-4
            }
        }

        return array;
    }

    public String toBraKet() {
        String signOne = (qubits[1] < 0) ? "-" : "+";
        String signTwo = (qubits[2] < 0) ? "-" : "+";
        String signThree = (qubits[3] < 0) ? "-" : "+";
        String pq1 = String.format( "%.2f", Math.sqrt(Math.abs(qubits[0])));
        String pq2 = String.format( "%.2f", Math.sqrt(Math.abs(qubits[1])));
        String pq3 = String.format( "%.2f", Math.sqrt(Math.abs(qubits[2])));
        String pq4 = String.format( "%.2f", Math.sqrt(Math.abs(qubits[3])));

        if (Math.abs(qubits[0]) == 1) { return  "|00>"; }
        if (Math.abs(qubits[1]) == 1) { return signOne + "|01>"; }
        if (Math.abs(qubits[2]) == 1) { return signTwo + "|10>"; }
        if (Math.abs(qubits[3]) == 1) { return signThree + "|11>"; }

        String s = pq1 + "|00> " + signOne + " " + pq2 + "|01> " + signTwo + " " + pq3 + "|10> " + signThree + " " + pq4 + "|11>";

        return s;
    }

    public void applyNotGate() {      // apply not to FIRST QUBIT, SECOND QUBIT, BOTH
        float notGate[][] = {{0, 0, 0, 1},
                            {0, 0, 1, 0},
                            {0, 1, 0, 0},
                            {1, 0, 0, 0}};

        float[] array = vectorMult(notGate);

        for (int i = 0; i < array.length; i++)
            qubits[i] = Float.parseFloat(String.format("%.2f", Math.pow(array[i], 2)));
    }

    public void applyNotGate(int qb) {
        if (qb == 0) {
            float firstNotGate[][] = {{0, 0, 1, 0},
                                {0, 0, 0, 1},
                                {1, 0, 0, 0},
                                {0, 1, 0, 0}};

            float[] array = vectorMult(firstNotGate);

            for (int i = 0; i < array.length; i++)
                qubits[i] = Float.parseFloat(String.format("%.2f", Math.pow(array[i], 2)));
        } else {
            float secondNotGate[][] = {{0, 1, 0, 0},
                    {1, 0, 0, 0},
                    {0, 0, 0, 1},
                    {0, 0, 1, 0}};

            float[] array = vectorMult(secondNotGate);

            for (int i = 0; i < array.length; i++)
                qubits[i] = Float.parseFloat(String.format("%.2f", Math.pow(array[i], 2)));
        }
    }

    public void applyHGate() {
        float hGate[][] = { {c, c, c, c},
                            {c, -c, c, -c},
                            {c, c, -c, -c},
                            {c, -c, -c, c} };

        float[] array = vectorMult(hGate);

        for (int i = 0; i < array.length; i++)
            qubits[i] = Float.parseFloat(String.format("%.2f",Math.pow(array[i], 2)));
    }

    public void applyHGate(int qb) {
        if(qb == 0){
            float hGate[][] =   {{c, 0, c, 0},
                    {0, c, 0, c},
                    {c, 0, -c, 0},
                    {0, c, 0, -c}};
            float[] array = vectorMult(hGate);

            for (int i = 0; i < array.length; i++)
                qubits[i] = Float.parseFloat(String.format("%.2f",Math.pow(array[i], 2)));
        }
        else{
            float hGate[][] =    {{c, c, 0, 0},
                    {c, -c, 0, 0},
                    {0, 0, c, c},
                    {0, 0, c, -c}};
            float[] array = vectorMult(hGate);

            for (int i = 0; i < array.length; i++)
                qubits[i] = Float.parseFloat(String.format("%.2f", Math.pow(array[i], 2)));
        }
    }

    public void applySwapGate(int qubit1, int qubit2) {
        float swapGate[][] = {{1, 0, 0, 0},
                                {0, 0, 1, 0},
                                {0, 1, 0, 0},
                                {0, 0, 0, 1}};
        float[] array = vectorMult(swapGate);

        for (int i = 0; i < array.length; i++)
            qubits[i] = Float.parseFloat(String.format("%.2f",Math.pow(array[i], 2)));
    }


}
