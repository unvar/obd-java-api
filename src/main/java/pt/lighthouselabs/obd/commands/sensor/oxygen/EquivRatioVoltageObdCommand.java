/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package pt.lighthouselabs.obd.commands.sensor.oxygen;

import pt.lighthouselabs.obd.commands.ObdCommand;
import pt.lighthouselabs.obd.enums.EquivRatioVoltageSensor;

/**
 * Equivalence Ratio And Voltage.
 */
public class EquivRatioVoltageObdCommand extends ObdCommand {

  private float equivRatio = 0.0f;
  private float voltage = 0.0f;
  private final EquivRatioVoltageSensor sensor;

  /**
   * Default ctor.
   *
   * Will read the sensor from parameters and construct the command accordingly.
   * Please, see EquivRatioVoltageSensor enum for more details.
   */
  public EquivRatioVoltageObdCommand(final EquivRatioVoltageSensor sensor) {
    super(sensor.buildObdCommand());
    this.sensor = sensor;
  }

  protected void performCalculations() {
    // ((A*256)+B)*2/65535
    equivRatio = ((buffer.get(2) * 256) + buffer.get(3)) * 2.0f / 65535.0f;
    // ((C*256)+D)*8/65535
    voltage = ((buffer.get(4) * 256.0f) + buffer.get(5)) * 8.0f / 65535.0f;
  }

  @Override
  public String getFormattedResult() {
    return String.format("%.2f %.2f%s", equivRatio, voltage, "V");
  }

  /**
   * @return the Equivalence Ratio value.
   */
  public final float getEquiRatio() {
    return equivRatio;
  }

  /**
   * @return the name of the sensor.
   */
  public final String getSensor() {
    return sensor.getSensor();
  }

  @Override
  public String getName() {
    return "Equivalence Ratio Voltage " + sensor.getSensor();
  }

}
