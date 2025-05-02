package org.abstractica.csgblox.models;

import org.abstractica.csgblox.parts.Part;
import org.abstractica.javacsg.Color;
import org.abstractica.javacsg.Transform3D;

public interface AssemblyNodeBuilder
{
    AssemblyNodeBuilder setColor(Color color);
    AssemblyNodeBuilder add(Assembly assembly);
    AssemblyNodeBuilder add(Transform3D t, Part part);
    AssemblyNode build();
}
