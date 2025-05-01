package org.abstractica.csgblox.test;

import org.abstractica.clicksystem.ClickSystem;
import org.abstractica.clicksystem.ClickSystemFactory;
import org.abstractica.csgblox.parts.Part;
import org.abstractica.csgblox.parts.PartFactory;
import org.abstractica.csgblox.parts.impl.PartFactoryImpl;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

public class RectAngleBrickTest
{
    public static void main(String[] args)
    {
        JavaCSG csg = JavaCSGFactory.createDefault();
        ClickSystem cs = ClickSystemFactory.system_12_8_6_medium(csg);
        PartFactory factory = new PartFactoryImpl(cs);
        Part brick = factory.getRectangleBrick(1, 4, 2, true);
        csg.view(brick.getPrintGeometry());
    }
}
