/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package net.java.html.js.tests;

import net.java.html.js.JavaScriptBody;

/**
 *
 * @author Jaroslav Tulach
 */
public final class Factorial {
    int minusOne(int i) {
        return i - 1;
    }

    @JavaScriptBody(args = { "i" }, javacall = true,body = 
        "if (i <= 1) return 1;\n"
      + "var im1 = this.@net.java.html.js.tests.Factorial::minusOne(I)(i);\n"
      + "return this.@net.java.html.js.tests.Factorial::factorial(I)(im1) * i;"
    )
    native int factorial(int n);
}
