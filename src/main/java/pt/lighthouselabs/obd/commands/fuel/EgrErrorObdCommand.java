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
 * Get EGR Error
 */
public class EgrErrorObdCommand extends ObdCommand {

    private float egrError = 0f;

    public EgrErrorObdCommand() {
        super("01 2C");
    }

    @Override
    protected void performCalculations() {
        // (A-128) * 100/128
        egrError = 100.0f * (buffer.get(2) - 128) / 255.0f;
    }

    @Override
    public String getFormattedResult() {
        return String.format("%.1f%s", egrError, "%");
    }

    @Override
    public String getName() {
        return AvailableCommandNames.COMMANDED_EGR.getValue();
    }

    public float getEgrError() {
        return egrError;
    }

}
