/*
 * This file is part of Arduino.
 *
 * Copyright 2015 Arduino LLC (http://www.arduino.cc/)
 *
 * Arduino is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 *
 * As a special exception, you may use this file as part of a free software
 * library without restriction.  Specifically, if other files instantiate
 * templates or use macros or inline functions from this file, or you compile
 * this file and link it with other files to produce an executable, this
 * file does not by itself cause the resulting executable to be covered by
 * the GNU General Public License.  This exception does not however
 * invalidate any other reasons why the executable file might be covered by
 * the GNU General Public License.
 */

package processing.app;

import org.fest.swing.fixture.JMenuItemFixture;
import org.junit.Test;
import processing.app.helpers.RSyntaxTextAreaFixture;

import static org.junit.Assert.assertEquals;

public class AutoformatTest extends AbstractGUITest {

  @Test
  public void shouldProduceNicelyFormattedCode() throws Exception {
    JMenuItemFixture menuToolsAutoFormat = window.menuItem("menuToolsAutoFormat");
    menuToolsAutoFormat.requireEnabled();

    RSyntaxTextAreaFixture editor = window.RSyntaxTextArea("editor");
    editor.setText("void setup() {\n" +
            "// put your setup code here, to run once:\n" +
            "int foo[] = { 1, 2, 3, 4, 5};\n" +
            "int foo[2][5] = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}};\n" +
            "}\n" +
            "\n" +
            "void loop() {\n" +
            "// put your main code here, to run repeatedly:\n" +
            "}");

    menuToolsAutoFormat.click();

    String formattedText = editor.getText();
    assertEquals("void setup() {\n" +
            "  // put your setup code here, to run once:\n" +
            "  int foo[] = { 1, 2, 3, 4, 5};\n" +
            "  int foo[2][5] = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}};\n" +
            "}\n" +
            "\n" +
            "void loop() {\n" +
            "  // put your main code here, to run repeatedly:\n" +
            "}", formattedText);

  }
}
