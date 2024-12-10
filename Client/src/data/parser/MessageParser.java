
package data.parser;

import java.util.HashMap;
import java.util.Map;

/**
 * The {@code MessageParser} class provides a utility method to parse
 * formatted strings containing delimited key-value pairs into a
 * {@code Map<String, String>}.
 * <p>
 * This class is designed for scenarios where structured data
 * is represented as a compact string and needs to be processed.
 * <p>
 * Example input format: {@code "key1:value1|key2:value2|key3:value3"}.
 *
 * This class is thread-safe as it uses no shared state or side effects.
 */
public class MessageParser {

    /**
     * Parses a message string containing key-value pairs separated by the
     * delimiter {@code |}. Each key-value pair within the message is
     * separated by the {@code :} delimiter.
     * <p>
     * Example input: {@code "key1:value1|key2:value2|key3:value3"}.
     * The method splits the string by the {@code |} delimiter to isolate
     * pairs, then splits each pair by the {@code :} delimiter to extract
     * keys and values.
     * <p>
     * Malformed or incomplete pairs (e.g., missing {@code :}) are ignored
     * during processing.
     *
     * @param message the string containing key-value pairs to parse; if
     *                {@code null}, a {@code NullPointerException} may
     *                occur during processing
     * @return a {@code Map<String, String>} containing the parsed key-value
     *         pairs; an empty {@code Map} is returned if no valid pairs
     *         are found
     */
    public static Map<String, String> parseMessage(String message) {
        Map<String, String> data = new HashMap<>();
        String[] pairs = message.split("\\|");
        for (String pair : pairs) {
            String[] keyValue = pair.split(":", 2);
            if (keyValue.length == 2) {
                data.put(keyValue[0], keyValue[1]);
            }
        }
        return data;
    }

    public static String formatMessage(String typeVal, String prefixVal, String sender, String message) {
        if (typeVal == null || prefixVal == null || sender == null || message == null) {
            throw new NullPointerException("None of the parameters can be null");
        }
        return MessageKey.TYPE + ":" + typeVal +
                "|" + MessageKey.PREFIX + ":" + prefixVal +
                "|" + MessageKey.SENDER + ":"  + sender +
                "|" + MessageKey.MESSAGE + ":" + message;
    }
}