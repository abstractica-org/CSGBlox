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



        Part brick1 = partFactory.getRectangleBrick(1, 8, 1, true);
        csg.view(brick1.getPrintGeometry());
        /*


        AssemblyNodeBuilder nodeBuilder = assemblyFactory.getNodeBuilder();
        Assembly assembly1 = assemblyFactory.createPart(csg.colorRGB(1, 0,0), brick1);
        Assembly assembly2 = assemblyFactory.createPart(csg.colorRGB(0, 1,0), brick1);
        assembly2 = assemblyFactory.translateZ(1, assembly2);
        nodeBuilder.add(assembly1);
        nodeBuilder.add(assembly2);

        Assembly res = nodeBuilder.build();
        Model model = modelFactory.createModel("RedGreen", res);


        csg.view(model.getViewGeometry());
        System.out.println(brick1.getName());*/
    }
}
