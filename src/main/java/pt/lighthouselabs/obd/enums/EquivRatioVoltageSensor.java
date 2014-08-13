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
package pt.lighthouselabs.obd.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Select one of the Equivalence Ratio Voltage Sensor.
 */
public enum EquivRatioVoltageSensor {

  O2S1_WR_LAMBDA(0x24, "O2S1 WR Lambda"),
  O2S2_WR_LAMBDA(0x25, "O2S2 WR Lambda"),
  O2S3_WR_LAMBDA(0x26, "O2S3 WR Lambda"),
  O2S4_WR_LAMBDA(0x27, "O2S4 WR Lambda"),
  O2S5_WR_LAMBDA(0x28, "O2S5 WR Lambda"),
  O2S6_WR_LAMBDA(0x29, "O2S6 WR Lambda"),
  O2S7_WR_LAMBDA(0x2A, "O2S7 WR Lambda"),
  O2S8_WR_LAMBDA(0x2B, "O2S8 WR Lambda");

  private final int value;
  private final String sensor;

  private static Map<Integer, EquivRatioVoltageSensor> map = new HashMap<Integer, EquivRatioVoltageSensor>();

  static {
    for (EquivRatioVoltageSensor error : EquivRatioVoltageSensor.values())
      map.put(error.getValue(), error);
  }

  private EquivRatioVoltageSensor(final int value, final String bank) {
    this.value = value;
    this.sensor = bank;
  }

  public int getValue() {
    return value;
  }

  public String getSensor() {
    return sensor;
  }

  public static EquivRatioVoltageSensor fromValue(final int value) {
    return map.get(value);
  }

  /**
   * @return
   */
  public final String buildObdCommand() {
    return new String("01 " + value);
  }

}