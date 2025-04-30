package org.abstractica.csgblox.models.impl;

import org.abstractica.csgblox.models.Assembly;
import org.abstractica.csgblox.models.Model;
import org.abstractica.csgblox.models.ModelFactory;

public class ModelFactoryImpl implements ModelFactory
{
    @Override
    public Model createModel(String name, Assembly assembly)
    {
        return new ModelImpl(name, assembly);
    }
}
