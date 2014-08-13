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
package pt.lighthouselabs.obd.commands.fuel;

import pt.lighthouselabs.obd.commands.ObdCommand;
import pt.lighthouselabs.obd.enums.AvailableCommandNames;

/**
 * Get engine fuel rate
 */
public class EngineFuelRateObdCommand extends ObdCommand {

  private float fuelRate = 0f;

  public EngineFuelRateObdCommand() {
    super("01 5E");
  }

  @Override
  protected void performCalculations() {
    // ((A*256)+B)*0.05
    fuelRate = ((buffer.get(2) * 256.0f) + buffer.get(3)) * 0.05f;
  }

  @Override
  public String getFormattedResult() {
    return String.format("%.2f%s", fuelRate, "L/h");
  }

  @Override
  public String getName() {
    return AvailableCommandNames.ENGINE_FUEL_RATE.getValue();
  }

  public float getFuelInjectionTiming() {
    return fuelRate;
  }

}
