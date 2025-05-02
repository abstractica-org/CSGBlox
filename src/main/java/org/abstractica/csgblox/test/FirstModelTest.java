package org.abstractica.csgblox.test;

import org.abstractica.clicksystem.ClickSystem;
import org.abstractica.clicksystem.ClickSystemFactory;
import org.abstractica.csgblox.models.*;
import org.abstractica.csgblox.models.impl.AssemblyFactoryImpl;
import org.abstractica.csgblox.models.impl.ModelFactoryImpl;
import org.abstractica.csgblox.parts.Part;
import org.abstractica.csgblox.parts.PartFactory;
import org.abstractica.csgblox.parts.impl.PartFactoryImpl;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

public class FirstModelTest
{
    public static void main(String[] args)
    {
        JavaCSG csg = JavaCSGFactory.createDefault();
        ClickSystem cs = ClickSystemFactory.system_12_8_6_medium(csg);
        PartFactory partFactory = new PartFactoryImpl(cs);
        AssemblyFactory assemblyFactory = new AssemblyFactoryImpl(csg, cs.getUnit());
        ModelFactory modelFactory = new ModelFactoryImpl();

        Part brick = partFactory.getRectangleBrick(4, 2, 2, true);

        AssemblyNodeBuilder nodeBuilder = assemblyFactory.getNodeBuilder();

        nodeBuilder.setColor(csg.colorRGB(1, 0, 0));
        nodeBuilder.add(csg.translate3DZ(0), brick);
        nodeBuilder.setColor(csg.colorRGB(0, 1, 0));
        nodeBuilder.add(csg.translate3DZ(12), brick);
        Assembly res = nodeBuilder.build();
        Model model = modelFactory.createModel("RedGreen", res);


        csg.view(model.getViewGeometry());
        System.out.println(brick.getName());
    }
}
