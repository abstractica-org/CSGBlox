package org.abstractica.csgblox.models;

public interface AssemblyNodeBuilder
{
    AssemblyNodeBuilder add(Assembly assembly);
    AssemblyNode build();
}
