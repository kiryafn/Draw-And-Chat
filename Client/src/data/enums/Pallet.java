package data.enums;

import java.awt.*;

public enum Pallet {
    SERVER (new Color(200, 0, 255)),
    CLIENT (new Color(196, 123, 184)),
    HELP   (new Color(106, 171, 115)),
    BAN    (new Color(247, 84, 100)),
    MESSAGE(new Color(0, 0, 0)),
    WORD   (new Color(196, 123, 184)),
    ALL    (new Color(93, 185, 216)),
    SENDER (new Color(124, 39, 184)),
    WHISPER(new Color(237, 104, 255)),
    MENU_BG(new Color(197, 175, 255));

    private final Color color;
    Pallet(Color color) {
        this.color = color;
    }

    public Color value() {
        return color;
    }
}
