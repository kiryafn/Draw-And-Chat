package data.enums;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * The {@code Fonts} enum provides a set of predefined fonts that can be used throughout the application.
 * It encapsulates the loading of font files from a specified directory and handles any errors that
 * may occur during this process by providing a fallback font.
 */
public enum Fonts {

    /**
     * The MONTSERRAT font instance loaded from the "resources/fonts/Montserrat-Regular.ttf" file.
     */
    MONTSERRAT(loadFont("/resources/fonts/Montserrat-Regular.ttf"));

    /**
     * The {@code Font} instance associated with the enum constant.
     */
    private final Font font;

    /**
     * Constructor for the {@code Fonts} enum, which initializes the font for the enum constant.
     *
     * @param font the {@code Font} object to be associated with the enum constant.
     */
    Fonts(Font font) {
        this.font = font;
    }

    /**
     * Retrieves the {@code Font} associated with the enum constant.
     *
     * @return the {@code Font} instance.
     */
    public Font font() {
        return font;
    }

    /**
     * A utility method to load a {@code Font} from a file path.
     * It attempts to create a font from the specified file and falls back to a default serif font if an error occurs.
     *
     * @param path the path to the font file.
     * @return the {@code Font} object loaded from the file, or a fallback serif font if the file could not be loaded.
     */
    private static Font loadFont(String path) {
        try {
            File fontFile = new File(path);
            if (!fontFile.exists()) {
                System.err.println("Font file not found: " + path);
                return new Font("Serif", Font.PLAIN, 20); // fallback font
            }
            Font toReturn = Font.createFont(Font.TRUETYPE_FONT, fontFile);
            toReturn.deriveFont(Font.PLAIN, 60);
            return toReturn;
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            return new Font("Serif", Font.PLAIN, 20); // fallback font
        }
    }
}