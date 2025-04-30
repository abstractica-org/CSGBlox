package org.abstractica.csgblox.parts.impl;

import org.abstractica.csgblox.parts.Part;
import org.abstractica.javacsg.Geometry3D;

public class PartImpl implements Part
{
    private final String name;
    private final Geometry3D viewGeometry;
    private final Geometry3D printGeometry;

    public PartImpl(String name, Geometry3D viewGeometry, Geometry3D printGeometry)
    {
        this.name = name;
        this.viewGeometry = viewGeometry;
        this.printGeometry = printGeometry;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public Geometry3D getViewGeometry()
    {
        return viewGeometry;
    }

    @Override
    public Geometry3D getPrintGeometry()
    {
        return printGeometry;
    }
}
