package io.appform.hope.core.operators;

import io.appform.hope.core.values.BooleanValue;
import io.appform.hope.core.values.JsonPathValue;
import io.appform.hope.core.values.StringValue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestOperatorEquality {

    @Test
    void AndEquality() {
        BooleanValue b1 = new BooleanValue(false);
        BooleanValue b2 = new BooleanValue(true);
        And a1 = new And(b1, b2);
        And a2 = new And(b1, b2);
        assertEquals(a2, a1);
    }

    @Test
    void EqualsEquality() {
        JsonPathValue jpv1 = new JsonPathValue("providerId");
        JsonPathValue jpv2 = new JsonPathValue("providerId");
        StringValue sv1 = new StringValue("UTIB");
        StringValue sv2 = new StringValue("UTIB");
        Equals equals1 = new Equals(jpv1, sv1);
        Equals equals2 = new Equals(jpv2, sv2);
        assertEquals(equals1, equals2);
    }
}