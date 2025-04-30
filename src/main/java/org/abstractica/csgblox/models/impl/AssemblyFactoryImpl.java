package org.abstractica.csgblox.models.impl;

import org.abstractica.csgblox.models.*;
import org.abstractica.csgblox.parts.Part;
import org.abstractica.javacsg.Angle;
import org.abstractica.javacsg.Color;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.Transform3D;

public class AssemblyFactoryImpl implements AssemblyFactory
{
    private final JavaCSG csg;
    private final double unit;

    public AssemblyFactoryImpl(JavaCSG csg, double unit)
    {
        this.csg = csg;
        this.unit = unit;
    }

    @Override
    public AssemblyPart createPart(Color color, Part part)
    {
        return new AssemblyPartImpl(part, color, csg.color3D(color, part.getViewGeometry()));
    }

    @Override
    public AssemblyTransform translate(double x, double y, double z, Assembly assembly)
    {
        Transform3D t = csg.translate3D(x * unit, y * unit, z * unit);
        return new AssemblyTransformImpl(t, assembly);
    }

    @Override
    public AssemblyTransform translateX(double x, Assembly assembly)
    {
        Transform3D t = csg.translate3DX(x * unit);
        return new AssemblyTransformImpl(t, assembly);
    }

    @Override
    public AssemblyTransform translateY(double y, Assembly assembly)
    {
        Transform3D t = csg.translate3DY(y * unit);
        return new AssemblyTransformImpl(t, assembly);
    }

    @Override
    public AssemblyTransform translateZ(double z, Assembly assembly)
    {
        Transform3D t = csg.translate3DZ(z * unit);
        return new AssemblyTransformImpl(t, assembly);
    }

    @Override
    public AssemblyTransform rotate(Angle x, Angle y, Angle z, Assembly assembly)
    {
        Transform3D t = csg.rotate3D(x, y, z);
        return new AssemblyTransformImpl(t, assembly);
    }

    @Override
    public AssemblyTransform rotateX(Angle x, Assembly assembly)
    {
        Transform3D t = csg.rotate3DX(x);
        return new AssemblyTransformImpl(t, assembly);
    }

    @Override
    public AssemblyTransform rotateY(Angle y, Assembly assembly)
    {
        Transform3D t = csg.rotate3DY(y);
        return new AssemblyTransformImpl(t, assembly);
    }

    @Override
    public AssemblyTransform rotateZ(Angle z, Assembly assembly)
    {
        Transform3D t = csg.rotate3DZ(z);
        return new AssemblyTransformImpl(t, assembly);
    }

    @Override
    public AssemblyNodeBuilder getNodeBuilder()
    {
        return new AssemblyNodeBuilderImpl(csg);
    }


}
