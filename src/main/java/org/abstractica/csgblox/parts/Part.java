package org.abstractica.csgblox.parts;

import org.abstractica.javacsg.Geometry3D;

public interface Part
{
    String getName();
    Geometry3D getViewGeometry();
    Geometry3D getPrintGeometry();
}
