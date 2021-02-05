abstract public class ParentQubit {
    public float[] qubits;
    private int numqubits;

    public ParentQubit(int numqubits){
        qubits = new float[(int)Math.pow(2, numqubits)];

        qubits[0] = 1;

        this.numqubits = numqubits;

        for (int i = 1; i < qubits.length; i++)
            qubits[i] = 0;
    }

    public void setValue(float v, int i) { qubits[i] = v; }

    public void setValues(float[] v){
        for (int i = 0; i < v.length; i++){
            qubits[i] = v[i];
        }
    }

    public float getValue(int i){ return qubits[i]; }

    public float[] getValues(){
        for (float i : qubits) {
            System.out.println(i);
        }
        return qubits;
    }

    public void setPhase(int p, int i){
        if (p == 1 || p == -1) {
            qubits[i] = Math.abs(qubits[i]) * p;
        }
    }

    public void setPhases(int[] p){
        for (int i = 0; i < p.length; i++){
            if (p[i] == 1 || p[i] == -1) {
                qubits[i] = Math.abs(qubits[i]) * p[i];
            }
        }
    }

    public int getPhase(int i){ return (Math.abs(qubits[i]) == qubits[i]) ? 1 : -1; }

    /* Abstract Classes */
    public int getNumQubits(){ return this.numqubits; }

    abstract ParentQubit mergeQubits(ParentQubit pq);

    abstract String toBraKet();

    abstract void applyNotGate();

    abstract void applyNotGate(int qb);

    abstract void applyHGate();

    abstract void applyHGate(int qb);

    abstract void applySwapGate(int qubit1, int qubit2);
}

