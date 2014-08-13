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
import pt.lighthouselabs.obd.enums.OxygenSensor;

/**
 * Oxygen Sensor Voltage.
 */
public class OxygenSensorVoltageObdCommand extends ObdCommand {

  private float voltage = 0.0f;
  private float shortTermFuelTrim = 0.0f;
  private final OxygenSensor sensor;

  /**
   * Default ctor.
   *
   * Will read the sensor from parameters and construct the command accordingly.
   * Please, see OxygenSensor enum for more details.
   */
  public OxygenSensorVoltageObdCommand(final OxygenSensor sensor) {
    super(sensor.buildObdCommand());
    this.sensor = sensor;
  }

  protected void performCalculations() {
    // A/200
    voltage = buffer.get(2) / 200.0f;
    // (B-128) * 100/128
    shortTermFuelTrim = (buffer.get(3) - 128) * 100.0f / 128.0f;
  }

  @Override
  public String getFormattedResult() {
    return String.format("%.3f Volts STFT %.1f%%", voltage, shortTermFuelTrim);
  }

  /**
   * @return the STFT.
   */
  public final float getShortTermFuelTrim() {
    return shortTermFuelTrim;
  }

  /**
   * @return the name of the sensor.
   */
  public final String getSensor() {
    return sensor.getSensor();
  }

  @Override
  public String getName() {
    return "Oxygen Sensor Voltage STFT " + sensor.getSensor();
  }

}
