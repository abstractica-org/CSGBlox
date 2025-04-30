package org.abstractica.csgblox.models.impl;

import org.abstractica.csgblox.models.Assembly;
import org.abstractica.csgblox.models.AssemblyNode;
import org.abstractica.csgblox.models.AssemblyNodeBuilder;
import org.abstractica.csgblox.parts.Part;
import org.abstractica.javacsg.Color;
import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.Transform3D;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AssemblyNodeBuilderImpl implements AssemblyNodeBuilder
{
    private final JavaCSG csg;
    private final List<Assembly> children;

    public AssemblyNodeBuilderImpl(JavaCSG csg)
    {
        this.csg = csg;
        this.children = new ArrayList<>();
    }


    @Override
    public AssemblyNodeBuilder add(Assembly assembly)
    {
        children.add(assembly);
        return this;
    }

    @Override
    public AssemblyNode build()
    {
        List<Geometry3D> childGeometries = new ArrayList<>();
        for (Assembly child : children)
        {
            childGeometries.add(child.getViewGeometry());
        }
        return new AssemblyNodeImpl(csg.union3D(childGeometries), Collections.unmodifiableList(children));
    }
}
