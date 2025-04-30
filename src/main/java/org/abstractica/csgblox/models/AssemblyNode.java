package org.abstractica.csgblox.models;

import java.util.List;

public interface AssemblyNode extends Assembly
{
    List<Assembly> getChildren();
}
