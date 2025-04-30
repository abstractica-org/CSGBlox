package org.abstractica.csgblox.models;

import org.abstractica.csgblox.parts.Part;
import org.abstractica.javacsg.Angle;
import org.abstractica.javacsg.Color;

public interface AssemblyFactory
{
    AssemblyPart createPart(Color color, Part part);
    AssemblyTransform translate(double x, double y, double z, Assembly assembly);
    AssemblyTransform translateX(double x, Assembly assembly);
    AssemblyTransform translateY(double y, Assembly assembly);
    AssemblyTransform translateZ(double z, Assembly assembly);
    AssemblyTransform rotate(Angle x, Angle y, Angle z, Assembly assembly);
    AssemblyTransform rotateX(Angle x, Assembly assembly);
    AssemblyTransform rotateY(Angle y, Assembly assembly);
    AssemblyTransform rotateZ(Angle z, Assembly assembly);




    AssemblyNodeBuilder getNodeBuilder();
}
