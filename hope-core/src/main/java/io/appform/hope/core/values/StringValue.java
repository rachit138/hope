/*
 * Copyright 2019. Santanu Sinha
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and limitations
 * under the License.
 */

package io.appform.hope.core.values;

import com.google.common.base.Objects;
import io.appform.hope.core.Visitor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *
 */
@Data
@ToString(callSuper = true)
public class StringValue extends EvaluatableValue<String> {

    /**
     * @param value String value
     */
    public StringValue(String value) {
        super(value);
    }

    /**
     * @param pathValue A json path that will get evaluated to a string
     */
    public StringValue(JsonPathValue pathValue) {
        super(pathValue);
    }

    /**
     * @param pointerValue json pointer value
     */
    public StringValue(JsonPointerValue pointerValue) {
        super(pointerValue);
    }

    /**
     * @param function A function that evaluates to a string
     */
    public StringValue(FunctionValue function) {
        super(function);
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (obj == this) { return true; }
        if (obj.getClass() != getClass()) { return false; }
        StringValue other = (StringValue) obj;
        return Objects.equal(this.getValue(), other.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getValue(), this.getPathValue(), this.getPointerValue(), this.getFunction());
    }
}
