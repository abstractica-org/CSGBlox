package org.abstractica.csgblox.models.impl;

import org.abstractica.csgblox.models.*;
import org.abstractica.csgblox.parts.Part;
import org.abstractica.javacsg.Color;
import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.Transform3D;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AssemblyFactoryImpl implements AssemblyFactory
{
    private final JavaCSG csg;
    private final double unit;
    private Color currentColor;

    public AssemblyFactoryImpl(JavaCSG csg, double unit)
    {
        this.csg = csg;
        this.unit = unit;
        this.currentColor = csg.colorRGB(0.75, 0.75, 0.75);
    }

    @Override
    public void setColor(Color color)
    {
        currentColor = color;
    }

    @Override
    public Assembly createPart(Transform3D t, Part part)
    {
        Assembly partAssembly = createPart(part);
        return createTransform(t, partAssembly);
    }

    @Override
    public AssemblyPart createPart(Part part)
    {
        return new AssemblyPartImpl(part, currentColor, csg.color3D(currentColor, part.getViewGeometry()));
    }

    @Override
    public Assembly createTransform(Transform3D t, Assembly assembly)
    {
        return new AssemblyTransformImpl(t, assembly);
    }

    @Override
    public AssemblyNodeBuilder getNodeBuilder()
    {
        return new AssemblyNodeBuilderImpl();
    }

    public class AssemblyNodeBuilderImpl implements AssemblyNodeBuilder
    {
        private final List<Assembly> children;

        public AssemblyNodeBuilderImpl()
        {
            this.children = new ArrayList<>();
        }


        @Override
        public AssemblyNodeBuilder setColor(Color color)
        {
            currentColor = color;
            return this;
        }

        @Override
        public AssemblyNodeBuilder add(Assembly assembly)
        {
            children.add(assembly);
            return this;
        }

        @Override
        public AssemblyNodeBuilder add(Transform3D t, Part part)
        {
            children.add(createPart(t, part));
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
}
