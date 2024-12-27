package domain;

import data.exceptions.BannedWordException;
import data.exceptions.InvalidUsernameException;

import java.util.ArrayList;
import java.util.List;

public class ServerUtils {
    public static void isMessageAllowed(String message,  List<String> bannedPhrases) throws BannedWordException {
        message = message.toLowerCase();
        for (String bannedPhrase : bannedPhrases) {
            if(message.contains(bannedPhrase)) throw new BannedWordException("Message containing banned phrase");
        }
    }

    public static void isNameAllowed(String username, List<String> bannedwords, List<String> players) throws InvalidUsernameException {
        username = username.toLowerCase();
        for (String existingName : players){
            if (existingName.equals(username)) throw new InvalidUsernameException("User with this name exists.");
        }

        for (String phrase : bannedwords) {
            if (username.contains(phrase)) {
                throw new InvalidUsernameException("Your nickname contains prohibited words.");
            }
        }
    }
}
