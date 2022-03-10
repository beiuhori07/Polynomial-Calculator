package ro.utcn.hori.model;

import ro.utcn.hori.operations.UnaryOperation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
//    private static final String PATTERN = "(\\s*[+-]*\\s*\\d+x\\^\\d+)";
//    private static final String PATTERN = "([+-]?(?:(?:\\d+x\\^\\d+)|(?:\\d+x)|(?:\\d+)|(?:\\d+)|(?:x\\^\\d+)|(?:x)))";
//    private static final String PATTERN = "([+-]?(?:(?:\\d+x\\^\\d+)|(?:\\d+x)|(?:\\d+.\\d+x\\^\\d+)|(?:\\d+.\\d+x)|(?:\\d+.\\d)|(?:\\d+)|(?:x\\^\\d+)|(?:x)))";
    private static final String PATTERN = "([+-]?(?:(?:\\d+x\\^\\d+)|(?:\\d+x)|(?:\\d+.\\d+x\\^\\d+)|(?:\\d+\\.\\d+x)|(?:\\d+\\.\\d+)|(?:\\d+)|(?:x\\^\\d+)|(?:x)))";

    private List<Monomial> monomials = new ArrayList<>();

    public Polynomial(List<Monomial> monomials) {
        this.monomials = monomials;
        Collections.sort(this.monomials);
    }

    public Polynomial(String s) {
        s = s.replaceAll("\\s","");
        Pattern p = Pattern.compile(PATTERN);
        Matcher m = p.matcher(s);
        int x = 0;
        while(m.find()) {
            x++;
            System.out.println("Group " + x + ": " + m.group());
            monomials.add(new Monomial(m.group()));
        }
        Collections.sort(this.monomials);
    }

    public List<Monomial> getMonomials() {
        return Collections.unmodifiableList(monomials);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polynomial that = (Polynomial) o;
        return Objects.equals(monomials, that.monomials);
    }

    @Override
    public int hashCode() {
        return Objects.hash(monomials);
    }

    @Override
    public String toString() {
        String result = "";
        for(Monomial mon: monomials) {
            result = result + mon.toString() + " + ";
        }
        result = result.length() > 2 ? result.substring(0, result.length() - 2) : result;
        return result;
    }
}
