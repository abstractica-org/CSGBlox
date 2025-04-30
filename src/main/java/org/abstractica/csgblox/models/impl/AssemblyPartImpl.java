package org.abstractica.csgblox.models.impl;

import org.abstractica.csgblox.models.AssemblyPart;
import org.abstractica.csgblox.parts.Part;
import org.abstractica.javacsg.Color;
import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.Transform3D;

public class AssemblyPartImpl implements AssemblyPart
{
    private final Part part;
    private final Color color;
    private final Geometry3D colorGeometry;

    public AssemblyPartImpl(Part part, Color color, Geometry3D colorGeometry)
    {
        this.part = part;
        this.color = color;
        this.colorGeometry = colorGeometry;
    }

    @Override
    public Color getColor()
    {
        return color;
    }

    @Override
    public Part getPart()
    {
        return part;
    }

    @Override
    public Geometry3D getViewGeometry()
    {
        return colorGeometry;
    }
}
