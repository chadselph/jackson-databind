package com.fasterxml.jackson.failing;

import com.fasterxml.jackson.databind.BaseMapTest;
import com.fasterxml.jackson.databind.ObjectMapper;

// [JACKSON-887]
public class TestStaticInnerType extends BaseMapTest
{
    public void testInnerType() throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();
        BaseType.SubType<?> r = mapper.readValue("{}", BaseType.SubType.class);
        assertNotNull(r);
    }
}

abstract class BaseType<T> {
    public T value;

    public final static class SubType<T extends Number> extends BaseType<T>
    {
    }
}