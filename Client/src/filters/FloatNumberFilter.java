package filters;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class FloatNumberFilter  extends DocumentFilter {
    private static final String DIGITS = "\\d+";
    private static final String DOT = "\\.*";
    private static final String REGEXP = "\\d+\\.\\d+";

    @Override
    public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {

        if (string.matches(DIGITS) || string.matches(DOT)) {
            super.insertString(fb, offset, string, attr);
        }
    }

    @Override
    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String string, AttributeSet attrs) throws BadLocationException {
        int count = fb.getDocument().getText(0, fb.getDocument().getLength()).split("\\.",-1).length-1;
        if (string.matches(DIGITS) || (string.matches(DOT) && count != 1) || string.matches(REGEXP)) {
            super.replace(fb, offset, length, string, attrs);
        }
    }
}
