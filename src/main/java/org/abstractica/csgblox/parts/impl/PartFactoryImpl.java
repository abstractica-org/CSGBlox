package org.abstractica.csgblox.parts.impl;

import org.abstractica.clicksystem.ClickSystem;
import org.abstractica.csgblox.parts.Part;
import org.abstractica.csgblox.parts.PartFactory;
import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

import java.util.ArrayList;
import java.util.List;

public class PartFactoryImpl implements PartFactory
{
    private final JavaCSG csg;
    private final ClickSystem cs;

    public PartFactoryImpl(ClickSystem cs)
    {
        this.csg = cs.getJavaCSG();
        this.cs = cs;
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
    public Part getRectangleBrick(double xSize, double ySize, double zSize)
    {
        if (    xSize < 1 || xSize != Math.floor(xSize) ||
                ySize < 1 || ySize != Math.floor(ySize) ||
                (zSize*2 < 1 || zSize*2 != Math.floor(zSize*2)))
        {
            throw new IllegalArgumentException("Invalid brick size");
        }
        double unit = cs.getUnit();
        Geometry3D hole = cs.getTurnHole(0.5*unit, true, true, (int) (zSize*2), false);
        Geometry3D printGeometry = generateBrick(xSize, ySize, zSize, hole);
        Geometry3D viewHole = csg.cylinder3D(unit *(2.0 / 3.0), unit * zSize, 16, false);
        Geometry3D viewGeometry = generateBrick(xSize, ySize, zSize, viewHole);
        String name = String.format("RectAngleBrick_%dx%dx%d", (int) xSize, (int) ySize,(int) (zSize*2));
        return new PartImpl(name, viewGeometry, printGeometry);
    }

    private Geometry3D generateBrick(double xSize, double ySize, double zSize, Geometry3D hole)
    {
        double unit = cs.getUnit();
        Geometry3D brick = csg.box3D(unit*xSize, unit*ySize, unit*zSize, false);
        brick = csg.translate3D(0.5*unit*xSize, 0.5*unit*ySize, 0).transform(brick);
        List<Geometry3D> holes = new ArrayList<>();
        for(int y = 0; y < ySize; ++y)
        {
            for(int x = 0; x < xSize; ++x)
            {
                Geometry3D holeCopy = csg.translate3D((x+0.5)*unit, (y+0.5)*unit, 0).transform(hole);
                holes.add(holeCopy);
            }
        }
        brick = csg.difference3D(brick, holes);
        return brick;
    }
}
