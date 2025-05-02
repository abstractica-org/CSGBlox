package org.abstractica.csgblox.parts.impl;

import org.abstractica.clicksystem.ClickSystem;
import org.abstractica.csgblox.parts.Part;
import org.abstractica.javacsg.Geometry2D;
import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

import java.util.ArrayList;
import java.util.List;

public class RectangleBrickFactory
{
    private final JavaCSG csg;
    private final ClickSystem cs;

    public RectangleBrickFactory(ClickSystem cs)
    {
        this.csg = cs.getJavaCSG();
        this.cs = cs;
    }

    public Part getRectangleBrick(int xSize, int ySize, int zSize, boolean rounded)
    {
        if (    xSize < 1 || ySize < 1 || zSize < 1)
        {
            throw new IllegalArgumentException("Invalid brick size");
        }
        double unit = cs.getUnit();
        Geometry3D printHole = cs.getTurnHole(0.5*unit, true, true, (int) (zSize*2), false);
        Geometry3D printBrick = createSolidBrick(xSize, ySize, zSize, rounded, false,128);
        Geometry3D printGeometry = generateBrick(xSize, ySize, zSize, printBrick,  printHole);
        Geometry3D viewHole = csg.cylinder3D(unit *(2.0 / 3.0), unit * zSize, 16, false);
        Geometry3D viewBrick = createSolidBrick(xSize, ySize, zSize, rounded, true, 16);
        Geometry3D viewGeometry = generateBrick(xSize, ySize, zSize, viewBrick, viewHole);
        String name = rounded ? "RoundedRectangleBrick" : "RectangleBrick";
        name = String.format(name + "_%dx%dx%d", (int) xSize, (int) ySize,(int) (zSize*2));
        return new PartImpl(name, viewGeometry, printGeometry);
    }

    private Geometry3D createSolidBrick(int xSize, int ySize, int zSize, boolean rounded, boolean view, int angularResolution)
    {
        double unit = cs.getUnit();
        double sizeX = xSize*unit;
        double sizeY = ySize*unit;
        double sizeZ = 0.5*zSize*unit;
        double viewAdjust = view ? (1.0/12.0)*unit : 0.0;
        Geometry3D res;
        if(!rounded)
        {
            res = csg.box3D(sizeX-viewAdjust, sizeY-viewAdjust, sizeZ-viewAdjust, false);
            res = csg.translate3D(0.5*sizeX, 0.5*sizeY, 0).transform(res);
        }
        else
        {
            double diameter = unit-viewAdjust;
            Geometry2D corner = csg.circle2D(unit, angularResolution);
            List<Geometry2D> corners = new ArrayList<>();
            corners.add(csg.translate2D(0.5 * unit, 0.5 * unit).transform(corner));
            corners.add(csg.translate2D((xSize - 0.5) * unit, 0.5 * unit).transform(corner));
            corners.add(csg.translate2D(0.5 * unit, (ySize - 0.5) * unit).transform(corner));
            corners.add(csg.translate2D((xSize - 0.5) * unit, (ySize - 0.5) * unit).transform(corner));
            Geometry2D profile = csg.hull2D(corners);
            res = csg.linearExtrude(sizeZ-viewAdjust, false, profile);
        }
        if(view)
        {
            res = csg.translate3DZ(0.5*viewAdjust).transform(res);
        }
        return res;
    }

    private Geometry3D generateBrick(double xSize, double ySize, double zSize, Geometry3D brick, Geometry3D hole)
    {
        double unit = cs.getUnit();
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
