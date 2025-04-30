package org.abstractica.csgblox.models.impl;

import org.abstractica.csgblox.models.Assembly;
import org.abstractica.csgblox.models.AssemblyTransform;
import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.Transform3D;

public class AssemblyTransformImpl implements AssemblyTransform
{
    private final Transform3D transform;
    private final Assembly assembly;

    public AssemblyTransformImpl(Transform3D transform, Assembly assembly)
    {
        this.transform = transform;
        this.assembly = assembly;
    }

    @Override
    public Transform3D getTransform()
    {
        return transform;
    }

    @Override
    public Assembly getAssembly()
    {
        return assembly;
    }

    @Override
    public Geometry3D getViewGeometry()
    {
        return transform.transform(assembly.getViewGeometry());
    }
}
