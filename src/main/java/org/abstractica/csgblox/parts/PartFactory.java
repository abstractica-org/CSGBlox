package org.abstractica.csgblox.parts;

public interface PartFactory
{
    Part getClicker(double aLength);
    Part getDoubleClicker(double aLength, double bLength);
    Part getRectangleBrick(int xSize, int ySize, int zSize, boolean rounded);
    //More to come
}
