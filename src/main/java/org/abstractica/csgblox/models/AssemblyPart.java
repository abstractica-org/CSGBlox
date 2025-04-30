package org.abstractica.csgblox.models;

import org.abstractica.csgblox.parts.Part;
import org.abstractica.javacsg.Color;

public interface AssemblyPart extends Assembly
{
    Color getColor();
    Part getPart();
}
