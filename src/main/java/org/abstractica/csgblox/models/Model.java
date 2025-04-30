package org.abstractica.csgblox.models;

import org.abstractica.javacsg.Geometry3D;

public interface Model
{
    String getName();
    Geometry3D getViewGeometry();
    Assembly getAssembly();
}
