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
 * Get fuel injection timing
 */
public class FuelInjectionTimingObdCommand extends ObdCommand {

  private float fuelInjectionTiming = 0f;

  public FuelInjectionTimingObdCommand() {
    super("01 5D");
  }

  @Override
  protected void performCalculations() {
    // (((A*256)+B)-26,880)/128
    fuelInjectionTiming = (((buffer.get(2) * 256.0f) + buffer.get(3)) - 26880.0f)/128;
  }

  @Override
  public String getFormattedResult() {
    return String.format("%.1f%s", fuelInjectionTiming, "");
  }

  @Override
  public String getName() {
    return AvailableCommandNames.FUEL_INJECTION_TIMING.getValue();
  }

  public float getFuelInjectionTiming() {
    return fuelInjectionTiming;
  }

}
