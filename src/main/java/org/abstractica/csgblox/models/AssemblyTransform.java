package org.abstractica.csgblox.models;

import org.abstractica.javacsg.Transform3D;

public interface AssemblyTransform extends Assembly
{
    Transform3D getTransform();
    Assembly getAssembly();
}
