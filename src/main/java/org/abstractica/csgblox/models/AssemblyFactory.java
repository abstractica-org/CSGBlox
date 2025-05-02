package org.abstractica.csgblox.models;

import org.abstractica.csgblox.parts.Part;
import org.abstractica.javacsg.Color;
import org.abstractica.javacsg.Transform3D;

public interface AssemblyFactory
{
    void setColor(Color color);
    Assembly createPart(Transform3D t, Part part);
    Assembly createPart(Part part);
    Assembly createTransform(Transform3D t, Assembly assembly);
    AssemblyNodeBuilder getNodeBuilder();
}
