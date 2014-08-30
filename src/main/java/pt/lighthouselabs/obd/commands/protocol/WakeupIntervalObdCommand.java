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
package pt.lighthouselabs.obd.commands.protocol;

/**
 * This will set the value of time in milliseconds (ms) for periodic
 * wakeup messages
 */
public class WakeupIntervalObdCommand extends ObdProtocolCommand {

  /**
   * @param timeout
   *          value between 0 and 255 that multiplied by 20 results in the
   *          desired timeout in milliseconds (ms).
   */
  public WakeupIntervalObdCommand(int timeout) {
    super("AT SW " + Integer.toHexString(0xFF & timeout));
  }

  /**
   * @param other
   */
  public WakeupIntervalObdCommand(WakeupIntervalObdCommand other) {
    super(other);
  }

  @Override
  public String getFormattedResult() {
    return getResult();
  }

  @Override
  public String getName() {
    return "WakeupInterval";
  }

}