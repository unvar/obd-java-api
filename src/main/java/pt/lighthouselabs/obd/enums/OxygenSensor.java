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
 * Select one of the Oxygen Sensor.
 */
public enum OxygenSensor {

  BANK1_SENSOR1(0x14, "Bank 1 Sensor 1"),
  BANK1_SENSOR2(0x15, "Bank 1 Sensor 2"),
  BANK1_SENSOR3(0x16, "Bank 1 Sensor 3"),
  BANK1_SENSOR4(0x17, "Bank 1 Sensor 4"),
  BANK2_SENSOR1(0x18, "Bank 2 Sensor 1"),
  BANK2_SENSOR2(0x19, "Bank 2 Sensor 2"),
  BANK2_SENSOR3(0x1A, "Bank 2 Sensor 3"),
  BANK2_SENSOR4(0x1B, "Bank 2 Sensor 4");

  private final int value;
  private final String sensor;

  private static Map<Integer, OxygenSensor> map = new HashMap<Integer, OxygenSensor>();

  static {
    for (OxygenSensor error : OxygenSensor.values())
      map.put(error.getValue(), error);
  }

  private OxygenSensor(final int value, final String bank) {
    this.value = value;
    this.sensor = bank;
  }

  public int getValue() {
    return value;
  }

  public String getSensor() {
    return sensor;
  }

  public static OxygenSensor fromValue(final int value) {
    return map.get(value);
  }

  /**
   * @return
   */
  public final String buildObdCommand() {
    return new String("01 " + value);
  }

}