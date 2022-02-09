public interface MessageEncoder {
    public abstract String encode(String plainText);     // abstract method which encodes the given
                                                        // plainText into encrypted text and returns the encrypted text
}
