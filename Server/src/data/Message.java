package data;

import java.io.Serializable;

public record Message(String prefix, String sender, String message) implements Serializable {
}
