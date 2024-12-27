package data;

import java.awt.*;
import java.io.Serializable;

public record DrawingInfo(int x, int y, int brushSize, Color color) implements Serializable{
}
