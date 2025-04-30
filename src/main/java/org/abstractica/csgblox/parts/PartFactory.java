package org.abstractica.csgblox.parts;

public interface PartFactory
{
    Part getDoubleClicker(double aLength, double bLength);
    Part getRectangleBrick(double xSize, double ySize, double zSize);
    //More to come
}
