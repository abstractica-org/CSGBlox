package org.abstractica.csgblox.parts.impl;

import org.abstractica.clicksystem.ClickSystem;
import org.abstractica.csgblox.parts.Part;
import org.abstractica.csgblox.parts.PartFactory;
import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class PartFactoryImpl implements PartFactory
{
    private final JavaCSG csg;
    private final ClickSystem cs;
    private final RectangleBrickFactory rectangleBrickFactory;

    public PartFactoryImpl(ClickSystem cs)
    {
        this.csg = cs.getJavaCSG();
        this.cs = cs;
        this.rectangleBrickFactory = new RectangleBrickFactory(cs);
    }

    @Override
    public Part getClicker(double aLength)
    {
        if (    aLength*2 < 1 || aLength*2 != Math.floor(aLength*2))
        {
            throw new IllegalArgumentException("Invalid clicker size");
        }
        double unit = cs.getUnit();
        Geometry3D clicker = cs.getClicker(aLength*unit, 0);
        Geometry3D viewClicker = csg.cylinder3D(unit * (2.0 / 3.0) * 0.95, unit * aLength, 16, false);
        String name = String.format("Clicker_%d", (int) aLength*2);
        return new PartImpl(name, viewClicker, clicker);
    }

    @Override
    public Part getDoubleClicker(double aLength, double bLength)
    {
        if (    aLength*2 < 1 || aLength*2 != Math.floor(aLength*2) ||
                bLength*2 < 1 || bLength*2 != Math.floor(bLength*2))
        {
            throw new IllegalArgumentException("Invalid clicker size");
        }
        double unit = cs.getUnit();
        Geometry3D clicker = cs.getDoubleClicker(aLength*unit, bLength*unit, 0);
        Geometry3D viewClicker = csg.cylinder3D(unit * (2.0 / 3.0) * 0.95, unit * (aLength+bLength), 16, false);
        String name = String.format("DoubleClicker_%dx%d", (int) aLength*2, (int) bLength*2);
        return new PartImpl(name, viewClicker, clicker);
    }

    @Override
    public Part getRectangleBrick(int xSize, int ySize, int zSize, boolean rounded)
    {
        return rectangleBrickFactory.getRectangleBrick(xSize, ySize, zSize, rounded);
    }
}
