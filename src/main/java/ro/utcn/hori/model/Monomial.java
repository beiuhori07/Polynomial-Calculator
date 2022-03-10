package ro.utcn.hori.model;

import java.util.Objects;

public class Monomial implements Comparable{
    private float coefficient;
    private int exp;

    public Monomial(float coefficient, int exp) {
        this.coefficient = coefficient;
        this.exp = exp;
    }

    public Monomial(String s) {
        if(!s.contains("x")) {
            // ex:   5  <=>  5x^0
            this.coefficient = Float.parseFloat(s);
            this.exp = 0;

        } else {
            if(s.charAt(s.length() - 1) == 'x' && s.charAt(0) != 'x') {
                // ex: 5x, 7x
                this.exp = 1;
                if(s.startsWith("-x") || s.startsWith("+x")) {
                    if (s.startsWith("-x")) {
                        this.coefficient = -1f;
                    } else {
                        this.coefficient = 1f;
                    }
                } else {
                    this.coefficient = Float.parseFloat(s.substring(0, s.length() - 1));
                }
            } else {
                if(s.charAt(0) == 'x') {
                    // ex: x^2 => coef = 1
                    this.coefficient = 1f;
                    if(s.charAt(s.length() - 1) == 'x') {
                        this.exp = 1;
                    } else {
                        this.exp = Integer.parseInt(s.substring(2));
                    }

                } else {
                    if(s.startsWith("-x") || s.startsWith("+x")) {
                        // ex: -x^3 , +x^4
                        this.exp = Integer.parseInt(s.substring(3));
                        if(s.startsWith("-x")){
                            this.coefficient = -1f;
                        } else {
                            this.coefficient = 1f;
                        }
                    } else {
                        // ex: 5x^3 -> explicit coef
                        String[] parts = s.split("x\\^");
                        this.coefficient = Float.parseFloat(parts[0]);
                        this.exp = Integer.parseInt(parts[1]);

                    }
                }
            }
        }
    }

    public float getCoefficient() {
        return coefficient;
    }

    public int getExp() {
        return exp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monomial monomial = (Monomial) o;
        return Float.compare(monomial.coefficient, coefficient) == 0 && exp == monomial.exp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coefficient, exp);
    }

    @Override
    public String toString() {
        if(this.exp == 0) return "" + ((this.coefficient < 0) ? "("+ this.coefficient + ")" : this.coefficient) + "";
        if(this.exp == 1) return "" + ((this.coefficient < 0) ? "("+ this.coefficient + ")" : this.coefficient) + "x";
        return "" + ((this.coefficient < 0) ? "("+ this.coefficient + ")" : this.coefficient) + "x^" + this.exp;
    }

    @Override
    public int compareTo(Object o) {
        int exp = ((Monomial)o).getExp();
        return exp - this.exp;
    }
}
