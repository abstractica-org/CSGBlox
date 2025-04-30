package org.abstractica.csgblox.models;

public interface ModelFactory
{
    Model createModel(String name, Assembly assembly);
}
