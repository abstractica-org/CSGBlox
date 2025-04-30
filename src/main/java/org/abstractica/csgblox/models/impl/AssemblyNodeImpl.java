package org.abstractica.csgblox.models.impl;

import org.abstractica.csgblox.models.Assembly;
import org.abstractica.csgblox.models.AssemblyNode;
import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.Transform3D;

import java.util.List;

public class AssemblyNodeImpl implements AssemblyNode
{
    private final Geometry3D combinedGeometry;
    private final List<Assembly> children;

    public AssemblyNodeImpl(Geometry3D combinedGeometry, List<Assembly> children)
    {
        this.combinedGeometry = combinedGeometry;
        this.children = children;
    }

    @Override
    public List<Assembly> getChildren()
    {
        return children;
    }

    @Override
    public Geometry3D getViewGeometry()
    {
        return combinedGeometry;
    }
}
