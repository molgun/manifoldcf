/* $Id$ */

/**
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements. See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* The ASF licenses this file to You under the Apache License, Version 2.0
* (the "License"); you may not use this file except in compliance with
* the License. You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package org.apache.manifoldcf.scriptengine;

/** Variable class representing an integer.
*/
public class VariableInt extends VariableBase
{
  protected int value;
  
  public VariableInt(int value)
  {
    this.value = value;
  }

  public int hashCode()
  {
    return new Integer(value).hashCode();
  }
  
  public boolean equals(Object o)
  {
    if (!(o instanceof VariableInt))
      return false;
    return ((VariableInt)o).value == value;
  }
  
  /** Get the variable's script value */
  public String getScriptValue()
    throws ScriptException
  {
    return Integer.toString(value);
  }

  /** Get the variable's value as a string */
  public String getStringValue()
    throws ScriptException
  {
    return Integer.toString(value);
  }

  /** Get the variable's value as an integer */
  public int getIntValue()
    throws ScriptException
  {
    return value;
  }
  
  /** Get the variable's value as a double */
  public double getDoubleValue()
    throws ScriptException
  {
    return (double)value;
  }

  public VariableReference plus(Variable v)
    throws ScriptException
  {
    if (v == null)
      throw new ScriptException(composeMessage("Binary '+' operand cannot be null"));
    return new VariableInt(value + v.getIntValue());
  }
    
  public VariableReference minus(Variable v)
    throws ScriptException
  {
    if (v == null)
      throw new ScriptException(composeMessage("Binary '-' operand cannot be null"));
    return new VariableInt(value - v.getIntValue());
  }

  
  public VariableReference asterisk(Variable v)
    throws ScriptException
  {
    if (v == null)
      throw new ScriptException(composeMessage("Binary '*' operand cannot be null"));
    return new VariableInt(value * v.getIntValue());
  }
    
  public VariableReference slash(Variable v)
    throws ScriptException
  {
    if (v == null)
      throw new ScriptException(composeMessage("Binary '/' operand cannot be null"));
    return new VariableInt(value / v.getIntValue());
  }
    
  public VariableReference unaryMinus()
    throws ScriptException
  {
    return new VariableInt(-value);
  }
  
  public VariableReference greaterAngle(Variable v)
    throws ScriptException
  {
    if (v == null)
      throw new ScriptException(composeMessage("Binary '>' operand cannot be null"));
    return new VariableBoolean(value > v.getIntValue());
  }
  
  public VariableReference lesserAngle(Variable v)
    throws ScriptException
  {
    if (v == null)
      throw new ScriptException(composeMessage("Binary '<' operand cannot be null"));
    return new VariableBoolean(value < v.getIntValue());
  }
    
  public VariableReference doubleEquals(Variable v)
    throws ScriptException
  {
    if (v == null)
      throw new ScriptException(composeMessage("Binary '==' operand cannot be null"));
    return new VariableBoolean(value == v.getIntValue());
  }
    
  public VariableReference greaterAngleEquals(Variable v)
    throws ScriptException
  {
    if (v == null)
      throw new ScriptException(composeMessage("Binary '>=' operand cannot be null"));
    return new VariableBoolean(value >= v.getIntValue());
  }
    
  public VariableReference lesserAngleEquals(Variable v)
    throws ScriptException
  {
    if (v == null)
      throw new ScriptException(composeMessage("Binary '<=' operand cannot be null"));
    return new VariableBoolean(value <= v.getIntValue());
  }
  
  public VariableReference exclamationEquals(Variable v)
    throws ScriptException
  {
    if (v == null)
      throw new ScriptException(composeMessage("Binary '!=' operand cannot be null"));
    return new VariableBoolean(value != v.getIntValue());
  }
  
  public VariableReference ampersand(Variable v)
    throws ScriptException
  {
    if (v == null)
      throw new ScriptException(composeMessage("Binary '&' operand cannot be null"));
    return new VariableInt(value & v.getIntValue());
  }
    
  public VariableReference pipe(Variable v)
    throws ScriptException
  {
    if (v == null)
      throw new ScriptException(composeMessage("Binary '|' operand cannot be null"));
    return new VariableInt(value | v.getIntValue());
  }

  public VariableReference unaryExclamation()
    throws ScriptException
  {
    return new VariableInt(value ^ value);
  }

}
