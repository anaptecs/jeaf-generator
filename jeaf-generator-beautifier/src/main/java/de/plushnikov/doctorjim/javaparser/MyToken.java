package de.plushnikov.doctorjim.javaparser;

/**
 * <p>MyToken class.</p>
 *
 * @author Plushnikov Michail
 * @version $Id: $
 */
public class MyToken extends Token {
    /**
     * Constructs a new token for the specified Image and Kind.
     *
     * @param kind a int.
     * @param image a {@link java.lang.String} object.
     */
    public MyToken(int kind, String image) {
        this.kind = kind;
        this.image = image;
    }

    int realKind = JavaParserConstants.GT;

    /**
     * {@inheritDoc}
     *
     * Returns a new Token object.
     */
    public static Token newToken(int ofKind, String tokenImage) {
        return new MyToken(ofKind, tokenImage);
    }
}
