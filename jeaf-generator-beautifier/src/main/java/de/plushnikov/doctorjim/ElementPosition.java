package de.plushnikov.doctorjim;

import de.plushnikov.doctorjim.javaparser.Token;

/**
 * Simple Bean for transportion of data of some parsed element.
 *
 * @author Plushnikov Michail
 * @version $Id: $
 */
public final class ElementPosition implements Comparable<ElementPosition> {
    private String mValue;

    private int mStartColumn;
    private int mStartLine;
    private int mEndColumn;
    private int mEndLine;

    /**
     * <p>Constructor for ElementPosition.</p>
     *
     * @param pWert a {@link java.lang.String} object.
     * @param pStart a {@link de.plushnikov.doctorjim.javaparser.Token} object.
     * @param pEnd a {@link de.plushnikov.doctorjim.javaparser.Token} object.
     */
    public ElementPosition(String pWert, Token pStart, Token pEnd) {
        mValue = pWert;
        mStartLine = pStart.beginLine;
        mStartColumn = pStart.beginColumn;

        mEndLine = pEnd.endLine;
        mEndColumn = pEnd.endColumn;
    }

    /**
     * <p>getValue</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getValue() {
        return mValue;
    }

    /**
     * <p>getStartColumn</p>
     *
     * @return a int.
     */
    public int getStartColumn() {
        return mStartColumn;
    }

    /**
     * <p>getStartLine</p>
     *
     * @return a int.
     */
    public int getStartLine() {
        return mStartLine;
    }

    /**
     * <p>getEndColumn</p>
     *
     * @return a int.
     */
    public int getEndColumn() {
        return mEndColumn;
    }

    /**
     * <p>getEndLine</p>
     *
     * @return a int.
     */
    public int getEndLine() {
        return mEndLine;
    }

    /**
     * Compares Position of two JavaObjects
     *
     * @param pOther another ElementPosition
     * @return a int.
     */
    public int compareTo(ElementPosition pOther) {
        if (mEndLine == pOther.mEndLine) {
            if (mEndColumn == pOther.mEndColumn) {
                return 0;
            } else {
                if (mEndColumn > pOther.mEndColumn) {
                    return 1;
                } else {
                    return -1;
                }
            }
        } else {
            if (mEndLine > pOther.mEndLine) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
