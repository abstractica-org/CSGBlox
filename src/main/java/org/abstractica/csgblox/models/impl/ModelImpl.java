package org.abstractica.csgblox.models.impl;

import org.abstractica.csgblox.models.Assembly;
import org.abstractica.csgblox.models.Model;
import org.abstractica.javacsg.Geometry3D;

public class ModelImpl implements Model
{
    private final String name;
    private final Assembly assembly;

    public ModelImpl(String name, Assembly assembly)
    {
        this.name = name;
        this.assembly = assembly;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public Geometry3D getViewGeometry()
    {
        return assembly.getViewGeometry();
    }

    @Override
    public Assembly getAssembly()
    {
        return assembly;
    }
}
